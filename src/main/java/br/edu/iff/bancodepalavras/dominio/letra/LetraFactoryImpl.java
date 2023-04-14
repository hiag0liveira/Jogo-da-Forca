package br.edu.iff.bancodepalavras.dominio.letra;

public abstract class LetraFactoryImpl implements LetraFactory {

	private Letra[] pool;
	private Letra encoberta;
	
	protected LetraFactoryImpl() {
		this.pool = new Letra[26];
		this.encoberta = null;
	}
			
	@Override
	public final Letra getLetra(char codigo) {
		if(codigo < 'a' || codigo > 'z') {
			throw new IllegalArgumentException("Carácter Invalido");
		}
		int i = codigo - 'a';
		Letra result = this.pool[i];
		if(result == null) {
			result = this.criarLetra(codigo);
			this.pool[i] = result;
		}
		return result;
	}

	protected abstract Letra criarLetra(char codigo);


	@Override
	public Letra getLetraEncoberta() {
		if(encoberta == null) {
			char codigo = '*';
			this.encoberta = criarLetra(codigo);
		}
		return this.encoberta;
	}

}
