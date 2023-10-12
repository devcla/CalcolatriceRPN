import javax.swing.*;
import java.awt.*;

public class Calcolatrice {
    private JPanel Panel;
    private JPanel displayContainer;
    private JLabel display;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton button4;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton button8;
    private JButton button9;
    private JButton a3Button;
    private JButton a2Button;
    private JButton a1Button;
    private JPanel buttonContainer;
    private CalcolatriceRPN calcolatrice;
    public Calcolatrice() {
        calcolatrice = new CalcolatriceRPN();
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calcolatrice");
        frame.setContentPane(new Calcolatrice().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(450, 400));
        frame.setVisible(true);
    }

}
