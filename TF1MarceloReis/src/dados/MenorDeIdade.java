package dados;

import visao.Janela;

public class MenorDeIdade extends Pessoa{

	private Integer quantasVezesFoiVacinada;

	public MenorDeIdade(String nome, Character sexo,
			Data dataNascimento, StringBuilder cpf,
			Integer quantasVezesFoiVacinada) {
		super(nome, sexo, dataNascimento, cpf);
		this.quantasVezesFoiVacinada = quantasVezesFoiVacinada;
	}

	public Integer getQuantasVezesFoiVacinada() {
		return quantasVezesFoiVacinada;
	}

	public String consultarDados(){
		return "Nome: " + getNome() + "\n" +
				"Data de Nascimento: " + getDataNascimento() + "\n" +
				"Sexo: " + ((getSexo() == 'M') ? "Masculino\n" : "Feminino\n") +
				"CPF: " + getCpf() + "\n" +
				"Quantas vezes ja foi vacinado: " + getQuantasVezesFoiVacinada();
	}
	
	public String toString() {
		return this.getNome() + Janela.tabular(this.getNome().length()).toString() + this.getDataNascimento() + Janela.tabular(this.getDataNascimento().toString().length()).toString() + 
				(this.getSexo() == 'M' ? "Masculino" + Janela.tabular(9) : "Feminino" + Janela.tabular(8)) + this.getCpf() + 
				Janela.tabular(this.getCpf().length()).toString() + this.getQuantasVezesFoiVacinada();
	}
}