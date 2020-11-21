package br.com.reinesmalz.sistema;


import java.util.List;
import java.util.Scanner;

import br.com.reinesmalz.dao.ClienteDAO;
import br.com.reinesmalz.dao.PedidoDAO;
import br.com.reinesmalz.model.Cliente;
import br.com.reinesmalz.model.Pedido;




public class PedidoSis {
	private Scanner leitor;
	private PedidoDAO pedidoDAO;
	private ClienteDAO clienteDAO;
	private Inicio inicio = new Inicio();
	

		
	public void escolha() {
		this.leitor = new Scanner(System.in);
		System.out.println("1- Historico de pedidos " + "\n" + "2- Lista de clientes" + "\n" + "3- Inicio" );
		int esc = this.leitor.nextInt();
		switch (esc) {
		case 1:
			historicoPedido();			
			break;
		case 2:
			listaCliente();
			break;
		case 3:
			this.inicio.inicio();
			break;	
		default:
			if (esc < 1 || esc > 2 ) {
				 System.out.println("Opção invalida!");
				 escolha();}
			break;
		}
			
	}

	public void historicoPedido() {
	this.pedidoDAO = new PedidoDAO();
	List <Pedido> lista = this.pedidoDAO.listar();
	
    for (Pedido p : lista) {
	      System.out.println("Id: " + p.getIdPedido() +  " | Id Cliente: " 
	               + p.getIdCliente() +  " | Valor: " + p.getValor());
	    }
    escolha();
	}
	
	public void listaCliente() {	
	
		this.clienteDAO = new ClienteDAO();
		 List<Cliente> lista = this.clienteDAO.listar();
		 
		 for (Cliente c : lista) {			 	 
		      System.out.println("Id Cliente: " + c.getIdCliente() + " | Nome: " + c.getNome() + " | CPF: " 
		               + c.getCpf() + " | Endereço: " + c.getEndereco() + " | Telefone: " 
		    		  + c.getTelefone());
		      }
		  escolha();
		 }
}