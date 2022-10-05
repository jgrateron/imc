package com.fresco;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class PanelImc extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lblEstatura;
	private JTextField jtfEstatura;
	private JLabel lblPeso;
	private JTextField jtfPeso;

	public PanelImc() {
		lblEstatura = new JLabel("Estatura en centímetros: ");
		jtfEstatura = new JTextField("", 20);
		lblPeso = new JLabel("Peso en kilogramos: ");
		jtfPeso = new JTextField("", 20);

		setLayout(new MigLayout("insets dialog, fill", "[right]unrel[]", "[]unrel[]"));
		add(lblEstatura, "");
		add(jtfEstatura, "wrap");
		add(lblPeso, "");
		add(jtfPeso, "wrap");
	}

	public double getEstatura() {
		try {
			return Double.valueOf(jtfEstatura.getText()) / 100;
		} catch (NumberFormatException e) {
			jtfEstatura.requestFocus();
			throw new NumberFormatException("Valor no válido en estatura");
		}
	}

	public double getPeso() {
		try {
			return Double.valueOf(jtfPeso.getText());
		} catch (NumberFormatException e) {
			jtfPeso.requestFocus();
			throw new NumberFormatException("Valor no válido en peso");
		}
	}
}
