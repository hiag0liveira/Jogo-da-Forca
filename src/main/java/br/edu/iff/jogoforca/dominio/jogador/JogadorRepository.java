package br.edu.iff.jogoforca.dominio.jogador;

import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

public interface JogadorRepository extends Repository {

    public Jogador getPorId(Long id);

    public Jogador getPorNome(String nome);

    public void inserir(Jogador jogador) throws RepositoryException;

    public void atualizar(Jogador jogador) throws RepositoryException;

    public void remover(Jogador jogador) throws RepositoryException;

}