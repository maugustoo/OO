package dados;

import interfac.ChavePessoa;

import java.util.ArrayList;
import java.util.List;

public class BancoDePacientes implements ChavePessoa{

	private List<MenorDeIdade> pessoasMenoresDeIdade;
	private List<MaiorDeIdade> pessoasMaioresDeIdade;

	public BancoDePacientes() {
		pessoasMenoresDeIdade = new ArrayList<MenorDeIdade>();
		pessoasMaioresDeIdade = new ArrayList<MaiorDeIdade>();
	}
	public List<MenorDeIdade> getPessoasMenoresDeIdade() {
		return pessoasMenoresDeIdade;
	}
	public void setPessoasMenoresDeIdade(MenorDeIdade pessoaMenorDeIdade) {
		pessoasMenoresDeIdade.add(pessoaMenorDeIdade);
	}
	public List<MaiorDeIdade> getPessoasMaioresDeIdade() {
		return pessoasMaioresDeIdade;
	}

	public void setPessoasMaioresDeIdade(MaiorDeIdade pessoaMaiorDeIdade) {
		pessoasMaioresDeIdade.add(pessoaMaiorDeIdade);
	}

	@Override
	public boolean tamanhoEValido(String cpf) {
		return cpf.length() == 11 ? true : false;
	}

	@Override
	public boolean primeiroDigitoVerificadorEValido(String cpf) {
		int verificador = 0;

		for(int count = 0, auxMult=10; count < 9; ++count, --auxMult){
			verificador += (cpf.charAt(count)-48) * auxMult;
		}
		verificador =  (verificador*10)%11;

		if(verificador == 10)
			verificador = 0;

		if(verificador == cpf.charAt(9)-48)
			return true;
		else{
			return false;
		}
	}

	@Override
	public boolean segundoDigitoVerificadorEValido(String cpf) {
		int verificador = 0;

		for(int count = 0, auxMult=11; count <= 9; ++count, --auxMult){
			verificador += (cpf.charAt(count)-48) * auxMult;
		}
		verificador =  (verificador*10)%11;

		if(verificador == 10)
			verificador = 0;

		if(verificador == cpf.charAt(10)-48)
			return true;
		else{
			return false;
		}
	}

	@Override
	public boolean cpfERepetido(String cpf) {

		cpf = cpf.replace(".", "").replace("-", "");

		for(int count = 0; count < pessoasMaioresDeIdade.size(); count++){
			if(pessoasMaioresDeIdade.get(count).getCpf().toString().replace(".", "").replace("-", "").equals(cpf)){
				return true;
			}
		}
		for(int count = 0; count < pessoasMenoresDeIdade.size(); count++){
			if(pessoasMenoresDeIdade.get(count).getCpf().toString().replace(".", "").replace("-", "").equals(cpf)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean cpfEValido(String cpf) {

		cpf = cpf.replace(".", "").replace("-", "");

		if(cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || 
				cpf.equals("44444444444")	|| cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") ||
				cpf.equals("88888888888") || cpf.equals("99999999999"))
			return false;
		if(tamanhoEValido(cpf) && primeiroDigitoVerificadorEValido(cpf) && segundoDigitoVerificadorEValido(cpf) && !cpfERepetido(cpf)){
			return true;
		}else
			return false;
	}
}