package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

import java.util.List;

public interface RodadaRepository extends Repository {

    public Rodada getPorId(Long id);

    public List<Rodada> getPorJogador(Jogador jogador);

    public void inserir(Rodada rodada) throws RepositoryException;

    public void atualizar(Rodada rodada) throws RepositoryException;

    public void remover(Rodada rodada) throws RepositoryException;
}
