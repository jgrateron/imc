package com.fresco;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DImc extends JDialog {

	private static final long serialVersionUID = 1L;
	private Icon background;
	private ClassLoader classLoader = ClassLoader.getSystemClassLoader();

	public DImc(JFrame parent, double imc) {
		super(parent, Dialog.ModalityType.DOCUMENT_MODAL);
		setTitle("IMC");
		setSize(714, 380);

		background = new ImageIcon(classLoader.getResource("FeLCxYgWAAEl5HH.jpeg"));

		var image = new BufferedImage(background.getIconWidth(), background.getIconHeight(),
				BufferedImage.TYPE_INT_ARGB);
		var g2 = image.createGraphics();
		g2.setColor(Color.BLACK);
		g2.setFont(new Font("Monospaced", Font.PLAIN, 24));
		g2.drawImage(toImage(background), 0, 0, null);
		g2.drawString(String.format("%.2f", imc), 320, 320);
		JLabel picLabel = new JLabel(new ImageIcon(image));
		add(picLabel);

		setResizable(false);
		setLocationRelativeTo(parent);
		pack();
	}

	private Image toImage(Icon icon) {
		return ((ImageIcon) icon).getImage();
	}

}
