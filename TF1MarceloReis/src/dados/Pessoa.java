package dados;

public abstract class Pessoa implements Comparable<Pessoa>{

	private String nome;
	private Character sexo;
	private Data dataNascimento;
	private StringBuilder cpf;

	public Pessoa(String nome, Character sexo, Data dataNascimento,
			StringBuilder cpf) {
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public Character getSexo() {
		return sexo;
	}

	public Data getDataNascimento() {
		return dataNascimento;
	}

	public String consultarDados(){
		return "";
	}

	public StringBuilder getCpf() {
		return cpf;
	}

	@Override
	public int compareTo(Pessoa pessoa) {
		return (getNome().compareTo(pessoa.getNome()));
	}

}