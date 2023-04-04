import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalculatorAutonomieZbor extends JFrame {

    private JLabel labelConsum;
    private JLabel labelViteza;
    private JLabel labelRezervor;
    private JTextField fieldConsum;
    private JTextField fieldViteza;
    private JTextField fieldRezervor;
    private JButton buttonCalculeaza;
    private JLabel labelAutonomie;

    public CalculatorAutonomieZbor() {
        setTitle("Calculator Autonomie Zbor");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelConsum = new JLabel("Consum (l/ora): ");
        fieldConsum = new JTextField(10);
        labelViteza = new JLabel("Viteza de croazieră (km/h): ");
        fieldViteza = new JTextField(10);
        labelRezervor = new JLabel("Capacitate rezervor (l): ");
        fieldRezervor = new JTextField(10);
        buttonCalculeaza = new JButton("Calculează");
        labelAutonomie = new JLabel();

        buttonCalculeaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double consum = Double.parseDouble(fieldConsum.getText());
                    double viteza = Double.parseDouble(fieldViteza.getText());
                    double rezervor = Double.parseDouble(fieldRezervor.getText());

                    double autonomie = (rezervor / consum) * viteza;
                    labelAutonomie.setText("Autonomie de zbor: " + autonomie + " km");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Introduceți valori numerice valide!",
                            "Eroare", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setLayout(new FlowLayout());
        add(labelConsum);
        add(fieldConsum);
        add(labelViteza);
        add(fieldViteza);
        add(labelRezervor);
        add(fieldRezervor);
        add(buttonCalculeaza);
        add(labelAutonomie);
    }

    public static void main(String[] args) {
        CalculatorAutonomieZbor calculator = new CalculatorAutonomieZbor();
        calculator.setVisible(true);
    }
}
