package entidade;

public class Produto {
	
	private int idProduto;
	private int quantidade;
	private String produto;
	private double valor;
	private double valorFinal;
	
	//Cadastro do produto(Cadastrar quando for cadastro de produto e quando a nota for deletada)
	//Dele��o do produto(Deletar quando for adicionado a uma nota)
	//Relat�rio do produto(Quando for emitir uma nota quando acessar a op��o altera��o estoque)
	//Altera��o de estoque(Transfer�ncia �nica, e transferir todo o estoque)
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(double valorFinal) {
		this.valorFinal = valorFinal;
	}

	public String toString() { // Converte o objeto para ter uma sa�da 
		return "Quantidade: " + getQuantidade() + " | Produto: " + getProduto() + "| Valor: " + getValor() + "| Valor final: " + getValorFinal() + "\n";
	}
	
}
