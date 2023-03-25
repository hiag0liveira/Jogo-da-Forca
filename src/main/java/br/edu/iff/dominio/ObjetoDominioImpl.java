package br.edu.iff.dominio;

public abstract class ObjetoDominioImpl implements ObjetoDominio {
    private final long id;

    public ObjetoDominioImpl(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }
}
