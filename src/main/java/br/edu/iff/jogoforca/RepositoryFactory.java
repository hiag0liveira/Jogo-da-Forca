
package br.edu.iff.jogoforca;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;

public interface RepositoryFactory {

    public PalavraRepository getPalavraRepository();

    public TemaRepository getTemaRepository();

    public RodadaRepository getRodadaRepository();

    public JogadorRepository getJogadorRepository();

}