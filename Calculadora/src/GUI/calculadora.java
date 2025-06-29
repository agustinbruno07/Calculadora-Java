package GUI;


import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
public class calculadora extends JFrame implements ActionListener {

	private JTextField ingresarTexto;
	private JButton btnSuma;
	private JButton btnResta;
	private JButton btnMult;
	private JButton btnDiv;
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private JButton btnUno;
	private JButton btnDos;
	private JButton btnCuatro;
	private JButton btnTres;
	private JButton btnCinco;
	private JButton btnSeis;
	private JButton btnSiete;
	private JButton btnOcho;
	private JButton btnNueve;
    private JButton btnRaiz;
	private JButton btnPotencia;
	private JButton btnClear;
	private JButton btnIGUAL;
	private JLabel lblTitulo;
	private JButton btnPunto;
	
	//variables
	String memoria1="";
	String memoria2="";
	String signo="";
	String muestra_resultado = "";
	float resultadoSuma=0;
	float resultadoResta=0;
	float resultadoMultiplicacion=0;
	float resultadoDivision=0;
	float resultadoRaiz=0;
	float numero1=0;
	float numero2=0;
	private JButton btnCero;
	
	public calculadora() {
		setResizable(false);
		setSize(1920,1080);
		setTitle("Guillermo-Agustin-Santino");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel panelCalculadora = new JPanel();
		panelCalculadora.setBackground(Color.DARK_GRAY);
		panelCalculadora.setLayout(null);
		
		vectores panelVectores = new vectores();
		matrices panelMatrices = new matrices();
		ecuaciones panelEcuaciones = new ecuaciones();
		 
		cardLayout = new CardLayout();
	    cardPanel = new JPanel(cardLayout);
	    setContentPane(cardPanel);
	    
	    cardPanel.add(panelCalculadora, "calculadora");
	    cardPanel.add(panelVectores, "vectores");
	    cardPanel.add(panelMatrices, "matrices");
	    cardPanel.add(panelEcuaciones, "ecuaciones");
	   
	    ingresarTexto= new JTextField();
	    ingresarTexto.setBackground(Color.WHITE);
	    ingresarTexto.setFont(new Font("Arial", Font.PLAIN, 12));
	    ingresarTexto.setBounds(531, 238, 237, 39);
	    ingresarTexto.setColumns(10);
	    panelCalculadora.add(ingresarTexto);
	
		
		btnSuma = new JButton("+");
		btnSuma.addActionListener(this);
		btnSuma.setBounds(701, 407, 67, 27);
		panelCalculadora.add(btnSuma);
		
		btnResta = new JButton("     -");
		btnResta.addActionListener(this);
		btnResta.setHorizontalAlignment(SwingConstants.LEFT);
		btnResta.setBounds(701, 367, 67, 27);
		panelCalculadora.add(btnResta);
		
		btnMult = new JButton("X");
		btnMult.addActionListener(this);
		btnMult.setBounds(701, 288, 67, 27);
		panelCalculadora.add(btnMult);
		
		btnDiv = new JButton("/");
		btnDiv.addActionListener(this);
		btnDiv.setBounds(701, 329, 67, 27);
		panelCalculadora.add(btnDiv);
		
		btnRaiz = new JButton("√");
		btnRaiz.addActionListener(this);
		btnRaiz.setBounds(531, 288, 51, 27);
		panelCalculadora.add(btnRaiz);
		
		btnPotencia = new JButton("^");
		btnPotencia.addActionListener(this);
		btnPotencia.setBounds(588, 288, 51, 27);
		panelCalculadora.add(btnPotencia);
		
		JButton btnVectores = new JButton("Trabajar con Vectores");
		btnVectores.setBackground(Color.WHITE);
		btnVectores.addActionListener(e -> cardLayout.show(cardPanel, "vectores"));
		btnVectores.setForeground(Color.BLACK);
		btnVectores.setBounds(514, 483, 266, 23);
		panelCalculadora.add(btnVectores);
		
		JButton  btnMatrices = new JButton("Trabajar con Matrices");
		btnMatrices.setBackground(Color.WHITE);
		btnMatrices.addActionListener(e -> cardLayout.show(cardPanel, "matrices"));;
		btnMatrices.setBounds(514, 517, 266, 23);
		panelCalculadora.add(btnMatrices);
		
		JButton btnEcuaciones = new JButton("Trabajar con Sistemas de Ecuaciones");
		btnEcuaciones.setBackground(Color.WHITE);
		btnEcuaciones.addActionListener(e -> cardLayout.show(cardPanel, "ecuaciones"));
		btnEcuaciones.setBounds(514, 551, 266, 23);
		panelCalculadora.add(btnEcuaciones);
		
		btnUno = new JButton("1");
		btnUno.addActionListener(this);
		btnUno.setBounds(531, 329, 51, 27);
		panelCalculadora.add(btnUno);
		
		btnDos = new JButton("2");
		btnDos.addActionListener(this);
		btnDos.setBounds(588, 329, 51, 27);
		panelCalculadora.add(btnDos);
		
	
		btnCuatro = new JButton("4");
		btnCuatro.addActionListener(this);
		btnCuatro.setBounds(531, 367, 51, 27);
		panelCalculadora.add(btnCuatro);
		
		btnTres = new JButton("3");
		btnTres.addActionListener(this);
		btnTres.setBounds(644, 329, 51, 27);
		panelCalculadora.add(btnTres);
		
		btnCinco = new JButton("5");
		btnCinco.addActionListener(this);
		btnCinco.setBounds(588, 367, 51, 27);
		panelCalculadora.add(btnCinco);
		
		btnSeis = new JButton("6");
		btnSeis.addActionListener(this);
		btnSeis.setBounds(644, 367, 51, 27);
		panelCalculadora.add(btnSeis);
		
		btnSiete = new JButton("7");
		btnSiete.addActionListener(this);
		btnSiete.setBounds(531, 407, 51, 27);
		panelCalculadora.add(btnSiete);
		
		btnOcho = new JButton("8");
		btnOcho.addActionListener(this);
		btnOcho.setBounds(588, 407, 51, 27);
		panelCalculadora.add(btnOcho);
		
		btnNueve = new JButton("9");
		btnNueve.addActionListener(this);
		btnNueve.setBounds(644, 407, 51, 27);
		panelCalculadora.add(btnNueve);
		
		btnIGUAL = new JButton("=");
		btnIGUAL.addActionListener(this);
		btnIGUAL.setForeground(Color.BLACK);
		btnIGUAL.setBounds(644, 445, 124, 27);
		panelCalculadora.add(btnIGUAL);
		
		btnClear = new JButton("C");
		btnClear.addActionListener(this);
		btnClear.setBounds(644, 288, 51, 27);
		panelCalculadora.add(btnClear);
		
		lblTitulo = new JLabel("GAS-LATOR");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblTitulo.setBounds(582, 181, 137, 46);
		panelCalculadora.add(lblTitulo);
		
		btnCero = new JButton("0");
		btnCero.addActionListener(this);
		btnCero.setBounds(531, 445, 51, 27);
		panelCalculadora.add(btnCero);
		
		btnPunto = new JButton(".");
		btnPunto.addActionListener(this);
		btnPunto.setFont(new Font("Arial", Font.BOLD, 16));
		btnPunto.setBounds(588, 445, 51, 27);
		panelCalculadora.add(btnPunto);
	}


