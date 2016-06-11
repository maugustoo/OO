package dados;

import java.util.Calendar;

public class Data {

	private Integer dia;
	private Integer mes;
	private Integer ano;
	
	public Data(Integer dia, Integer mes, Integer ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	public Integer getDia() {
		return dia;
	}
	public Integer getMes() {
		return mes;
	}

	public Integer getAno() {
		return ano;
	}

	public Integer getIdade(){
		int idade;
		
		idade = Calendar.getInstance().get(Calendar.YEAR) - this.getAno();
		
		if(Calendar.getInstance().get(Calendar.MONTH)+1 < this.getMes()){
			idade--;
		}
		if((Calendar.getInstance().get(Calendar.MONTH)+1 == this.getMes()) && 
				Calendar.getInstance().get(Calendar.DAY_OF_MONTH) < this.getDia()){
			idade--;
		}
		
		return idade;
	}
	
	@Override
	public String toString() {
		return dia + "/" + mes + "/" + ano;
	}	
}