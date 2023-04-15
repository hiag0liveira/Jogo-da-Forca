package br.edu.iff.jogoforca;

import br.edu.iff.bancodepalavras.dominio.letra.LetraFactory;
import br.edu.iff.bancodepalavras.dominio.palavra.*;
import br.edu.iff.bancodepalavras.dominio.tema.TemaAppService;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactory;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactoryImpl;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.jogoforca.dominio.boneco.BonecoFactory;
import br.edu.iff.jogoforca.dominio.jogador.JogadorFactory;
import br.edu.iff.jogoforca.dominio.jogador.JogadorFactoryImpl;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaAppService;
import br.edu.iff.jogoforca.dominio.rodada.RodadaFactory;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.jogoforca.dominio.sorteio.RodadaSorteioFactory;
import br.edu.iff.jogoforca.embdr.BDRRepositoryFactory;
import br.edu.iff.jogoforca.emmemoria.MemoriaRepositoryFactory;
import br.edu.iff.jogoforca.imagem.ElementoGraficoImagemFactory;
import br.edu.iff.jogoforca.texto.ElementoGraficoTextoFactory;

public class Aplicacao {
    private static final String[] TIPOS_REPOSITORY_FACTORY = {"memoria", "relacional"};
    private static final String[] TIPOS_ELEMENTO_GRAFICO = {"texto", "imagem"};
    private static final String[] TIPOS_RODADA_FACTORY = {"sorteio"};

    private String tipoRepositoryFactory = TIPOS_REPOSITORY_FACTORY[0];
    private String tipoElementoGraficoFactory = TIPOS_ELEMENTO_GRAFICO[0];
    private String tipoRodadaFactory = TIPOS_RODADA_FACTORY[0];

    private static Aplicacao soleInstance;

    private Aplicacao() {}

    public static Aplicacao getAplicacao() {
        if (soleInstance == null) {
            soleInstance = new Aplicacao();
        }

        return soleInstance;
    }

    public void configurar() {
        RepositoryFactory repositoryFactory = getRepositoryFactory();

        TemaRepository temaRepository = repositoryFactory.getTemaRepository();
        RodadaRepository rodadaRepository = repositoryFactory.getRodadaRepository();
        PalavraRepository palavraRepository = repositoryFactory.getPalavraRepository();
        JogadorRepository jogadorRepository = repositoryFactory.getJogadorRepository();

        TemaFactoryImpl.createSoleInstance(temaRepository);
        PalavraFactoryImpl.createSoleInstance(palavraRepository);
        JogadorFactoryImpl.createSoleInstance(jogadorRepository);
        RodadaSorteioFactory.createSoleInstance(rodadaRepository, temaRepository, palavraRepository);

        RodadaFactory rodadaFactory = getRodadaFactory();
        TemaAppService.createSoleInstance(temaRepository, getTemaFactory());
        PalavraAppService.createSoleInstance(temaRepository, palavraRepository, getPalavraFactory());
        RodadaAppService.createSoleInstance(rodadaFactory, rodadaRepository, jogadorRepository);

        Palavra.setLetraFactory(getLetraFactory());
        Rodada.setBonecoFactory(getBonecoFactory());
    }

    public String[] getTiposRepositoryFactory() {
        return TIPOS_REPOSITORY_FACTORY;
    }

    public void setTipoRepositoryFactory(String tipoRepositoryFactory) {
        this.tipoRepositoryFactory = tipoRepositoryFactory;
    }

    public String[] getTiposElementoGraficoFactory() {
        return TIPOS_ELEMENTO_GRAFICO;
    }

    public void setTipoElementoGraficoFactory(String tipoElementoGraficoFactory) {
        this.tipoElementoGraficoFactory = tipoElementoGraficoFactory;
    }

    public String[] getTiposRodadaFactory() {
        return TIPOS_RODADA_FACTORY;
    }

    public void setTipoRodadaFactory(String tipoRodadaFactory) {
        this.tipoRodadaFactory = tipoRodadaFactory;
    }

    public RepositoryFactory getRepositoryFactory() {
        switch (tipoRepositoryFactory) {
            case "memoria":
                return MemoriaRepositoryFactory.getSoleInstance();
            case "relacional":
                return BDRRepositoryFactory.getSoleInstance();
            default:
                throw new IllegalStateException("tipoRepositoryFactory não possui um valor válido");
        }
    }

    public ElementoGraficoFactory getElementoGraficoFactory() {
        switch (tipoElementoGraficoFactory) {
            case "texto":
                return ElementoGraficoTextoFactory.getSoleInstance();
            case "imagem":
                return ElementoGraficoImagemFactory.getSoleInstance();
            default:
                throw new IllegalStateException("tipoElementoGraficoFactory não possui um valor válido");
        }
    }

    public RodadaFactory getRodadaFactory() {
        if (tipoRodadaFactory.equals("sorteio")) {
            return RodadaSorteioFactory.getSoleInstance();
        }
        throw new IllegalStateException("tipoRodadaFactory não possui um valor válido");
    }

    public BonecoFactory getBonecoFactory() {
        return this.getElementoGraficoFactory();
    }

    public LetraFactory getLetraFactory() {
        return this.getElementoGraficoFactory();
    }

    public TemaFactory getTemaFactory() {
        return TemaFactoryImpl.getSoleInstance();
    }

    public PalavraFactory getPalavraFactory() {
        return PalavraFactoryImpl.getSoleInstance();
    }

    public JogadorFactory getJogadorFactory() {
        return JogadorFactoryImpl.getSoleInstance();
    }
}
