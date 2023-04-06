package br.edu.iff.bancodepalavras.dominio.tema;

import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

import java.util.List;

public interface TemaRepository extends Repository {

    public Tema getPorId(Long id);

    public List<Tema> getPorNome(String nome);

    public List<Tema> getTodos();

    public void inserir(Tema tema) throws RepositoryException;

    public void remover(Tema tema) throws RepositoryException;

    public void atualizar(Tema tema) throws RepositoryException;

}
