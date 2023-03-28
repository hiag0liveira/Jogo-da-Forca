package br.edu.iff.dominio.rodada;

import br.edu.iff.dominio.ObjetoDominioImpl;
import br.edu.iff.dominio.boneco.BonecoFactory;
import br.edu.iff.dominio.jogador.Jogador;
import br.edu.iff.dominio.letra.Letra;
import br.edu.iff.dominio.palavra.Palavra;

public class Rodada extends ObjetoDominioImpl {
    private final int maxPalavras = 3;
    private final int maxErros = 10;
    private final int pontosQuandoDescobreTodasAsPalavras = 100;
    private final int pontosPorLetraEncoberta = 15;

    private static BonecoFactory bonecoFactory;
    private final Item[] itens;
    private Letra[] erradas;
    private final Jogador jogador;

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
        this.erradas = erradas;
        this.jogador = jogador;
    }

    public static Rodada criar(long id, Palavra[] palavras, Jogador jogador) {
        return new Rodada(id, palavras, jogador);
    }

    public static Rodada reconstruir(long id, Item[] itens, Letra[] erradas, Jogador jogador) {
        return new Rodada(id, itens, erradas, jogador);
    }

    // TODO: continuar a implementação dos outros métodos
    // TODO: Revisar métodos estáticos
}
