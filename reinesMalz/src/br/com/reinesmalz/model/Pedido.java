package br.com.reinesmalz.model;


import java.util.List;
import java.util.ArrayList;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "Pedido")
@TableGenerator(
	    name = "gerador_id_Pedido",
	    table = "sqlite_sequence",
	    pkColumnName = "name",
	    valueColumnName = "seq",
	    pkColumnValue = "Pedido",
	    initialValue = 1,
	    allocationSize = 1
	)
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gerador_id_Pedido")
	private int idPedido;
	private double valor;
	private int idCliente;
	
	@OneToMany
	private List<ItemPedido> itens;
	
	public Pedido() {
	itens = new ArrayList<ItemPedido>();
	}
		  
	public void adicionarItem(ItemPedido item) {
	itens.add(item);
	}


	public int getIdPedido() {
		return idPedido;
	}


	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public List<ItemPedido> getItens() {
		return itens;
	}


	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	
	
}
