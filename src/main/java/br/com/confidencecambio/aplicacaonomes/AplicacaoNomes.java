package br.com.confidencecambio.aplicacaonomes;

import br.com.confidencecambio.aplicacaonomes.entidades.Humanoide;
import br.com.confidencecambio.aplicacaonomes.entidades.Maquina;
import br.com.confidencecambio.aplicacaonomes.entidades.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicacaoNomes {

	public static void main(String args[]) {

		List<Humanoide> listaEntidades = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		String nome = "";

		System.out.println("Nome completo do cliente: ");
		nome = scan.nextLine();
		while(nome.strip().isEmpty()) {
			checkIfNull(nome);
			nome = scan.nextLine();
		}
		listaEntidades.add(new Pessoa.Cliente(nome.strip()));

		System.out.println("Nome completo do gerente: ");
		nome = scan.nextLine();
		while(nome.strip().isEmpty()) {
			checkIfNull(nome);
			nome = scan.nextLine();
		}
		listaEntidades.add(new Pessoa.Gerente(nome.strip()));

		System.out.println("Nome completo do robo: ");
		nome = scan.nextLine();
		while(nome.strip().isEmpty()) {
			checkIfNull(nome);
			nome = scan.nextLine();
		}
		listaEntidades.add(new Maquina.Robo(nome.strip()));

		scan.close();

		for(Humanoide humanoide : listaEntidades) {
			System.out.println(getNomeClasse(humanoide));
			System.out.println("Primeiro nome: " +
					humanoide.retornarPrimeiroNome());
			System.out.println("Ultimo nome: " +
					humanoide.retornarUltimoNome());
			System.out.println("Nome maiusculo: " +
					humanoide.retornarNomeMaiusculo());
			System.out.println("Nome abreviado: " +
					humanoide.retornarNomeAbreviado());
		}

	}

	public static void checkIfNull(String nome) {
		if (nome.strip().isEmpty())
			System.out.println("Nome não pode ser vazio! Digite o nome " +
					"completo: ");

	}

	public static String getNomeClasse(Humanoide humanoide) {
		return "\n" + humanoide.getClass().getName().split("\\$")[1] + ":";
	}
}
