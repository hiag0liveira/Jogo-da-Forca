package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.repository.RepositoryException;

public class RodadaAppService {

	private static RodadaRepository rodadaRepository;
	private static RodadaFactory rodadaFactory;
	private static JogadorRepository jogadorRepository;
	private static RodadaAppService soleInstance = null;

	private RodadaAppService(RodadaFactory rodadaFactory, RodadaRepository rodadaRepository,
			JogadorRepository jogadorRepository) {
		RodadaAppService.jogadorRepository = jogadorRepository;
		RodadaAppService.rodadaFactory = rodadaFactory;
		RodadaAppService.rodadaRepository = rodadaRepository;
	}

	public static RodadaAppService getSoleInstance() {
		if(soleInstance == null) {
			RodadaAppService.createSoleInstance(rodadaFactory, rodadaRepository, jogadorRepository);
		}
		return RodadaAppService.soleInstance;	
	}
	
	
	public static void createSoleInstance(RodadaFactory rodadaFactory, RodadaRepository rodadaRepository,
			JogadorRepository jogadorRepository) {

		soleInstance = new RodadaAppService(rodadaFactory, rodadaRepository,
				jogadorRepository);
	}

	
	public Rodada novaRodada(Long idJogador) {
		Jogador jogador = jogadorRepository.getPorId(idJogador);
		if(jogador == null) {
			throw new IllegalArgumentException("Id do jogador invalido");
		}
		return rodadaFactory.getRodada(jogador);
	}
	
	
	public Rodada novaRodada(String nomeJogador) throws JogadorNaoEncontradoException {
		Jogador jogador = jogadorRepository.getPorNome(nomeJogador);
		if(jogador == null) {
			throw new JogadorNaoEncontradoException("Jogador não encontrado");
		}
		return rodadaFactory.getRodada(jogador);
	}
	
	
	public Rodada novaRodada(Jogador jogador) {
		return rodadaFactory.getRodada(jogador);
		
	}
	
	public boolean salvarRodada(Rodada rodada) throws RepositoryException {
		try {
			rodadaRepository.inserir(rodada);
			return true;
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			return false;
		}
		
	}
}
