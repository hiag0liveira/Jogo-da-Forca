package br.edu.iff;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	int opcao;
		Scanner sc = new Scanner(System.in); 

//Fazer a aplicacao
//    	Aplicacao aplicacao = Aplicacao.g
    	
    	//cadastro tema
//    	Tema temas = TemaFactory
    	
    	do {
    		System.out.println("1 - jogar");
			System.out.println("0 - sair");
			System.out.println("Escolha uma opção: ");
			opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Nome: ");
				String nomeJogador = sc.next();
				
				
				IniciarJogo();
				break;
				
			case 2:
				System.out.println("Obrigado por Jogar");
				break;
			}
			
		} while (opcao !=0);
    	sc.close();
    }

    
	private static void IniciarJogo() {
		// TODO Auto-generated method stub
		
	}
}