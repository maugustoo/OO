package dados;

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
		return this.getNome() + "\t" + this.getDataNascimento() + "\t" + (this.getSexo() == 'M' ? "Masculino  " : "Feminino  ") + this.getCpf() + "\t" + 
				(this.getVacinadaAnteriormente() ? "Sim" : "Nao");
	}
}