
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class divisionMatrices extends JPanel {
    private static final long serialVersionUID = 1L; // Serialización requerida
    private JTextField txtDimension;
    private JPanel panelMatrizA;
    private JPanel panelMatrizB;
    private JPanel panelMatrizResultado;
    private JTextField txtAns;
    private String ultimoResultado = "";

    public divisionMatrices() {
        setSize(1920, 1080);
        setBackground(Color.BLACK);
        setLayout(null);

        JLabel lblDimension = new JLabel("Dimensión (n x n):");
        lblDimension.setForeground(Color.WHITE);
        lblDimension.setBounds(472, 0, 150, 25);
        add(lblDimension);

        txtDimension = new JTextField();
        txtDimension.setBounds(592, 0, 100, 25);
        add(txtDimension);

        JButton btnGenerar = new JButton("Generar Matrices");
        btnGenerar.setBounds(472, 27, 200, 25);
        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    generarCampos();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido para la dimensión.");
                }
            }
        });
        add(btnGenerar);

        JLabel lblMatrizA = new JLabel("Matriz A:");
        lblMatrizA.setForeground(Color.WHITE);
        lblMatrizA.setBounds(472, 56, 100, 25);
        add(lblMatrizA);

        panelMatrizA = new JPanel();
        panelMatrizA.setLayout(null);
        panelMatrizA.setBounds(472, 82, 400, 275);
        add(panelMatrizA);

        JLabel lblMatrizB = new JLabel("Matriz B:");
        lblMatrizB.setForeground(Color.WHITE);
        lblMatrizB.setBounds(472, 353, 100, 25);
        add(lblMatrizB);

        panelMatrizB = new JPanel();
        panelMatrizB.setLayout(null);
        panelMatrizB.setBounds(472, 389, 400, 259);
        add(panelMatrizB);

        JLabel lblResultado = new JLabel("Resultado:");
        lblResultado.setForeground(Color.WHITE);
        lblResultado.setBounds(1102, 128, 100, 25);
        add(lblResultado);

        panelMatrizResultado = new JPanel();
        panelMatrizResultado.setLayout(null);
        panelMatrizResultado.setBounds(892, 82, 400, 275);
        add(panelMatrizResultado);

        JButton btnCalcular = new JButton("Calcular División");
        btnCalcular.setBounds(472, 659, 109, 25);
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    calcularDivision();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese valores numéricos válidos en las matrices.");
                }
            }
        });
        add(btnCalcular);

        JButton btnAns = new JButton("Ans");
        btnAns.setBounds(593, 659, 134, 25);
        btnAns.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtAns.setText(ultimoResultado);
            }
        });
        add(btnAns);

        txtAns = new JTextField();
        txtAns.setBounds(472, 695, 400, 25);
        txtAns.setEditable(false);
        add(txtAns);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(748, 659, 124, 25);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Container papa = getParent();
                CardLayout cardlayout = (CardLayout) papa.getLayout();
                cardlayout.show(papa, "panelMatrices");
            }
        });
        add(btnVolver);
        
        JLabel lblResultado_1 = new JLabel("Resultado:");
        lblResultado_1.setForeground(Color.WHITE);
        lblResultado_1.setBounds(892, 46, 100, 25);
        add(lblResultado_1);
    }

    private void generarCampos() {
        panelMatrizA.removeAll();
        panelMatrizB.removeAll();
        panelMatrizResultado.removeAll();

        int dimension = Integer.parseInt(txtDimension.getText());
        int x = 10, y = 10, width = 50, height = 25;

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                JTextField txtPosicionA = new JTextField();
                txtPosicionA.setBounds(x + (j * (width + 5)), y + (i * (height + 5)), width, height);
                panelMatrizA.add(txtPosicionA);

                JTextField txtPosicionB = new JTextField();
                txtPosicionB.setBounds(x + (j * (width + 5)), y + (i * (height + 5)), width, height);
                panelMatrizB.add(txtPosicionB);

                JTextField txtPosicionResultado = new JTextField();
                txtPosicionResultado.setBounds(x + (j * (width + 5)), y + (i * (height + 5)), width, height);
                txtPosicionResultado.setEditable(false);
                panelMatrizResultado.add(txtPosicionResultado);
            }
        }

        panelMatrizA.revalidate();
        panelMatrizA.repaint();
        panelMatrizB.revalidate();
        panelMatrizB.repaint();
        panelMatrizResultado.revalidate();
        panelMatrizResultado.repaint();
    }

    private void calcularDivision() {
        int dimension = Integer.parseInt(txtDimension.getText());
        double[][] matrizA = new double[dimension][dimension];
        double[][] matrizB = new double[dimension][dimension];
        double[][] resultado;

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                JTextField txtPosicionA = (JTextField) panelMatrizA.getComponent(i * dimension + j);
                matrizA[i][j] = Double.parseDouble(txtPosicionA.getText());

                JTextField txtPosicionB = (JTextField) panelMatrizB.getComponent(i * dimension + j);
                matrizB[i][j] = Double.parseDouble(txtPosicionB.getText());
            }
        }

        double[][] inversaB = calcularInversaMatriz(matrizB);
        if (inversaB == null) {
            JOptionPane.showMessageDialog(this, "La matriz B no tiene inversa.");
            return;
        }

        resultado = multiplicarMatrices(matrizA, inversaB);

        StringBuilder resultadoString = new StringBuilder();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                JTextField txtPosicionResultado = (JTextField) panelMatrizResultado.getComponent(i * dimension + j);
                txtPosicionResultado.setText(String.format("%.4f", resultado[i][j]));
                resultadoString.append(String.format("%.4f ", resultado[i][j]));
            }
            resultadoString.append("\n");
        }
        ultimoResultado = resultadoString.toString();
    }

    private double[][] calcularInversaMatriz(double[][] matriz) {
        int n = matriz.length;
        double[][] identidad = new double[n][n];
        double[][] copia = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                identidad[i][j] = (i == j) ? 1 : 0;
                copia[i][j] = matriz[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            if (Math.abs(copia[i][i]) < 1e-10) {
                for (int k = i + 1; k < n; k++) {
                    if (Math.abs(copia[k][i]) > Math.abs(copia[i][i])) {
                        double[] temp = copia[i];
                        copia[i] = copia[k];
                        copia[k] = temp;

                        temp = identidad[i];
                        identidad[i] = identidad[k];
                        identidad[k] = temp;
                    }
                }
            }

            double pivote = copia[i][i];
            if (Math.abs(pivote) < 1e-10) {
                return null;
            }
            for (int j = 0; j < n; j++) {
                copia[i][j] /= pivote;
                identidad[i][j] /= pivote;
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = copia[k][i];
                    for (int j = 0; j < n; j++) {
                        copia[k][j] -= factor * copia[i][j];
                        identidad[k][j] -= factor * identidad[i][j];
                    }
                }
            }
        }

        return identidad;
    }

    private double[][] multiplicarMatrices(double[][] matrizA, double[][] matrizB) {
        int n = matrizA.length;
        double[][] resultado = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultado[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    resultado[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        return resultado;
    }
}
