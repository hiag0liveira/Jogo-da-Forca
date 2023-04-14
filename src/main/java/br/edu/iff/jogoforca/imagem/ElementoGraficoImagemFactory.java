package br.edu.iff.jogoforca.imagem;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.jogoforca.ElementoGraficoFactory;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;

public class ElementoGraficoImagemFactory implements ElementoGraficoFactory{

	private static ElementoGraficoImagemFactory soleInstance = null;
	
	public static ElementoGraficoImagemFactory getSoleInstance() {
		if(soleInstance == null) {
			soleInstance = new ElementoGraficoImagemFactory();
		}
		return soleInstance;
	}
	
	@Override
	public Boneco getBoneco() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Letra getLetra(char codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Letra getLetraEncoberta() {
		// TODO Auto-generated method stub
		return null;
	}

}
