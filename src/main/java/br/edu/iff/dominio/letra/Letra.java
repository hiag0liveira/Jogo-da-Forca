package br.edu.iff.dominio.letra;

import java.util.Objects;

public abstract class Letra {
    private final char codigo;

    protected Letra(char codigo) {
        this.codigo = codigo;
    }

    public char getCodigo() {
        return codigo;
    }

    public abstract void exibir(Object contexto);

    @Override
    public String toString() {
        return String.valueOf(codigo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Letra letra = (Letra) o;
        return codigo == letra.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
