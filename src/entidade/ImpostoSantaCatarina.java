package entidade;

public class ImpostoSantaCatarina extends Imposto  {

	private static final Double IMPOSTOSANTA = 0.10;
	public ImpostoSantaCatarina(Double valor) {
		super(valor);

	}
@Override
public Double calcularImpostoEstadual() {
	
	return this.valor * IMPOSTOSANTA;
}
	
	
}
