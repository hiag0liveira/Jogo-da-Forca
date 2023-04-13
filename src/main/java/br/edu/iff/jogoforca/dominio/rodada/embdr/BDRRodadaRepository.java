package br.edu.iff.jogoforca.dominio.rodada.embdr;

import java.util.List;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.repository.RepositoryException;

public class BDRRodadaRepository implements RodadaRepository {

    private static BDRRodadaRepository soleInstance = null;

    //get e set
    public static BDRRodadaRepository getSoleInstance() {
        if(BDRRodadaRepository.soleInstance == null) {
            BDRRodadaRepository.soleInstance = new BDRRodadaRepository();
        }

        return BDRRodadaRepository.soleInstance;
    }
    //construtor
    private BDRRodadaRepository() {
        // TODO Auto-generated constructor stub
    }
    //metodos
    @Override
    public long getProximoId() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Rodada getPorId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Rodada> getPorJogador(Jogador jogador) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void inserir(Rodada rodada) throws RepositoryException {
        // TODO Auto-generated method stub

    }

    @Override
    public void atualizar(Rodada rodada) throws RepositoryException {
        // TODO Auto-generated method stub

    }

    @Override
    public void remover(Rodada rodada) throws RepositoryException {
        // TODO Auto-generated method stub

    }



}