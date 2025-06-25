package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import operaciones.logicaCalculadora;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Component;
import javax.swing.*;
import java.awt.*;
public class calculadora extends JFrame {
	private JTextField numero1;
	private JTextField numero2;
	private JButton btnSuma;
	private JLabel lblresu;
	private JLabel lblnum1;
	private JLabel lblnum2;
	private JButton btnResta;
	private JButton btnMult;
	private JButton btnDiv;
	private JLabel lblResultado;
	private CardLayout cardLayout;
	private JPanel cardPanel;
	
	public calculadora() {
		setSize(500,300);
		cardLayout = new CardLayout();
	    cardPanel = new JPanel(cardLayout);
	    setContentPane(cardPanel);
	    JPanel panelCalculadora = new JPanel();
	    panelCalculadora.setLayout(null);
	    panelCalculadora.setBackground(Color.GRAY);
	    cardPanel.add(panelCalculadora, "calculadora");

	    vectores panelVectores = new vectores();
	    matrices panelMatrices = new matrices();
	    ecuaciones panelEcuaciones = new ecuaciones();

	    cardPanel.add(panelVectores, "vectores");
	    cardPanel.add(panelMatrices, "matrices");
	    cardPanel.add(panelEcuaciones, "ecuaciones");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    numero1= new JTextField();
	    numero1.setFont(new Font("Arial", Font.PLAIN, 12));
	    numero1.setBounds(0, 52, 97, 39);
	    numero1.setColumns(10);
	    panelCalculadora.add(numero1);
	    numero2 = new JTextField();
	    numero2.setFont(new Font("Arial", Font.PLAIN, 12));
		numero2.setBounds(122, 52, 97, 39);
		panelCalculadora.add(numero2);
		numero2.setColumns(10);
	
		
		btnSuma = new JButton("+");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try {
	                    double num1 = Double.parseDouble(numero1.getText());
	                    double num2 = Double.parseDouble(numero2.getText());
	                    double resultadoSuma = operaciones.logicaCalculadora.sumar(num1, num2);
	                    lblResultado.setText(String.valueOf(resultadoSuma));
	                } catch (NumberFormatException ex) {
	                    lblResultado.setText("DATOS INVALIDOS");
	                } catch (Exception ex) {
	                    lblResultado.setText("Error");
	                    ex.printStackTrace();
	                }
	            }
		});
		
		btnSuma.setBounds(21, 102, 74, 27);
		panelCalculadora.add(btnSuma);
		
	    lblnum2 = new JLabel("numero 2(radicando)");
	    lblnum2.setForeground(Color.WHITE);
	    lblnum2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblnum2.setBounds(122, 27, 140, 27);
		panelCalculadora.add(lblnum2);
		
		lblnum1 = new JLabel("numero 1(indice)");
		lblnum1.setForeground(Color.WHITE);
		lblnum1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblnum1.setBounds(0, 27, 117, 27);
		panelCalculadora.add(lblnum1);
		
	    lblresu = new JLabel("Resultado:");
	    lblresu.setForeground(Color.WHITE);
	    lblresu.setFont(new Font("Arial", Font.BOLD, 14));
		lblresu.setBounds(219, 63, 83, 14);
		panelCalculadora.add(lblresu);
		
		btnResta = new JButton("     -");
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   try {
	                    double num1 = Double.parseDouble(numero1.getText());
	                    double num2 = Double.parseDouble(numero2.getText());
	                    double resultadoResta = operaciones.logicaCalculadora.restar(num1, num2);
	                    lblResultado.setText(String.valueOf(resultadoResta));
	                } catch (NumberFormatException ex) {
	                    lblResultado.setText("DATOS INVALIDOS");
	                } catch (Exception ex) {
	                    lblResultado.setText("Error");
	                    ex.printStackTrace();
	                }
	            }
		});
		btnResta.setHorizontalAlignment(SwingConstants.LEFT);
		btnResta.setBounds(122, 102, 74, 27);
		panelCalculadora.add(btnResta);
		
		btnMult = new JButton("X");
		btnMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try {
	                    double num1 = Double.parseDouble(numero1.getText());
	                    double num2 = Double.parseDouble(numero2.getText());
	                    double resultadoMult = operaciones.logicaCalculadora.multiplicar(num1, num2);
	                    lblResultado.setText(String.valueOf(resultadoMult));
	                } catch (NumberFormatException ex) {

	                    lblResultado.setText("DATOS INVALIDOS");
	                } catch (Exception ex) {
	                    lblResultado.setText("Error");
	                    ex.printStackTrace();
	                }
	            }
			
		});
		btnMult.setBounds(21, 140, 74, 27);
		panelCalculadora.add(btnMult);
		
		btnDiv = new JButton("%");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	                    double num1 = Double.parseDouble(numero1.getText());
	                    double num2 = Double.parseDouble(numero2.getText());
	                    double resultadoDiv = operaciones.logicaCalculadora.dividir(num1, num2);
	                    lblResultado.setText(String.valueOf(resultadoDiv));
	                } catch (NumberFormatException ex) {

	                    lblResultado.setText("DATOS INVALIDOS");
	                } catch (Exception ex) {
	                    lblResultado.setText("Error");
	                    ex.printStackTrace();
	                }
	            
			}
		});
		btnDiv.setBounds(122, 140, 74, 27);
		panelCalculadora.add(btnDiv);
		
		JButton btnRaiz = new JButton("Raiz");
		btnRaiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	                    double num1 = Double.parseDouble(numero1.getText());
	                    double num2 = Double.parseDouble(numero2.getText());
	                    double resultadoRaiz= operaciones.logicaCalculadora.raiz(num1, num2);
	                    lblResultado.setText(String.valueOf(resultadoRaiz));
	                } catch (NumberFormatException ex) {

	                    lblResultado.setText("DATOS INVALIDOS");
	                } catch (Exception ex) {
	                    lblResultado.setText("Error");
	                    ex.printStackTrace();
	                }
			}
			
		});
		btnRaiz.setBounds(122, 178, 74, 27);
		panelCalculadora.add(btnRaiz);
		
		JButton btnPotencia = new JButton("Potencia");
		btnPotencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	                    double num1 = Double.parseDouble(numero1.getText());
	                    double num2 = Double.parseDouble(numero2.getText());
	                    double resultadoPot= operaciones.logicaCalculadora.potencia(num1, num2);
	                    lblResultado.setText(String.valueOf(resultadoPot));
	                   
	                } catch (NumberFormatException ex) {

	                    lblResultado.setText("DATOS INVALIDOS");
	                } catch (Exception ex) {
	                    lblResultado.setText("Error");
	                    ex.printStackTrace();
	                }
	            
				
			}
		});
		btnPotencia.setBounds(21, 178, 74, 27);
		panelCalculadora.add(btnPotencia);
		
		JLabel lblTitulo = new JLabel("GAS-LATOR");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		
		lblTitulo.setBounds(165, 7, 154, 25);
		panelCalculadora.add(lblTitulo);
		
		lblResultado = new JLabel("0");
		lblResultado.setForeground(Color.WHITE);
		lblResultado.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblResultado.setBounds(299, 62, 282, 14);
		panelCalculadora.add(lblResultado);
		
		JButton btnVectores = new JButton("Trabajar con Vectores");
		btnVectores.addActionListener(e -> cardLayout.show(cardPanel, "vectores"));
		btnVectores.setForeground(Color.BLACK);
		btnVectores.setBounds(241, 104, 179, 23);
		panelCalculadora.add(btnVectores);
		
		JButton  btnMatrices = new JButton("Trabajar con Matrices");
		btnMatrices.addActionListener(e -> cardLayout.show(cardPanel, "matrices"));;
		btnMatrices.setBounds(241, 140, 179, 23);
		panelCalculadora.add(btnMatrices);
		
		JButton btnEcuaciones = new JButton("Trabajar con Ecuaciones");
		btnEcuaciones.addActionListener(e -> cardLayout.show(cardPanel, "ecuaciones"));
		btnEcuaciones.setBounds(241, 180, 179, 23);
		panelCalculadora.add(btnEcuaciones);
	}
}

