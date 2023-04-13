package br.edu.iff.bancodepalavras.dominio.palavra;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.RepositoryException;

public class PalavraFactoryImpl extends EntityFactory implements PalavraFactory{

    private static PalavraFactoryImpl soleInstance;

    public static void createSoleInstance(PalavraRepository palavraRepository) {
        if (soleInstance == null) {
            soleInstance = new PalavraFactoryImpl(palavraRepository);
        }
    }

    private PalavraFactoryImpl(PalavraRepository repository) {
        super(repository);
    }

    public static PalavraFactoryImpl getSoleInstance() {
        if(soleInstance == null) {
            throw new RuntimeException("A fabricacao de repositorio de palavras não foi iniciada");
        }
        else {
            return soleInstance;
        }
    }


    private PalavraRepository getPalavraRepository() {
        return (PalavraRepository) getRepository();
    }

    @Override
    public Palavra getPalavra(String palavra, Tema tema) {
        Palavra palavraParaCriacao = Palavra.criar(getProximoId(), palavra, tema);
        try {
            getPalavraRepository().inserir(palavraParaCriacao);
        } catch (RepositoryException e) {
            throw new RuntimeException("Ocorreu um erro ao tentar salvar a  palavra");
        }
        return palavraParaCriacao;
    }

}
