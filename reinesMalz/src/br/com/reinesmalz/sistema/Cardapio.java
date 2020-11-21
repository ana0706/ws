package br.com.reinesmalz.sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.com.reinesmalz.dao.ProdutoDAO;
import br.com.reinesmalz.model.ItemPedido;
import br.com.reinesmalz.model.Pedido;
import br.com.reinesmalz.model.Produto;
import br.com.reinesmalz.dao.ItemPedidoDAO;
import br.com.reinesmalz.dao.PedidoDAO;


public class Cardapio {
	private Scanner leitor;
	private PedidoDAO pedidoDAO = new PedidoDAO();
	private ItemPedidoDAO itemDAO = new ItemPedidoDAO();
	private ProdutoDAO produtoDAO = new ProdutoDAO();
	private Cadastro cadastro = new Cadastro();
	private Inicio volta;
	private Pedido pedido = new Pedido();
	private int p;
	private double valTotal;
	
	
	public void escolhaCardapio() {
		this.volta = new Inicio ();
		
		this.leitor = new Scanner(System.in);
		System.out.println("Deseja visualizar cardapio?" + "\n"
							+ "1- Sim" + "\n"
							+ "2- Não, obrigada!");
		
		int escolha = this.leitor.nextInt();
		
		switch (escolha) {
		case 1:
			listaCardapio();		
			break;
		case 2:
			this.volta.inicio();
			break;
		default:
			if (escolha < 1 || escolha > 2 ) {
				 System.out.println("Opção invalida!");
				}
				 escolhaCardapio();
			break;
		}	
	}
		
	public void listaCardapio() {
		ProdutoDAO objetoDAO = new ProdutoDAO();
	
		List<Produto> lista = objetoDAO.listar();
	   
	    for (Produto p : lista) {
	      System.out.println("Id: " + p.getIdProduto() +  " | Nome: " 
	               			+ p.getNome() + "\n"+ "Descrição: "
	               			+ p.getDescricao() +  " | Valor: " + p.getValor());
	      	      
	    } 
	    criarPedido();
	}

	public void criarPedido() {
		
		// criar pedido
		this.valTotal = 0;
		int idCliente = this.cadastro.getClienteId();
		PedidoDAO pedidoDAO = new PedidoDAO();		
	    this.pedido = new Pedido();
	    this.pedido.setValor(this.valTotal);
	    this.pedido.setIdCliente(idCliente);
	    pedidoDAO.salvar(this.pedido);
	    this.p = this.pedido.getIdPedido();
	    
	    
	    
		this.leitor = new Scanner(System.in);
		 
		escolhaItem();
		
	}
	
	public void escolhaItem() {
	    	System.out.println("Insira o numero dos itens desejados:" + "\n");
			int idProduto = this.leitor.nextInt();
			this.leitor.nextLine();
			
			System.out.println("Insira a quantidade dos itens:" + "\n");
			int qtd =  this.leitor.nextInt();
			this.leitor.nextLine();
					
				
				ItemPedidoDAO itemDAO = new ItemPedidoDAO();
			    List<ItemPedido> listaDeItens = new ArrayList<ItemPedido>();
			    ItemPedido item = new ItemPedido();
			      item.setIdProduto(idProduto);
			      item.setQtd(qtd);
			      item.setIdPedido(this.p);
			      listaDeItens.add(item);
			      itemDAO.salvar(item);
			      
			      
			      int ip = idProduto;
			      this.produtoDAO = new ProdutoDAO();
			      List <Produto> lista = this.produtoDAO.listar();
			      for (Produto p : lista) {
			    	  if (ip == p.getIdProduto()) {
			    		 this.valTotal = this.pedido.getValor() + (p.getValor()* qtd);
			    		 this.pedido.setValor(valTotal);
			    		 ;
			    	  }
			      }
			      
			      System.out.println("Item adicionado " + idProduto + " | Qtd: " + item.getQtd() + " | Id pedido: " + this.pedido.getIdPedido()
			      + "\n" + "Valor Total: " + this.pedido.getValor());
			      esc();
			      	      
	    }
	    

	public void esc() {
			
			System.out.println("1 - Deseja adcionar mais um item. " + " | 2 - Fechar Pedido");
			int e = this.leitor.nextInt();
			switch (e) {
			case 1:
				escolhaItem();		
				break;
			case 2:
				this.volta.inicio();
			default:
				if (e < 1 || e > 2 ) {
					 System.out.println("Opção invalida!");
					
				this.leitor.nextLine();
				System.out.println("Digite novamente");
				e = this.leitor.nextInt();	
				}
				break;
			}	
		}
}	