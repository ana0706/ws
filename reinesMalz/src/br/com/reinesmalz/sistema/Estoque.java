package br.com.reinesmalz.sistema;

import java.util.List;
import java.util.Scanner;
import br.com.reinesmalz.dao.ProdutoDAO;
import br.com.reinesmalz.model.Produto;

public class Estoque {
	private Scanner leitor;	
	private ProdutoDAO objetoDAO = new ProdutoDAO();
	private Inicio inicio = new Inicio();
	
	public void estoque() {
		this.leitor = new Scanner(System.in);
		System.out.println("1- Estoque completo " + "\n" + "2- Alterar "
							+ "\n" + "3- Adicionar " + "\n" + "4- Excluir " + "\n" + "5- Inicio" );
		
		
		int esc = this.leitor.nextInt();
		switch (esc) {
		case 1:
			listaItem();			
			break;
		case 2:
			alteraItem();
			break;
		case 3:
			adicionaItem();
			break;	
		case 4:
			excluiItem();
			break;
		case 5:
			this.inicio.inicio();
		default:
			if (esc < 1 || esc > 5 ) {
				 System.out.println("Opção invalida!");
				 estoque();}
			
			break;
		}
	}
	
	public void listaItem() {
		
		this.objetoDAO = new ProdutoDAO();
		List <Produto> lista = this.objetoDAO.listar();
		for (Produto p : lista) {
		      System.out.println("Id: " + p.getIdProduto() +  " | Nome: "+ p.getNome() 
		      					+  " | Valor: " + p.getValor() + " | Quantidade em estoque: "
		      					+ p.getQtdEstoque()+"\n" + " | Descrição: " 
				      					+ p.getDescricao());
		}
		 estoque();     
	} 
		
	  
	
	public void alteraItem() {
		
		this.leitor = new Scanner(System.in);
		
		System.out.println("Digite o ID do produto:");		
		int idProduto = this.leitor.nextInt();
		this.leitor.nextLine();
		
		System.out.println("Digite o Nome:");		
		String nome = this.leitor.next();
		
		System.out.println("Digite a descrição:");		
		String descricao = this.leitor.next();
		this.leitor.nextLine();
		
		System.out.println("Digite a quantidade em estoque:");		
		int qtdEstoque = this.leitor.nextInt();
		this.leitor.nextLine();
		
		System.out.println("Digite o valor:");	
		String v = this.leitor.next();		
		double valor = Double.parseDouble(v);
		
		
				
		Produto addProduto = new Produto(idProduto ,nome, descricao, qtdEstoque, valor);
	    this.objetoDAO.atualizar(addProduto);
	    
	    System.out.println("Item alterado: " + " | idProduto: " + idProduto + " | Nome: " + nome);
	    estoque();
	    
		}
		
	public void adicionaItem() {
		this.leitor = new Scanner(System.in);
		
		System.out.println("Digite o Nome:");		
		String nome = this.leitor.nextLine();
		
		System.out.println("Digite a descrição:");		
		String descricao = this.leitor.nextLine();
		
		System.out.println("Digite a quantidade em estoque:");		
		int qtdEstoque = this.leitor.nextInt();
		 this.leitor.nextLine();
		
		System.out.println("Digite o valor:");	
		String v = this.leitor.next();		
		double valor = Double.parseDouble(v);
		
		
		Produto addProduto = new Produto( nome, descricao, qtdEstoque, valor);
	    this.objetoDAO.salvar(addProduto);
	    
	    System.out.println("Item adicionado: " + nome);
	    estoque();
	}
	
	public void excluiItem() {
		this.leitor = new Scanner(System.in);
		System.out.println("Digite o ID do protudo à excluir: ");
		int id = this.leitor.nextInt();
		
		this.objetoDAO = new ProdutoDAO();
		this.objetoDAO.apagar(id);
		
		System.out.println("Item excluido com sucesso!");
		estoque();
		
	}
	
}
