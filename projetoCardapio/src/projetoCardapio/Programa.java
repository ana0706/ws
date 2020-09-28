package projetoCardapio;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Programa {
		public static void main(String[] Args) throws FileNotFoundException {					
			//Inicialização do cardapio	
			
			
			Scanner leitor = new Scanner(System.in);			
			 
			System.out.println("Olá! \n Digite 1 para abrir pedido. \n Digite 2 para inserir itens aos cardápios. \n Digite 3 para atualizar itens dos cardápios. \n Digite 4 para excluir itens dos cardápios.");
			int op = leitor.nextInt();
			
			switch (op) {
			case 1:
				MenuPrincipal MenuPrincipal = new MenuPrincipal();
				MenuPrincipal.cardapio();
				break;
			case 2:
				NovoProduto novoProduto = new NovoProduto();
				try {
					novoProduto.incluir();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				AtualizarProduto atualizarProduto = new AtualizarProduto();	
				
				break;
			case 4:
				ExcluirProduto excluirProduto = new ExcluirProduto();
				break;				
			default:
				if(op >=5) {
					main(Args);
				}
				break;
			}
			
			leitor.close();					
		}
		
}		
		
		
		
			 
		

	
			
	

