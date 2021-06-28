package entidade;

import java.util.Comparator;

public class ComparadorPorNome implements Comparator<Empresa> {

	@Override
	public int compare(Empresa o1, Empresa o2) {
		// TODO Auto-generated method stub
		return o1.getNome().compareTo(o2.getNome());		
	}
	
}

