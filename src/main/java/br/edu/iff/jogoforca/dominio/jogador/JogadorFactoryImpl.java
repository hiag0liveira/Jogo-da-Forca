package br.edu.iff.jogoforca.dominio.jogador;

import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.RepositoryException;

public class JogadorFactoryImpl extends EntityFactory implements JogadorFactory {

    private static JogadorFactoryImpl soleInstance;

    public static void createSoleInstance(JogadorRepository jogadorRepository) {
        if (soleInstance == null) {
            soleInstance = new JogadorFactoryImpl(jogadorRepository);
        }
    }

    private JogadorFactoryImpl(JogadorRepository jogadorRepository) {
        super(jogadorRepository);
    }

    public static JogadorFactoryImpl getSoleInstance() {
        if(soleInstance == null) {
            throw new RuntimeException(" A fabricacao de repositorio de Jogador não foi iniciada");
        }
        else {
            return soleInstance;
        }
    }

    private JogadorRepository getJogadorRepository() {
        return (JogadorRepository) getRepository();
    }


    @Override
    public Jogador getJogador(String nome) {
        Jogador jogadorParaCriacao = Jogador.criar(getProximoId(), nome);
        try {
            getJogadorRepository().inserir(jogadorParaCriacao);
        } catch ( RepositoryException e) {
            throw new RuntimeException ("Ocorreu um erro ao tentar salvar o jogador");

        }

        return jogadorParaCriacao;
    }

}