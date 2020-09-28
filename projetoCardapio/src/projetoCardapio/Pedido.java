package projetoCardapio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Pedido {
	private FileWriter arquivo;
	private int item;
	private double preco;
	private String nome;
	private String obs;
	
	
	public Pedido(int item, String nome, double preco, String obs) {
		try {
			arquivo = new FileWriter("/home/ana-caroline/ws/pedidos.txt", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.item = item;
		this.preco = preco;
		this.nome = nome;
		this.obs = obs;
				
	}
	
	public void pularLinha(){
		BufferedWriter gravador = new BufferedWriter(arquivo);
		try {
			gravador.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		try {
			gravador.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			gravador.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gravarPedido() throws IOException {
		BufferedWriter gravador = new BufferedWriter(arquivo);
						
		gravador.write( this.item + "\t " + this.preco + "\t" + this.nome + "\nObs:" + this.obs);		
		gravador.close();		
	}
}
