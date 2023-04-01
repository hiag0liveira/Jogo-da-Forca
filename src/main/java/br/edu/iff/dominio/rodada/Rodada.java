package br.edu.iff.dominio.rodada;

import br.edu.iff.dominio.ObjetoDominioImpl;
import br.edu.iff.dominio.boneco.BonecoFactory;
import br.edu.iff.dominio.jogador.Jogador;
import br.edu.iff.dominio.letra.Letra;
import br.edu.iff.dominio.palavra.Palavra;
import br.edu.iff.dominio.tema.Tema;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rodada extends ObjetoDominioImpl {
    private static int maxPalavras = 3;
    private static int maxErros = 10;
    private static int pontosQuandoDescobreTodasAsPalavras = 100;
    private static int pontosPorLetraEncoberta = 15;

    private static BonecoFactory bonecoFactory;
    private Item[] itens;
    private List<Letra> erradas;
    private Jogador jogador;

    private Rodada(long id, Palavra[] palavras, Jogador jogador) {
        super(id);

        this.itens = new Item[palavras.length];
        for (int i = 0; i < itens.length; i++) {
            this.itens[i] = Item.criar(i, palavras[i]);
        }

        this.jogador = jogador;
    }

    private Rodada(long id, Item[] itens, Letra[] erradas, Jogador jogador) {
        super(id);
        this.itens = itens;
        this.erradas = Arrays.asList(erradas);
        this.jogador = jogador;
    }

    public static int getMaxPalavras() {
        return maxPalavras;
    }

    public static void setMaxPalavras(int maxPalavras) {
        Rodada.maxPalavras = maxPalavras;
    }

    public static int getMaxErros() {
        return maxErros;
    }

    public static void setMaxErros(int maxErros) {
        Rodada.maxErros = maxErros;
    }

    public static int getPontosQuandoDescobreTodasAsPalavras() {
        return pontosQuandoDescobreTodasAsPalavras;
    }

    public static void setPontosQuandoDescobreTodasAsPalavras(int pontosQuandoDescobreTodasAsPalavras) {
        Rodada.pontosQuandoDescobreTodasAsPalavras = pontosQuandoDescobreTodasAsPalavras;
    }

    public static int getPontosPorLetraEncoberta() {
        return pontosPorLetraEncoberta;
    }

    public static void setPontosPorLetraEncoberta(int pontosPorLetraEncoberta) {
        Rodada.pontosPorLetraEncoberta = pontosPorLetraEncoberta;
    }

    public static BonecoFactory getBonecoFactory() {
        return bonecoFactory;
    }

    public static void setBonecoFactory(BonecoFactory bonecoFactory) {
        Rodada.bonecoFactory = bonecoFactory;
    }

    public static Rodada criar(long id, Palavra[] palavras, Jogador jogador) {
        return new Rodada(id, palavras, jogador);
    }

    public static Rodada reconstruir(long id, Item[] itens, Letra[] erradas, Jogador jogador) {
        return new Rodada(id, itens, erradas, jogador);
    }

    public Jogador getJogador() {
        return jogador;
    }

    public Palavra[] getPalavras() {
        Palavra[] palavras = new Palavra[itens.length];
        for (int i = 0; i < itens.length; i++) {
            palavras[i] = itens[i].getPalavra();
        }

        return palavras;
    }

    public Tema getTema() {
        if (itens.length == 0) {
            throw new IllegalStateException("itens tem que conter ao menos um item");
        }
        return itens[0].getPalavra().getTema();
    }

    public int getNumPalavras() {
        return itens.length;
    }

    public void tentar(char codigo) {
        if (encerrou()) {
            throw new IllegalStateException("A rodada já encerrou");
        }

        boolean palavraCorreta = false;
        for (Item item : itens) {
            if (item.tentar(codigo)) {
                palavraCorreta = true;
            }
        }

        if (!palavraCorreta) {
            // TODO: revisar essa código
            erradas.add(Palavra.getLetraFactory().getLetra(codigo));
        }
    }

    public void arriscar(String[] palavras) {
        if (!arriscou()) {
            throw new IllegalStateException("Só é permitido arriscar uma vez");
        }

        for (int i = 0; i < palavras.length; i++) {
            itens[i].arriscar(palavras[i]);
        }
    }

    public void exibirItens(Object contexto) {
        for (Item item : itens) {
            item.exibir(contexto);
        }
    }

    public void exibirBoneco(Object contexto) {
        getBonecoFactory().getBoneco().exibir(contexto, getErradas().length);
    }

    public void exibirPalavras(Object contexto) {
        for (Palavra palavra : getPalavras()) {
            palavra.exibir(contexto);
        }
    }

    public void exibirLetrasErradas(Object contexto) {
        for (Letra letra : erradas) {
            letra.exibir(contexto);
        }
    }

    public int getTentativas() {
        return getCertas().length + getErradas().length;
    }

    public Letra[] getCertas() {
        Set<Letra> certas = new HashSet<>();
        for (Item item : itens) {
            certas.addAll(Arrays.asList(item.getLetrasDescobertas()));
        }

        return certas.toArray(new Letra[0]);
    }

    public Letra[] getErradas() {
        return erradas.toArray(new Letra[0]);
    }

    public int calcularPontos() {
        if (!descobriu()) {
            return 0;
        }

        int pontos = pontosQuandoDescobreTodasAsPalavras;
        for (Item item : itens) {
            pontos += item.calcularPontosLetrasEncobertas(pontosPorLetraEncoberta);
        }

        return pontos;
    }

    public boolean encerrou() {
        return arriscou() || descobriu() || getQtdeTentativasRestantes() == 0;
    }

    public boolean descobriu() {
        for (Item item : itens) {
            if (!item.descobriu()) {
                return false;
            }
        }

        return true;
    }

    public boolean arriscou() {
        for (Item item : itens) {
            if (item.arriscou()) {
                return true;
            }
        }

        return false;
    }

    public int getQtdeTentativasRestantes() {
        return maxErros - getQtdeErros();
    }

    public int getQtdeErros() {
        return getErradas().length;
    }

    public int getQtdeAcertos() {
        return getCertas().length;
    }

    public int getQtdeTentativas() {
        return getQtdeErros() + getQtdeAcertos();
    }
}
