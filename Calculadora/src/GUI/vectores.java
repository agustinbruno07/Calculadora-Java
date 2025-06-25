package GUI;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class vectores extends JPanel {
         private JButton btnVolver ;
         private JPanel panelVectores;
         private JTextField tamanio;
         private JTextArea resultado;
		public vectores() {
			setBackground(Color.DARK_GRAY);
		    setLayout(null);
		    
			
		    
		    
		    
		    
		    
			JButton btnNewButton = new JButton("Volver");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 Container papa = getParent(); 
			    	    CardLayout cardlayout = (CardLayout) papa.getLayout();
			    	    cardlayout.show(papa, "calculadora");
				}
			});
			btnNewButton.setBounds(163, 192, 89, 23);
			add(btnNewButton);
	    }
		
	

}
