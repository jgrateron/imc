package com.fresco;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class App extends JFrame {
	private static final long serialVersionUID = 1L;

	private PanelImc panelImc;
	private JButton jbCalcular;
	private JButton jbCerrar;

	public App() {
		init();
	}

	public void init() {
		setTitle("Calculadora del índice de masa corporal (IMC)");
		setSize(512, 512);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout(5, 5));
		panelImc = new PanelImc();
		var lblCalcular = new JLabel("Para calcular su índice de masa corporal, ingrese su estatura y peso.");
		var font = lblCalcular.getFont();
		font = font.deriveFont(18f);
		lblCalcular.setFont(font);
		add(lblCalcular, BorderLayout.NORTH);
		add(panelImc, BorderLayout.CENTER);

		var panelBotones = new JPanel();
		jbCalcular = new JButton("Calcular");
		jbCalcular.addActionListener(evt -> calcularImc());
		jbCerrar = new JButton("Cerrar");
		jbCerrar.addActionListener(evt -> closeDialog());
		panelBotones.add(jbCalcular);
		panelBotones.add(jbCerrar);
		add(panelBotones, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		pack();
	}

	private void calcularImc() {
		try {
			double estatura = panelImc.getEstatura();
			double peso = panelImc.getPeso();
			double imc = peso / (estatura * estatura);
			var dImc = new DImc(this, imc);
			dImc.setVisible(true);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.WARNING_MESSAGE);
			return;
		}
	}

	private void closeDialog() {
		setVisible(false);
		dispose();
	}

	public static void main(String[] args) {
		var app = new App();
		app.setVisible(true);
	}

}
