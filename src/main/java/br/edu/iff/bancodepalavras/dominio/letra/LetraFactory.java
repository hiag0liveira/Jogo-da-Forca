package br.edu.iff.bancodepalavras.dominio.letra;

public interface LetraFactory {
    Letra getLetra(char codigo);

    Letra getLetraEncoberta();
}
