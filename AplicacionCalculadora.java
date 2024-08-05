import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplicacionCalculadora extends JFrame {
    private JTextField campoNumero;
    private JLabel etiquetaResultado;

    public AplicacionCalculadora() {
        setTitle("Calculadora Matemática");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel etiquetaNumero = new JLabel("Introduce un número:");
        campoNumero = new JTextField(15);
        JButton botonCalcular = new JButton("Ejecutar");
        etiquetaResultado = new JLabel("");
        etiquetaResultado.setForeground(Color.RED);

        botonCalcular.setFont(new Font("SansSerif", Font.BOLD, 16));
        botonCalcular.setPreferredSize(new Dimension(120, 40));

        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(campoNumero.getText());

                    double raiz = OperacionesGeometricas.calcularRaiz(numero);
                    int cuadrado = OperacionesGeometricas.calcularAlCuadrado(numero);
                    int cubo = OperacionesGeometricas.calcularAlCubo(numero);

                    etiquetaResultado.setText("Raíz: " + raiz +
                            " | Cuadrado: " + cuadrado +
                            " | Cubo: " + cubo);
                } catch (NumberFormatException ex) {
                    etiquetaResultado.setText("Introduce un valor válido.");
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(etiquetaNumero, gbc);

        gbc.gridx = 1;
        add(campoNumero, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(botonCalcular, gbc);

        gbc.gridy = 2;
        add(etiquetaResultado, gbc);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AplicacionCalculadora());
    }
}
