package br.edu.iff.bancodepalavras.dominio.letra.texto;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactoryImpl;

public class LetraTextoFactory extends LetraFactoryImpl {

	private static LetraTextoFactory soleInstance = null;

	public static LetraTextoFactory getSoleInstance() {

		if (LetraTextoFactory.soleInstance == null) {
			LetraTextoFactory.soleInstance = new LetraTextoFactory();
		}
		return LetraTextoFactory.soleInstance;

	}

	private LetraTextoFactory() {

	}

	@Override
	protected Letra criarLetra(char codigo) {
		// TODO Auto-generated method stub
		return new LetraTexto(codigo);
	}

}
