package br.com.reinesmalz.sistema;

import java.util.List;
import java.util.Scanner;
import br.com.reinesmalz.dao.ClienteDAO;
import br.com.reinesmalz.model.Cliente;

public class Cadastro {
	private Scanner leitor;
	private ClienteDAO objetoDao = new ClienteDAO();
	private Inicio inicio = new Inicio();
	private int clienteId;
	
	
	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public void cadastro() {
		this.leitor = new Scanner(System.in);
		System.out.println("Já é nosso cliente?" + "\n"
							+ "1- Sim!" + "\n"
							+ "2- Não. Quero fazer meu cadastro!" + "\n"
							+ "3- Voltar");
		
		int escolha = this.leitor.nextInt();
		
		switch (escolha) {
		case 1:
			buscaCadastro();						
			break;
		case 2:
			novoCliente();
			break;
		case 3:
			this.inicio.inicio();
			break;	
		default:
			 if (escolha < 1 || escolha > 2 ) {
				 System.out.println("Opção invalida!");
				 cadastro();
			 }
			break;	
		}
	}
	
	public void novoCliente() {
		this.leitor = new Scanner(System.in);
			
		System.out.println("Digite o Nome:");		
		String nome = this.leitor.next();
		
		System.out.println("Digite o CPF:");		
		String cpf = this.leitor.next();
		
		System.out.println("Digite o Telefone:");		
		int telefone = this.leitor.nextInt();
		
		System.out.println("Digite o Endereço:");		
		String endereco = this.leitor.next();
		
		
		Cliente addCliente = new Cliente(nome, cpf, telefone, endereco);
	    this.objetoDao.salvar(addCliente);
	    
	    System.out.println("Cliente adicionado: " + nome);
	    
	   Cardapio cardapio = new Cardapio();
	   cardapio.escolhaCardapio();
		
	}
	
	public void buscaCadastro () {		
		this.leitor = new Scanner(System.in);
		System.out.println("Digite o CPF:");
		String cpf = this.leitor.next();
		
		this.objetoDao = new ClienteDAO();
		 
		Cliente c =  this.objetoDao .buscarPorCPF(cpf);
		 
		this.clienteId = c.getIdCliente();
		
		      System.out.println("Nome: " + c.getNome() + " CPF: " 
		               + c.getCpf() + " Endereço: " + c.getEndereco() + " Telefone: " + c.getTelefone());
		      
		      
		      Cardapio cardapio = new Cardapio();
			  cardapio.escolhaCardapio();
		      		 
	}
	

	

	
}
