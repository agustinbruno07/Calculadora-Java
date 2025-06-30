
package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class transpuestaMatriz extends JPanel {
    private JTextField txtFilas;
    private JTextField txtColumnas;
    private JPanel panelMatrizOriginal;
    private JPanel panelMatrizTranspuesta;
    private JTextField txtAns;
    private String ultimoResultado = "";

    public transpuestaMatriz() {
        setSize(1920, 1080);
        setBackground(Color.BLACK);
        setLayout(null);

        JLabel lblFilas = new JLabel("Filas:");
        lblFilas.setForeground(Color.WHITE);
        lblFilas.setBounds(474, 11, 100, 25);
        add(lblFilas);

        txtFilas = new JTextField();
        txtFilas.setBounds(574, 11, 100, 25);
        add(txtFilas);

        JLabel lblColumnas = new JLabel("Columnas:");
        lblColumnas.setForeground(Color.WHITE);
        lblColumnas.setBounds(474, 51, 100, 25);
        add(lblColumnas);

        txtColumnas = new JTextField();
        txtColumnas.setBounds(574, 51, 100, 25);
        add(txtColumnas);

        JButton btnGenerar = new JButton("Generar Matriz");
        btnGenerar.setBounds(474, 91, 200, 25);
        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarCampos();
            }
        });
        add(btnGenerar);

        JLabel lblMatrizOriginal = new JLabel("Matriz Original:");
        lblMatrizOriginal.setForeground(Color.WHITE);
        lblMatrizOriginal.setBounds(474, 110, 200, 25);
        add(lblMatrizOriginal);

        panelMatrizOriginal = new JPanel();
        panelMatrizOriginal.setLayout(null);
        panelMatrizOriginal.setBounds(474, 131, 400, 200);
        add(panelMatrizOriginal);

        JLabel lblMatrizTranspuesta = new JLabel("Matriz Transpuesta:");
        lblMatrizTranspuesta.setForeground(Color.WHITE);
        lblMatrizTranspuesta.setBounds(474, 326, 200, 25);
        add(lblMatrizTranspuesta);

        panelMatrizTranspuesta = new JPanel();
        panelMatrizTranspuesta.setLayout(null);
        panelMatrizTranspuesta.setBounds(474, 351, 400, 200);
        add(panelMatrizTranspuesta);

        JButton btnCalcular = new JButton("Calcular Transpuesta");
        btnCalcular.setBounds(474, 571, 174, 25);
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularTranspuesta();
            }
        });
        add(btnCalcular);

        JButton btnAns = new JButton("Ans");
        btnAns.setBounds(653, 571, 108, 25);
        btnAns.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtAns.setText(ultimoResultado);
            }
        });
        add(btnAns);

        txtAns = new JTextField();
        txtAns.setBounds(474, 606, 400, 25);
        txtAns.setEditable(false);
        add(txtAns);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(771, 571, 103, 25);
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
        panelMatrizOriginal.removeAll();
        panelMatrizTranspuesta.removeAll();

        int filas = Integer.parseInt(txtFilas.getText());
        int columnas = Integer.parseInt(txtColumnas.getText());

        int x = 10, y = 10, width = 50, height = 25;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                JTextField txtPosicion = new JTextField();
                txtPosicion.setBounds(x + (j * (width + 5)), y + (i * (height + 5)), width, height);
                panelMatrizOriginal.add(txtPosicion);
            }
        }

        for (int i = 0; i < columnas; i++) {
            for (int j = 0; j < filas; j++) {
                JTextField txtPosicion = new JTextField();
                txtPosicion.setBounds(x + (j * (width + 5)), y + (i * (height + 5)), width, height);
                txtPosicion.setEditable(false);
                panelMatrizTranspuesta.add(txtPosicion);
            }
        }

        panelMatrizOriginal.revalidate();
        panelMatrizOriginal.repaint();
        panelMatrizTranspuesta.revalidate();
        panelMatrizTranspuesta.repaint();
    }

    private void calcularTranspuesta() {
        int filas = Integer.parseInt(txtFilas.getText());
        int columnas = Integer.parseInt(txtColumnas.getText());

        StringBuilder resultadoString = new StringBuilder();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                JTextField txtOriginal = (JTextField) panelMatrizOriginal.getComponent(i * columnas + j);
                JTextField txtTranspuesta = (JTextField) panelMatrizTranspuesta.getComponent(j * filas + i);

                txtTranspuesta.setText(txtOriginal.getText());
                resultadoString.append(txtOriginal.getText()).append(" ");
            }
            resultadoString.append("\n");
        }

        ultimoResultado = resultadoString.toString();
    }
}
