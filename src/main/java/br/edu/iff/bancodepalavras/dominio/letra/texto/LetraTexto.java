package br.edu.iff.bancodepalavras.dominio.letra.texto;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;

public class LetraTexto extends Letra {

	protected LetraTexto(char codigo) {
		super(codigo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void exibir(Object contexto) {
		System.out.print(this.getCodigo());
		
	}

}
