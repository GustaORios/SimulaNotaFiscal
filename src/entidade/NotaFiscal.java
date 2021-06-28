package entidade;

import java.util.ArrayList;
import java.util.Date;

public class NotaFiscal {
	
	public static final int CAPACIDADE_DEFAULT = 20;

	private Integer numero;
	private ArrayList<Produto> produtos;
	private Date dataEmissao;
	private Imposto imposto;
	private Double valor;
	private Double valorComImposto;
	private boolean cancelada;
	private String estado;
	
	public NotaFiscal(Integer numero, ArrayList<Produto> produtos2,  Double valor, String estado ,Imposto imposto) {
		
		this.numero = numero;
		this.produtos = produtos2;
		this.imposto = imposto;
		this.valor = valor;
		this.dataEmissao = new Date();
		this.valorComImposto = this.valor+imposto.calcularImpostoTotal();
		this.cancelada = false;
		this.estado = estado;
	
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Imposto getImposto() {
		return imposto;
	}

	public void setImposto(Imposto imposto) {
		this.imposto = imposto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorComImposto() {
		return valorComImposto;
	}

	public void setValorComImposto(Double valorComImposto) {
		this.valorComImposto = valorComImposto;
	}

	public boolean getCancelada() {
		return cancelada;
	}

	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}
	
	
	public NotaFiscal(String estado) {
		super();
		this.setEstado(estado);
	}

	@Override
	public String toString() {
		
		return "\nNumero da nota: " + this.numero  + "\nDescricao: " + this.produtos +  "\nData: " +
		this.dataEmissao + "\nEstado de emissão da nota: "+ this.estado+ "\nValor do Produto: " + this.valor + "\nImposto Federal: " + 
		this.imposto.calcularImpostoFederal() + "\nImposto Estadual: " + 
		this.imposto.calcularImpostoEstadual() + "\nTotal de Imposto: " + this.imposto.calcularImpostoTotal()
		+ "\nvalor total do Produto com Imposto: " + this.valorComImposto+ "\n" ; 
	}
	
	
	

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
