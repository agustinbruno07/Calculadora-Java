
package GUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Container;
import javax.swing.JPanel;

public class matrices extends JPanel {
    private static final long serialVersionUID = 1L;

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private sumaMatrices panelSuma;
    private restaMatrices panelResta;
    private multiplicacionMatrices panelMultiplicacion;
    private multiplicacionEscalar panelEscalar;
    private inversaMatriz panelInversa;
    private divisionMatrices panelDivision;
    private determinanteMatriz panelDeterminante;
    private transpuestaMatriz panelTranspuesta;

    public matrices() {
        setSize(1920, 1080);
        setLayout(new CardLayout());

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBounds(0, 0, 600, 549);
        add(cardPanel);

        JPanel panelMatrices = new JPanel();
        panelMatrices.setBackground(Color.DARK_GRAY);
        panelMatrices.setLayout(null);
        panelMatrices.setBounds(0, 0, 600, 549);
        cardPanel.add(panelMatrices, "panelMatrices");

        panelDeterminante = new determinanteMatriz();
        panelDivision = new divisionMatrices();
        panelInversa = new inversaMatriz();
        panelEscalar = new multiplicacionEscalar();
        panelMultiplicacion = new multiplicacionMatrices();
        panelResta = new restaMatrices();
        panelSuma = new sumaMatrices();
        panelTranspuesta = new transpuestaMatriz();

        cardPanel.add(panelSuma, "panelSuma");
        cardPanel.add(panelResta, "restaMatrices");
        cardPanel.add(panelMultiplicacion, "multiplicacionMatrices");
        cardPanel.add(panelEscalar, "multiplicacionEscalar");
        cardPanel.add(panelInversa, "inversaMatriz");
        cardPanel.add(panelDivision, "divisionMatrices");
        cardPanel.add(panelDeterminante, "determinanteMatriz");
        cardPanel.add(panelTranspuesta, "transpuestaMatriz");
        
        
		JButton btnVolver = new JButton("volver");
		btnVolver.setBounds(819, 532, 89, 23);
		btnVolver.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	    Container papa = getParent(); 
		    	    CardLayout cardlayout = (CardLayout) papa.getLayout();
		    	    cardlayout.show(papa, "calculadora");
		    }
		});
		panelMatrices.add(btnVolver);

        JButton btnSuma = new JButton("Suma de matrices");
        btnSuma.setBounds(561, 252, 207, 23);
        btnSuma.addActionListener(e -> cardLayout.show(cardPanel, "panelSuma"));
        panelMatrices.add(btnSuma);

        JButton btnResta = new JButton("Resta de matrices");
        btnResta.setBounds(561, 286, 207, 23);
        btnResta.addActionListener(e -> cardLayout.show(cardPanel, "restaMatrices"));
        panelMatrices.add(btnResta);

        JButton btnMult = new JButton("Multiplicacion de matrices");
        btnMult.setBounds(561, 354, 207, 23);
        btnMult.addActionListener(e -> cardLayout.show(cardPanel, "multiplicacionMatrices"));
        panelMatrices.add(btnMult);

        JButton btnDeterminante = new JButton("Determinante de matriz");
        btnDeterminante.setBounds(561, 388, 207, 23);
        btnDeterminante.addActionListener(e -> cardLayout.show(cardPanel, "determinanteMatriz"));
        panelMatrices.add(btnDeterminante);

        JButton btnEscalar = new JButton("Multiplicar matriz por escalar");
        btnEscalar.setBounds(561, 320, 207, 23);
        btnEscalar.addActionListener(e -> cardLayout.show(cardPanel, "multiplicacionEscalar"));
        panelMatrices.add(btnEscalar);

        JButton btnInversa = new JButton("Inversa de una matriz");
        btnInversa.setBounds(561, 456, 207, 23);
        btnInversa.addActionListener(e -> cardLayout.show(cardPanel, "inversaMatriz"));
        panelMatrices.add(btnInversa);

        JButton btnDiv = new JButton("Division de matrices");
        btnDiv.setBounds(561, 490, 207, 23);
        btnDiv.addActionListener(e -> cardLayout.show(cardPanel, "divisionMatrices"));
        panelMatrices.add(btnDiv);

        JButton btnTranspuesta = new JButton("Transpuesta de una matriz");
        btnTranspuesta.setBounds(561, 422, 207, 23);
        btnTranspuesta.addActionListener(e -> cardLayout.show(cardPanel, "transpuestaMatriz"));
        panelMatrices.add(btnTranspuesta);

        JLabel opciones = new JLabel("Con que opcion queres trabajar?");
        opciones.setForeground(Color.WHITE);
        opciones.setFont(new Font("Tahoma", Font.PLAIN, 16));
        opciones.setBounds(552, 210, 243, 31);
        panelMatrices.add(opciones);
    }
}
