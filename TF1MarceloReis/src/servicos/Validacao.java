package servicos;

import java.util.Calendar;

public class Validacao {

	public static boolean nameIsValid(String name){
		return name.isEmpty() ? false : true;
	}

	public static boolean qtdVezesVacinadaIsValid(int qtdVezes){
		return (qtdVezes>=0 && qtdVezes<100) ? true : false; 
	}

	public static boolean dataIsValid(int dia, int mes, int ano){
		if(mes==1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
			if(dia<1 || dia > 31)
				return false;

		}if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
			if(dia<1 || dia > 30)
				return false;

		}if(mes == 2){
			if(ano%4 == 0 && (ano%100!=0 || ano%400==0)){
				if(dia < 1 || dia > 29)
					return false;
			}else{
				if(dia < 1 || dia > 28)
					return false;
			}

		}if(mes<1 || mes>12){
			return false;

		}if(Calendar.getInstance().get(Calendar.YEAR) < ano){
			return false;
		}if(Calendar.getInstance().get(Calendar.YEAR) == ano && Calendar.getInstance().get(Calendar.MONTH)+1 < mes){
			return false;
		}if(Calendar.getInstance().get(Calendar.YEAR) == ano && Calendar.getInstance().get(Calendar.MONTH)+1 == mes && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) < dia){
			return false;
		}if(ano < 1900)
			return false;
		return true;
	}

}