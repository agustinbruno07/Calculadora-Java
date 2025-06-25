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
	
	public calculadora() {
		getContentPane().setBackground(Color.MAGENTA);
		getContentPane().setLayout(null);
		
	    numero1= new JTextField();
	    numero1.setBounds(41, 52, 76, 20);
		getContentPane().add(numero1);
	    numero1.setColumns(10);
		
	    numero2 = new JTextField();
		numero2.setBounds(137, 52, 76, 20);
		getContentPane().add(numero2);
		numero2.setColumns(10);
	
		
		btnSuma = new JButton("+");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try {
	                    double num1 = Double.parseDouble(numero1.getText());
	                    double num2 = Double.parseDouble(numero2.getText());
	                    double resultadoSuma = operaciones.logicaCalculadora.sumar(num1, num2);
	                    lblresu.setText(String.valueOf(resultadoSuma));
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(calculadora.this,"Error: Ingrese números válidos en ambos campos.","Error de Entrada",JOptionPane.ERROR_MESSAGE);
	                    lblresu.setText("Error");
	                } catch (Exception ex) {
	                    JOptionPane.showMessageDialog(calculadora.this,"Ocurrió un error inesperado al sumar: " ,"Error", JOptionPane.ERROR_MESSAGE);
	                    lblresu.setText("Error");
	                    ex.printStackTrace();
	                }
	            }
		});
		
		btnSuma.setBounds(41, 102, 76, 38);
		getContentPane().add(btnSuma);
		
	    lblnum2 = new JLabel("numero 2");
		lblnum2.setBounds(137, 27, 86, 14);
		getContentPane().add(lblnum2);
		
		lblnum1 = new JLabel("numero 1");
		lblnum1.setBounds(41, 27, 46, 14);
		getContentPane().add(lblnum1);
		
	    lblresu = new JLabel("resultado");
		lblresu.setBounds(260, 43, 164, 38);
		getContentPane().add(lblresu);
		
		btnResta = new JButton("        -");
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   try {
	                    double num1 = Double.parseDouble(numero1.getText());
	                    double num2 = Double.parseDouble(numero2.getText());
	                    double resultadoResta = operaciones.logicaCalculadora.restar(num1, num2);
	                    lblresu.setText(String.valueOf(resultadoResta));
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(calculadora.this,"Error: Ingrese números válidos en ambos campos.","Error de Entrada",JOptionPane.ERROR_MESSAGE);
	                    lblresu.setText("Error");
	                } catch (Exception ex) {
	                    JOptionPane.showMessageDialog(calculadora.this,"Ocurrió un error inesperado al restar: " ,"Error", JOptionPane.ERROR_MESSAGE);
	                    lblresu.setText("Error");
	                    ex.printStackTrace();
	                }
	            }
		});
		btnResta.setHorizontalAlignment(SwingConstants.LEFT);
		btnResta.setBounds(137, 102, 76, 38);
		getContentPane().add(btnResta);
		
		btnMult = new JButton("X");
		btnMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try {
	                    double num1 = Double.parseDouble(numero1.getText());
	                    double num2 = Double.parseDouble(numero2.getText());
	                    double resultadoMult = operaciones.logicaCalculadora.multiplicar(num1, num2);
	                    lblresu.setText(String.valueOf(resultadoMult));
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(calculadora.this,"Error: Ingrese números válidos en ambos campos.","Error de Entrada",JOptionPane.ERROR_MESSAGE);
	                    lblresu.setText("Error");
	                } catch (Exception ex) {
	                    JOptionPane.showMessageDialog(calculadora.this,"Ocurrió un error inesperado al Multiplicar: " ,"Error", JOptionPane.ERROR_MESSAGE);
	                    lblresu.setText("Error");
	                    ex.printStackTrace();
	                }
	            }
			
		});
		btnMult.setBounds(41, 151, 76, 38);
		getContentPane().add(btnMult);
		
		btnDiv = new JButton("%");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
	                    double num1 = Double.parseDouble(numero1.getText());
	                    double num2 = Double.parseDouble(numero2.getText());
	                    double resultadoDiv = operaciones.logicaCalculadora.dividir(num1, num2);
	                    lblresu.setText(String.valueOf(resultadoDiv));
	                } catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(calculadora.this,"Error: Ingrese números válidos en ambos campos.","Error de Entrada",JOptionPane.ERROR_MESSAGE);
	                    lblresu.setText("Error");
	                } catch (Exception ex) {
	                    JOptionPane.showMessageDialog(calculadora.this,"Ocurrió un error inesperado al dividir: " ,"Error", JOptionPane.ERROR_MESSAGE);
	                    lblresu.setText("Error");
	                    ex.printStackTrace();
	                }
	            
			}
		});
		btnDiv.setBounds(137, 151, 76, 38);
		getContentPane().add(btnDiv);
	
	}
	
	
}

