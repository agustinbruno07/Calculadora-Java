package GUI;

import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class vectores extends JPanel {
    private JTextField Tam1erVector;
    private JTextField Tam2doVector;
    private JButton btnConfirmar;
    private JPanel panelCampos;
    private List<JTextField> camposA;
    private List<JTextField> camposB;
    private JTextField txtEscalar;
    private JTextArea areaResultado;
    private JTextField textEscalar;
    private double[] ultimoResultado;
    private int ultimoResultadoTam;
    public vectores() {
        setBackground(Color.DARK_GRAY);
        setLayout(null);
        setSize(1920,1080);      
        JPanel panelDeArriba = new JPanel();
        panelDeArriba.setBackground(Color.DARK_GRAY);
        panelDeArriba.setLayout(null);
        panelDeArriba.setBounds(424, 177, 600, 113);
        add(panelDeArriba);
        
        JLabel lblTitulo = new JLabel("Trabajando con Vectores");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblTitulo.setBounds(163, -3, 300, 30);
        panelDeArriba.add(lblTitulo);
        
        JLabel lblTamaño = new JLabel("Primer Vector ");
        lblTamaño.setForeground(Color.WHITE);
        lblTamaño.setBounds(47, 50, 86, 25);
        panelDeArriba.add(lblTamaño);
        
        Tam1erVector = new JTextField();
        Tam1erVector.setBounds(134, 50, 50, 25);
        Tam1erVector.setHorizontalAlignment(SwingConstants.CENTER);
        panelDeArriba.add(Tam1erVector);
        
        JLabel lblSegundoVector = new JLabel("Segundo Vector ");
        lblSegundoVector.setForeground(Color.WHITE);
        lblSegundoVector.setBounds(31, 79, 102, 25);
        panelDeArriba.add(lblSegundoVector);
        
        Tam2doVector = new JTextField();
        Tam2doVector.setBounds(134, 79, 50, 25);
        Tam2doVector.setHorizontalAlignment(SwingConstants.CENTER);
        panelDeArriba.add(Tam2doVector);
        
        btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(e -> camposVectores());
        btnConfirmar.setBounds(185, 63, 95, 25);
        panelDeArriba.add(btnConfirmar);
        
        JLabel lblNewLabel = new JLabel("Escalar K:");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(300, 68, 76, 14);
        panelDeArriba.add(lblNewLabel);
        
        textEscalar = new JTextField();
        textEscalar.setBounds(361, 65, 49, 20);
        panelDeArriba.add(textEscalar);
        textEscalar.setColumns(10);
       
        panelCampos = new JPanel();
        panelCampos.setLayout(null);
        panelCampos.setBounds(424, 288, 600, 130);
        panelCampos.setBackground(Color.DARK_GRAY);
        add(panelCampos);
        
        JPanel panelOperaciones = new JPanel();
        panelOperaciones.setLayout(null);
        panelOperaciones.setBounds(424, 417, 600, 55);
        panelOperaciones.setBackground(Color.BLACK);
        add(panelOperaciones);
       
        JButton btnSuma = new JButton("A + B");
        btnSuma.setBounds(10, 11, 64, 30);
        btnSuma.addActionListener(e -> Suma());
        panelOperaciones.add(btnSuma);
        
        JButton btnResta = new JButton("A - B");
        btnResta.setBounds(84, 11, 77, 30);
        btnResta.addActionListener(e -> Resta());
        panelOperaciones.add(btnResta);
        
        JButton btnMultEscalar = 	new JButton("K * A");
        btnMultEscalar.setBounds(171, 11, 64, 30);
        btnMultEscalar.addActionListener(e -> MultEscalar());
        panelOperaciones.add(btnMultEscalar);
        
        JButton btnProdEscalar = new JButton("Prod.Escalar");
        btnProdEscalar.setBounds(245, 11, 117, 30);
        btnProdEscalar.addActionListener(e -> ProductoEscalar());
        panelOperaciones.add(btnProdEscalar);
        
        JButton btnProdVectorial = new JButton("Prod.Vectorial");
        btnProdVectorial.setBounds(372, 11, 119, 30);
        btnProdVectorial.addActionListener(e ->ProductoVectorial());
        panelOperaciones.add(btnProdVectorial);
        
        JButton btnANS = new JButton("ANS");
        btnANS.addActionListener(e -> mostrarANS());
        btnANS.setBounds(501, 11, 89, 30);
        panelOperaciones.add(btnANS);
        
        JPanel panelResultado = new JPanel();
        panelResultado.setLayout(null);
        panelResultado.setBounds(424, 471, 600, 99);
        panelResultado.setBackground(Color.DARK_GRAY);
        add(panelResultado);
        
        areaResultado = new JTextArea();
        areaResultado.setBounds(20, 10, 418, 78);
        areaResultado.setEditable(false);
        areaResultado.setBackground(Color.WHITE);
        panelResultado.add(areaResultado);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(484, 37, 90, 30);
        btnVolver.addActionListener(e -> {
            Container papa = getParent(); 
            CardLayout cardlayout = (CardLayout) papa.getLayout();
            cardlayout.show(papa, "calculadora");
        });
        panelResultado.add(btnVolver);
       
        camposA = new ArrayList<>();
        camposB = new ArrayList<>();
    }
    private void mostrarANS() {
		
		Tam1erVector.setText(String.valueOf(camposA.size()));
		Tam2doVector.setText(String.valueOf(camposB.size()));
		camposVectores();
	    for (int i = 0; i < ultimoResultadoTam; i++) {
	    	camposA.get(i).setText(String.valueOf(ultimoResultado[i]));
	    }
	    for (JTextField campo : camposB) {
            campo.setText("");
        }
	    areaResultado.setText("El resultado anterior Cargado en el Vector A\n");
	    
    }
    private void camposVectores() {
    	int tam1 = Integer.parseInt(Tam1erVector.getText());
    	int tam2 = Integer.parseInt(Tam2doVector.getText());
    	areaResultado.setText(""); 
		if (tam2 < 1 || tam2 > 6) {
			areaResultado.setText("El tamaño de los vectores debe ser entre 1 y 6");
			return;
    		
    	}else if (Tam1erVector.getText().isEmpty() || Tam2doVector.getText().isEmpty()) {
			areaResultado.setText("ingrese el tamaño de los vectores");
			return;
			
		}else if(tam1 != tam2) {
    	    areaResultado.setText("Los vectores deben tener el mismo tamaño");
    	}else if (tam1 <= 0 || tam2 <= 0) {
			areaResultado.setText("El tamaño de los vectores debe ser mayor que cero");
		} else {
			panelCampos.removeAll();// hago limpiar los campos anteriores por si existen
			camposA.clear();//limpio los campos 
			camposB.clear();
			 
			JLabel lblVectorA = new JLabel("Vector A:");
	        lblVectorA.setForeground(Color.BLACK);
	        lblVectorA.setBounds(20, 10, 100, 20);
	        panelCampos.add(lblVectorA);
			for (int i = 0; i < tam1; i++) {
	        JTextField campoA = new JTextField();
	        campoA.setBounds(20 + (i * 60), 40, 50, 25);
			panelCampos.add(campoA);
			camposA.add(campoA);
			}
			JLabel lblVectorB = new JLabel("Vector B:");
	        lblVectorB.setForeground(Color.BLACK);
	        lblVectorB.setBounds(20, 70, 100, 20);
	        panelCampos.add(lblVectorB);
			for(int i = 0; i< tam1; i++) {
				JTextField campoB = new JTextField();
				campoB.setBounds(20 + (i * 60), 100, 50, 25);
				panelCampos.add(campoB);
				camposB.add(campoB);
			}
			panelCampos.revalidate();
			panelCampos.repaint();
    	
    } 

}
    private void Suma() {
    	 int tam1 = Integer.parseInt(Tam1erVector.getText());
    	 int tam2 = Integer.parseInt(Tam2doVector.getText());
    	if (camposA.isEmpty() || camposB.isEmpty()) {
			areaResultado.setText("Por favor, ingrese los vectores primero.");
			return;
		}
    	if(tam1 != tam2){
    		JOptionPane.showMessageDialog(this, "Los vectores deben tener el mismo tamaño para la suma");
    		areaResultado.setText("Error");
    		return;
    	}
         
    	String Resultado = "El resultado de la suma es";
     	 double[] vectorA = new double[tam1];
         double[] vectorB = new double[tam2];
         double[] resultado = new double[tam1]; 
     	 for(int i = 0; i< tam1; i++) {
        	 vectorA[i] = Double.parseDouble(camposA.get(i).getText());
        	 vectorB[i] = Double.parseDouble(camposB.get(i).getText());
        	 resultado[i] = vectorA[i] + vectorB[i];
         }
     	 areaResultado.setText(Resultado + "\n"	);
		for (int i = 0; i < tam1; i++) {
			areaResultado.append("[" + resultado[i]+ "]");
		}

        ultimoResultado = resultado;//para el ANS
        ultimoResultadoTam = resultado.length; //para el ANS
    }
    private void Resta() {
    	 int tam1 = Integer.parseInt(Tam1erVector.getText());
    	 int tam2 = Integer.parseInt(Tam2doVector.getText());
    	if (camposA.isEmpty() || camposB.isEmpty()) {
			areaResultado.setText("Por favor, ingrese los vectores primero.");
			return;
		}
    	if(tam1 != tam2){
    		JOptionPane.showMessageDialog(this, "Los vectores deben tener el mismo tamaño para la resta");
    		areaResultado.setText("Error");
    		return;
    	}
         
    	String Resultado = "El resultado de la resta es";
     	 double[] vectorA = new double[tam1];
         double[] vectorB = new double[tam2];
         double[] resultado = new double[tam1]; 
         
     	 for(int i = 0; i< tam1; i++) {
        	 vectorA[i] = Double.parseDouble(camposA.get(i).getText());
        	 vectorB[i] = Double.parseDouble(camposB.get(i).getText());
        	 resultado[i] = vectorA[i] - vectorB[i];
         }
     	 areaResultado.setText(Resultado + "\n"	);
		for (int i = 0; i < tam1; i++) {
			areaResultado.append("[" + resultado[i]+ "]");
		}

        ultimoResultado = resultado;//para el ANS
        ultimoResultadoTam = resultado.length; //para el ANS
    }
    private void MultEscalar() {
    	int tam1 = Integer.parseInt(Tam1erVector.getText());
    	int tam2 = Integer.parseInt(Tam2doVector.getText());
    	if (camposA.isEmpty() || camposB.isEmpty()) {
			areaResultado.setText("Por favor, ingrese los vectores primero.");
			return;
		}
		if (tam1 <= 0 || tam2 <= 0) {
			JOptionPane.showMessageDialog(this, "El tamaño de los  vectores debe ser mayor que cero");
			areaResultado.setText("Error");
			return;
		}
		if (textEscalar.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor escalar");
			areaResultado.setText("Error");
			return;
			
		}

		String Resultado = "El resultado de la multiplicación escalar es";
		double[] vectorA = new double[tam1];
		double escalar = Double.parseDouble(textEscalar.getText());
		double[] resultado = new double[tam1];
		for (int i = 0; i < tam1; i++) {
			vectorA[i] = Double.parseDouble(camposA.get(i).getText());
			resultado[i] = vectorA[i] * escalar;
		}
		areaResultado.setText(Resultado + "\n");
		for (int i = 0; i < tam1; i++) {
			areaResultado.append("[" + resultado[i]+ "]");
		}

    	
    }

	private void ProductoEscalar() {
    	int tam1 = Integer.parseInt(Tam1erVector.getText());
    	int tam2 = Integer.parseInt(Tam2doVector.getText());
    	if (camposA.isEmpty() || camposB.isEmpty()) {
    	areaResultado.setText(" ingrese los vectores primero.");
    	}
    	String Resultado = "El resultado del producto escalar es ";
    	double[] vectorA = new double[tam1];
    	double[] vectorB = new double[tam2];
    	double[] resultado = new double[tam1];
		for (int i = 0; i < tam1; i++) {
			vectorA[i] = Double.parseDouble(camposA.get(i).getText());
			vectorB[i] = Double.parseDouble(camposB.get(i).getText());
			resultado[i] += vectorA[i] * vectorB[i];
		}
		areaResultado.setText(Resultado + "\n");
		for (int i = 0; i < tam1; i++) {
			areaResultado.append(" " + resultado[i]);
		}

        ultimoResultado = resultado;//para el ANS
        ultimoResultadoTam = resultado.length; //para el ANS
	}   
	private void ProductoVectorial() {
		int tam1 = Integer.parseInt(Tam1erVector.getText());
		int tam2 = Integer.parseInt(Tam2doVector.getText());
		if (camposA.isEmpty() || camposB.isEmpty()) {
			areaResultado.setText(" ingrese los vectores primero.");
			return;
		}
		if (tam1 != 3 || tam2 != 3) {
			JOptionPane.showMessageDialog(this,
					"El producto vectorial solo se puede realizar con vectores de tamaño 3");
			areaResultado.setText("Error");
			return;
		}

		String Resultado = "El resultado del producto vectorial es ";
		double[] vectorA = new double[tam1];
		double[] vectorB = new double[tam2];
		double[] resultado = new double[3];

      
		vectorA[0] = Double.parseDouble(camposA.get(0).getText());
		vectorA[1] = Double.parseDouble(camposA.get(1).getText());
		vectorA[2] = Double.parseDouble(camposA.get(2).getText());

		vectorB[0] = Double.parseDouble(camposB.get(0).getText());
		vectorB[1] = Double.parseDouble(camposB.get(1).getText());
		vectorB[2] = Double.parseDouble(camposB.get(2).getText());

		resultado[0] = vectorA[1] * vectorB[2] - vectorA[2] * vectorB[1];
		resultado[1] = vectorA[2] * vectorB[0] - vectorA[0] * vectorB[2];
		resultado[2] = vectorA[0] * vectorB[1] - vectorA[1] * vectorB[0];

		areaResultado.setText(Resultado + "\n");
		for (int i = 0; i < 3; i++) {
			areaResultado.append("[" + resultado[i]+ "]");
		}

        ultimoResultado = resultado;//para el ANS
        ultimoResultadoTam = resultado.length; //para el ANS
	}
 }