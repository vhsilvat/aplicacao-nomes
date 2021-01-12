package br.com.confidencecambio.aplicacaonomes.entidades;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Humanoide {

	private String nome;

	public Humanoide(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String retornarPrimeiroNome() {

		String[] parte = nome.split("\\s+");

		return parte[0];
	}

	public String retornarUltimoNome() {

		String[] parte = nome.split("\\s+");
		if(parte.length == 1)
			return "Sem sobrenome!";

		// retira o primeiro nome
		List<String> arrayList = Stream.of(parte).collect(Collectors.toList());
		arrayList.remove(parte[0]);

		return arrayList.stream().map(Objects::toString).
				collect(Collectors.joining(" "));
	}

	public String retornarNomeMaiusculo() {
		return nome.toUpperCase();
	}

	public String retornarNomeAbreviado() {
		String[] parte = nome.split("\\s+");
		if(parte.length == 1)
			return "Sem sobrenome!";

		// retira o primeiro e o ultimo nome
		List<String> arrayList = Stream.of(parte).collect(Collectors.toList());
		arrayList.remove(parte[0]);
		arrayList.remove(parte[parte.length - 1]);

		StringBuilder nomeAbreviado = new StringBuilder();
		nomeAbreviado.append(parte[0] + " ");

		// se não ouver mais de um sobrenome, abrevie o ultimo nome
		if(arrayList.size() != 0) {
			arrayList.forEach(s -> nomeAbreviado.append(s.substring(0, 1) + ". "));
			nomeAbreviado.append(parte[parte.length - 1]);
		} else {
			nomeAbreviado.append(parte[parte.length - 1].substring(0, 1) + ".");
		}

		return nomeAbreviado.toString();
	}
}
