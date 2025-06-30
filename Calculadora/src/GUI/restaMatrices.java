
package GUI;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class restaMatrices extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField txtFilas;
    private JTextField txtColumnas;
    private JPanel panelMatriz1;
    private JPanel panelMatriz2;
    private JPanel panelResultado;
    private JTextField txtAns; 
    private String ultimoResultado = "";

    public restaMatrices() {
        setLocation(-779, -435);
        setBackground(java.awt.Color.BLACK);
        setLayout(null);
        setSize(1920, 1080);

        JLabel lblFilas = new JLabel("Filas:");
        lblFilas.setForeground(java.awt.Color.WHITE);
        lblFilas.setBounds(428, 11, 100, 25);
        add(lblFilas);

        txtFilas = new JTextField();
        txtFilas.setBounds(528, 11, 100, 25);
        add(txtFilas);

        JLabel lblColumnas = new JLabel("Columnas:");
        lblColumnas.setForeground(java.awt.Color.WHITE);
        lblColumnas.setBounds(428, 61, 100, 25);
        add(lblColumnas);

        txtColumnas = new JTextField();
        txtColumnas.setBounds(528, 61, 100, 25);
        add(txtColumnas);

        JButton btnGenerar = new JButton("Generar Matrices");
        btnGenerar.setBounds(428, 111, 200, 25);
        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarCampos();
            }
        });
        add(btnGenerar);

        // Etiqueta para Matriz A
        JLabel lblMatrizA = new JLabel("Matriz A");
        lblMatrizA.setForeground(java.awt.Color.WHITE);
        lblMatrizA.setBounds(428, 134, 100, 25);
        add(lblMatrizA);

        panelMatriz1 = new JPanel();
        panelMatriz1.setLayout(null);
        panelMatriz1.setBounds(428, 161, 400, 200);
        add(panelMatriz1);

        // Etiqueta para Matriz B
        JLabel lblMatrizB = new JLabel("Matriz B");
        lblMatrizB.setForeground(java.awt.Color.WHITE);
        lblMatrizB.setBounds(779, 406, 100, 25);
        add(lblMatrizB);

        panelMatriz2 = new JPanel();
        panelMatriz2.setLayout(null);
        panelMatriz2.setBounds(428, 392, 400, 200);
        add(panelMatriz2);

        panelResultado = new JPanel();
        panelResultado.setLayout(null);
        panelResultado.setBounds(842, 161, 400, 200);
        add(panelResultado);

        JButton btnRestar = new JButton("Restar");
        btnRestar.setBounds(428, 603, 200, 25);
        btnRestar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                restarMatrices();
            }
        });
        add(btnRestar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Container papa = getParent();
                CardLayout cardlayout = (CardLayout) papa.getLayout();
                cardlayout.show(papa, "panelMatrices");
            }
        });
        btnVolver.setBounds(736, 603, 89, 23);
        add(btnVolver);

        JButton btnAns = new JButton("Ans");
        btnAns.setBounds(637, 604, 89, 23);
        btnAns.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtAns.setText(ultimoResultado);
            }
        });
        add(btnAns);

        txtAns = new JTextField();
        txtAns.setBounds(428, 639, 400, 25);
        txtAns.setEditable(false);
        add(txtAns);
        
                // Etiqueta para Resultado
                JLabel lblResultado = new JLabel("Resultado");
                lblResultado.setBounds(842, 134, 100, 25);
                add(lblResultado);
                lblResultado.setForeground(java.awt.Color.WHITE);
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

    private void restarMatrices() {
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
                int resta = valor1 - valor2;

                resultado[i][j].setText(String.valueOf(resta));
                resultadoString.append(resta).append(" ");
            }
            resultadoString.append("\n");
        }

        ultimoResultado = resultadoString.toString();
    }
}
