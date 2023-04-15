package br.edu.iff.bancodepalavras.dominio.palavra.emmemoria;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.RepositoryException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoriaPalavraRepository implements PalavraRepository {

    private static MemoriaPalavraRepository soleInstance = null;

    public static MemoriaPalavraRepository getSoleInstance() {
        if(MemoriaPalavraRepository.soleInstance == null) {
            MemoriaPalavraRepository.soleInstance = new MemoriaPalavraRepository();
        }
        return MemoriaPalavraRepository.soleInstance;
    }

    private List<Palavra> pool;

    private MemoriaPalavraRepository() {
        pool = new ArrayList<>();
    }

    @Override
    public long getProximoId() {
        return pool.size() + 1;
    }

    @Override
    public Palavra getPorId(long id) {
        if (this.pool.size() > 0){
            for(Palavra palavraBuscada: pool) {
                if(palavraBuscada.getId() == id) {
                    return palavraBuscada;
                }
            }
        }
        throw new RuntimeException("Palavra não encontrada no ID: " + id);
    }

    @Override
    public List<Palavra> getPorTema(Tema tema){
        List<Palavra> palavrasEncontradasNoTema = new ArrayList<>();
        for(Palavra palavrasBuscadas: pool) {
            if(palavrasBuscadas.getTema() == tema) {
                palavrasEncontradasNoTema.add(palavrasBuscadas);
            }
        }
        return palavrasEncontradasNoTema;
    }

    @Override
    public List<Palavra> getTodas(){
        return Collections.unmodifiableList(pool);
    }

    @Override
    public Palavra getPalavras(String palavra) {
        for(Palavra palavraBuscada: pool) {
            if(palavraBuscada.compararPalavra(palavra)) {
                return palavraBuscada;
            }
        }

        return null;
    }

    @Override
    public void inserir(Palavra palavra) throws RepositoryException{
        if(pool.contains(palavra)) {
            throw new RepositoryException("A palavra já se encontra no repositório");
        }
        else {
            pool.add(palavra);
        }
    }


    @Override
    public void atualizar(Palavra palavra) throws RepositoryException {
    }


    @Override
    public void remover(Palavra palavra)throws RepositoryException{
        if(pool.contains(palavra)) {
            pool.remove(palavra);
        }
        else {
            throw new RepositoryException("Palavra não localizada no repositório");
        }
    }

}