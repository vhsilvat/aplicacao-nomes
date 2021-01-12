package br.com.confidencecambio.aplicacaonomes.entidades;

public class Pessoa {

	private Pessoa() {}

	public static class Cliente extends Humanoide {

		public Cliente(String nome) {
			super(nome);
		}
	}

	public static class Gerente extends Humanoide {

		public Gerente(String nome) {
			super(nome);
		}
	}
}
