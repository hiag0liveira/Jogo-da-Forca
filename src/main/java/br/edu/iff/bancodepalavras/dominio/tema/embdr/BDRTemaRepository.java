package br.edu.iff.bancodepalavras.dominio.tema.embdr;

import java.util.List;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.repository.RepositoryException;

public class BDRTemaRepository implements TemaRepository {

    private static BDRTemaRepository soleInstance = null;

    public static BDRTemaRepository getSoleInstance() {
        if(BDRTemaRepository.soleInstance == null) {
            BDRTemaRepository.soleInstance = new BDRTemaRepository();
        }

        return BDRTemaRepository.soleInstance;
    }

    private BDRTemaRepository() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public long getProximoId() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Tema getPorId(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Tema> getPorNome(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Tema> getTodos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void inserir(Tema tema) throws RepositoryException {
        // TODO Auto-generated method stub

    }

    @Override
    public void remover(Tema tema) throws RepositoryException {
        // TODO Auto-generated method stub

    }

    @Override
    public void atualizar(Tema tema) throws RepositoryException {
        // TODO Auto-generated method stub

    }


}