	public void actionPerformed(ActionEvent e) {
	   
		if(e.getSource() == btnUno) {
	        ingresarTexto.setText(ingresarTexto.getText() + "1");
	    }
	    else if(e.getSource() == btnDos) {
	        ingresarTexto.setText(ingresarTexto.getText() + "2");
	    }
	    else if(e.getSource() == btnTres) {
	        ingresarTexto.setText(ingresarTexto.getText() + "3");
	    }
	    else if(e.getSource() == btnCuatro) {
	        ingresarTexto.setText(ingresarTexto.getText() + "4");
	    }
	    else if(e.getSource() == btnCinco) {
	        ingresarTexto.setText(ingresarTexto.getText() + "5");
	    }
	    else if(e.getSource() == btnSeis) {
	        ingresarTexto.setText(ingresarTexto.getText() + "6");
	    }
	    else if(e.getSource() == btnSiete) {
	        ingresarTexto.setText(ingresarTexto.getText() + "7");
	    }
	    else if(e.getSource() == btnOcho) {
	        ingresarTexto.setText(ingresarTexto.getText() + "8");
	    }
	    else if(e.getSource() == btnNueve) {
	        ingresarTexto.setText(ingresarTexto.getText() + "9");
	    }
	    else if(e.getSource() == btnCero) {
	        ingresarTexto.setText(ingresarTexto.getText() + "0");
	    } 
	    else if(e.getSource() == btnPunto) {
             ingresarTexto.setText(ingresarTexto.getText() + ".");
	    }
		
	    else if(e.getSource() == btnSuma) {
	        if(!ingresarTexto.getText().isEmpty()) {
	            signo = "Suma";
	            memoria1 = ingresarTexto.getText();
	            numero1 = Float.parseFloat(memoria1);
	            ingresarTexto.setText("");
	        }
	    }
	    else if(e.getSource() == btnResta) {
	        if(!ingresarTexto.getText().isEmpty()) {
	            signo = "Resta";
	            memoria1 = ingresarTexto.getText();
	            numero1 = Float.parseFloat(memoria1);
	            ingresarTexto.setText("");
	        }
	    }
	    else if(e.getSource() == btnMult) {
	        if(!ingresarTexto.getText().isEmpty()) {
	            signo = "Multiplicacion";
	            memoria1 = ingresarTexto.getText();
	            numero1 = Float.parseFloat(memoria1);
	            ingresarTexto.setText("");
	        }else {
	        	 ingresarTexto.setText("Error");
	        }	
	    }
	    else if(e.getSource() == btnDiv) {
	        if(!ingresarTexto.getText().isEmpty()) {
	            signo = "Division";
	            memoria1 = ingresarTexto.getText();
	            numero1 = Float.parseFloat(memoria1);
	            ingresarTexto.setText("");
	        }else {
	        	 ingresarTexto.setText("Error");
	        }	
	    }
	   
	    else if(e.getSource() == btnPotencia) {  
	        if(!ingresarTexto.getText().isEmpty()) {
	            signo = "Potencia";
	            memoria1 = ingresarTexto.getText();
	            numero1 = Float.parseFloat(memoria1);
	            ingresarTexto.setText("");
	        }else {
	        	 ingresarTexto.setText("Error");
	        }	
	    }
	    
	    	else if(e.getSource() == btnRaiz) {
	    	    if(!ingresarTexto.getText().isEmpty()) {
	    	        if(signo.isEmpty()) {
	    	            signo = "Raiz";
	    	            memoria1 = ingresarTexto.getText(); 
	    	            numero1 = Float.parseFloat(memoria1);
	    	            ingresarTexto.setText(""); 
	    	        } 
	    	        else if(signo.equals("Raiz")) { 
	    	            memoria2 = ingresarTexto.getText();
	    	            numero2 = Float.parseFloat(memoria2);
	    	            
	    	           
	    	            if(numero2 >= 0 || numero1 % 2 != 0) { 
	    	                resultadoRaiz = (float) Math.pow(numero2, 1.0/numero1);
	    	                if(numero2 < 0) {
	    	                	resultadoRaiz *= -1; 
	    	                }
	    	                muestra_resultado = Float.toString(resultadoRaiz);
	    	                ingresarTexto.setText(muestra_resultado);
	    	            } else {
	    	                ingresarTexto.setText("Error");
	    	            }
	    	            
	    	            
	    	            signo = "";
	    	            numero1 = 0;
	    	            numero2 = 0;
	    	        }
	    	    }
	    	}
	    
	   
	    else if(e.getSource() == btnIGUAL) {
	        operacion();
	        ingresarTexto.setText(muestra_resultado);
	        signo = ""; 
	        numero1 = 0;
	        numero2 = 0;
	        memoria1= "";
	        memoria2= "";
	        
	    } else if(e.getSource() == btnClear) {
	        signo = "";
	    	ingresarTexto.setText("");
 	        memoria1 = "";
 	        memoria2 = "";
 	        muestra_resultado = "";
 	        numero1 = 0;
 	        numero2 = 0;
	      
	    }
	  
	  
	}

