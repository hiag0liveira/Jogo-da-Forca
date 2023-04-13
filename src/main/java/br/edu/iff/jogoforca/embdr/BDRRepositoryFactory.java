package br.edu.iff.jogoforca.embdr;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.jogoforca.RepositoryFactory;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;

public class BDRRepositoryFactory implements RepositoryFactory  {

    private static BDRRepositoryFactory soleInstance = null;

    //get set
    public static BDRRepositoryFactory getSoleInstance() {
        if(BDRRepositoryFactory.soleInstance == null) {
            BDRRepositoryFactory.soleInstance = new BDRRepositoryFactory();
        }

        return BDRRepositoryFactory.soleInstance;
    }

    private BDRRepositoryFactory() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public PalavraRepository getPalavraRepository() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TemaRepository getTemaRepository() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public RodadaRepository getRodadaRepository() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JogadorRepository getJogadorRepository() {
        // TODO Auto-generated method stub
        return null;
    }



}
