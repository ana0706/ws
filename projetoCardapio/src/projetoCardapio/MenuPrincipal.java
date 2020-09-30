package projetoCardapio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MenuPrincipal {
	private File arquivoVinho;
	private File arquivoBebida;
	private File arquivoPrato;
	private Scanner l;
	
	public MenuPrincipal() {
		// TODO Auto-generated constructor stub
		this.arquivoVinho = new File("/home/ana-caroline/ws/vinhos-tabulados.txt");
		this.arquivoBebida = new File ("/home/ana-caroline/ws/bebidas-tabuladas.txt");
		this.arquivoPrato = new File ("/home/ana-caroline/ws/pratos.csv");
		
		
	}
		
	
	public void cardapio() throws FileNotFoundException {
			
		this.l = new Scanner(System.in);							
		System.out.println("Qual cardapio deseja vizualizar? \n(1) Bebidas \n(2)Vinhos \n(3)Pratos \n(4)Fechar pedido");
			int opcao = l.nextInt();
						
			switch(opcao) {
			case 1:
				ListaProduto listaBebida= new ListaProduto(this.arquivoBebida, false);
				listaBebida.lerLista();							
				break;				
			case 2:
				ListaProduto listaVinho = new ListaProduto(this.arquivoVinho, false);
				listaVinho.lerLista();							
				break;
			case 3:
				ListaProduto listaPrato = new ListaProduto(this.arquivoPrato, true);
				listaPrato.lerLista();		
				break;
			case 4:
				Pedido pedido = new Pedido(opcao, null, opcao, null);
				pedido.pularLinha();
				cardapio();
				
			default:
				if(opcao >= 5) {
					cardapio();					
				};
				break;
			}			
		}
		
		
}
