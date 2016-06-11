package servicos;

import java.util.Comparator;

import dados.Pessoa;

public class OrdenaNome implements Comparator<Pessoa> {
	public int compare(Pessoa nome1, Pessoa nome2) {
		return (nome1.getNome().toString().compareTo(nome2.getNome().toString()));
	}
}