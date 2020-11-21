package br.com.reinesmalz.sistema;
import java.util.Scanner;

public class Inicio {
	
	public void inicio() {
	
	Cadastro cadastro = new Cadastro();
	PedidoSis pedido = new PedidoSis();
	Estoque estoque = new Estoque();
	Scanner leitor = new Scanner(System.in);
	
	System.out.println("Seja Bem Vindo!" + "\n" + "Você Deseja: " + "\n"
						+ "1- Criar novo pedido." + "\n"
						+ "2- Consultar historico de pedidos e clientes." + "\n"
						+ "3- Consultar e alterar estoque.");													
	
	int escolha = leitor.nextInt();
	
	switch (escolha) {
	case 1:		
		cadastro.cadastro();		
		break;
	case 2:		
		pedido.escolha();
		break;
	case 3:
		estoque.estoque();						
		break;				
	default:
		if (escolha < 1 || escolha > 3 ) {
			 System.out.println("Opção invalida!");
			inicio();}
		break;
	}
	
	}
}
