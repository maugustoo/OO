package visao;

import dados.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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

	/**
	 * Create the frame.
	 */
	public Janela(BancoDePacientes bancoPacientes) {

		//menuGeral();
		criaPainelPesquisar();
		pacientes = bancoPacientes;

		setBackground(Color.DARK_GRAY);
		setTitle("H1N1");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 600, 350);

	}

	private void menuGeral(){

		setVisible(false);

		switch(criaJanelaMenuGeral()){
		case 0:
			try {
				criaPainelCadastrar();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			break;
		case 1:
			listarPessoas();
			menuGeral();
			break;
		case 2:
			try {
				criaPainelConsultarCpf();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			criaPainelPesquisar();
			break;
		case 4:
			System.exit(0);
		}
	}

	private void criaPainelCadastrar() throws ParseException{

		//Componentes do painei cadastrar

		final JButton btnConfirmarDados;
		final JPanel painelCadastrar;
		final JTextField textRecebeNome;
		final JTextField textRecebeCpf;
		final JButton btnFinalizarCadastro;
		final JRadioButton rdbtnMasculino;
		final JRadioButton rdbtnFeminino;
		final JRadioButton rdbtnJaVacinadoAnteriormenteSim;
		final JRadioButton rdbtnJaVacinadoAnteriormenteNao;
		final JTextField textQtdVezesVacinado;
		final JButton btnCancelar;
		final JLabel iconeErroSexo; 
		final JLabel iconeErroCpf;
		final JLabel iconeErroData;
		final JLabel iconeErroVacina;
		final JLabel iconeErroNome;
		JLabel lblCadastro;
		JLabel lblNome;
		JLabel lblSexo;
		JLabel lblCpf;
		JLabel lblDataNascimento;
		final JLabel lblVacinadoAnteriormente;
		final JLabel lblQtdVezesVacinado;
		final JTextField textRecebeDataNascimento;

		ButtonGroup radiosButons;
		ButtonGroup yesNoOption;

		painelCadastrar = new JPanel();
		painelCadastrar.setBackground(Color.DARK_GRAY);
		painelCadastrar.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelCadastrar.setLayout(null);

		lblCadastro = new JLabel("Cadastro do paciente");
		lblCadastro.setForeground(Color.LIGHT_GRAY);
		lblCadastro.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCadastro.setBounds(223, 12, 181, 15);
		painelCadastrar.add(lblCadastro);

		iconeErroSexo = new JLabel(new ImageIcon("imagens/error.png"));
		iconeErroSexo.setLocation(295, 94);
		iconeErroSexo.setSize(20, 19);
		iconeErroSexo.setVisible(false);
		painelCadastrar.add(iconeErroSexo);

		iconeErroCpf = new JLabel(new ImageIcon("imagens/error.png"));
		iconeErroCpf.setLocation(228, 125);
		iconeErroCpf.setSize(20, 19);
		iconeErroCpf.setVisible(false);
		painelCadastrar.add(iconeErroCpf);

		iconeErroData = new JLabel(new ImageIcon("imagens/error.png"));
		iconeErroData.setLocation(228, 156);
		iconeErroData.setSize(20, 19);
		iconeErroData.setVisible(false);
		painelCadastrar.add(iconeErroData);

		iconeErroVacina = new JLabel(new ImageIcon("imagens/error.png"));
		iconeErroVacina.setLocation(429, 200);
		iconeErroVacina.setSize(20, 19);
		iconeErroVacina.setVisible(false);
		painelCadastrar.add(iconeErroVacina);
		
		final JLabel erroCpfJaCadastrado = new JLabel("CPF já cadastrado!");
		erroCpfJaCadastrado.setForeground(Color.RED);
		erroCpfJaCadastrado.setBounds(260, 125, 134, 15);
		erroCpfJaCadastrado.setVisible(false);
		painelCadastrar.add(erroCpfJaCadastrado);


		iconeErroNome = new JLabel(new ImageIcon("imagens/error.png"));
		iconeErroNome.setLocation(409, 63);
		iconeErroNome.setSize(20, 19);
		iconeErroNome.setVisible(false);
		painelCadastrar.add(iconeErroNome);

		textRecebeNome = new JTextField();
		textRecebeNome.setBounds(70, 63, 334, 19);
		painelCadastrar.add(textRecebeNome);
		textRecebeNome.setColumns(30);

		radiosButons = new ButtonGroup();
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBackground(Color.DARK_GRAY);
		rdbtnMasculino.setForeground(Color.LIGHT_GRAY);
		rdbtnMasculino.setBounds(70, 92, 96, 23);
		painelCadastrar.add(rdbtnMasculino);
		radiosButons.add(rdbtnMasculino);

		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBackground(Color.DARK_GRAY);
		rdbtnFeminino.setForeground(Color.LIGHT_GRAY);
		rdbtnFeminino.setBounds(191, 94, 89, 23);
		painelCadastrar.add(rdbtnFeminino);
		radiosButons.add(rdbtnFeminino);

		textRecebeCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		textRecebeCpf.setBounds(64, 125, 155, 19);
		painelCadastrar.add(textRecebeCpf);
		textRecebeCpf.setColumns(11);

		yesNoOption = new ButtonGroup();
		rdbtnJaVacinadoAnteriormenteSim = new JRadioButton("Sim");
		rdbtnJaVacinadoAnteriormenteSim.setForeground(Color.LIGHT_GRAY);
		rdbtnJaVacinadoAnteriormenteSim.setBackground(Color.DARK_GRAY);
		rdbtnJaVacinadoAnteriormenteSim.setBounds(304, 198, 55, 23);
		rdbtnJaVacinadoAnteriormenteSim.setVisible(false);
		painelCadastrar.add(rdbtnJaVacinadoAnteriormenteSim);
		yesNoOption.add(rdbtnJaVacinadoAnteriormenteSim);

		rdbtnJaVacinadoAnteriormenteNao = new JRadioButton("Nao");
		rdbtnJaVacinadoAnteriormenteNao.setForeground(Color.LIGHT_GRAY);
		rdbtnJaVacinadoAnteriormenteNao.setBackground(Color.DARK_GRAY);
		rdbtnJaVacinadoAnteriormenteNao.setBounds(363, 200, 55, 23);
		rdbtnJaVacinadoAnteriormenteNao.setVisible(false);
		painelCadastrar.add(rdbtnJaVacinadoAnteriormenteNao);
		yesNoOption.add(rdbtnJaVacinadoAnteriormenteNao);

		textQtdVezesVacinado = new JTextField();
		textQtdVezesVacinado.setBounds(299, 200, 60, 19);
		textQtdVezesVacinado.setVisible(false);
		painelCadastrar.add(textQtdVezesVacinado);
		textQtdVezesVacinado.setColumns(10);

		btnFinalizarCadastro = new JButton("Finalizar Cadastro");
		btnFinalizarCadastro.setBackground(Color.LIGHT_GRAY);
		btnFinalizarCadastro.setBounds(100, 240, 175, 25);
		btnFinalizarCadastro.setVisible(false);
		painelCadastrar.add(btnFinalizarCadastro);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setBounds(339, 240, 175, 25);
		painelCadastrar.add(btnCancelar);

		btnConfirmarDados = new JButton("Confirmar Dados");
		btnConfirmarDados.setBackground(Color.LIGHT_GRAY);
		btnConfirmarDados.setBounds(100, 240, 175, 25);
		painelCadastrar.add(btnConfirmarDados);		

		lblNome = new JLabel("Nome: ");
		lblNome.setForeground(Color.LIGHT_GRAY);
		lblNome.setBounds(12, 67, 70, 15);
		painelCadastrar.add(lblNome);

		lblSexo = new JLabel("Sexo: ");
		lblSexo.setForeground(Color.LIGHT_GRAY);
		lblSexo.setBounds(12, 98, 70, 15);
		painelCadastrar.add(lblSexo);

		lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.LIGHT_GRAY);
		lblCpf.setBounds(12, 129, 70, 15);
		lblCpf.setToolTipText("Digite apenas numeros");
		painelCadastrar.add(lblCpf);

		lblDataNascimento = new JLabel("Data Nascimento: ");
		lblDataNascimento.setForeground(Color.LIGHT_GRAY);
		lblDataNascimento.setBounds(12, 160, 130, 15);
		lblDataNascimento.setToolTipText("(dd/mm/aaaa)");
		painelCadastrar.add(lblDataNascimento);

		textRecebeDataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		textRecebeDataNascimento.setBounds(146, 156, 78, 19);
		painelCadastrar.add(textRecebeDataNascimento);
		textRecebeDataNascimento.setColumns(10);


		lblVacinadoAnteriormente = new JLabel("O paciente ja foi vacinado anteriormente?");
		lblVacinadoAnteriormente.setFont(new Font("Dialog", Font.BOLD, 11));
		lblVacinadoAnteriormente.setForeground(Color.LIGHT_GRAY);
		lblVacinadoAnteriormente.setBounds(15, 204, 275, 15);
		lblVacinadoAnteriormente.setVisible(false);
		painelCadastrar.add(lblVacinadoAnteriormente);

		lblQtdVezesVacinado = new JLabel("Quantas vezes o Paciente ja foi Vacinado?");
		lblQtdVezesVacinado.setFont(new Font("Dialog", Font.BOLD, 11));
		lblQtdVezesVacinado.setForeground(Color.LIGHT_GRAY);
		lblQtdVezesVacinado.setBounds(15, 204, 275, 15);
		lblQtdVezesVacinado.setVisible(false);
		painelCadastrar.add(lblQtdVezesVacinado);


		ActionListener actionListenerCadastrarMaior = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				boolean nameIsValid, cpfIsValid, dateIsValid = true, sexoIsValid=true, vacinadoAnteriormente=true, qtdVacinadoAnteriormenteIsValid = true;
				Data data = null;
				String dataNascimento[] = null;

				if(e.getSource() == btnCancelar){
					painelCadastrar.setVisible(false);
					getContentPane().removeAll();
					menuGeral();
				}else if(e.getSource() == btnConfirmarDados){
					nameIsValid = Validacao.nameIsValid(textRecebeNome.getText().trim());
					cpfIsValid = pacientes.cpfEValido(textRecebeCpf.getText().trim());

					try {
						dataNascimento = textRecebeDataNascimento.getText().split("/");

						dateIsValid = Validacao.dataIsValid(Integer.parseInt(dataNascimento[0]),
								Integer.parseInt(dataNascimento[1]), 
								Integer.parseInt(dataNascimento[2]));
					} catch (Exception ex) {
						dateIsValid = false;
					}
					if(!rdbtnFeminino.isSelected() && !rdbtnMasculino.isSelected()){
						sexoIsValid = false;
						iconeErroSexo.setVisible(true);
					}else{
						iconeErroSexo.setVisible(false);
					}

					if(!nameIsValid){
						iconeErroNome.setVisible(true);
					}else{
						iconeErroNome.setVisible(false);
						textRecebeNome.setEditable(false);
					}

					if(!dateIsValid){
						iconeErroData.setVisible(true);
					}else{
						iconeErroData.setVisible(false);
						data = new Data(Integer.parseInt(dataNascimento[0]),
								Integer.parseInt(dataNascimento[1]), 
								Integer.parseInt(dataNascimento[2]));
						textRecebeDataNascimento.setEditable(false);
						btnFinalizarCadastro.setVisible(true);
						btnConfirmarDados.setVisible(false);
					}

					if(!cpfIsValid){
						iconeErroCpf.setVisible(true);
						if(pacientes.cpfERepetido(textRecebeCpf.getText().trim())){
							erroCpfJaCadastrado.setVisible(true);
						}else{
							erroCpfJaCadastrado.setVisible(false);
						}
							
					}else{
						iconeErroCpf.setVisible(false);
						erroCpfJaCadastrado.setVisible(false);
						textRecebeCpf.setEditable(false);
					}

					if(dateIsValid && data.getIdade()>=18){
						lblVacinadoAnteriormente.setVisible(true);
						rdbtnJaVacinadoAnteriormenteNao.setVisible(true);
						rdbtnJaVacinadoAnteriormenteSim.setVisible(true);
					}else if(dateIsValid && data.getIdade()<18){
						lblQtdVezesVacinado.setVisible(true);
						textQtdVezesVacinado.setVisible(true);
					}

					if(!cpfIsValid || !dateIsValid || !nameIsValid || !sexoIsValid){
						JOptionPane.showMessageDialog(null, "Dados invalidos!");
					}
				}else if(e.getSource() == btnFinalizarCadastro){
					nameIsValid = Validacao.nameIsValid(textRecebeNome.getText().trim());
					cpfIsValid = pacientes.cpfEValido(textRecebeCpf.getText().trim());

					dataNascimento = textRecebeDataNascimento.getText().split("/");

					data = new Data(Integer.parseInt(dataNascimento[0]),
							Integer.parseInt(dataNascimento[1]), 
							Integer.parseInt(dataNascimento[2]));

					if(data.getIdade()>=18 && !rdbtnJaVacinadoAnteriormenteNao.isSelected() && !rdbtnJaVacinadoAnteriormenteSim.isSelected()){
						vacinadoAnteriormente=false;
						iconeErroVacina.setVisible(true);
					}else if(data.getIdade()>=18 && (rdbtnJaVacinadoAnteriormenteNao.isSelected() || rdbtnJaVacinadoAnteriormenteSim.isSelected())){
						iconeErroVacina.setVisible(false);
					}

					if(!rdbtnFeminino.isSelected() && !rdbtnMasculino.isSelected()){
						sexoIsValid = false;
						iconeErroSexo.setVisible(true);
					}else{
						iconeErroSexo.setVisible(false);
					}

					if(data.getIdade()<18){
						try {
							qtdVacinadoAnteriormenteIsValid = Validacao.qtdVezesVacinadaIsValid(Integer.parseInt(textQtdVezesVacinado.getText().trim()));
						} catch (Exception ex2) {
							qtdVacinadoAnteriormenteIsValid = false;
						}
					}
					if(!nameIsValid){
						iconeErroNome.setVisible(true);
					}else{
						iconeErroNome.setVisible(false);
					}

					if(!dateIsValid){
						iconeErroData.setVisible(true);
					}else{
						iconeErroData.setVisible(false);
					}

					if(!cpfIsValid){
						iconeErroCpf.setVisible(true);
						if(pacientes.cpfERepetido(textRecebeCpf.getText().trim())){
							erroCpfJaCadastrado.setVisible(true);
						}else{
							erroCpfJaCadastrado.setVisible(false);
						}
					}else{
						iconeErroCpf.setVisible(false);
						erroCpfJaCadastrado.setVisible(false);
					}

					if(!qtdVacinadoAnteriormenteIsValid && data.getIdade()<18){
						iconeErroVacina.setVisible(true);
					}else if(qtdVacinadoAnteriormenteIsValid && data.getIdade()<18){
						iconeErroVacina.setVisible(false);
					}

					if(nameIsValid && dateIsValid && vacinadoAnteriormente && cpfIsValid && sexoIsValid && data.getIdade()>=18){
						pacientes.getPessoas().add(new MaiorDeIdade(textRecebeNome.getText().trim()
								, rdbtnFeminino.isSelected() ? 'F' : 'M', data, 
										new StringBuilder().append(textRecebeCpf.getText().trim()),
										rdbtnJaVacinadoAnteriormenteSim.isSelected() ? true : false));
						JOptionPane.showMessageDialog(null, "Cadastro Efetuado com Sucesso!");
						painelCadastrar.setVisible(false);

						getContentPane().removeAll();
						menuGeral();

					}else if(nameIsValid && dateIsValid && qtdVacinadoAnteriormenteIsValid && cpfIsValid && sexoIsValid && data.getIdade()<18){
						pacientes.getPessoas().add(new MenorDeIdade(textRecebeNome.getText().trim()
								, rdbtnFeminino.isSelected() ? 'F' : 'M', data, 
										new StringBuilder().append(textRecebeCpf.getText().trim()),
										Integer.parseInt(textQtdVezesVacinado.getText().trim())));

						JOptionPane.showMessageDialog(null, "Cadastro Efetuado com Sucesso!");

						painelCadastrar.setVisible(false);
						getContentPane().removeAll();
						menuGeral();

					}else if(!cpfIsValid || !dateIsValid || !nameIsValid || !sexoIsValid || !qtdVacinadoAnteriormenteIsValid || !vacinadoAnteriormente){
						JOptionPane.showMessageDialog(null, "Dados invalidos!");
					}
				}
			}
		};

		btnFinalizarCadastro.addActionListener(actionListenerCadastrarMaior);
		btnCancelar.addActionListener(actionListenerCadastrarMaior);
		btnConfirmarDados.addActionListener(actionListenerCadastrarMaior);

		getContentPane().add(painelCadastrar);
		setVisible(true);		
	}

	private void criaPainelConsultarCpf() throws ParseException{

		//Componentes do painel Consultar CPF
		final JPanel painelConsultarCpf;
		final JTextField textRecebeCpfConsulta;
		final JButton btnCancelarConsultarCpf;
		final JButton btnConsultar;
		final JLabel lblTituloConsultarCPF;
		final JLabel lblDigiteOCpf;

		painelConsultarCpf = new JPanel();
		painelConsultarCpf.setBackground(Color.DARK_GRAY);
		painelConsultarCpf.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelConsultarCpf.setLayout(null);

		lblTituloConsultarCPF = new JLabel("Consultar por CPF");
		lblTituloConsultarCPF.setForeground(Color.LIGHT_GRAY);
		lblTituloConsultarCPF.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTituloConsultarCPF.setBounds(214, 25, 171, 15);
		painelConsultarCpf.add(lblTituloConsultarCPF);

		lblDigiteOCpf = new JLabel("Digite o CPF:");
		lblDigiteOCpf.setForeground(Color.LIGHT_GRAY);
		lblDigiteOCpf.setBounds(151, 132, 95, 15);
		painelConsultarCpf.add(lblDigiteOCpf);

		textRecebeCpfConsulta = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
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
					menuGeral();					
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
				for(Pessoa pessoa : pacientes.getPessoas()){
					if(pessoa.getCpf().toString().equals(cpf)){
						JOptionPane.showMessageDialog(null, pessoa.consultarDados() ,"Paciente Registrado", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		}
	}

	public static void limpaTela(int NUM){
		for(int count = 0; count < NUM; ++count)
			System.out.println();
	}

	private int criaJanelaMenuGeral(){
		String opcoes[] = {"Cadastrar", "Listar", "Consultar", "Pesquisar", "Sair"};
		return JOptionPane.showOptionDialog(null, "Escolha a opcao desejada", "Menu Geral", 0,
				JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
	}

	private void criaPainelPesquisar(){
		//Componentes do painei pesquisar
		final JPanel painelPesquisar;
		final JTextField textFieldRecebeNomePesquisa;
		final JTable tablePesquisar;
		final JButton btnPesquisar;
		final JButton btnVoltarPesquisar;
		final JScrollPane scrollPane;
		JLabel lblPesquisarPorNome;
		JLabel lblDigiteONome;
		final JLabel lblQuantidadeDePacientes;
		final JTextField textInformaQtdPacientesEncontrados;

		
		painelPesquisar = new JPanel();
		painelPesquisar.setBackground(Color.DARK_GRAY);
		painelPesquisar.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelPesquisar.setLayout(null);

		lblPesquisarPorNome = new JLabel("PESQUISAR POR NOME");
		lblPesquisarPorNome.setForeground(Color.LIGHT_GRAY);
		lblPesquisarPorNome.setBackground(Color.DARK_GRAY);
		lblPesquisarPorNome.setBounds(211, 23, 164, 15);
		painelPesquisar.add(lblPesquisarPorNome);


		lblDigiteONome = new JLabel("Digite o nome: ");
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
		
		textInformaQtdPacientesEncontrados = new JTextField();
		textInformaQtdPacientesEncontrados.setEditable(false);
		textInformaQtdPacientesEncontrados.setBounds(345, 298, 39, 19);
		painelPesquisar.add(textInformaQtdPacientesEncontrados);
		textInformaQtdPacientesEncontrados.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 165, 514, 123);
		painelPesquisar.add(scrollPane);

		DefaultTableModel modeloDeTabela = new DefaultTableModel();
		tablePesquisar = new JTable(modeloDeTabela);
		tablePesquisar.setFont(new Font("Dialog", Font.PLAIN, 10));

		lblQuantidadeDePacientes = new JLabel("Quantidade de Pacientes Encontrados: ");
		lblQuantidadeDePacientes.setForeground(Color.LIGHT_GRAY);
		lblQuantidadeDePacientes.setBounds(60, 300, 283, 15);
		painelPesquisar.add(lblQuantidadeDePacientes);
		
		tablePesquisar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Idade", "Sexo", "CPF"
			}
		));
		
		scrollPane.setViewportView(tablePesquisar);

		ActionListener actionListenerPesquisar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				if(e.getSource() == btnVoltarPesquisar){
					painelPesquisar.setVisible(false);
					getContentPane().removeAll();
					menuGeral();
				}else if(e.getSource() == btnPesquisar && !textFieldRecebeNomePesquisa.getText().trim().isEmpty()){
					boolean encontrouAlguem = false;
					int numColunas = tablePesquisar.getModel().getColumnCount();
					int numLinhas;
					
					Object []linhas = new Object[numColunas];

					tablePesquisar.setModel(new DefaultTableModel(new Object[][] {}, 
							new String[]{"Nome", "Idade", "Sexo", "CPF"
					}
							));

					scrollPane.setViewportView(tablePesquisar);
					
					Collections.sort(pacientes.getPessoas());

					for(Pessoa pessoa : pacientes.getPessoas()){
						if(pessoa.getNome().toUpperCase().contains(textFieldRecebeNomePesquisa.getText().trim().toUpperCase())){
							encontrouAlguem = true;
							linhas [0] = pessoa.getNome();
							linhas[1] = pessoa.getDataNascimento().getIdade();
							linhas[2] = pessoa.getSexo() == 'M' ? "Masculino" : "Feminino";
							linhas[3] = pessoa.getCpf();
							
							((DefaultTableModel) tablePesquisar.getModel()).addRow(linhas);
						}
					}
					numLinhas = tablePesquisar.getModel().getRowCount();
					textInformaQtdPacientesEncontrados.setText(numLinhas + "");
					
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

		if(pacientes.getPessoas().size()>0){
			int countMaiores = 0, countMenores = 0;
			
			limpaTela(50);
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("NOME" + tabular(5) +"NASCIMENTO" + tabular(10) + "SEXO" + tabular(4) + "CPF" + tabular(3) +"JA VACINADO?/QTD VEZES?");
			System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
			
			for(Pessoa pessoa : pacientes.getPessoas()){
				System.out.println(pessoa);
				if(pessoa instanceof MaiorDeIdade){
					countMaiores++;
				}else
					countMenores++;
			}
			
			limpaTela(5);
			System.out.println("Quantidade de Pacientes Maiores de Idade: " + countMaiores);
			System.out.println("Quantidade de Pacientes Menores de Idade: " + countMenores);
			System.out.println("Quantidade total de Pacientes: " + pacientes.getPessoas().size());
		}
		else{
			JOptionPane.showMessageDialog(null, "NENHUM PACIENTE CADASTRADO!");
		}
	}

	public static StringBuilder tabular(int tamanhoString){
		StringBuilder tabulacao = new StringBuilder();
		for(int count = 0;  count < 30-tamanhoString; count++)
			tabulacao.append(" ");
		return tabulacao;
	}
}