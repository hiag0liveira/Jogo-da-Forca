package br.edu.iff.dominio.item;

import br.edu.iff.dominio.ObjetoDominioImpl;
import br.edu.iff.dominio.letra.Letra;
import br.edu.iff.dominio.palavra.Palavra;

import java.util.ArrayList;
import java.util.List;

public class Item extends ObjetoDominioImpl {
    private Palavra palavra;
    private boolean[] posicoesDescobertas;
    private String palavraArriscada = null;

    private Item(long id) {
        super(id);
    }

    private Item(long id, Palavra palavra, int[] posicoesDescobertas, String palavraArriscada) {
        super(id);
        this.palavra = palavra;
        this.posicoesDescobertas = new boolean[palavra.getTamanho()];
        for (int posicao : posicoesDescobertas) {
            this.posicoesDescobertas[posicao] = true;
        }
        this.palavraArriscada = palavraArriscada;
    }

    public static Item criar(long id, Palavra palavra) {
        return new Item(id, palavra, new int[]{}, null);
    }

    public static Item reconstruir(long id, Palavra palavra, int[] posicoesDescobertas, String palavraArriscada) {
        return new Item(id, palavra, posicoesDescobertas, palavraArriscada);
    }

    public Palavra getPalavra() {
        return palavra;
    }

    public Letra[] getLetrasDescobertas() {
        return getLetras(true);
    }

    public Letra[] getLetrasEncobertas() {
        return getLetras(false);
    }

    private Letra[] getLetras(boolean estado) {
        List<Integer> posicoes = new ArrayList<>();
        for (int i = 0; i < this.posicoesDescobertas.length; i++) {
            if (this.posicoesDescobertas[i] == estado) {
                posicoes.add(i);
            }
        }

        Letra[] letras = new Letra[posicoes.size()];
        for (int i = 0; i < posicoes.size(); i++) {
            letras[i] = palavra.getLetra(posicoes.get(i));
        }

        return letras;
    }

    public int qtdeLetrasEncobertas() {
        return getLetrasEncobertas().length;
    }

    public int calcularPontosLetrasEncobertas(int valorPorLetraEncoberta) {
        // TODO: revisar essa implementação
        return qtdeLetrasEncobertas() * valorPorLetraEncoberta;
    }

    public boolean descobriu() {
        for (boolean descoberta : posicoesDescobertas) {
            if (!descoberta) {
                return false;
            }
        }

        return true;
    }

    public void exibir(Object contexto) {
        palavra.exibir(contexto);
    }

    public void tentar(char codigo) {
        int[] posicoes = palavra.tentar(codigo);
        for (int posicao : posicoes) {
            posicoesDescobertas[posicao] = true;
        }
    }

    public void arriscar(String palavra) {
        this.palavraArriscada = palavra;
    }

    public boolean arriscou() {
        return this.palavraArriscada != null;
    }

    public boolean acertou() {
        return palavra.compararPalavra(palavraArriscada);
    }
}