	public void operacion() {
	    if(!ingresarTexto.getText().isEmpty()) {
	        memoria2 = ingresarTexto.getText();
	        numero2 = Float.parseFloat(memoria2);
	        
	        switch(signo) {
	            case "Suma":
	                resultadoSuma = numero1 + numero2;
	                muestra_resultado = Float.toString(resultadoSuma);
	                break;
	            case "Resta":
	                resultadoResta = numero1 - numero2;
	                muestra_resultado = Float.toString(resultadoResta);
	                break;
	            case "Multiplicacion":
	                resultadoMultiplicacion = numero1 * numero2;
	                muestra_resultado = Float.toString(resultadoMultiplicacion);
	                break;
	            case "Division":
	                if(numero2 != 0) {
	                    resultadoDivision = numero1 / numero2;
	                    muestra_resultado = Float.toString(resultadoDivision);
	                } else {
	                    muestra_resultado = "Error";
	                }
	                break;
	            case "Raiz":
	            	if (numero1 % 2 == 0 && numero2 < 0) {
	                    muestra_resultado = "Error: Raiz neg.";
	                } else {
	                    muestra_resultado = Float.toString((float) Math.pow(numero2, 1.0 / numero1));
	                }
	                break;
	            default:
	                muestra_resultado = ingresarTexto.getText(); 
	                break;
	        }
	    }
	}
}