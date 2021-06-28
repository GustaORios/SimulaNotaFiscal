package apresentacao;

import java.util.ArrayList;

import entidade.Estoque;
import entidade.Produto;

public class cadastrarProduto {

	private static Produto produto = new Produto();
	private static Estoque estoque = new Estoque();
	
	public static ArrayList<Produto> renderizar() throws Exception {

		ArrayList<Produto> produtos = new ArrayList<Produto>(); 
		ArrayList<Estoque> estoques = new ArrayList<Estoque>(); 
		
		String[] opcao = { "Cadastrar produto" };
		
		boolean repitir = true;

		do {
			int menu = Console.mostrarMenu(opcao, "\nOpções", null);
			
			switch (menu) {
			
			case 1:
			produto = new Produto();
			estoque.setFilial(Console.recuperaTexto("Filial"));
			produto.setQuantidade(Console.recuperaInteiro("Quantidade"));
			produto.setProduto(Console.recuperaTexto("Produto"));
			produto.setValor(Console.recuperaDecimal("Valor do produto"));
			produto.setValorFinal(produto.getValor() * produto.getQuantidade());
		
			//produtos.add(produto);
			
			estoque.setProduto(produto);
			estoques.add(estoque);
			break;
			case -1:
				System.out.println("Voltando...");
				repitir = false;
				return produtos;
			}
		} while (repitir == true);
		return produtos;
		
	}
}
