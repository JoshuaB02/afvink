import javax.swing.*;
import java.awt.*;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Hello World!");
        System.out.println("Hello "+args[0]+"!");
        JOptionPane.showMessageDialog(jFrame, "Hello "+args[0]+"!");
        JTextField t = new JTextField(20);
        JLabel l = new JLabel("Joshua");
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JFrame f = new JFrame();
        c.gridx = 1;
        c.gridy = 0;
        p.add(t, c);
        c.gridx = 0;
        c.gridy = 0;
        p.add(l, c);
        f.add(p);
        f.setSize(300, 300);
        f.setVisible(true);
    }
}
