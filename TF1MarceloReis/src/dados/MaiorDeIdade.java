package dados;

import visao.Janela;

public class MaiorDeIdade extends Pessoa {

	private Boolean vacinadaAnteriormente;

	public MaiorDeIdade(String nome, Character sexo,
			Data dataNascimento, StringBuilder cpf,
			Boolean vacinadaAnteriormente) {
		super(nome, sexo, dataNascimento, cpf);
		this.vacinadaAnteriormente = vacinadaAnteriormente;
	}

	public Boolean getVacinadaAnteriormente() {
		return vacinadaAnteriormente;
	}

	public String consultarMaiorDeIdade(){
		return "Nome: " + getNome() + "\n" +
				"Data de Nascimento: " + getDataNascimento() + "\n" +
				"Sexo: " + ((getSexo() == 'M') ? "Masculino\n" : "Feminino\n") +
				"CPF: " + getCpf() + "\n" +
				"Ja foi vacinado? " + ((getVacinadaAnteriormente()) ? "Sim\n" : "Nao\n");
	}
	
	public String toString() {
		return this.getNome() + Janela.tabular(this.getNome().length()).toString() + this.getDataNascimento() + Janela.tabular(this.getDataNascimento().toString().length()).toString() + 
				(this.getSexo() == 'M' ? "Masculino" + Janela.tabular(9) : "Feminino" + Janela.tabular(8)) + this.getCpf() + 
				Janela.tabular(this.getCpf().length()).toString() + (this.getVacinadaAnteriormente() ? "Sim" : "Nao");
	}
}