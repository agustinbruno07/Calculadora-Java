
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
        lblFilas.setBounds(780, 110, 100, 25);
        add(lblFilas);

        txtFilas = new JTextField();
        txtFilas.setBounds(880, 110, 100, 25);
        add(txtFilas);

        JLabel lblColumnas = new JLabel("Columnas:");
        lblColumnas.setForeground(Color.WHITE);
        lblColumnas.setBounds(780, 150, 100, 25);
        add(lblColumnas);

        txtColumnas = new JTextField();
        txtColumnas.setBounds(880, 150, 100, 25);
        add(txtColumnas);

        JButton btnGenerar = new JButton("Generar Matriz");
        btnGenerar.setBounds(780, 190, 200, 25);
        btnGenerar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarCampos();
            }
        });
        add(btnGenerar);

        JLabel lblMatrizOriginal = new JLabel("Matriz Original:");
        lblMatrizOriginal.setForeground(Color.WHITE);
        lblMatrizOriginal.setBounds(630, 226, 200, 25);
        add(lblMatrizOriginal);

        panelMatrizOriginal = new JPanel();
        panelMatrizOriginal.setLayout(null);
        panelMatrizOriginal.setBounds(780, 230, 400, 200);
        add(panelMatrizOriginal);

        JLabel lblMatrizTranspuesta = new JLabel("Matriz Transpuesta:");
        lblMatrizTranspuesta.setForeground(Color.WHITE);
        lblMatrizTranspuesta.setBounds(630, 450, 200, 25);
        add(lblMatrizTranspuesta);

        panelMatrizTranspuesta = new JPanel();
        panelMatrizTranspuesta.setLayout(null);
        panelMatrizTranspuesta.setBounds(780, 450, 400, 200);
        add(panelMatrizTranspuesta);

        JButton btnCalcular = new JButton("Calcular Transpuesta");
        btnCalcular.setBounds(780, 670, 200, 25);
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularTranspuesta();
            }
        });
        add(btnCalcular);

        JButton btnAns = new JButton("Ans");
        btnAns.setBounds(780, 710, 200, 25);
        btnAns.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtAns.setText(ultimoResultado);
            }
        });
        add(btnAns);

        txtAns = new JTextField();
        txtAns.setBounds(1000, 710, 200, 25);
        txtAns.setEditable(false);
        add(txtAns);

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(780, 750, 200, 25);
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
