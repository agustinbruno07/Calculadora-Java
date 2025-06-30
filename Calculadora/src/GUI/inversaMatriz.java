
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inversaMatriz extends JPanel {
    private JTextField txtDimension;
    private JPanel panelMatrizOriginal;
    private JPanel panelMatrizInversa;
    private JTextField txtAns;
    private String ultimoResultado = "";

    public inversaMatriz() {
        setSize(1920, 1080);
        setBackground(Color.BLACK);
        setLayout(null);

        JLabel lblDimension = new JLabel("Dimensión (n x n):");
        lblDimension.setForeground(Color.WHITE);
        lblDimension.setBounds(506, 12, 150, 25);
        add(lblDimension);

        txtDimension = new JTextField();
        txtDimension.setBounds(606, 12, 100, 25);
        add(txtDimension);

        JButton btnGenerar = new JButton("Generar Matriz");
        btnGenerar.setBounds(506, 48, 200, 25);
        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    generarCampos();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una dimensión válida.");
                }
            }
        });
        add(btnGenerar);

        JLabel lblMatrizOriginal = new JLabel("Matriz:");
        lblMatrizOriginal.setForeground(Color.WHITE);
        lblMatrizOriginal.setBounds(506, 72, 150, 25);
        add(lblMatrizOriginal);

        panelMatrizOriginal = new JPanel();
        panelMatrizOriginal.setLayout(null);
        panelMatrizOriginal.setBounds(506, 96, 400, 276);
        add(panelMatrizOriginal);

        JLabel lblMatrizInversa = new JLabel("Matriz Inversa:");
        lblMatrizInversa.setForeground(Color.WHITE);
        lblMatrizInversa.setBounds(506, 371, 150, 25);
        add(lblMatrizInversa);

        panelMatrizInversa = new JPanel();
        panelMatrizInversa.setLayout(null);
        panelMatrizInversa.setBounds(506, 395, 400, 276);
        add(panelMatrizInversa);

        JButton btnCalcular = new JButton("Calcular Inversa");
        btnCalcular.setBounds(506, 682, 150, 25);
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    calcularInversa();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al calcular la inversa: " + ex.getMessage());
                }
            }
        });
        add(btnCalcular);

        JButton btnAns = new JButton("Ans");
        btnAns.setBounds(661, 682, 141, 25);
        btnAns.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtAns.setText(ultimoResultado);
            }
        });
        add(btnAns);

        txtAns = new JTextField();
        txtAns.setBounds(506, 718, 400, 25);
        txtAns.setEditable(false);
        add(txtAns);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(813, 682, 93, 25);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Container papa = getParent();
                CardLayout cardlayout = (CardLayout) papa.getLayout();
                cardlayout.show(papa, "panelMatrices");
            }
        });
        add(btnVolver);
    }

    private void generarCampos() {
        panelMatrizOriginal.removeAll();
        panelMatrizInversa.removeAll();

        int dimension = Integer.parseInt(txtDimension.getText());
        int x = 10, y = 10, width = 50, height = 25;

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                JTextField txtPosicion = new JTextField();
                txtPosicion.setBounds(x + (j * (width + 5)), y + (i * (height + 5)), width, height);
                panelMatrizOriginal.add(txtPosicion);
            }
        }

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                JTextField txtPosicion = new JTextField();
                txtPosicion.setBounds(x + (j * (width + 5)), y + (i * (height + 5)), width, height);
                txtPosicion.setEditable(false);
                panelMatrizInversa.add(txtPosicion);
            }
        }

        panelMatrizOriginal.revalidate();
        panelMatrizOriginal.repaint();
        panelMatrizInversa.revalidate();
        panelMatrizInversa.repaint();
    }

    private void calcularInversa() {
        int dimension = Integer.parseInt(txtDimension.getText());
        double[][] matriz = new double[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                JTextField txtPosicion = (JTextField) panelMatrizOriginal.getComponent(i * dimension + j);
                matriz[i][j] = Double.parseDouble(txtPosicion.getText());
            }
        }

        double[][] inversa = calcularInversaMatriz(matriz);

        if (inversa == null) {
            JOptionPane.showMessageDialog(this, "La matriz no tiene inversa.");
            return;
        }

        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                JTextField txtPosicion = (JTextField) panelMatrizInversa.getComponent(i * dimension + j);
                txtPosicion.setText(String.format("%.4f", inversa[i][j]));
                resultado.append(String.format("%.4f ", inversa[i][j]));
            }
            resultado.append("\n");
        }
        ultimoResultado = resultado.toString();
    }

    private double[][] calcularInversaMatriz(double[][] matriz) {
        int n = matriz.length;
        double determinante = calcularDeterminante(matriz);

        if (Math.abs(determinante) < 1e-10) {
            return null;
        }

        double[][] cofactores = calcularMatrizCofactores(matriz);
        double[][] transpuesta = transponerMatriz(cofactores);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transpuesta[i][j] /= determinante;
            }
        }

        return transpuesta;
    }

    private double calcularDeterminante(double[][] matriz) {
        int n = matriz.length;
        if (n == 1) {
            return matriz[0][0];
        }

        double determinante = 0;
        for (int j = 0; j < n; j++) {
            determinante += matriz[0][j] * calcularCofactor(matriz, 0, j);
        }

        return determinante;
    }

    private double[][] calcularMatrizCofactores(double[][] matriz) {
        int n = matriz.length;
        double[][] cofactores = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cofactores[i][j] = calcularCofactor(matriz, i, j);
            }
        }

        return cofactores;
    }

    private double calcularCofactor(double[][] matriz, int fila, int columna) {
        int n = matriz.length;
        double[][] submatriz = new double[n - 1][n - 1];

        for (int i = 0, subI = 0; i < n; i++) {
            if (i == fila) continue;

            for (int j = 0, subJ = 0; j < n; j++) {
                if (j == columna) continue;

                submatriz[subI][subJ] = matriz[i][j];
                subJ++;
            }
            subI++;
        }

        return Math.pow(-1, fila + columna) * calcularDeterminante(submatriz);
    }

    private double[][] transponerMatriz(double[][] matriz) {
        int n = matriz.length;
        double[][] transpuesta = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transpuesta[i][j] = matriz[j][i];
            }
        }

        return transpuesta;
    }
}
