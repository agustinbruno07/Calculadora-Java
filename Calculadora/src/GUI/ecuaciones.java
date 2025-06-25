package GUI;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ecuaciones extends JPanel {

	
	public ecuaciones() {
		JButton btnVolver = new JButton("volver");
		btnVolver.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	    Container papa = getParent(); 
		    	    CardLayout cardlayout = (CardLayout) papa.getLayout();
		    	    cardlayout.show(papa, "calculadora");
		    }
		});
		add(btnVolver);
	}

}
