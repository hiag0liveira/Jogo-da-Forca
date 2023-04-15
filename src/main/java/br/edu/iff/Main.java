package br.edu.iff;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraAppService;
import br.edu.iff.bancodepalavras.dominio.tema.TemaAppService;
import br.edu.iff.jogoforca.Aplicacao;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaAppService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Aplicacao aplicacao = Aplicacao.getAplicacao();
        aplicacao.configurar();

        inserirTemasEPalavras();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe seu nome: ");
        String nomeJogador = scanner.nextLine();
        System.out.println();

        Jogador jogador = Aplicacao.getAplicacao().getJogadorFactory().getJogador(nomeJogador);
        Rodada rodada = RodadaAppService.getSoleInstance().novaRodada(jogador);

        do {
            printStatus(rodada);

            printOpcoes();
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Informe uma letra: ");
                    char codigo = scanner.nextLine().charAt(0);
                    System.out.println();

                    rodada.tentar(codigo);
                    break;
                case 2:
                    String[] palavras = new String[rodada.getNumPalavras()];
                    for (int i = 0; i < rodada.getNumPalavras(); i++) {
                        System.out.println("Informe a Palavra " + (i + 1) + ": ");
                        palavras[i] = scanner.nextLine();
                    }
                    System.out.println();
                    rodada.arriscar(palavras);
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        } while (!rodada.encerrou());

        printResultadoFinal(rodada);
    }

    private static void inserirTemasEPalavras() {
        TemaAppService temaService = TemaAppService.getSoleInstance();
        temaService.novoTema("comida");
        temaService.novoTema("esportes");
        temaService.novoTema("casa");

        PalavraAppService palavraService = PalavraAppService.getSoleInstance();

        palavraService.novaPalavra("arroz", 1L);
        palavraService.novaPalavra("feijao", 1L);
        palavraService.novaPalavra("carne", 1L);

        palavraService.novaPalavra("futebol", 2L);
        palavraService.novaPalavra("volei", 2L);
        palavraService.novaPalavra("basquete", 2L);

        palavraService.novaPalavra("quarto", 3L);
        palavraService.novaPalavra("banheiro", 3L);
        palavraService.novaPalavra("sala", 3L);
    }

    private static void printStatus(Rodada rodada) {
        System.out.println("Tema: " + rodada.getTema().getNome());
        System.out.println();

        System.out.println("Palavras:");
        rodada.exibirItens(null);
        System.out.println();

        System.out.println("Letras Erradas:");
        rodada.exibirLetrasErradas(null);
        System.out.println();

        System.out.println("Boneco:");
        rodada.exibirBoneco(null);
        System.out.println();
    }

    private static void printOpcoes() {
        System.out.println("[1] Tentar");
        System.out.println("[2] Arriscar");
    }

    private static void printResultadoFinal(Rodada rodada) {
        System.out.println("Resultado Final: " + (rodada.descobriu() ? "venceu" : "perdeu"));

        System.out.println("Total Tentativas: " + rodada.getQtdeTentativas());
        System.out.println("Tentativas Erradas: " + rodada.getQtdeErros());
        System.out.println("Tentativas Certas: " + rodada.getQtdeTentativasRestantes());
        System.out.println("Arriscou: " + (rodada.arriscou() ? "sim" : "não"));
        System.out.println("Pontos: " + rodada.calcularPontos());
    }
}