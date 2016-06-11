/**Sintese: 
 * 		Objetivo: Fazer o controle de cadastros da gripe suina
 * 		Entradas: Nomes, Datas de Nascimento, CPFs, Sexos, Vacinado anteriormente, Quantidade de vezes que 
 * 				  foi vacinado anteriormente
 * 		Saidas:  Nomes, Datas de Nascimento, CPFs, Sexos, Vacinado anteriormente, Quantidade de vezes que 
 * 				  foi vacinado anteriormente
 */

package principal;

import dados.BancoDePacientes;
import visao.Janela;

public class Principal {

	public static void main(String[] args) {
		BancoDePacientes bancoPacientes = new BancoDePacientes();
		Janela frame = new Janela(bancoPacientes);
	}
}