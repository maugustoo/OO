package visao;

import dados.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import servicos.OrdenaNome;
import servicos.Validacao;
import dados.BancoDePacientes;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class Janela extends JFrame {

	private BancoDePacientes pacientes;

	//Componentes do painel de entrada
	private JPanel painelEntrada;
	private JTextArea txtEntrada;
	private JButton btnContinuar;
	//Componentes do painel de Cadastrar Inicial
	private JPanel painelCadastrarInicial;
	private JTextField txtQualOTipo;
	private JButton btnVoltarAoMenuPrincipal;
	private JButton btnMenorDeIdade;
	private JButton btnMaiorDeIdade;
	//Componentes do painel de Cadastrar Maior de Idade
	private JPanel painelCadastrarMaiorDeIdade;
	private JTextField txtCadastroDoMaior;
	private JTextField txtNomeMaior;
	private JTextField textRecebeNomeMaior;
	private JTextField txtSexoMaior;
	private JTextField txtCpfMaior;
	private JTextField textRecebeCpfMaior;
	private JTextField txtDataNascimentoMaior;
	private JTextField textRecebeDiaNascimentoMaior;
	private JTextField textBarraDivisoriaNascimentoMaior;
	private JTextField textRecebeMesNascimentoMaior;
	private JTextField textBarraDivisoriaNascimento2Maior;
	private JTextField textRecebeAnoNascimentoMaior;
	private JButton btnFinalizarCadastroMaiorDeIdade;
	private JRadioButton rdbtnMasculinoMaior;
	private JRadioButton rdbtnFemininoMaior;
	private JTextField txtOPacienteJaVacinadoAnteriormente;
	private JRadioButton rdbtnJaVacinadoAnteriormenteSim;
	private JRadioButton rdbtnJaVacinadoAnteriormenteNao;
	//Componentes do painel de Cadastrar Menor Inicial
	private JPanel painelCadastrarMenorDeIdade;
	private JTextField txtCadastroDoMenor;
	private JTextField txtNomeMenor;
	private JTextField textRecebeNomeMenor;
	private JTextField txtSexoMenor;
	private JTextField txtCpfMenor;
	private JTextField textRecebeCpfMenor;
	private JTextField txtDataNascimentoMenor;
	private JTextField textRecebeDiaNascimentoMenor;
	private JTextField textBarraDivisoriaNascimentoMenor;
	private JTextField textRecebeMesNascimentoMenor;
	private JTextField textBarraDivisoriaNascimento2Menor;
	private JTextField textRecebeAnoNascimentoMenor;
	private JButton btnFinalizarCadastroMenorDeIdade;
	private JRadioButton rdbtnMasculinoMenor;
	private JRadioButton rdbtnFemininoMenor;
	private JTextField txtQuantasVezesOPacienteFoiVacinado;
	private JTextField textQtdVezesVacinado;
	private JButton btnCancelar;
	private JButton btnCancelarMaiorDeIdade;
	//Componentes do painel Consultar CPF
	private JPanel painelConsultarCpf;
	private JTextField textRecebeCpfConsulta;
	private JButton btnCancelarConsultarCpf;
	private JButton btnConsultar;
	//Componentes do painei pesquisar
	private JPanel painelPesquisar;
	private JTextField textFieldRecebeNomePesquisa;
	private JTable tablePesquisar;
	private JButton btnPesquisar;
	private JButton btnVoltarPesquisar;
	private JScrollPane scrollPane;
	
	
	/**
	 * Create the frame.
	 */
	public Janela(BancoDePacientes bancoPacientes) {

			getPainelEntrada();
		//	getMenuCadastrar();
		// 	getMenuCadastrarMaiorDeIdade();
		//  getMenuCadastrarMenorDeIdade();
		//	getConsultarCpf();
		//	getPesquisar();

		pacientes = bancoPacientes;

		setBackground(Color.DARK_GRAY);
		setTitle("H1N1");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 600, 350);
	}

	private void getPainelEntrada(){
		painelEntrada = new JPanel();
		painelEntrada.setBackground(Color.DARK_GRAY);
		painelEntrada.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelEntrada.setLayout(null);

		txtEntrada = new JTextArea();
		txtEntrada.setEditable(false);
		txtEntrada.setBackground(Color.DARK_GRAY);
		txtEntrada.setFont(new Font("Dialog", Font.ITALIC, 14));
		txtEntrada.setForeground(Color.LIGHT_GRAY);
		txtEntrada.setText("\t    BEM VINDO\n\t          AO\n                  BANCO DE CONTROLE\n\t          DA\n\t  GRIPE SUINA");
		txtEntrada.setBounds(158, 41, 249, 87);
		painelEntrada.add(txtEntrada);

		btnContinuar = new JButton("Continuar");
		btnContinuar.setForeground(Color.DARK_GRAY);
		btnContinuar.setBackground(Color.LIGHT_GRAY);
		btnContinuar.setBounds(246, 167, 141, 25);
		painelEntrada.add(btnContinuar);

		ActionListener actionListenerPainelEntrada = new ActionListener() {
			public void actionPerformed( ActionEvent e ) {
				if(e.getSource() == btnContinuar) {
					painelEntrada.setVisible(false);
					getContentPane().removeAll();
					getMenuGeral();
				}
			}
		};

		btnContinuar.addActionListener(actionListenerPainelEntrada);

		getContentPane().add( painelEntrada );
		setVisible(true);
	}

	private void getMenuGeral(){

		setVisible(false);
		
		switch(janelaMenuGeral()){
			case 0:
				getMenuCadastrar();
			break;
			case 1:
				listarPessoas();
				getMenuGeral();
			break;
			case 2:
			try {
				getConsultarCpf();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
			case 3:
				getPesquisar();
			break;
			case 4:
				System.exit(0);
		}
	}

	private void getMenuCadastrar(){
		painelCadastrarInicial = new JPanel();
		painelCadastrarInicial.setBackground(Color.DARK_GRAY);
		painelCadastrarInicial.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelCadastrarInicial.setLayout(null);

		txtQualOTipo = new JTextField();
		txtQualOTipo.setEditable(false);
		txtQualOTipo.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 18));
		txtQualOTipo.setForeground(Color.LIGHT_GRAY);
		txtQualOTipo.setBackground(Color.DARK_GRAY);
		txtQualOTipo.setText("Qual o tipo de pessoa?");
		txtQualOTipo.setBounds(186, 62, 232, 19);
		painelCadastrarInicial.add(txtQualOTipo);
		txtQualOTipo.setColumns(10);

		btnMaiorDeIdade = new JButton("Maior de Idade");
		btnMaiorDeIdade.setForeground(Color.DARK_GRAY);
		btnMaiorDeIdade.setBackground(Color.LIGHT_GRAY);
		btnMaiorDeIdade.setBounds(228, 104, 154, 25);
		painelCadastrarInicial.add(btnMaiorDeIdade);

		btnMenorDeIdade = new JButton("Menor de Idade");
		btnMenorDeIdade.setBackground(Color.LIGHT_GRAY);
		btnMenorDeIdade.setBounds(228, 156, 154, 25);
		painelCadastrarInicial.add(btnMenorDeIdade);

		btnVoltarAoMenuPrincipal = new JButton("Voltar ao Menu Principal");
		btnVoltarAoMenuPrincipal.setBackground(Color.LIGHT_GRAY);
		btnVoltarAoMenuPrincipal.setBounds(202, 205, 207, 25);
		painelCadastrarInicial.add(btnVoltarAoMenuPrincipal);

		ActionListener actionListenerCadastrarInicial = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnMaiorDeIdade){
					painelCadastrarInicial.setVisible(false);
					getContentPane().removeAll();
					try {
						getMenuCadastrarMaiorDeIdade();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}else if(e.getSource() == btnMenorDeIdade){
					painelCadastrarInicial.setVisible(false);
					getContentPane().removeAll();
					try {
						getMenuCadastrarMenorDeIdade();
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}else if(e.getSource() == btnVoltarAoMenuPrincipal){
					painelCadastrarInicial.setVisible(false);
					getContentPane().removeAll();
					getMenuGeral();
				}
			}
		};

		btnMaiorDeIdade.addActionListener(actionListenerCadastrarInicial);
		btnMenorDeIdade.addActionListener(actionListenerCadastrarInicial);
		btnVoltarAoMenuPrincipal.addActionListener(actionListenerCadastrarInicial);

		getContentPane().add( painelCadastrarInicial );
		setVisible(true);
	}

	private void getMenuCadastrarMaiorDeIdade() throws ParseException{
		painelCadastrarMaiorDeIdade = new JPanel();
		painelCadastrarMaiorDeIdade.setBackground(Color.DARK_GRAY);
		painelCadastrarMaiorDeIdade.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelCadastrarMaiorDeIdade.setLayout(null);

		txtCadastroDoMaior = new JTextField();
		txtCadastroDoMaior.setEditable(false);
		txtCadastroDoMaior.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		txtCadastroDoMaior.setForeground(Color.LIGHT_GRAY);
		txtCadastroDoMaior.setBackground(Color.DARK_GRAY);
		txtCadastroDoMaior.setText("Cadastro do Maior de Idade");
		txtCadastroDoMaior.setBounds(184, 12, 220, 19);
		painelCadastrarMaiorDeIdade.add(txtCadastroDoMaior);
		txtCadastroDoMaior.setColumns(10);

		txtNomeMaior = new JTextField();
		txtNomeMaior.setForeground(Color.LIGHT_GRAY);
		txtNomeMaior.setBackground(Color.DARK_GRAY);
		txtNomeMaior.setEditable(false);
		txtNomeMaior.setText("Nome: ");
		txtNomeMaior.setBounds(12, 63, 46, 19);
		painelCadastrarMaiorDeIdade.add(txtNomeMaior);
		txtNomeMaior.setColumns(10);

		textRecebeNomeMaior = new JTextField();
		textRecebeNomeMaior.setBounds(70, 63, 334, 19);
		painelCadastrarMaiorDeIdade.add(textRecebeNomeMaior);
		textRecebeNomeMaior.setColumns(30);

		txtSexoMaior = new JTextField();
		txtSexoMaior.setForeground(Color.LIGHT_GRAY);
		txtSexoMaior.setBackground(Color.DARK_GRAY);
		txtSexoMaior.setEditable(false);
		txtSexoMaior.setText("Sexo: ");
		txtSexoMaior.setBounds(12, 94, 46, 19);
		painelCadastrarMaiorDeIdade.add(txtSexoMaior);
		txtSexoMaior.setColumns(10);

		ButtonGroup radiosButons = new ButtonGroup();
		rdbtnMasculinoMaior = new JRadioButton("Masculino");
		rdbtnMasculinoMaior.setBackground(Color.DARK_GRAY);
		rdbtnMasculinoMaior.setForeground(Color.LIGHT_GRAY);
		rdbtnMasculinoMaior.setBounds(70, 92, 149, 23);
		painelCadastrarMaiorDeIdade.add(rdbtnMasculinoMaior);
		radiosButons.add(rdbtnMasculinoMaior);

		rdbtnFemininoMaior = new JRadioButton("Feminino");
		rdbtnFemininoMaior.setBackground(Color.DARK_GRAY);
		rdbtnFemininoMaior.setForeground(Color.LIGHT_GRAY);
		rdbtnFemininoMaior.setBounds(255, 92, 149, 23);
		painelCadastrarMaiorDeIdade.add(rdbtnFemininoMaior);
		radiosButons.add(rdbtnFemininoMaior);

		txtCpfMaior = new JTextField();
		txtCpfMaior.setForeground(Color.LIGHT_GRAY);
		txtCpfMaior.setBackground(Color.DARK_GRAY);
		txtCpfMaior.setEditable(false);
		txtCpfMaior.setText("CPF: ");
		txtCpfMaior.setBounds(12, 125, 46, 19);
		txtCpfMaior.setToolTipText("Digite apenas numeros");
		painelCadastrarMaiorDeIdade.add(txtCpfMaior);
		txtCpfMaior.setColumns(10);

		textRecebeCpfMaior = new JFormattedTextField(new MaskFormatter("###########"));
		textRecebeCpfMaior.setBounds(64, 125, 155, 19);
		painelCadastrarMaiorDeIdade.add(textRecebeCpfMaior);
		textRecebeCpfMaior.setColumns(11);

		txtDataNascimentoMaior = new JTextField();
		txtDataNascimentoMaior.setForeground(Color.LIGHT_GRAY);
		txtDataNascimentoMaior.setBackground(Color.DARK_GRAY);
		txtDataNascimentoMaior.setEditable(false);
		txtDataNascimentoMaior.setText("Data Nascimento: ");
		txtDataNascimentoMaior.setBounds(12, 156, 114, 19);
		txtDataNascimentoMaior.setToolTipText("(dd/mm/aaaa)");
		painelCadastrarMaiorDeIdade.add(txtDataNascimentoMaior);
		txtDataNascimentoMaior.setColumns(10);

		textRecebeDiaNascimentoMaior = new JFormattedTextField(new MaskFormatter("##"));
		textRecebeDiaNascimentoMaior.setBounds(138, 156, 20, 19);
		painelCadastrarMaiorDeIdade.add(textRecebeDiaNascimentoMaior);
		textRecebeDiaNascimentoMaior.setColumns(2);

		textBarraDivisoriaNascimentoMaior = new JTextField();
		textBarraDivisoriaNascimentoMaior.setBackground(Color.DARK_GRAY);
		textBarraDivisoriaNascimentoMaior.setForeground(Color.LIGHT_GRAY);
		textBarraDivisoriaNascimentoMaior.setEditable(false);
		textBarraDivisoriaNascimentoMaior.setText("/");
		textBarraDivisoriaNascimentoMaior.setBounds(170, 156, 9, 19);
		painelCadastrarMaiorDeIdade.add(textBarraDivisoriaNascimentoMaior);
		textBarraDivisoriaNascimentoMaior.setColumns(1);

		textRecebeMesNascimentoMaior = new JFormattedTextField(new MaskFormatter("##"));
		textRecebeMesNascimentoMaior.setBounds(191, 156, 20, 19);
		painelCadastrarMaiorDeIdade.add(textRecebeMesNascimentoMaior);
		textRecebeMesNascimentoMaior.setColumns(2);

		textBarraDivisoriaNascimento2Maior = new JTextField();
		textBarraDivisoriaNascimento2Maior.setForeground(Color.LIGHT_GRAY);
		textBarraDivisoriaNascimento2Maior.setBackground(Color.DARK_GRAY);
		textBarraDivisoriaNascimento2Maior.setEditable(false);
		textBarraDivisoriaNascimento2Maior.setText("/");
		textBarraDivisoriaNascimento2Maior.setBounds(228, 156, 9, 19);
		painelCadastrarMaiorDeIdade.add(textBarraDivisoriaNascimento2Maior);
		textBarraDivisoriaNascimento2Maior.setColumns(1);

		textRecebeAnoNascimentoMaior = new JFormattedTextField(new MaskFormatter("####"));
		textRecebeAnoNascimentoMaior.setBounds(249, 156, 55, 19);
		painelCadastrarMaiorDeIdade.add(textRecebeAnoNascimentoMaior);
		textRecebeAnoNascimentoMaior.setColumns(4);

		txtOPacienteJaVacinadoAnteriormente = new JTextField();
		txtOPacienteJaVacinadoAnteriormente.setForeground(Color.LIGHT_GRAY);
		txtOPacienteJaVacinadoAnteriormente.setBackground(Color.DARK_GRAY);
		txtOPacienteJaVacinadoAnteriormente.setEditable(false);
		txtOPacienteJaVacinadoAnteriormente.setText("O paciente ja foi vacinado anteriormente?");
		txtOPacienteJaVacinadoAnteriormente.setBounds(12, 190, 269, 19);
		painelCadastrarMaiorDeIdade.add(txtOPacienteJaVacinadoAnteriormente);
		txtOPacienteJaVacinadoAnteriormente.setColumns(10);

		ButtonGroup yesNoOption = new ButtonGroup();
		rdbtnJaVacinadoAnteriormenteSim = new JRadioButton("Sim");
		rdbtnJaVacinadoAnteriormenteSim.setForeground(Color.LIGHT_GRAY);
		rdbtnJaVacinadoAnteriormenteSim.setBackground(Color.DARK_GRAY);
		rdbtnJaVacinadoAnteriormenteSim.setBounds(299, 188, 55, 23);
		painelCadastrarMaiorDeIdade.add(rdbtnJaVacinadoAnteriormenteSim);
		yesNoOption.add(rdbtnJaVacinadoAnteriormenteSim);

		rdbtnJaVacinadoAnteriormenteNao = new JRadioButton("Nao");
		rdbtnJaVacinadoAnteriormenteNao.setForeground(Color.LIGHT_GRAY);
		rdbtnJaVacinadoAnteriormenteNao.setBackground(Color.DARK_GRAY);
		rdbtnJaVacinadoAnteriormenteNao.setBounds(369, 188, 55, 23);
		painelCadastrarMaiorDeIdade.add(rdbtnJaVacinadoAnteriormenteNao);
		yesNoOption.add(rdbtnJaVacinadoAnteriormenteNao);

		btnFinalizarCadastroMaiorDeIdade = new JButton("Finalizar Cadastro");
		btnFinalizarCadastroMaiorDeIdade.setBackground(Color.LIGHT_GRAY);
		btnFinalizarCadastroMaiorDeIdade.setBounds(100, 240, 175, 25);
		painelCadastrarMaiorDeIdade.add(btnFinalizarCadastroMaiorDeIdade);

		btnCancelarMaiorDeIdade = new JButton("Cancelar");
		btnCancelarMaiorDeIdade.setBackground(Color.LIGHT_GRAY);
		btnCancelarMaiorDeIdade.setBounds(339, 240, 175, 25);
		painelCadastrarMaiorDeIdade.add(btnCancelarMaiorDeIdade);

		ActionListener actionListenerCadastrarMaior = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				boolean nameIsValid, cpfIsValid, dateIsValid, sexoIsValid=true, vacinadoAnteriormente=true;

				if(e.getSource() == btnCancelarMaiorDeIdade){
					painelCadastrarMaiorDeIdade.setVisible(false);
					getContentPane().removeAll();
					getMenuCadastrar();
				}else if(e.getSource() == btnFinalizarCadastroMaiorDeIdade){
					nameIsValid = Validacao.nameIsValid(textRecebeNomeMaior.getText().trim());
					cpfIsValid = pacientes.cpfEValido(textRecebeCpfMaior.getText().trim());

					try {
						dateIsValid = Validacao.dataIsValid(Integer.parseInt(textRecebeDiaNascimentoMaior.getText().trim()),
								Integer.parseInt(textRecebeMesNascimentoMaior.getText().trim()), 
								Integer.parseInt(textRecebeAnoNascimentoMaior.getText().trim()));
					} catch (Exception ex) {
						dateIsValid = false;
					}

					if(!rdbtnFemininoMaior.isSelected() && !rdbtnMasculinoMaior.isSelected()){
						sexoIsValid = false;
						JOptionPane.showMessageDialog(null, "Voce precisa escoher o Sexo!");
					}

					if(!rdbtnJaVacinadoAnteriormenteSim.isSelected() && !rdbtnJaVacinadoAnteriormenteNao.isSelected()){
						vacinadoAnteriormente = false;
						JOptionPane.showMessageDialog(null, "Você precisa informar se ja foi vacinado anteriormente!");
					}

					if(!nameIsValid){
						JOptionPane.showMessageDialog(null, "Nome Inválido!");
					}
					if(!dateIsValid){
						JOptionPane.showMessageDialog(null, "Data invalida!");
					}
					if(!cpfIsValid){
						JOptionPane.showMessageDialog(null, "Cpf inválido!");
					}
					if(nameIsValid && dateIsValid && vacinadoAnteriormente && cpfIsValid && sexoIsValid){
						pacientes.getPessoasMaioresDeIdade().add(new MaiorDeIdade(new StringBuilder().append(textRecebeNomeMaior.getText().trim())
								, rdbtnFemininoMaior.isSelected() ? 'F' : 'M', new Data(Integer.parseInt(textRecebeDiaNascimentoMaior.getText().trim()),
										Integer.parseInt(textRecebeMesNascimentoMaior.getText().trim()), 
										Integer.parseInt(textRecebeAnoNascimentoMaior.getText().trim())), 
										new StringBuilder().append(textRecebeCpfMaior.getText().trim()),
										rdbtnJaVacinadoAnteriormenteSim.isSelected() ? true : false));
						JOptionPane.showMessageDialog(null, "Cadastro Efetuado com Sucesso!");
						painelCadastrarMaiorDeIdade.setVisible(false);
						getContentPane().removeAll();
						getMenuGeral();
					}
				}
			}
		};

		btnFinalizarCadastroMaiorDeIdade.addActionListener(actionListenerCadastrarMaior);
		btnCancelarMaiorDeIdade.addActionListener(actionListenerCadastrarMaior);
		
		getContentPane().add( painelCadastrarMaiorDeIdade );
		setVisible(true);
	}

	private void getMenuCadastrarMenorDeIdade() throws ParseException{
		painelCadastrarMenorDeIdade = new JPanel();
		painelCadastrarMenorDeIdade.setForeground(Color.LIGHT_GRAY);
		painelCadastrarMenorDeIdade.setBackground(Color.DARK_GRAY);
		painelCadastrarMenorDeIdade.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelCadastrarMenorDeIdade.setLayout(null);

		txtCadastroDoMenor = new JTextField();
		txtCadastroDoMenor.setEditable(false);
		txtCadastroDoMenor.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		txtCadastroDoMenor.setForeground(Color.LIGHT_GRAY);
		txtCadastroDoMenor.setBackground(Color.DARK_GRAY);
		txtCadastroDoMenor.setText("Cadastro do Menor de Idade");
		txtCadastroDoMenor.setBounds(184, 12, 231, 19);
		painelCadastrarMenorDeIdade.add(txtCadastroDoMenor);
		txtCadastroDoMenor.setColumns(10);

		txtNomeMenor = new JTextField();
		txtNomeMenor.setForeground(Color.LIGHT_GRAY);
		txtNomeMenor.setBackground(Color.DARK_GRAY);
		txtNomeMenor.setEditable(false);
		txtNomeMenor.setText("Nome: ");
		txtNomeMenor.setBounds(12, 63, 46, 19);
		painelCadastrarMenorDeIdade.add(txtNomeMenor);
		txtNomeMenor.setColumns(10);

		textRecebeNomeMenor = new JTextField();
		textRecebeNomeMenor.setBounds(70, 63, 334, 19);
		painelCadastrarMenorDeIdade.add(textRecebeNomeMenor);
		textRecebeNomeMenor.setColumns(30);

		txtSexoMenor = new JTextField();
		txtSexoMenor.setBackground(Color.DARK_GRAY);
		txtSexoMenor.setForeground(Color.LIGHT_GRAY);
		txtSexoMenor.setEditable(false);
		txtSexoMenor.setText("Sexo: ");
		txtSexoMenor.setBounds(12, 94, 46, 19);
		painelCadastrarMenorDeIdade.add(txtSexoMenor);
		txtSexoMenor.setColumns(10);

		ButtonGroup radiosButons = new ButtonGroup();
		rdbtnMasculinoMenor = new JRadioButton("Masculino");
		rdbtnMasculinoMenor.setForeground(Color.LIGHT_GRAY);
		rdbtnMasculinoMenor.setBackground(Color.DARK_GRAY);
		rdbtnMasculinoMenor.setBounds(70, 92, 149, 23);
		painelCadastrarMenorDeIdade.add(rdbtnMasculinoMenor);
		radiosButons.add(rdbtnMasculinoMenor);

		rdbtnFemininoMenor = new JRadioButton("Feminino");
		rdbtnFemininoMenor.setForeground(Color.LIGHT_GRAY);
		rdbtnFemininoMenor.setBackground(Color.DARK_GRAY);
		rdbtnFemininoMenor.setBounds(255, 92, 149, 23);
		painelCadastrarMenorDeIdade.add(rdbtnFemininoMenor);
		radiosButons.add(rdbtnFemininoMenor);

		txtCpfMenor = new JTextField();
		txtCpfMenor.setBackground(Color.DARK_GRAY);
		txtCpfMenor.setForeground(Color.LIGHT_GRAY);
		txtCpfMenor.setEditable(false);
		txtCpfMenor.setText("CPF: ");
		txtCpfMenor.setBounds(12, 125, 46, 19);
		txtCpfMenor.setToolTipText("Digite apenas numeros");
		painelCadastrarMenorDeIdade.add(txtCpfMenor);
		txtCpfMenor.setColumns(10);

		textRecebeCpfMenor = new JFormattedTextField(new MaskFormatter("###########"));
		textRecebeCpfMenor.setBounds(64, 125, 155, 19);
		painelCadastrarMenorDeIdade.add(textRecebeCpfMenor);
		textRecebeCpfMenor.setColumns(11);

		txtDataNascimentoMenor = new JTextField();
		txtDataNascimentoMenor.setForeground(Color.LIGHT_GRAY);
		txtDataNascimentoMenor.setBackground(Color.DARK_GRAY);
		txtDataNascimentoMenor.setEditable(false);
		txtDataNascimentoMenor.setText("Data Nascimento: ");
		txtDataNascimentoMenor.setBounds(12, 156, 114, 19);
		txtDataNascimentoMenor.setToolTipText("(dd/mm/aaaa)");
		painelCadastrarMenorDeIdade.add(txtDataNascimentoMenor);
		txtDataNascimentoMenor.setColumns(10);

		textRecebeDiaNascimentoMenor = new JFormattedTextField(new MaskFormatter("##"));
		textRecebeDiaNascimentoMenor.setBounds(138, 156, 20, 19);
		painelCadastrarMenorDeIdade.add(textRecebeDiaNascimentoMenor);
		textRecebeDiaNascimentoMenor.setColumns(2);

		textBarraDivisoriaNascimentoMenor = new JTextField();
		textBarraDivisoriaNascimentoMenor.setForeground(Color.LIGHT_GRAY);
		textBarraDivisoriaNascimentoMenor.setBackground(Color.DARK_GRAY);
		textBarraDivisoriaNascimentoMenor.setEditable(false);
		textBarraDivisoriaNascimentoMenor.setText("/");
		textBarraDivisoriaNascimentoMenor.setBounds(170, 156, 9, 19);
		painelCadastrarMenorDeIdade.add(textBarraDivisoriaNascimentoMenor);
		textBarraDivisoriaNascimentoMenor.setColumns(1);

		textRecebeMesNascimentoMenor = new JFormattedTextField(new MaskFormatter("##"));
		textRecebeMesNascimentoMenor.setBounds(191, 156, 20, 19);
		painelCadastrarMenorDeIdade.add(textRecebeMesNascimentoMenor);
		textRecebeMesNascimentoMenor.setColumns(2);

		textBarraDivisoriaNascimento2Menor = new JTextField();
		textBarraDivisoriaNascimento2Menor.setForeground(Color.LIGHT_GRAY);
		textBarraDivisoriaNascimento2Menor.setBackground(Color.DARK_GRAY);
		textBarraDivisoriaNascimento2Menor.setEditable(false);
		textBarraDivisoriaNascimento2Menor.setText("/");
		textBarraDivisoriaNascimento2Menor.setBounds(228, 156, 9, 19);
		painelCadastrarMenorDeIdade.add(textBarraDivisoriaNascimento2Menor);
		textBarraDivisoriaNascimento2Menor.setColumns(1);

		textRecebeAnoNascimentoMenor = new JFormattedTextField(new MaskFormatter("####"));
		textRecebeAnoNascimentoMenor.setBounds(249, 156, 55, 19);
		painelCadastrarMenorDeIdade.add(textRecebeAnoNascimentoMenor);
		textRecebeAnoNascimentoMenor.setColumns(4);

		txtQuantasVezesOPacienteFoiVacinado = new JTextField();
		txtQuantasVezesOPacienteFoiVacinado.setBackground(Color.DARK_GRAY);
		txtQuantasVezesOPacienteFoiVacinado.setForeground(Color.LIGHT_GRAY);
		txtQuantasVezesOPacienteFoiVacinado.setEditable(false);
		txtQuantasVezesOPacienteFoiVacinado.setText("Quantas vezes o Paciente ja foi Vacinado?");
		txtQuantasVezesOPacienteFoiVacinado.setBounds(12, 200, 275, 19);
		painelCadastrarMenorDeIdade.add(txtQuantasVezesOPacienteFoiVacinado);
		txtQuantasVezesOPacienteFoiVacinado.setColumns(10);

		textQtdVezesVacinado = new JTextField();
		textQtdVezesVacinado.setBounds(299, 200, 60, 19);
		painelCadastrarMenorDeIdade.add(textQtdVezesVacinado);
		textQtdVezesVacinado.setColumns(10);

		btnFinalizarCadastroMenorDeIdade = new JButton("Finalizar Cadastro");
		btnFinalizarCadastroMenorDeIdade.setBackground(Color.LIGHT_GRAY);
		btnFinalizarCadastroMenorDeIdade.setBounds(88, 243, 175, 25);
		painelCadastrarMenorDeIdade.add(btnFinalizarCadastroMenorDeIdade);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setBounds(299, 243, 175, 25);
		painelCadastrarMenorDeIdade.add(btnCancelar);


		ActionListener actionListenerCadastrarMenor = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				boolean nameIsValid, cpfIsValid, dateIsValid, sexoIsValid=true, qtdVacinadoAnteriormenteIsValid;

				if(e.getSource() == btnCancelar){
					painelCadastrarMenorDeIdade.setVisible(false);
					getContentPane().removeAll();
					getMenuCadastrar();					
				}else if(e.getSource() == btnFinalizarCadastroMenorDeIdade){
					nameIsValid = Validacao.nameIsValid(textRecebeNomeMenor.getText().trim());
					cpfIsValid = pacientes.cpfEValido(textRecebeCpfMenor.getText().trim());

					try {
						dateIsValid = Validacao.dataIsValid(Integer.parseInt(textRecebeDiaNascimentoMenor.getText().trim()),
								Integer.parseInt(textRecebeMesNascimentoMenor.getText().trim()), 
								Integer.parseInt(textRecebeAnoNascimentoMenor.getText().trim()));
					} catch (Exception ex) {
						dateIsValid = false;
					}

					try {
						qtdVacinadoAnteriormenteIsValid = Validacao.qtdVezesVacinadaIsValid(Integer.parseInt(textQtdVezesVacinado.getText().trim()));
					} catch (Exception ex2) {
						qtdVacinadoAnteriormenteIsValid = false;
					}

					if(!rdbtnFemininoMenor.isSelected() && !rdbtnMasculinoMenor.isSelected()){
						sexoIsValid = false;
						JOptionPane.showMessageDialog(null, "Voce precisa escoher o Sexo!");
					}

					if(!nameIsValid){
						JOptionPane.showMessageDialog(null, "Nome Inválido!");
					}
					if(!dateIsValid){
						JOptionPane.showMessageDialog(null, "Data invalida!");
					}
					if(!cpfIsValid){
						JOptionPane.showMessageDialog(null, "Cpf inválido!");
					}
					if(!qtdVacinadoAnteriormenteIsValid){
						JOptionPane.showMessageDialog(null, "Quantidade inválida!");
					}
					if(nameIsValid && dateIsValid && qtdVacinadoAnteriormenteIsValid && cpfIsValid && sexoIsValid){
						pacientes.getPessoasMenoresDeIdade().add(new MenorDeIdade(new StringBuilder().append(textRecebeNomeMenor.getText().trim())
								, rdbtnFemininoMenor.isSelected() ? 'F' : 'M', new Data(Integer.parseInt(textRecebeDiaNascimentoMenor.getText().trim()),
										Integer.parseInt(textRecebeMesNascimentoMenor.getText().trim()), 
										Integer.parseInt(textRecebeAnoNascimentoMenor.getText().trim())), 
										new StringBuilder().append(textRecebeCpfMenor.getText().trim()),
										Integer.parseInt(textQtdVezesVacinado.getText().trim())));
						JOptionPane.showMessageDialog(null, "Cadastro Efetuado com Sucesso!");
						
						painelCadastrarMenorDeIdade.setVisible(false);
						getContentPane().removeAll();
						getMenuGeral();
					}
				}
			}
		};

		btnFinalizarCadastroMenorDeIdade.addActionListener(actionListenerCadastrarMenor);
		btnCancelar.addActionListener(actionListenerCadastrarMenor);

		getContentPane().add( painelCadastrarMenorDeIdade );
		setVisible(true);
	}

	private void getConsultarCpf() throws ParseException{
		painelConsultarCpf = new JPanel();
		painelConsultarCpf.setBackground(Color.DARK_GRAY);
		painelConsultarCpf.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelConsultarCpf.setLayout(null);
		
		JLabel lblTituloConsultarCPF = new JLabel("Consultar por CPF");
		lblTituloConsultarCPF.setForeground(Color.LIGHT_GRAY);
		lblTituloConsultarCPF.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTituloConsultarCPF.setBounds(214, 25, 171, 15);
		painelConsultarCpf.add(lblTituloConsultarCPF);
		
		JLabel lblDigiteOCpf = new JLabel("Digite o CPF:");
		lblDigiteOCpf.setForeground(Color.LIGHT_GRAY);
		lblDigiteOCpf.setBounds(151, 132, 95, 15);
		painelConsultarCpf.add(lblDigiteOCpf);
		
		textRecebeCpfConsulta = new JFormattedTextField(new MaskFormatter("###########"));
		textRecebeCpfConsulta.setBounds(290, 130, 114, 19);
		painelConsultarCpf.add(textRecebeCpfConsulta);
		textRecebeCpfConsulta.setColumns(11);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBackground(Color.LIGHT_GRAY);
		btnConsultar.setBounds(142, 199, 117, 25);
		painelConsultarCpf.add(btnConsultar);
		
		btnCancelarConsultarCpf = new JButton("Cancelar");
		btnCancelarConsultarCpf.setBackground(Color.LIGHT_GRAY);
		btnCancelarConsultarCpf.setBounds(327, 199, 117, 25);
		painelConsultarCpf.add(btnCancelarConsultarCpf);
		
		ActionListener actionListenerConsultar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == btnCancelarConsultarCpf){
					painelConsultarCpf.setVisible(false);
					getContentPane().removeAll();
					getMenuGeral();					
				}if(e.getSource() == btnConsultar){
					consultarCpf(textRecebeCpfConsulta.getText().trim());
					textRecebeCpfConsulta.setText("");
				}
			}
		};
		
		btnCancelarConsultarCpf.addActionListener(actionListenerConsultar);
		btnConsultar.addActionListener(actionListenerConsultar);
		getContentPane().add( painelConsultarCpf );
		setVisible(true);
	}
	
	private void consultarCpf(String cpf){
		if(!pacientes.cpfEValido(cpf) && !pacientes.cpfERepetido(cpf)){
			JOptionPane.showMessageDialog(null, "Cpf Invalido!");
		}else{
			if(!pacientes.cpfERepetido(cpf))
				JOptionPane.showMessageDialog(null, "Nao existe nenhum paciente com este cpf");
			else{
				for(int count = 0; count < pacientes.getPessoasMaioresDeIdade().size(); ++count){
					if(pacientes.getPessoasMaioresDeIdade().get(count).getCpf().toString().equals(cpf)){
						JOptionPane.showMessageDialog(null,"Nome: " + pacientes.getPessoasMaioresDeIdade().get(count).getNome() + "\n" +
								"Data de Nascimento: " + pacientes.getPessoasMaioresDeIdade().get(count).getDataNascimento() + "\n" +
								"Sexo: " + ((pacientes.getPessoasMaioresDeIdade().get(count).getSexo() == 'M') ? "Masculino\n" : "Feminino\n") +
								"CPF: " + pacientes.getPessoasMaioresDeIdade().get(count).getCpf() + "\n" +
								"Ja foi vacinado? " + ((pacientes.getPessoasMaioresDeIdade().get(count).getVacinadaAnteriormente()) ? "Sim\n" : "Nao\n")
								, "Paciente Registrado", JOptionPane.PLAIN_MESSAGE);
					}
				}
				for(int count = 0; count < pacientes.getPessoasMenoresDeIdade().size(); ++count){
					if(pacientes.getPessoasMenoresDeIdade().get(count).getCpf().toString().equals(cpf)){
						JOptionPane.showMessageDialog(null,"Nome: " + pacientes.getPessoasMenoresDeIdade().get(count).getNome() + "\n" +
								"Data de Nascimento: " + pacientes.getPessoasMenoresDeIdade().get(count).getDataNascimento() + "\n" +
								"Sexo: " + ((pacientes.getPessoasMenoresDeIdade().get(count).getSexo() == 'M') ? "Masculino\n" : "Feminino\n") +
								"CPF: " + pacientes.getPessoasMenoresDeIdade().get(count).getCpf() + "\n" +
								"Quantas vezes ja foi vacinado: " + pacientes.getPessoasMenoresDeIdade().get(count).getQuantasVezesFoiVacinada()
								, "Paciente Registrado", JOptionPane.PLAIN_MESSAGE);

					}
				}
			}
		}
	}
	
	private void limpaTela(int NUM){
		for(int count = 0; count < NUM; ++count)
			System.out.println();
	}

	private int janelaMenuGeral(){
		String opcoes[] = {"Cadastrar", "Listar", "Consultar", "Pesquisar", "Sair"};
		return JOptionPane.showOptionDialog(null, "Escolha a opcao desejada", "Menu Geral", 0,
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
	}
	
	private void getPesquisar(){
		painelPesquisar = new JPanel();
		painelPesquisar.setBackground(Color.DARK_GRAY);
		painelPesquisar.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelPesquisar.setLayout(null);
		
		JLabel lblPesquisarPorNome = new JLabel("PESQUISAR POR NOME");
		lblPesquisarPorNome.setForeground(Color.LIGHT_GRAY);
		lblPesquisarPorNome.setBackground(Color.DARK_GRAY);
		lblPesquisarPorNome.setBounds(211, 23, 164, 15);
		painelPesquisar.add(lblPesquisarPorNome);
		
		
		JLabel lblDigiteONome = new JLabel("Digite o nome: ");
		lblDigiteONome.setForeground(Color.LIGHT_GRAY);
		lblDigiteONome.setBounds(131, 78, 112, 15);
		painelPesquisar.add(lblDigiteONome);
		
		textFieldRecebeNomePesquisa = new JTextField();
		textFieldRecebeNomePesquisa.setBounds(248, 76, 253, 19);
		textFieldRecebeNomePesquisa.setColumns(10);
		painelPesquisar.add(textFieldRecebeNomePesquisa);
						
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBackground(Color.LIGHT_GRAY);
		btnPesquisar.setBounds(141, 112, 117, 25);
		painelPesquisar.add(btnPesquisar);
		
		btnVoltarPesquisar = new JButton("Voltar");
		btnVoltarPesquisar.setBackground(Color.LIGHT_GRAY);
		btnVoltarPesquisar.setForeground(Color.DARK_GRAY);
		btnVoltarPesquisar.setBounds(334, 112, 117, 25);
		painelPesquisar.add(btnVoltarPesquisar);
								
		scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 165, 514, 123);
		painelPesquisar.add(scrollPane);
		
		DefaultTableModel modeloDeTabela = new DefaultTableModel();
		tablePesquisar = new JTable(modeloDeTabela);
		tablePesquisar.setFont(new Font("Dialog", Font.PLAIN, 10));

		tablePesquisar.setModel(new DefaultTableModel(new Object[][] {}, 
				new String[]{"Nome", "Idade", "Sexo", "CPF", "Ja foi vacinado?/Qtd vezes:" 				
		}
		));
		tablePesquisar.getColumnModel().getColumn(1).setPreferredWidth(40);
		tablePesquisar.getColumnModel().getColumn(2).setPreferredWidth(40);
		tablePesquisar.getColumnModel().getColumn(3).setPreferredWidth(93);
		tablePesquisar.getColumnModel().getColumn(4).setPreferredWidth(170);
		scrollPane.setViewportView(tablePesquisar);

		
		ActionListener actionListenerPesquisar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				if(e.getSource() == btnVoltarPesquisar){
					painelPesquisar.setVisible(false);
					getContentPane().removeAll();
					getMenuGeral();
				}else if(e.getSource() == btnPesquisar && !textFieldRecebeNomePesquisa.getText().trim().isEmpty()){
					boolean encontrouAlguem = false;
					int numColunas = tablePesquisar.getModel().getColumnCount();
					Object []linhas = new Object[numColunas];
					List<Pessoa> pessoas = new ArrayList<Pessoa>();

					tablePesquisar.setModel(new DefaultTableModel(new Object[][] {}, 
							new String[]{"Nome", "Idade", "Sexo", "CPF", "Ja foi vacinado?/Qtd vezes:" 				
					}
					));
					tablePesquisar.getColumnModel().getColumn(1).setPreferredWidth(40);
					tablePesquisar.getColumnModel().getColumn(2).setPreferredWidth(40);
					tablePesquisar.getColumnModel().getColumn(3).setPreferredWidth(93);
					tablePesquisar.getColumnModel().getColumn(4).setPreferredWidth(170);
					scrollPane.setViewportView(tablePesquisar);
					
					for(MaiorDeIdade maiorDeIdade : pacientes.getPessoasMaioresDeIdade()){
						pessoas.add(maiorDeIdade);
					}
					for(MenorDeIdade menorDeIdade : pacientes.getPessoasMenoresDeIdade()){
						pessoas.add(menorDeIdade);
					}
					
					OrdenaNome ordemNome = new OrdenaNome();
					Collections.sort(pessoas, ordemNome);

					for(Pessoa pessoa : pessoas){
						if(pessoa.getNome().toString().toUpperCase().contains(textFieldRecebeNomePesquisa.getText().trim().toUpperCase())){
							encontrouAlguem = true;
							linhas [0] = pessoa.getNome();
							linhas[1] = pessoa.getDataNascimento().getIdade();
							linhas[2] = pessoa.getSexo() == 'M' ? "Masculino" : "Feminino";
							linhas[3] = pessoa.getCpf();
							if(pessoa instanceof MaiorDeIdade)
								linhas[4] = (((MaiorDeIdade) pessoa).getVacinadaAnteriormente()) ? "Sim" : "Nao";
							if(pessoa instanceof MenorDeIdade)
								linhas[4] = ((MenorDeIdade) pessoa).getQuantasVezesFoiVacinada();
							
							((DefaultTableModel) tablePesquisar.getModel()).addRow(linhas);
						}
					}
					if(!encontrouAlguem){
						JOptionPane.showMessageDialog(null, "Nao foi encontrado nenhum paciente");
					}
					textFieldRecebeNomePesquisa.setText("");
				}else if(e.getSource() == btnPesquisar && textFieldRecebeNomePesquisa.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(null, "E necessario digitar um nome para pesquisar!");
				}
			}
		};
		
		btnPesquisar.addActionListener(actionListenerPesquisar);
		btnVoltarPesquisar.addActionListener(actionListenerPesquisar);
		
		getContentPane().add(painelPesquisar);
		setVisible(true);
	}
	
	private void listarPessoas(){

		if(pacientes.getPessoasMaioresDeIdade().size()>0 || pacientes.getPessoasMenoresDeIdade().size()>0){
			limpaTela(50);
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("NOME\t\t" + "NASCIMENTO\t" + "SEXO\t" + "  CPF\t\t" + "JA VACINADO?/QTD VEZES?");
			System.out.println("----------------------------------------------------------------------------");
			if(pacientes.getPessoasMaioresDeIdade().size()>0){
				for(MaiorDeIdade maiorDeIdade : pacientes.getPessoasMaioresDeIdade())
					System.out.println(maiorDeIdade);
			}

			if(pacientes.getPessoasMenoresDeIdade().size()>0){
				for(MenorDeIdade menorDeIdade : pacientes.getPessoasMenoresDeIdade())
					System.out.println(menorDeIdade);
			}
			limpaTela(5);
			System.out.println("Quantidade de Pacientes Maiores de Idade: " + pacientes.getPessoasMaioresDeIdade().size());
			System.out.println("Quantidade de Pacientes Menores de Idade: " + pacientes.getPessoasMenoresDeIdade().size());
			System.out.println("Quantidade total de Pacientes: " + (pacientes.getPessoasMaioresDeIdade().size() + pacientes.getPessoasMenoresDeIdade().size()));
		}
		else{
			JOptionPane.showMessageDialog(null, "NENHUM PACIENTE CADASTRADO!");
		}
	}

}