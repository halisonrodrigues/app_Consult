package br.com.appconsult.empresa;

public class Empresa {

	private String nome;
	private String custo;

	public Empresa() {

	}

	public Empresa(String Nome, String Custo) {

		nome = Nome;
		custo = Custo;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCusto() {
		return custo;
	}

	public void setCusto(String custo) {
		this.custo = custo;
	}

}
