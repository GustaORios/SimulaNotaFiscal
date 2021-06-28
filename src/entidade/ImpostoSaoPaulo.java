package entidade;

public class ImpostoSaoPaulo extends Imposto {

	private static final Double IMPOSTOPAULO = 0.18;

	public ImpostoSaoPaulo(Double valor) {
		super(valor);

	}
	
	@Override
	public Double calcularImpostoEstadual() {
	
		return this.valor * IMPOSTOPAULO;

}
	
}
