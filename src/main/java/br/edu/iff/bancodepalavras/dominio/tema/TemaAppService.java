package br.edu.iff.bancodepalavras.dominio.tema;

import br.edu.iff.repository.RepositoryException;

public class TemaAppService {

    private static TemaAppService soleInstance;
    private static TemaRepository temaRepository;
    private static TemaFactory temaFactory;

    private TemaAppService(TemaRepository temaRepository, TemaFactory temaFactory) {
        TemaAppService.temaRepository = temaRepository;
        TemaAppService.temaFactory = temaFactory;
    }

    public static void createSoleInstance(TemaRepository temaRepository, TemaFactory temaFactory) {
            soleInstance = new TemaAppService(temaRepository, temaFactory);
    }

    public static TemaAppService getSoleInstance() {
        if (TemaAppService.soleInstance == null) {
            TemaAppService.createSoleInstance(temaRepository, temaFactory);
        }
        return TemaAppService.soleInstance;
    }


    public boolean novoTema(String nomeDoTema){
        Tema temaParaCriacao = temaFactory.getTema(nomeDoTema);
        try {
            temaRepository.inserir(temaParaCriacao);
        }catch (RepositoryException e) {
            throw new RuntimeException("Ocorreu um erro erro ao tentar salvar o tema");
         }
        return true;
    }
}

