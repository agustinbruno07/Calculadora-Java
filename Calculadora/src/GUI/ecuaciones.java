package GUI;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
public class ecuaciones extends JPanel {   
    private JButton btnVolver;
    private JButton btnSistema2x2;
    private JButton btnSistema3x3;
    private JTextField[] inputs2x2;
    private JTextField[] inputs3x3;    
    public ecuaciones() {
        setBackground(Color.DARK_GRAY);
        setLayout(null);        
        crearComponentesBase();
        inicializarInputs();
    }   
    private void crearComponentesBase() {
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(350, 400, 100, 30);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Container papa = getParent(); 
                CardLayout cardlayout = (CardLayout) papa.getLayout();
                cardlayout.show(papa, "calculadora");
            }
        });
        add(btnVolver);
        btnSistema2x2 = new JButton("Sistema 2x2");
        btnSistema2x2.setBounds(50, 400, 120, 30);
        btnSistema2x2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPanel2x2();
            }
        });
        add(btnSistema2x2);
        
        btnSistema3x3 = new JButton("Sistema 3x3");
        btnSistema3x3.setBounds(180, 400, 120, 30);
        btnSistema3x3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarPanel3x3();
            }
        });
        add(btnSistema3x3);
        mostrarPanelInicial();
    }
    
    private void inicializarInputs() {
        inputs2x2 = new JTextField[6];
        inputs3x3 = new JTextField[12];
    }
    
    private void mostrarPanelInicial() {
        limpiarPanelDinamico();
        
        JLabel lblTitulo = new JLabel("Sistemas de Ecuaciones ");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTitulo.setBounds(96, 20, 331, 30);
        add(lblTitulo);
        
        revalidate();
        repaint();
    }
    
    private void limpiarPanelDinamico() {
        Component[] components = getComponents();
        for (Component component : components) {
            if (!(component == btnVolver || component == btnSistema2x2 || component == btnSistema3x3)) {
                remove(component);
            }
        }
    }
    
    private void mostrarPanel2x2() {
        limpiarPanelDinamico();
        
        JLabel lblTitulo = new JLabel("Sistema 2x2 (ax + by = c, dx + ey = f)");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(100, 20, 300, 30);
        add(lblTitulo);
        
        String[] labels = {"a:", "b:", "c:", "d:", "e:", "f:"};
        for (int i = 0; i < 6; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setForeground(Color.WHITE);
            label.setBounds(50 + (i%3)*120, 70 + (i/3)*40, 30, 20);
            add(label);
            
            inputs2x2[i] = new JTextField();
            inputs2x2[i].setBounds(80 + (i%3)*120, 70 + (i/3)*40, 50, 20);
            add(inputs2x2[i]);
        }
        
        JButton btnResolver = new JButton("Resolver");
        btnResolver.setBounds(200, 180, 100, 30);
        btnResolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resolverSistema2x2Gauss();
            }
        });
        add(btnResolver);
        
        revalidate();
        repaint();
    }
    
    private void mostrarPanel3x3() {
        limpiarPanelDinamico();
        
        JLabel lblTitulo = new JLabel("Sistema 3x3 (ax + by + cz = d, ex + fy + gz = h, ix + jy + kz = l)");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(50, 20, 400, 30);
        add(lblTitulo);
        
        String[] labels = {"a:", "b:", "c:", "d:", "e:", "f:", "g:", "h:", "i:", "j:", "k:", "l:"};
        for (int i = 0; i < 12; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setForeground(Color.WHITE);
            label.setBounds(50 + (i%4)*100, 70 + (i/4)*40, 30, 20);
            add(label);
            
            inputs3x3[i] = new JTextField();
            inputs3x3[i].setBounds(80 + (i%4)*100, 70 + (i/4)*40, 50, 20);
            add(inputs3x3[i]);
        }
        
        JButton btnResolver = new JButton("Resolver");
        btnResolver.setBounds(200, 220, 100, 30);
        btnResolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resolverSistema3x3Gauss();
            }
        });
        add(btnResolver);
        
        revalidate();
        repaint();
    }


  
    private void resolverSistema2x2Gauss() {
        try {
            float a = Float.parseFloat(inputs2x2[0].getText());
            float b = Float.parseFloat(inputs2x2[1].getText());
            float c = Float.parseFloat(inputs2x2[2].getText());
            float d = Float.parseFloat(inputs2x2[3].getText());
            float e = Float.parseFloat(inputs2x2[4].getText());
            float f = Float.parseFloat(inputs2x2[5].getText());
            if (a == 0) {
                float temp;
                temp = a; a = d; d = temp;
                temp = b; b = e; e = temp;
                temp = c; c = f; f = temp;
            }
            
            if (a == 0) {
                JOptionPane.showMessageDialog(this, "El sistema no tiene solución única.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            float factor = d / a;
            d = 0;
            e = e - b * factor;
            f = f - c * factor;
            
            if (e == 0) {
                JOptionPane.showMessageDialog(this, "El sistema no tiene solución única.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            float y = f / e;
            float x = (c - b * y) / a;
            
            String resultado = String.format("Solución:\nx = %.4f\ny = %.4f", x, y);
            JOptionPane.showMessageDialog(this, resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

   private void resolverSistema3x3Gauss() {
        try {
            float[] coef = new float[12];
            for (int i = 0; i < 12; i++) {
                coef[i] = Float.parseFloat(inputs3x3[i].getText());
            }
            float a = coef[0], b = coef[1], c = coef[2], d = coef[3];
            float e = coef[4], f = coef[5], g = coef[6], h = coef[7];
            float i = coef[8], j = coef[9], k = coef[10], l = coef[11];
            if (a == 0) {
                if (e != 0) {
                    float temp;
                    temp = a; a = e; e = temp;
                    temp = b; b = f; f = temp;
                    temp = c; c = g; g = temp;
                    temp = d; d = h; h = temp;
                } else if (i != 0) {
                    float temp;
                    temp = a; a = i; i = temp;
                    temp = b; b = j; j = temp;
                    temp = c; c = k; k = temp;
                    temp = d; d = l; l = temp;
                } else {
                    JOptionPane.showMessageDialog(this, "El sistema no tiene solución única.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            float factor1 = e / a;
            e = 0;
            f = f - b * factor1;
            g = g - c * factor1;
            h = h - d * factor1;
            float factor2 = i / a;
            i = 0;
            j = j - b * factor2;
            k = k - c * factor2;
            l = l - d * factor2;
            if (f == 0) {
                if (j != 0) {
                    float temp;
                    temp = e; e = i; i = temp;
                    temp = f; f = j; j = temp;
                    temp = g; g = k; k = temp;
                    temp = h; h = l; l = temp;
                } else {
                    JOptionPane.showMessageDialog(this, "El sistema no tiene solución única.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            
            if (f == 0) {
                JOptionPane.showMessageDialog(this, "El sistema no tiene solución única.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            float factor3 = j / f;
            j = 0;
            k = k - g * factor3;
            l = l - h * factor3;
            
            if (k == 0) {
                JOptionPane.showMessageDialog(this, "El sistema no tiene solución única.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            float z = l / k;
            float y = (h - g * z) / f;
            float x = (d - b * y - c * z) / a;
            
            String resultado = String.format("Solución:\nx = %.4f\ny = %.4f\nz = %.4f", x, y, z);
            JOptionPane.showMessageDialog(this, resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}