
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class multiplicacionMatrices extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField txtFilas1;
    private JTextField txtColumnas1;
    private JTextField txtFilas2;
    private JTextField txtColumnas2;
    private JPanel panelMatriz1;
    private JPanel panelMatriz2;
    private JPanel panelResultado;
    private JTextField txtAns;
    private String ultimoResultado = "";

    public multiplicacionMatrices() {
        setBackground(Color.BLACK);
        setLayout(null);
        setSize(1920, 1080);

        JLabel lblFilas1 = new JLabel("Filas Matriz 1:");
        lblFilas1.setForeground(Color.WHITE);
        lblFilas1.setBounds(779, 53, 150, 25);
        add(lblFilas1);

        txtFilas1 = new JTextField();
        txtFilas1.setBounds(929, 53, 100, 25);
        add(txtFilas1);

        JLabel lblColumnas1 = new JLabel("Columnas Matriz 1:");
        lblColumnas1.setForeground(Color.WHITE);
        lblColumnas1.setBounds(779, 103, 150, 25);
        add(lblColumnas1);

        txtColumnas1 = new JTextField();
        txtColumnas1.setBounds(929, 103, 100, 25);
        add(txtColumnas1);

        JLabel lblFilas2 = new JLabel("Filas Matriz 2:");
        lblFilas2.setForeground(Color.WHITE);
        lblFilas2.setBounds(779, 153, 150, 25);
        add(lblFilas2);

        txtFilas2 = new JTextField();
        txtFilas2.setBounds(929, 153, 100, 25);
        add(txtFilas2);

        JLabel lblColumnas2 = new JLabel("Columnas Matriz 2:");
        lblColumnas2.setForeground(Color.WHITE);
        lblColumnas2.setBounds(779, 203, 150, 25);
        add(lblColumnas2);

        txtColumnas2 = new JTextField();
        txtColumnas2.setBounds(929, 203, 100, 25);
        add(txtColumnas2);

        JButton btnGenerar = new JButton("Generar Matrices");
        btnGenerar.setBounds(779, 253, 200, 25);
        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarCampos();
            }
        });
        add(btnGenerar);

        JLabel lblMatriz1 = new JLabel("Matriz 1");
        lblMatriz1.setForeground(Color.WHITE);
        lblMatriz1.setBounds(1200, 303, 100, 25);
        add(lblMatriz1);

        panelMatriz1 = new JPanel();
        panelMatriz1.setLayout(null);
        panelMatriz1.setBounds(779, 303, 400, 200);
        add(panelMatriz1);

        JLabel lblMatriz2 = new JLabel("Matriz 2");
        lblMatriz2.setForeground(Color.WHITE);
        lblMatriz2.setBounds(1200, 513, 100, 25);
        add(lblMatriz2);

        panelMatriz2 = new JPanel();
        panelMatriz2.setLayout(null);
        panelMatriz2.setBounds(779, 513, 400, 200);
        add(panelMatriz2);

        JLabel lblResultado = new JLabel("Resultado");
        lblResultado.setForeground(Color.WHITE);
        lblResultado.setBounds(1200, 723, 100, 25);
        add(lblResultado);

        panelResultado = new JPanel();
        panelResultado.setLayout(null);
        panelResultado.setBounds(779, 723, 400, 200);
        add(panelResultado);

        JButton btnMultiplicar = new JButton("Multiplicar");
        btnMultiplicar.setBounds(779, 953, 200, 25);
        btnMultiplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                multiplicarMatrices();
            }
        });
        add(btnMultiplicar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(1029, 953, 200, 25);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Container papa = getParent();
                CardLayout cardlayout = (CardLayout) papa.getLayout();
                cardlayout.show(papa, "panelMatrices");
            }
        });
        add(btnVolver);

        JButton btnAns = new JButton("Ans");
        btnAns.setBounds(779, 1003, 200, 25);
        btnAns.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtAns.setText(ultimoResultado);
            }
        });
        add(btnAns);

        txtAns = new JTextField();
        txtAns.setBounds(1029, 1003, 200, 25);
        txtAns.setEditable(false);
        add(txtAns);
    }

    private void generarCampos() {
        panelMatriz1.removeAll();
        panelMatriz2.removeAll();
        panelResultado.removeAll();

        int filas1 = Integer.parseInt(txtFilas1.getText());
        int columnas1 = Integer.parseInt(txtColumnas1.getText());
        int filas2 = Integer.parseInt(txtFilas2.getText());
        int columnas2 = Integer.parseInt(txtColumnas2.getText());

        if (columnas1 != filas2) {
            JOptionPane.showMessageDialog(this, "Las columnas de la primera matriz deben ser iguales a las filas de la segunda matriz.");
            return;
        }

        int x = 10, y = 10, width = 50, height = 25;

        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas1; j++) {
                JTextField txtPosicion = new JTextField();
                txtPosicion.setBounds(x + (j * (width + 5)), y + (i * (height + 5)), width, height);
                panelMatriz1.add(txtPosicion);
            }
        }

        for (int i = 0; i < filas2; i++) {
            for (int j = 0; j < columnas2; j++) {
                JTextField txtPosicion = new JTextField();
                txtPosicion.setBounds(x + (j * (width + 5)), y + (i * (height + 5)), width, height);
                panelMatriz2.add(txtPosicion);
            }
        }

        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas2; j++) {
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

    private void multiplicarMatrices() {
        int filas1 = Integer.parseInt(txtFilas1.getText());
        int columnas1 = Integer.parseInt(txtColumnas1.getText());
        int filas2 = Integer.parseInt(txtFilas2.getText());
        int columnas2 = Integer.parseInt(txtColumnas2.getText());

        StringBuilder resultadoString = new StringBuilder();

        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas2; j++) {
                int suma = 0;
                for (int k = 0; k < columnas1; k++) {
                    JTextField txtMatriz1 = (JTextField) panelMatriz1.getComponent(i * columnas1 + k);
                    JTextField txtMatriz2 = (JTextField) panelMatriz2.getComponent(k * columnas2 + j);

                    int valor1 = Integer.parseInt(txtMatriz1.getText());
                    int valor2 = Integer.parseInt(txtMatriz2.getText());
                    suma += valor1 * valor2;
                }
                JTextField txtResultado = (JTextField) panelResultado.getComponent(i * columnas2 + j);
                txtResultado.setText(String.valueOf(suma));
                resultadoString.append(suma).append(" ");
            }
            resultadoString.append("\n");
        }

        ultimoResultado = resultadoString.toString();
    }
}
