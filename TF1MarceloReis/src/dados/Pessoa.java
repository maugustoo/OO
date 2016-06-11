package dados;

public abstract class Pessoa{

	private StringBuilder nome;
	private Character sexo;
	private Data dataNascimento;
	private StringBuilder cpf;
	
	public Pessoa(StringBuilder nome, Character sexo, Data dataNascimento,
			StringBuilder cpf) {
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
	}

	public StringBuilder getNome() {
		return nome;
	}

	public Character getSexo() {
		return sexo;
	}

	public Data getDataNascimento() {
		return dataNascimento;
	}

	public StringBuilder getCpf() {
		return cpf;
	}
}