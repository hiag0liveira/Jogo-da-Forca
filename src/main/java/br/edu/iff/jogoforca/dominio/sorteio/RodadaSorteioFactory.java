package br.edu.iff.jogoforca.dominio.sorteio;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaFactoryImpl;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;

public class RodadaSorteioFactory extends RodadaFactoryImpl {
    private static RodadaSorteioFactory soleInstance;

    private RodadaSorteioFactory(RodadaRepository rodadaRepository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
        super(rodadaRepository, temaRepository, palavraRepository);
    }

    @Override
    public Rodada getRodada(Jogador jogador) {
        return null;
    }

    public static void createSoleInstance(RodadaRepository rodadaRepository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
        if (soleInstance == null) {
            soleInstance = new RodadaSorteioFactory(rodadaRepository, temaRepository, palavraRepository);
        }
    }

    public static RodadaSorteioFactory getSoleInstance() {
        return soleInstance;
    }
}
