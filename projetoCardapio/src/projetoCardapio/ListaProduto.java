package projetoCardapio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaProduto {
	private List<Item> listaItem = new ArrayList<>();
	private Scanner leitor;
	
	
	
	
	public ListaProduto(File arquivo, Boolean seExtensaoCsv) throws FileNotFoundException {
		// TODO Auto-generated constructor stub		
		this.leitor = new Scanner(arquivo);
		this.leitor.nextLine();
		while(this.leitor.hasNext()) {			
			String linha = this.leitor.nextLine();
			String[] parte; 
			String valor;
			String nome;
			
			if (seExtensaoCsv) {
				parte = linha.split(";"); 
				nome = parte[0];
				valor = parte[1];
				
			} else {
				parte = linha.split("\t"); 
				valor = parte[0];
				nome = parte[1];
				
			}

			String ponto = valor.replace(",", ".");
			double preco = Double.parseDouble(ponto);
			
			Item produto = new Item();
			produto.setPreco(preco);
			produto.setNome(nome);
			
			this.listaItem.add(produto);
		}
		this.leitor.close();
	}
	
	public void lerLista() throws FileNotFoundException {
		// TODO Auto-generated constructor stub	/
		int item;
		String obs;
		this.leitor = new Scanner(System.in);
		
		for(int i = 1; i < this.listaItem.size(); i++) {
			double valor = this.listaItem.get(i).getPreco();
			String nome = this.listaItem.get(i).getNome();
			System.out.println(i + " R$" + valor + " " + nome);
			System.out.println("\n");			
		}
		
		System.out.println("Digite os itens desejados:");
		item = this.leitor.nextInt();
		System.out.println("Observações do pedido:");
		obs = this.leitor.next();
		
		opcaoVoltar();
		
		anotarPedido(
				item,
				this.listaItem.get(item).getNome(),
				this.listaItem.get(item).getPreco(),
				obs);
		this.leitor.close();
	}
	
	public void opcaoVoltar() throws FileNotFoundException {
			
			this.leitor = new Scanner(System.in);
			System.out.println("Voltar para realizar outros pedidos ou sair.(0)");
			int voltar = this.leitor.nextInt();
				if ( voltar < 1) {
					MenuPrincipal MenuPrincipal = new MenuPrincipal();
					MenuPrincipal.cardapio();
				};	
			this.leitor.close();	
		}
	
	public void anotarPedido(int item, String nome, double valor, String obs) {		
		Pedido pedido = new Pedido(item, nome, valor, obs);
		
		try {
			pedido.gravarPedido();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	
}
	
	
	
	
