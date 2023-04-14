package br.edu.iff.jogoforca.dominio.boneco.texto;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;

public class BonecoTexto implements Boneco {

	private static BonecoTexto soleInstance = null;

	public static BonecoTexto getSoleInstance() {
		if(BonecoTexto.soleInstance == null) {
			BonecoTexto.soleInstance = new BonecoTexto();
			
		}
		return BonecoTexto.soleInstance;
	}

	private BonecoTexto() {
		
	}

	@Override
	public void exibir(Object contexto, int partes) {
		
		if(partes == 1) {
			System.out.println("cabeça");
		}
		
		if(partes == 2) {
			System.out.println("cabeça, olho esquerdo");
		}
		
		if(partes == 3) {
			System.out.println("cabeça, olho esquerdo, olho direito");
		}
		
		if(partes == 4) {
			System.out.println("cabeça, olho esquerdo, olho direito, nariz");
		}
		
		if(partes == 5) {
			System.out.println("cabeça, olho esquerdo, olho direito, nariz, boca");
		}
		
		if(partes == 6) {
			System.out.println("cabeça, olho esquerdo, olho direito, nariz, boca, tronco");
		}
		
		if(partes == 7) {
			System.out.println("cabeça, olho esquerdo, olho direito, nariz, boca, tronco, braço esquerdo");
		}
		
		if(partes == 8) {
			System.out.println("cabeça, olho esquerdo, olho direito, nariz, boca, tronco, braço esquerdo, braço direito");
		}
		
		if(partes == 9) {
			System.out.println("cabeça, olho esquerdo, olho direito, nariz, boca, tronco, braço esquerdo, braço direito, perna esquerda");
		}
		
		if(partes == 10) {
			System.out.println("cabeça, olho esquerdo, olho direito, nariz, boca, tronco, braço esquerdo, braço direito, perna esquerda, perna direita");
		}
	}
}
