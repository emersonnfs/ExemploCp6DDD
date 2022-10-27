package model;

public class Produto {
	private int id, quantidade;
	private double preco;
	private String nome;
	private Categoria categoria;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Produto() {
		
	}
	
	public Produto(int id, String nome, double preco, int quantidade, Categoria categoria) {
		this.id=id;
		this.nome=nome;
		this.preco=preco;
		this.quantidade=quantidade;
		this.categoria=categoria;
	}
	
}

