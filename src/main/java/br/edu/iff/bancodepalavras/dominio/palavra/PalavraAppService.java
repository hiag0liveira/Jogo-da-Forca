package br.edu.iff.bancodepalavras.dominio.palavra;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.repository.RepositoryException;

public class PalavraAppService {

	private static PalavraAppService soleInstance = null;
	private static TemaRepository temaRepository;
	private static PalavraRepository palavraRepository;
	private static PalavraFactory palavraFactory;

	private PalavraAppService(TemaRepository temaRepository, PalavraRepository palavraRepository,
			PalavraFactory palavraFactory) {
		PalavraAppService.temaRepository = temaRepository;
		PalavraAppService.palavraRepository = palavraRepository;
		PalavraAppService.palavraFactory = palavraFactory;
	}

	public static PalavraAppService getSoleInstance() {
		if (PalavraAppService.soleInstance == null) {
//			TemaRepository temaRepository = new TemaRepository();
			PalavraAppService.createSoleInstance(temaRepository, palavraRepository, palavraFactory);
		}
		return PalavraAppService.soleInstance;
	}

	public static void createSoleInstance(TemaRepository temaRepository, PalavraRepository palavraRepository,
			PalavraFactory palavraFactory) {

		soleInstance = new PalavraAppService(temaRepository, palavraRepository, palavraFactory);
	}

	public boolean novaPalavra(String palavra, Long idTema) {

		if (temaRepository.getPorId(idTema) == null) {
			throw new IllegalArgumentException("ID invalido");
		}

		if (palavraRepository.getPalavras(palavra) == null) {
			Tema tema = temaRepository.getPorId(idTema);
			Palavra novaPalavra = palavraFactory.getPalavra(palavra, tema);

			try {
				palavraRepository.inserir(novaPalavra);
				return true;
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				return false;
			}
		}

		return true;

	}
}
