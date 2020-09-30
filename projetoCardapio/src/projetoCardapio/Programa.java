package projetoCardapio;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Programa {
		public static void main(String[] Args) throws Exception {					
			//Inicialização do cardapio	
			
			
			Scanner leitor = new Scanner(System.in);			
			 
			System.out.println(
					"Olá! \n"
					+ "Digite 1 para abrir pedido. \n"
					+ "Digite 2 para inserir itens aos cardápios. \n"
					+ "Digite 3 para buscar cardápios.");
			int op = leitor.nextInt();
			
			switch (op) {
			case 1:
				MenuPrincipal MenuPrincipal = new MenuPrincipal();
				MenuPrincipal.cardapio();
				break;
			case 2:
				Cardapio novoProduto = new Cardapio();
				try {
					novoProduto.incluir();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				Cardapio cardapio = new Cardapio();
				cardapio.buscarCardapio();							
				break;
			case 4:
				//uu
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
		
		
		
			 
		

	
			
	

