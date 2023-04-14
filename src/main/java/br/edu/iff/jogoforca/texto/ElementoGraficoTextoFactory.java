package br.edu.iff.jogoforca.texto;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.texto.LetraTextoFactory;
import br.edu.iff.jogoforca.ElementoGraficoFactory;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.texto.BonecoTextoFactory;

public class ElementoGraficoTextoFactory implements ElementoGraficoFactory {

	private static ElementoGraficoTextoFactory soleInstance = null;
	private LetraTextoFactory letraTextoFactory;
	private BonecoTextoFactory bonecoTextoFactory;

	public static ElementoGraficoTextoFactory getSoleInstance() {
		if (ElementoGraficoTextoFactory.soleInstance == null) {
			ElementoGraficoTextoFactory.soleInstance = new ElementoGraficoTextoFactory();
		}
		return soleInstance;
	}

	private ElementoGraficoTextoFactory() {
		bonecoTextoFactory = BonecoTextoFactory.getSoleInstance();
		letraTextoFactory = LetraTextoFactory.getSoleInstance();
	}

	@Override
	public Boneco getBoneco() {
		// TODO Auto-generated method stub
		return bonecoTextoFactory.getBoneco();
	}

	@Override
	public Letra getLetra(char codigo) {
		// TODO Auto-generated method stub
		return letraTextoFactory.getLetra(codigo);
	}

	@Override
	public Letra getLetraEncoberta() {
		// TODO Auto-generated method stub
		return letraTextoFactory.getLetraEncoberta();
	}

}
