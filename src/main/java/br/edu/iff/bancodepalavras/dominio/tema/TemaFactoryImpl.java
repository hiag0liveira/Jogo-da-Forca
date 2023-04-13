package br.edu.iff.bancodepalavras.dominio.tema;

import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.RepositoryException;

public class TemaFactoryImpl extends EntityFactory implements TemaFactory {

    private static TemaFactoryImpl soleInstance;

    public static void createSoleInstance(TemaRepository temaRepository) {
        if (soleInstance == null) {
            soleInstance = new TemaFactoryImpl(temaRepository);
        }
    }

    private TemaFactoryImpl(TemaRepository temaRepository) {
        super(temaRepository);
    }

    public static TemaFactoryImpl getSoleInstance() {
        if(soleInstance == null) {
            throw new RuntimeException("A fabricacao de repositorio de temas não foi iniciada");
        }
        else {
            return soleInstance;
        }

    }

    private TemaRepository getTemaRepository() {
        return (TemaRepository) getRepository();
    }

    @Override
    public Tema getTema(String nome) {
        Tema temaParaCriacao = Tema.criar(getProximoId(), nome);
        try {
            getTemaRepository().inserir(temaParaCriacao);
        }catch (RepositoryException e) {
            throw new RuntimeException("Ocorreu um erro erro ao tentar salvar o tema");
        }
        return temaParaCriacao;
    }

}