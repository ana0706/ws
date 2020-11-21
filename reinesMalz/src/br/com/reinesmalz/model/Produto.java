package br.com.reinesmalz.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "Produto")
@TableGenerator(
	    name = "gerador_id_Produto",
	    table = "sqlite_sequence",
	    pkColumnName = "name",
	    valueColumnName = "seq",
	    pkColumnValue = "Produto",
	    initialValue = 1,
	    allocationSize = 1
	)
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gerador_id_Produto")
	private int idProduto;
	private String nome;
	private String descricao;
	private int qtdEstoque;
	private double valor;
	 
	public Produto () {
		
	}
	
	
	public Produto(int idProduto, String nome, String descricao, int qtdEstoque, double valor) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.valor = valor;
	}
	
	
	public Produto(String nome, String descricao, int qtdEstoque, double valor) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.valor = valor;
	}

	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQtdEstoque() {
		return qtdEstoque;
	}
	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
