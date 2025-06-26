package GUI;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class vectores extends JPanel {
         private JButton btnVolver;
         private JTextField tamanio;
         private JTextArea resultado;
         private JTextField textTam;
         
         
		public vectores() {
			setBackground(Color.DARK_GRAY);
		    setLayout(null);
		;
		   
			JButton btnNewButton = new JButton("Volver");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					    Container papa = getParent(); 
			    	    CardLayout cardlayout = (CardLayout) papa.getLayout();
			    	    cardlayout.show(papa, "calculadora");
				}
			});
			btnNewButton.setBounds(351, 266, 89, 23);
			add(btnNewButton);
			
			JLabel lblTamaño = new JLabel("Tamaño");
			lblTamaño.setForeground(Color.WHITE);
			lblTamaño.setBounds(10, 47, 46, 14);
			add(lblTamaño);
			
		
			JButton btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnConfirmar.setBounds(146, 43, 89, 23);
			add(btnConfirmar);
			
			JLabel lblTitulo = new JLabel("Trabajando con Vectores");
			lblTitulo.setForeground(Color.WHITE);
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblTitulo.setBackground(Color.WHITE);
			lblTitulo.setBounds(94, 0, 290, 38);
			add(lblTitulo);
			
			textTam = new JTextField();
			textTam.setHorizontalAlignment(SwingConstants.CENTER);
			textTam.setBounds(49, 44, 86, 20);
			add(textTam);
			textTam.setColumns(10);
	    }
}
