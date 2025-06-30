
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class determinanteMatriz extends JPanel {
    private JTextField txtDimension;
    private JPanel panelMatriz;
    private JLabel lblResultado;
    private JTextField txtAns;
    private String ultimoResultado = "";

    public determinanteMatriz() {
        setBackground(Color.BLACK);
        setLayout(null);
        setSize(1920, 1080);

        JLabel lblDimension = new JLabel("Dimensión (n x n):");
        lblDimension.setForeground(Color.WHITE);
        lblDimension.setBounds(472, 11, 150, 25);
        add(lblDimension);

        txtDimension = new JTextField();
        txtDimension.setBounds(622, 11, 100, 25);
        add(txtDimension);

        JButton btnGenerar = new JButton("Generar Matriz");
        btnGenerar.setBounds(472, 49, 200, 25);
        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarCampos();
            }
        });
        add(btnGenerar);

        panelMatriz = new JPanel();
        panelMatriz.setLayout(null);
        panelMatriz.setBounds(472, 85, 400, 294);
        add(panelMatriz);

        JButton btnCalcular = new JButton("Calcular Determinante");
        btnCalcular.setBounds(472, 400, 169, 25);
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularDeterminante();
            }
        });
        add(btnCalcular);

        lblResultado = new JLabel("Resultado: ");
        lblResultado.setForeground(Color.WHITE);
        lblResultado.setBounds(472, 472, 400, 25);
        add(lblResultado);

        JButton btnAns = new JButton("Ans");
        btnAns.setBounds(662, 400, 87, 25);
        btnAns.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtAns.setText(ultimoResultado);
            }
        });
        add(btnAns);

        txtAns = new JTextField();
        txtAns.setBounds(472, 436, 400, 25);
        txtAns.setEditable(false);
        add(txtAns);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(759, 400, 113, 25);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Container parent = getParent();
                CardLayout cardLayout = (CardLayout) parent.getLayout();
                cardLayout.show(parent, "panelMatrices");
            }
        });
        add(btnVolver);
    }

    private void generarCampos() {
        panelMatriz.removeAll();

        int dimension = Integer.parseInt(txtDimension.getText());
        int x = 10, y = 10, width = 50, height = 25;

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                JTextField txtPosicion = new JTextField();
                txtPosicion.setBounds(x + (j * (width + 5)), y + (i * (height + 5)), width, height);
                panelMatriz.add(txtPosicion);
            }
        }

        panelMatriz.revalidate();
        panelMatriz.repaint();
    }

    private void calcularDeterminante() {
        int dimension = Integer.parseInt(txtDimension.getText());
        double[][] matriz = new double[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                JTextField txtPosicion = (JTextField) panelMatriz.getComponent(i * dimension + j);
                matriz[i][j] = Double.parseDouble(txtPosicion.getText());
            }
        }

        double determinante = calcularDeterminanteRecursivo(matriz);
        ultimoResultado = String.valueOf(determinante);
        lblResultado.setText("Resultado: " + determinante);
    }

    private double calcularDeterminanteRecursivo(double[][] matriz) {
        int n = matriz.length;
        if (n == 1) {
            return matriz[0][0];
        }
        if (n == 2) {
            return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        }

        double determinante = 0;
        for (int i = 0; i < n; i++) {
            double[][] submatriz = new double[n - 1][n - 1];
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k < i) {
                        submatriz[j - 1][k] = matriz[j][k];
                    } else if (k > i) {
                        submatriz[j - 1][k - 1] = matriz[j][k];
                    }
                }
            }
            determinante += matriz[0][i] * calcularDeterminanteRecursivo(submatriz) * (i % 2 == 0 ? 1 : -1);
        }
        return determinante;
    }
}

