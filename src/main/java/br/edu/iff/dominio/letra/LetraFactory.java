package br.edu.iff.dominio.letra;

public interface LetraFactory {
    Letra getLetra(char codigo);

    Letra getLetraEncoberta();
}
