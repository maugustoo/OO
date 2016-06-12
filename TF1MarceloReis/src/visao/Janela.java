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
	//Componentes do painel de Cadastrar
	private JButton btnConfirmarDados;
	private JPanel painelCadastrar;
	private JTextField textRecebeNome;
	private JTextField textRecebeCpf;
	private JTextField textRecebeDiaNascimento;
	private JTextField textBarraDivisoriaNascimento;
	private JTextField textRecebeMesNascimento;
	private JTextField textBarraDivisoriaNascimento2;
	private JTextField textRecebeAnoNascimento;
	private JButton btnFinalizarCadastro;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFeminino;
	private JRadioButton rdbtnJaVacinadoAnteriormenteSim;
	private JRadioButton rdbtnJaVacinadoAnteriormenteNao;
	private JTextField textQtdVezesVacinado;
	private JButton btnCancelar;
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
	private JLabel lblCadastro;
	private JLabel lblNome;
	private JLabel lblSexo;
	private JLabel lblCpf;
	private JLabel lblDataNascimento;
	private JLabel lblVacinadoAnteriormente;
	private JLabel lblQtdVezesVacinado;


	/**
	 * Create the frame.
	 */
	public Janela(BancoDePacientes bancoPacientes) {

		//getPainelEntrada();
			try {
				getMenuCadastrar();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
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
			try {
				getMenuCadastrar();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
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

	private void getMenuCadastrar() throws ParseException{

		painelCadastrar = new JPanel();
		painelCadastrar.setBackground(Color.DARK_GRAY);
		painelCadastrar.setBorder(new EmptyBorder(5, 5, 5, 5));
		painelCadastrar.setLayout(null);

		lblCadastro = new JLabel("Cadastro do paciente");
		lblCadastro.setForeground(Color.LIGHT_GRAY);
		lblCadastro.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCadastro.setBounds(180, 12, 181, 15);
		painelCadastrar.add(lblCadastro);
		
		final JLabel iconeErroSexo = new JLabel(new ImageIcon("/home/marcelo/Documents/oo/programas/OO/TF1MarceloReis/imagens/error.png"));
		iconeErroSexo.setLocation(295, 94);
		iconeErroSexo.setSize(20, 19);
		iconeErroSexo.setVisible(false);
		painelCadastrar.add(iconeErroSexo);
		
		final JLabel iconeErroCpf = new JLabel(new ImageIcon("/home/marcelo/Documents/oo/programas/OO/TF1MarceloReis/imagens/error.png"));
		iconeErroCpf.setLocation(228, 125);
		iconeErroCpf.setSize(20, 19);
		iconeErroCpf.setVisible(false);
		painelCadastrar.add(iconeErroCpf);

		final JLabel iconeErroData = new JLabel(new ImageIcon("/home/marcelo/Documents/oo/programas/OO/TF1MarceloReis/imagens/error.png"));
		iconeErroData.setLocation(322, 156);
		iconeErroData.setSize(20, 19);
		iconeErroData.setVisible(false);
		painelCadastrar.add(iconeErroData);

		final JLabel iconeErroVacina = new JLabel(new ImageIcon("/home/marcelo/Documents/oo/programas/OO/TF1MarceloReis/imagens/error.png"));
		iconeErroVacina.setLocation(429, 200);
		iconeErroVacina.setSize(20, 19);
		iconeErroVacina.setVisible(false);
		painelCadastrar.add(iconeErroVacina);
		
		final JLabel iconeErroNome = new JLabel(new ImageIcon("/home/marcelo/Documents/oo/programas/OO/TF1MarceloReis/imagens/error.png"));
		iconeErroNome.setLocation(409, 63);
		iconeErroNome.setSize(20, 19);
		iconeErroNome.setVisible(false);
		painelCadastrar.add(iconeErroNome);

		textRecebeNome = new JTextField();
		textRecebeNome.setBounds(70, 63, 334, 19);
		painelCadastrar.add(textRecebeNome);
		textRecebeNome.setColumns(30);

		ButtonGroup radiosButons = new ButtonGroup();
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

		textRecebeCpf = new JFormattedTextField(new MaskFormatter("###########"));
		textRecebeCpf.setBounds(64, 125, 155, 19);
		painelCadastrar.add(textRecebeCpf);
		textRecebeCpf.setColumns(11);

		textRecebeDiaNascimento = new JFormattedTextField(new MaskFormatter("##"));
		textRecebeDiaNascimento.setBounds(138, 156, 20, 19);
		painelCadastrar.add(textRecebeDiaNascimento);
		textRecebeDiaNascimento.setColumns(2);

		textBarraDivisoriaNascimento = new JTextField();
		textBarraDivisoriaNascimento.setBackground(Color.DARK_GRAY);
		textBarraDivisoriaNascimento.setForeground(Color.LIGHT_GRAY);
		textBarraDivisoriaNascimento.setEditable(false);
		textBarraDivisoriaNascimento.setText("/");
		textBarraDivisoriaNascimento.setBounds(170, 156, 9, 19);
		painelCadastrar.add(textBarraDivisoriaNascimento);
		textBarraDivisoriaNascimento.setColumns(1);

		textRecebeMesNascimento = new JFormattedTextField(new MaskFormatter("##"));
		textRecebeMesNascimento.setBounds(191, 156, 20, 19);
		painelCadastrar.add(textRecebeMesNascimento);
		textRecebeMesNascimento.setColumns(2);

		textBarraDivisoriaNascimento2 = new JTextField();
		textBarraDivisoriaNascimento2.setForeground(Color.LIGHT_GRAY);
		textBarraDivisoriaNascimento2.setBackground(Color.DARK_GRAY);
		textBarraDivisoriaNascimento2.setEditable(false);
		textBarraDivisoriaNascimento2.setText("/");
		textBarraDivisoriaNascimento2.setBounds(228, 156, 9, 19);
		painelCadastrar.add(textBarraDivisoriaNascimento2);
		textBarraDivisoriaNascimento2.setColumns(1);

		textRecebeAnoNascimento = new JFormattedTextField(new MaskFormatter("####"));
		textRecebeAnoNascimento.setBounds(249, 156, 55, 19);
		painelCadastrar.add(textRecebeAnoNascimento);
		textRecebeAnoNascimento.setColumns(4);

		ButtonGroup yesNoOption = new ButtonGroup();
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

		ActionListener actionListenerCadastrarMaior = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				boolean nameIsValid, cpfIsValid, dateIsValid = true, sexoIsValid=true, vacinadoAnteriormente=true, qtdVacinadoAnteriormenteIsValid = true;
				Data data = null;

				if(e.getSource() == btnCancelar){
					painelCadastrar.setVisible(false);
					getContentPane().removeAll();
					getMenuGeral();
				}else if(e.getSource() == btnConfirmarDados){
					nameIsValid = Validacao.nameIsValid(textRecebeNome.getText().trim());
					cpfIsValid = pacientes.cpfEValido(textRecebeCpf.getText().trim());

					try {
						dateIsValid = Validacao.dataIsValid(Integer.parseInt(textRecebeDiaNascimento.getText().trim()),
								Integer.parseInt(textRecebeMesNascimento.getText().trim()), 
								Integer.parseInt(textRecebeAnoNascimento.getText().trim()));
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
						data = new Data(Integer.parseInt(textRecebeDiaNascimento.getText().trim()),
								Integer.parseInt(textRecebeMesNascimento.getText().trim()), 
								Integer.parseInt(textRecebeAnoNascimento.getText().trim()));
						textRecebeDiaNascimento.setEditable(false);
						textRecebeMesNascimento.setEditable(false);
						textRecebeAnoNascimento.setEditable(false);
						btnFinalizarCadastro.setVisible(true);
						btnConfirmarDados.setVisible(false);
					}

					if(!cpfIsValid){
						iconeErroCpf.setVisible(true);
					}else{
						iconeErroCpf.setVisible(false);
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

				}else if(e.getSource() == btnFinalizarCadastro){
					nameIsValid = Validacao.nameIsValid(textRecebeNome.getText().trim());
					cpfIsValid = pacientes.cpfEValido(textRecebeCpf.getText().trim());

					data = new Data(Integer.parseInt(textRecebeDiaNascimento.getText().trim()),
							Integer.parseInt(textRecebeMesNascimento.getText().trim()), 
							Integer.parseInt(textRecebeAnoNascimento.getText().trim()));

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
					}else{
						iconeErroCpf.setVisible(false);
					}
					
					if(!qtdVacinadoAnteriormenteIsValid && data.getIdade()<18){
						iconeErroVacina.setVisible(true);
					}else if(qtdVacinadoAnteriormenteIsValid && data.getIdade()<18){
						iconeErroVacina.setVisible(false);
					}
					
					if(nameIsValid && dateIsValid && vacinadoAnteriormente && cpfIsValid && sexoIsValid && data.getIdade()>=18){
						pacientes.getPessoasMaioresDeIdade().add(new MaiorDeIdade(new StringBuilder().append(textRecebeNome.getText().trim())
								, rdbtnFeminino.isSelected() ? 'F' : 'M', new Data(Integer.parseInt(textRecebeDiaNascimento.getText().trim()),
										Integer.parseInt(textRecebeMesNascimento.getText().trim()), 
										Integer.parseInt(textRecebeAnoNascimento.getText().trim())), 
										new StringBuilder().append(textRecebeCpf.getText().trim()),
										rdbtnJaVacinadoAnteriormenteSim.isSelected() ? true : false));
						JOptionPane.showMessageDialog(null, "Cadastro Efetuado com Sucesso!");
						painelCadastrar.setVisible(false);
						getContentPane().removeAll();
						getMenuGeral();
					}else if(nameIsValid && dateIsValid && qtdVacinadoAnteriormenteIsValid && cpfIsValid && sexoIsValid && data.getIdade()<18){
						pacientes.getPessoasMenoresDeIdade().add(new MenorDeIdade(new StringBuilder().append(textRecebeNome.getText().trim())
								, rdbtnFeminino.isSelected() ? 'F' : 'M', data, 
										new StringBuilder().append(textRecebeCpf.getText().trim()),
										Integer.parseInt(textQtdVezesVacinado.getText().trim())));

						JOptionPane.showMessageDialog(null, "Cadastro Efetuado com Sucesso!");

						painelCadastrar.setVisible(false);
						getContentPane().removeAll();
						getMenuGeral();
					}
				}
			}
		};

		btnFinalizarCadastro.addActionListener(actionListenerCadastrarMaior);
		btnCancelar.addActionListener(actionListenerCadastrarMaior);
		btnConfirmarDados.addActionListener(actionListenerCadastrarMaior);

		getContentPane().add(painelCadastrar);
		
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