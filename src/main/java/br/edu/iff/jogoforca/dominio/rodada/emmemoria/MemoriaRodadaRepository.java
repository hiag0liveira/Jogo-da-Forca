package br.edu.iff.jogoforca.dominio.rodada.emmemoria;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.repository.RepositoryException;

public class MemoriaRodadaRepository implements RodadaRepository {

    private static MemoriaRodadaRepository soleInstance = null;
    //get set
    public static MemoriaRodadaRepository getSoleInstance() {
        if(soleInstance == null) {
            soleInstance = new MemoriaRodadaRepository();
        }
        return soleInstance;
    }

    private List<Rodada> pool;

    private MemoriaRodadaRepository() {
        pool = new ArrayList<>();
    }

    @Override
    public long getProximoId() {
        long contadorID = pool.size() + 1;
        return contadorID;
    }

    @Override
    public Rodada getPorId(Long id) {
        for(Rodada rodadaBuscada: pool) {
            if(rodadaBuscada.getId() == (id)) {
                return rodadaBuscada;
            }
        }
        throw new RuntimeException("Nenhuma rodada encontrada com esse ID: " + id);
    }

    @Override
    public List<Rodada> getPorJogador(Jogador jogador){
        List<Rodada> rodadasDoJogador = new ArrayList<Rodada>();

        for(Rodada rodadasBuscadaDoJogador: pool) {
            if(rodadasBuscadaDoJogador.getJogador() == jogador) {
                rodadasDoJogador.add(rodadasBuscadaDoJogador);
            }
        }
        return rodadasDoJogador;
    }

    @Override
    public void inserir(Rodada rodada) throws RepositoryException {
        if(pool.contains(rodada)) {
            throw new RepositoryException("A rodada já se encontra no repositório");
        }
        else {
            pool.add(rodada);
        }
    }

    @Override
    public void atualizar(Rodada rodada) throws RepositoryException {
    }

    @Override
    public void remover(Rodada rodada) throws RepositoryException {
        if(pool.contains(rodada)) {
            pool.remove(rodada);
        } else {
            throw new RepositoryException("rodada não localizada, rodada: " + rodada);
        }
    }

}