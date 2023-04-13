package br.edu.iff.jogoforca.dominio.jogador;

public interface JogadorFactory {

    Jogador getJogador(String nome);
}