package entidade;

public class ImpostoParana extends Imposto {

	private static final Double IMPOSTOPARANA = 0.05;
	
	
	public ImpostoParana(Double valor) {
		super(valor);
	}

	@Override
	public Double calcularImpostoEstadual() {
		
		return  this.valor* IMPOSTOPARANA;
	}
	

	
}


