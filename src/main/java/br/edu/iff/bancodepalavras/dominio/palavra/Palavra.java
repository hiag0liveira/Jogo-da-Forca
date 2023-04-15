package br.edu.iff.bancodepalavras.dominio.palavra;

import br.edu.iff.dominio.ObjetoDominioImpl;
import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactory;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;

import java.util.ArrayList;
import java.util.Arrays;

public class Palavra extends ObjetoDominioImpl {
    private static LetraFactory letraFactory;
    private final Tema tema;
    private final char[] letras;

    private Palavra(long id, String palavra, Tema tema) {
        super(id);
        this.letras = palavra.toCharArray();
        this.tema = tema;
    }

    public static Palavra criar(long id, String palavra, Tema tema) {
        return new Palavra(id, palavra, tema);
    }

    public static Palavra reconstituir(long id, String palavra, Tema tema) {
        return new Palavra(id, palavra, tema);
    }

    public static LetraFactory getLetraFactory() {
        return letraFactory;
    }

    public static void setLetraFactory(final LetraFactory letraFactory) {
        Palavra.letraFactory = letraFactory;
    }

    public Letra[] getLetras() {
        if (letraFactory == null) {
            throw new IllegalStateException("letraFactory não pode ser null");
        }

        Letra[] letras = new Letra[this.letras.length];
        for (int i = 0; i < letras.length; i++) {
            letras[i] = letraFactory.getLetra(this.letras[i]);
        }

        return letras;
    }

    public Letra getLetra(int posicao) {
        if (letraFactory == null) {
            throw new IllegalStateException("letraFactory não pode ser null");
        }

        if (posicao < 0 || posicao >= letras.length) {
            throw new IllegalArgumentException("posicao precisa estar entre 0 e letras.length");
        }

        return letraFactory.getLetra(letras[posicao]);
    }

    public void exibir(Object contexto) {
        boolean[] posicoes = new boolean[letras.length];
        Arrays.fill(posicoes, true);

        exibir(contexto, posicoes);
    }

    public void exibir(Object contexto, boolean[] posicoes) {
        for (int i = 0; i < letras.length; i++) {
            if (posicoes[i]) {
                Letra letra = letraFactory.getLetra(letras[i]);
                letra.exibir(contexto);
            } else {
                letraFactory.getLetraEncoberta().exibir(contexto);
            }
        }
    }

    public int[] tentar(char codigo) {
        ArrayList<Integer> posicoes = new ArrayList<>();
        for (int i = 0; i < letras.length; i++) {
            if (letras[i] == codigo) {
                posicoes.add(i);
            }
        }

        int[] array = new int[posicoes.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = posicoes.get(i);
        }

        return array;
    }

    public boolean compararPalavra(String palavra) {
        return new String(letras).equals(palavra);
    }

    public Tema getTema() {
        return tema;
    }

    public int getTamanho() {
        return letras.length;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Letra letra : getLetras()) {
            builder.append(letra.toString());
        }
        return builder.toString();
    }
}
