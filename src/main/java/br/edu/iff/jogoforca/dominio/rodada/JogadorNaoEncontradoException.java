package br.edu.iff.jogoforca.dominio.rodada;

public class JogadorNaoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String jogador;
	
	public JogadorNaoEncontradoException(String string) {
		// TODO Auto-generated constructor stub
	}

	public String getJogador() {
		return jogador;
		
	}
}
