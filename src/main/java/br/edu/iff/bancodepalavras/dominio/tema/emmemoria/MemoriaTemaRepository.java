package br.edu.iff.bancodepalavras.dominio.tema.emmemoria;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.repository.RepositoryException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoriaTemaRepository implements TemaRepository {

    private static MemoriaTemaRepository soleInstance = null;

    private List<Tema> pool;

    private MemoriaTemaRepository() {
        pool = new ArrayList<>();
    }

    public static MemoriaTemaRepository getSoleInstance() {
        if(MemoriaTemaRepository.soleInstance == null) {
            MemoriaTemaRepository.soleInstance = new MemoriaTemaRepository();
        }
        return MemoriaTemaRepository.soleInstance;
    }

    @Override
    public long getProximoId() {
        return pool.size() + 1;
    }
    @Override
    public Tema getPorId(Long id) {
        for(Tema temaBuscado: pool) {
            if(temaBuscado.getId() == (id)) {
                return temaBuscado;
            }
        }
        throw new RuntimeException("nenhum tema encontrado o ID: " + id);
    }


    @Override
    public List<Tema> getPorNome(String nome){
        List<Tema> temasContidos = new ArrayList<>();
        for(Tema temaBuscado: pool) {
            if(temaBuscado.getNome().contains(nome)) {
                temasContidos.add(temaBuscado);
            }
        }
        return temasContidos;
    }

    @Override
    public List<Tema> getTodos() {
        // TODO Auto-generated method stub
        return Collections.unmodifiableList(pool);
    }

    @Override
    public void inserir(Tema tema) throws RepositoryException{
        if(pool.contains(tema)) {
            throw new RepositoryException("O tema já se encontra no repositório, tema: " + tema);
        }
        else {
            pool.add(tema);
        }
    }

    @Override
    public void atualizar(Tema tema) throws RepositoryException{
    }


    @Override
    public void remover(Tema tema) throws RepositoryException{
        if(pool.contains(tema)) {
            pool.remove(tema);
        }
        else {
            throw new RepositoryException("O Tema não se encontra no repositório, tema: " + tema);
        }
    }

}
