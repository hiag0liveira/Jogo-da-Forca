package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;

public interface RodadaFactory {
    Rodada getRodada(Jogador jogador);
}
