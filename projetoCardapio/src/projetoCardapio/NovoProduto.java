package projetoCardapio;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class NovoProduto {
		private FileWriter arquivoBebida;
		private FileWriter arquivoVinho;
		private FileWriter arquivoPrato; 
		private Scanner leitor;
		private double valor;
		private String nome;
		

	
	public NovoProduto() {
		// TODO Auto-generated constructor stub
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
	
		 
		
		 
		 
	
	
	
	
	
}
