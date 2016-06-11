package dados;

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
		return this.getNome() + "\t" + this.getDataNascimento() + "\t" + (this.getSexo() == 'M' ? "Masculino  " : "Feminino  ") + this.getCpf() + "\t" + this.getQuantasVezesFoiVacinada();
	}
}