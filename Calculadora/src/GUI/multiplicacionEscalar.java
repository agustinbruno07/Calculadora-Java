
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class multiplicacionEscalar extends JPanel {
    private JTextField txtFilas;
    private JTextField txtColumnas;
    private JTextField txtEscalar;
    private JPanel panelMatriz;
    private JPanel panelResultado;
    private JTextField txtAns;
    private String ultimoResultado = "";

    public multiplicacionEscalar() {
        setBackground(java.awt.Color.BLACK);
        setLayout(null);
        setSize(1920, 1080);

        JLabel lblFilas = new JLabel("Filas:");
        lblFilas.setForeground(Color.WHITE);
        lblFilas.setBounds(782, 120, 100, 25);
        add(lblFilas);

        txtFilas = new JTextField();
        txtFilas.setBounds(882, 120, 100, 25);
        add(txtFilas);

        JLabel lblColumnas = new JLabel("Columnas:");
        lblColumnas.setForeground(Color.WHITE);
        lblColumnas.setBounds(782, 170, 100, 25);
        add(lblColumnas);

        txtColumnas = new JTextField();
        txtColumnas.setBounds(882, 170, 100, 25);
        add(txtColumnas);

        JLabel lblEscalar = new JLabel("Escalar:");
        lblEscalar.setForeground(Color.WHITE);
        lblEscalar.setBounds(782, 220, 100, 25);
        add(lblEscalar);

        txtEscalar = new JTextField();
        txtEscalar.setBounds(882, 220, 100, 25);
        add(txtEscalar);

        JButton btnGenerar = new JButton("Generar Matriz");
        btnGenerar.setBounds(782, 270, 200, 25);
        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarCampos();
            }
        });
        add(btnGenerar);

        JLabel lblMatriz = new JLabel("Matriz");
        lblMatriz.setForeground(Color.WHITE);
        lblMatriz.setBounds(1200, 320, 100, 25);
        add(lblMatriz);

        panelMatriz = new JPanel();
        panelMatriz.setLayout(null);
        panelMatriz.setBounds(782, 320, 400, 200);
        add(panelMatriz);

        JLabel lblResultado = new JLabel("Resultado");
        lblResultado.setForeground(Color.WHITE);
        lblResultado.setBounds(1200, 530, 100, 25);
        add(lblResultado);

        panelResultado = new JPanel();
        panelResultado.setLayout(null);
        panelResultado.setBounds(782, 530, 400, 200);
        add(panelResultado);

        JButton btnMultiplicar = new JButton("Multiplicar");
        btnMultiplicar.setBounds(782, 770, 200, 25);
        btnMultiplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                multiplicarPorEscalar();
            }
        });
        add(btnMultiplicar);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(1032, 770, 200, 25);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Container papa = getParent();
                CardLayout cardlayout = (CardLayout) papa.getLayout();
                cardlayout.show(papa, "panelMatrices");
            }
        });
        add(btnVolver);

        JButton btnAns = new JButton("Ans");
        btnAns.setBounds(782, 820, 200, 25);
        btnAns.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtAns.setText(ultimoResultado);
            }
        });
        add(btnAns);

        txtAns = new JTextField();
        txtAns.setBounds(782, 870, 400, 25);
        txtAns.setEditable(false);
        add(txtAns);
    }

    private void generarCampos() {
        panelMatriz.removeAll();
        panelResultado.removeAll();

        int filas = Integer.parseInt(txtFilas.getText());
        int columnas = Integer.parseInt(txtColumnas.getText());

        int x = 10, y = 10, width = 50, height = 25;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                JTextField txtPosicion = new JTextField();
                txtPosicion.setBounds(x + (j * (width + 5)), y + (i * (height + 5)), width, height);
                panelMatriz.add(txtPosicion);
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

        panelMatriz.revalidate();
        panelMatriz.repaint();
        panelResultado.revalidate();
        panelResultado.repaint();
    }

    private void multiplicarPorEscalar() {
        int filas = Integer.parseInt(txtFilas.getText());
        int columnas = Integer.parseInt(txtColumnas.getText());
        int escalar = Integer.parseInt(txtEscalar.getText());

        StringBuilder resultadoString = new StringBuilder();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                JTextField txtMatriz = (JTextField) panelMatriz.getComponent(i * columnas + j);
                JTextField txtResultado = (JTextField) panelResultado.getComponent(i * columnas + j);

                int valor = Integer.parseInt(txtMatriz.getText());
                int resultado = valor * escalar;

                txtResultado.setText(String.valueOf(resultado));
                resultadoString.append(resultado).append(" ");
            }
            resultadoString.append("\n");
        }

        ultimoResultado = resultadoString.toString();
    }
}