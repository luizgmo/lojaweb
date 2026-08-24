package edu.ifsp.loja.modelo;

public class Cliente {
	private long id;
	private String nome;
	private boolean ativo;
	

	public Cliente(long id, String nome, boolean ativo) {
		this.id = id;
		this.nome = nome;
		this.ativo = ativo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
