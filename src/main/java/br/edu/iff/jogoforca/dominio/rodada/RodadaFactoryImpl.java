package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;

public abstract class RodadaFactoryImpl implements RodadaFactory {
    private RodadaRepository rodadaRepository;
    private TemaRepository temaRepository;
    private PalavraRepository palavraRepository;

    protected RodadaFactoryImpl(RodadaRepository rodadaRepository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
        this.rodadaRepository = rodadaRepository;
        this.temaRepository = temaRepository;
        this.palavraRepository = palavraRepository;
    }

    protected RodadaRepository getRodadaRepository() {
        return rodadaRepository;
    }

    protected TemaRepository getTemaRepository() {
        return temaRepository;
    }

    protected PalavraRepository getPalavraRepository() {
        return palavraRepository;
    }
}
