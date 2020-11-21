package br.com.reinesmalz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "Cliente")
@TableGenerator(
	    name = "gerador_id_Cliente",
	    table = "sqlite_sequence",
	    pkColumnName = "name",
	    valueColumnName = "seq",
	    pkColumnValue = "Cliente",
	    initialValue = 1,
	    allocationSize = 1
	)
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gerador_id_Cliente")
	private int idCliente;
	private String nome;
	private String cpf;
	private int telefone;
	private String endereco ;
	
	
	public Cliente(String nome, String cpf, int telefone, String endereco) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Cliente() {
		
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Cliente(int idCliente, String nome, String cpf, int telefone, String endereco) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	
	
}
	


