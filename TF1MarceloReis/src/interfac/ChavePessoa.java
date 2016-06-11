package interfac;

public interface ChavePessoa {

	boolean digitosSaoValidos(String cpf);
	boolean tamanhoEValido(String cpf);
	boolean primeiroDigitoVerificadorEValido(String cpf);
	boolean segundoDigitoVerificadorEValido(String cpf);
	boolean cpfERepetido(String cpf);
	boolean cpfEValido(String cpf);
}