package projetoCardapio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Cardapio {
		private FileWriter arquivoBebida;
		private FileWriter arquivoVinho;
		private FileWriter arquivoPrato;
		private File vinho;
		private File bebida;
		private File prato;
		private Scanner leitor;
		private double valor;
		private String nome;
		private String query;
		
		
		private List<Item>ListaProdutos = new ArrayList();
	
	public Cardapio() {
		// TODO Auto-generated constructor stub
		this.vinho = new File("/home/ana-caroline/ws/vinhos-tabulados.txt");
		this.bebida = new File ("/home/ana-caroline/ws/bebidas-tabuladas.txt");
		this.prato = new File ("/home/ana-caroline/ws/pratos.csv");
		try {
			this.arquivoBebida = new FileWriter("/home/ana-caroline/ws/bebidas-tabuladas.txt", true);
			this.arquivoVinho = new FileWriter("/home/ana-caroline/ws/vinhos-tabulados.txt", true);
			this.arquivoPrato = new FileWriter("/home/ana-caroline/ws/pratos.csv", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void detalheProduto() throws FileNotFoundException {
		this.leitor = new Scanner(System.in);
		System.out.println("Digite o valor do produto:(ex: 20,90)");
		this.valor = this.leitor.nextDouble();		
		System.out.println("Digite o nome do produto:");
		this.nome = this.leitor.next();
	}
	
	public void addProduto(FileWriter arquivo, boolean seExtensaoCsv) throws IOException {
		BufferedWriter gravador = new BufferedWriter(arquivo);
		gravador.newLine();		

		if(seExtensaoCsv) {
			gravador.write(this.nome +";" + this.valor);
		}else {
			gravador.write(this.valor + "\t" + this.nome);
		}		
		gravador.close();		
	}
	 
	 public void incluir() throws IOException {
		 this.leitor = new Scanner(System.in);
		 System.out.println("Digite o valor correspondente a lista desejada:\n (1)bebidas (2) vinhos (3) pratos. \n (4)Adicionar outro Produto. \n (5)Sair");
		 int opcao = this.leitor.nextInt();
		 
		 switch(opcao) {
			case 1:
				detalheProduto();		
				addProduto (this.arquivoBebida, false);
								
				break;				
			case 2:
				detalheProduto();
				addProduto (this.arquivoVinho, false);
				break;
			case 3:
				detalheProduto();
				addProduto (this.arquivoPrato, true);				
				break;
			case 4:
				incluir();
				break;
			case 5:
				
			default:
				
				break;
			}			 
	 }	 
	 
	 public void buscarCardapio() {
			this.leitor = new Scanner(System.in);
			System.out.println("Qual cardapio deseja atualizar? \n(1)Bebidas \n(2)Vinhos \n(3)Pratos \n(4)Sair");
			int opcao = leitor.nextInt();
			System.out.println("Qual item deseja buscar?");
			this.query = leitor.next();

			switch(opcao) {
			case 1:
				lista(this.bebida, false);
				buscarItem();
				break;				
			case 2:
				lista(this.vinho, false);
				buscarItem();
				break;
			case 3:
				lista(this.prato, true);
				buscarItem();
				break;
			case 4:
				break;			
			default:
				if(opcao >= 5) {
					System.out.println("Opção inválida!");					
				};
				break;
			}	
		}
	 
	 public void lista(File arquivo, boolean seExtensaoCsv){
		 
		 try {
			this.leitor = new Scanner(arquivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				
				this.ListaProdutos.add(produto);
				
		 }
			
	 }
			
	 public void buscarItem(){ 
		 String item;
		 for(int i = 0; i < this.ListaProdutos.size(); i++) {
			 item = this.ListaProdutos.get(i).getNome();
				if (item.contains(this.query)) {				
					System.out.println("item encontrado:" + item);
				}else {
					System.out.println("Item não econtrado");
				}
		 }
		 this.leitor.close();
	}
	 
	 
	 
	 
	 
	 }
	 
	 
	 
	 


		 
		 
	
	
	
	

