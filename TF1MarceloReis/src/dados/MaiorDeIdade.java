package dados;

import visao.Janela;

public class MaiorDeIdade extends Pessoa {

	private Boolean vacinadaAnteriormente;

	public MaiorDeIdade(StringBuilder nome, Character sexo,
			Data dataNascimento, StringBuilder cpf,
			Boolean vacinadaAnteriormente) {
		super(nome, sexo, dataNascimento, cpf);
		this.vacinadaAnteriormente = vacinadaAnteriormente;
	}

	public Boolean getVacinadaAnteriormente() {
		return vacinadaAnteriormente;
	}

	public String toString() {
		return this.getNome() + Janela.tabular(this.getNome().length()).toString() + this.getDataNascimento() + Janela.tabular(10).toString() + (this.getSexo() == 'M' ? "Masculino" : "Feminino") + Janela.tabular(8).toString() + this.getCpf() + 
				Janela.tabular(this.getCpf().length()).toString() + (this.getVacinadaAnteriormente() ? "Sim" : "Nao");
	}
}