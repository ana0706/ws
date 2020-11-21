package br.com.reinesmalz.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "itemPedido")
@TableGenerator(
	    name = "gerador_id_item",
	    table = "sqlite_sequence",
	    pkColumnName = "name",
	    valueColumnName = "seq",
	    pkColumnValue = "Pedido",
	    initialValue = 1,
	    allocationSize = 1
	)
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gerador_id_item")
	private int qtd;
	private int idProduto;
	private int idPedido;

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
		
	}
	public int getIdPedido() {
	    return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
}