package tprime;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GUI extends JFrame {
    JButton ListAInput= new JButton("First List Stats");
    JButton ListBInput= new JButton("Second List Stats");
    JButton Calculate= new JButton("Click to Calculate T Prime");
    JTextField ListA= new JTextField("Enter List A");
    JTextField ListB= new JTextField("Enter List B");
    JTextField Stats= new JTextField("Stats");

    public static void main(String[] arg) {
        GUI gui= new GUI();
    }

    public GUI() {
        super("T Prime Calculator");

        Box b= new Box(BoxLayout.Y_AXIS);
        b.add(ListAInput);
        b.add(ListBInput);
        b.add(Calculate);
        ListAInput.setEnabled(true);
        ListBInput.setEnabled(true);
        Calculate.setEnabled(true);

        ActionListener jtflA= (ActionEvent e) -> addToListA(e);
        ActionListener jtflB= (ActionEvent e) -> addToListB(e);

        ListAInput.addActionListener(e -> {
            ListAInput.setEnabled(false);
            ListA.setText("List A:" + Tprime.A + "\n" + "Mean of A " + Tprime.mean(Tprime.A) +
                "\n" + "Standard Deviation of A " + Tprime.stdev(Tprime.A) + "\n" +
                "Standard Error of A " + Tprime.sterr(Tprime.A));
        });

        ListBInput.addActionListener(e -> {
            ListBInput.setEnabled(false);
            ListB.setText("List B:" + Tprime.B + "\n" + "Mean of B " + Tprime.mean(Tprime.B) +
                "\n" + "Standard Deviation of B " + Tprime.stdev(Tprime.B) + "\n" +
                "Standard Error of B " + Tprime.sterr(Tprime.B));
        });

        Calculate.addActionListener(e -> {
            if (ListAInput.isEnabled() == false && ListBInput.isEnabled() == false) {
                Stats.setText("T prime is " + Tprime.tp(Tprime.A, Tprime.B));
            }
            ListAInput.setEnabled(true);
            ListBInput.setEnabled(true);
            Calculate.setEnabled(true);
        });

        add(ListA, BorderLayout.EAST);
        add(ListB, BorderLayout.WEST);
        add(Stats, BorderLayout.SOUTH);

        add(b, BorderLayout.CENTER);
        ListA.addActionListener(jtflA);
        ListB.addActionListener(jtflB);
        setFontSizes();

        pack();
        setVisible(true);
    }

    public void setFontSizes() {
        ListAInput.setFont(new Font("Arial", Font.PLAIN, 22));
        ListBInput.setFont(new Font("Arial", Font.PLAIN, 22));
        Calculate.setFont(new Font("Arial", Font.PLAIN, 22));
        ListA.setFont(new Font("Arial", Font.PLAIN, 22));
        ListB.setFont(new Font("Arial", Font.PLAIN, 22));
        Stats.setFont(new Font("Arial", Font.PLAIN, 22));
    }

    public void addToListA(ActionEvent e) {
        String str= ListA.getText();
        double gre;
        try {
            gre= Double.parseDouble(str);
            Tprime.A.add(gre);
            ListA.setText("");
            addToListA(e);
        } catch (Exception f) {

        }
    }

    public void addToListB(ActionEvent e) {
        String str= ListB.getText();
        double gre;
        try {
            gre= Double.parseDouble(str);
            Tprime.B.add(gre);
            ListB.setText("");
            addToListB(e);
        } catch (Exception f) {

        }
    }
}
