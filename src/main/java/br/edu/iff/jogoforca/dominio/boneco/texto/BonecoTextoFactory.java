package br.edu.iff.jogoforca.dominio.boneco.texto;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.BonecoFactory;

public class BonecoTextoFactory implements BonecoFactory {

	private static BonecoTextoFactory soleInstance = null;

	public static BonecoTextoFactory getSoleInstance() {
		
		if (BonecoTextoFactory.soleInstance == null) {
			BonecoTextoFactory.soleInstance = new BonecoTextoFactory();
		}
		return BonecoTextoFactory.soleInstance;
	}

	public BonecoTextoFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boneco getBoneco() {
		// TODO Auto-generated method stub
		return BonecoTexto.getSoleInstance();
	}

}
