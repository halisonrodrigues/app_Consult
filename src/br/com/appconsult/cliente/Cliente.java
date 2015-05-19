package br.com.appconsult.cliente;

public class Cliente {

	private Long id;
	private String nomeDoCliente;
	private String telefone;
	private String email;
	private String cidade;
	private String rua;
	private String bairro;

	public Cliente(String telefone, String nomeDoCliente, Long id) {

		this.id = id;
		this.telefone = telefone;
		this.nomeDoCliente = nomeDoCliente;

	}

	public Cliente(String nomeDoCliente, String telefone, String email,
			String rua, String bairro, String cidade, Long id) {

		this.id = id;
		this.nomeDoCliente = nomeDoCliente;
		this.telefone = telefone;
		this.email = email;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getnomeDoCliente() {
		return nomeDoCliente;
	}

	public void setnomeDoCliente(String nomeDoCliente) {
		this.nomeDoCliente = nomeDoCliente;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
