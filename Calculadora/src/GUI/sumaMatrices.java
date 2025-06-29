
package GUI;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class sumaMatrices extends JPanel {
    private JTextField txtFilas;
    private JTextField txtColumnas;
    private JPanel panelMatriz1;
    private JPanel panelMatriz2;
    private JPanel panelResultado;
    private JTextField txtAns; 
    private String ultimoResultado = "";

    public sumaMatrices() {
        setBackground(java.awt.Color.BLACK);
        setLayout(null);
        setSize(1920, 1080);

        JLabel lblFilas = new JLabel("Filas:");
        lblFilas.setForeground(java.awt.Color.WHITE);
        lblFilas.setBounds(780, 76, 100, 25);
        add(lblFilas);

        txtFilas = new JTextField();
        txtFilas.setBounds(880, 76, 100, 25);
        add(txtFilas);

        JLabel lblColumnas = new JLabel("Columnas:");
        lblColumnas.setForeground(java.awt.Color.WHITE);
        lblColumnas.setBounds(780, 126, 100, 25);
        add(lblColumnas);

        txtColumnas = new JTextField();
        txtColumnas.setBounds(880, 126, 100, 25);
        add(txtColumnas);

        JButton btnGenerar = new JButton("Generar Matrices");
        btnGenerar.setBounds(780, 176, 200, 25);
        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarCampos();
            }
        });
        add(btnGenerar);


        JLabel lblMatrizA = new JLabel("Matriz A");
        lblMatrizA.setForeground(java.awt.Color.WHITE);
        lblMatrizA.setBounds(1190, 226, 100, 25);
        add(lblMatrizA);

        panelMatriz1 = new JPanel();
        panelMatriz1.setLayout(null);
        panelMatriz1.setBounds(780, 226, 400, 200);
        add(panelMatriz1);

        JLabel lblMatrizB = new JLabel("Matriz B");
        lblMatrizB.setForeground(java.awt.Color.WHITE);
        lblMatrizB.setBounds(1190, 436, 100, 25);
        add(lblMatrizB);

        panelMatriz2 = new JPanel();
        panelMatriz2.setLayout(null);
        panelMatriz2.setBounds(780, 436, 400, 200);
        add(panelMatriz2);

        JLabel lblResultado = new JLabel("Resultado");
        lblResultado.setForeground(java.awt.Color.WHITE);
        lblResultado.setBounds(1190, 646, 100, 25);
        add(lblResultado);

        panelResultado = new JPanel();
        panelResultado.setLayout(null);
        panelResultado.setBounds(780, 646, 400, 200);
        add(panelResultado);

        JButton btnSumar = new JButton("Sumar");
        btnSumar.setBounds(780, 876, 200, 25);
        btnSumar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sumarMatrices();
            }
        });
        add(btnSumar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Container papa = getParent();
                CardLayout cardlayout = (CardLayout) papa.getLayout();
                cardlayout.show(papa, "panelMatrices");
            }
        });
        btnVolver.setBounds(1101, 876, 89, 23);
        add(btnVolver);

        JButton btnAns = new JButton("Ans");
        btnAns.setBounds(1001, 876, 89, 23);
        btnAns.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtAns.setText(ultimoResultado);
            }
        });
        add(btnAns);

        txtAns = new JTextField();
        txtAns.setBounds(780, 926, 400, 25);
        txtAns.setEditable(false);
        add(txtAns);
    }

    private void generarCampos() {
        panelMatriz1.removeAll();
        panelMatriz2.removeAll();
        panelResultado.removeAll();

        int filas = Integer.parseInt(txtFilas.getText());
        int columnas = Integer.parseInt(txtColumnas.getText());

        int x = 10, y = 10, width = 50, height = 25;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                JTextField txtPosicion = new JTextField();
                txtPosicion.setBounds(x + (j * (width + 5)), y + (i * (height + 5)), width, height);
                panelMatriz1.add(txtPosicion);
            }
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                JTextField txtPosicion = new JTextField();
                txtPosicion.setBounds(x + (j * (width + 5)), y + (i * (height + 5)), width, height);
                panelMatriz2.add(txtPosicion);
            }
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                JTextField txtPosicion = new JTextField();
                txtPosicion.setBounds(x + (j * (width + 5)), y + (i * (height + 5)), width, height);
                txtPosicion.setEditable(false);
                panelResultado.add(txtPosicion);
            }
        }

        panelMatriz1.revalidate();
        panelMatriz1.repaint();
        panelMatriz2.revalidate();
        panelMatriz2.repaint();
        panelResultado.revalidate();
        panelResultado.repaint();
    }

    private void sumarMatrices() {
        int filas = Integer.parseInt(txtFilas.getText());
        int columnas = Integer.parseInt(txtColumnas.getText());

        JTextField[][] matriz1 = new JTextField[filas][columnas];
        JTextField[][] matriz2 = new JTextField[filas][columnas];
        JTextField[][] resultado = new JTextField[filas][columnas];

        StringBuilder resultadoString = new StringBuilder();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz1[i][j] = (JTextField) panelMatriz1.getComponent(i * columnas + j);
                matriz2[i][j] = (JTextField) panelMatriz2.getComponent(i * columnas + j);
                resultado[i][j] = (JTextField) panelResultado.getComponent(i * columnas + j);

                int valor1 = Integer.parseInt(matriz1[i][j].getText());
                int valor2 = Integer.parseInt(matriz2[i][j].getText());
                int suma = valor1 + valor2;

                resultado[i][j].setText(String.valueOf(suma));
                resultadoString.append(suma).append(" ");
            }
            resultadoString.append("\n");
        }

        ultimoResultado = resultadoString.toString();
    }
}