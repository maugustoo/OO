package dados;

import visao.Janela;

public class MenorDeIdade extends Pessoa{

	private Integer quantasVezesFoiVacinada;

	public MenorDeIdade(StringBuilder nome, Character sexo,
			Data dataNascimento, StringBuilder cpf,
			Integer quantasVezesFoiVacinada) {
		super(nome, sexo, dataNascimento, cpf);
		this.quantasVezesFoiVacinada = quantasVezesFoiVacinada;
	}

	public Integer getQuantasVezesFoiVacinada() {
		return quantasVezesFoiVacinada;
	}

	public String toString() {
		return this.getNome() + Janela.tabular(this.getNome().length()).toString() + this.getDataNascimento() + Janela.tabular(10).toString() + (this.getSexo() == 'M' ? "Masculino" : "Feminino") + Janela.tabular(8).toString() + this.getCpf() + 
				Janela.tabular(this.getCpf().length()).toString() + this.getQuantasVezesFoiVacinada();
	}
}