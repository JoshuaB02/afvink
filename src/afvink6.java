import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class afvink6 extends JFrame implements ActionListener{
    JFileChooser pick;
    JButton b1;
    JLabel l1;

    public static void main(String[] args) {
        afvink6 frame = new afvink6();
        frame.setSize(300, 100);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container w = getContentPane();
        w.setBackground(Color.LIGHT_GRAY);
        w.setLayout(new FlowLayout());
        b1 = new JButton("select file");
        b1.addActionListener(this);
        w.add(b1);
        l1 = new JLabel();
        w.add(l1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String hydrophilicAA = "CDEGHKNPQRST";
        String hydrophobicAA = "AFILMVWY";
        pick = new JFileChooser();
        pick.showSaveDialog(null);
        String text = "";
        try{
            boolean read = false;
            String line;
            BufferedReader file = new BufferedReader(new FileReader(pick.getSelectedFile().getPath()));
            while ((line=file.readLine())!=null) {
                if (read) {
                    text += line;
                }
                if (line.startsWith(">") && read) {
                    break;
                }
                if (line.startsWith(">") && !read) {
                    read = true;
                }
            }
            file.close();
            if (text.isEmpty()) {
                throw new FileException();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error 101: File Not Found");
        } catch (IOException ioe) {
            System.out.println("Error 102: Non-Readable File");
        }  catch (FileException fe) {
            System.out.println("Error 103: Incorrect File Format");
        } catch (Exception a) {
            System.out.println("Error 501: Unknown Exception");
        }
        if (!text.isEmpty()) {
            try {
            char[] c = text.toCharArray();
            int hydrophilic = 0;
            int hydrophobic = 0;
            for (int i = 0;i < text.length() ;i ++) {
                String s = Character.toString(c[i]);
                if (hydrophilicAA.contains(s)) {
                    hydrophilic ++;
                } else if (hydrophobicAA.contains(s)) {
                    hydrophobic ++;
                } else {
                    throw new FileException();
                }
            l1.setText("<html>Hydrophilic amino acids: "+hydrophilic+"<br>Hydrophobic amino acids: "+hydrophobic+"<html>");}
            } catch (FileException fe) {
                System.out.println("error 104: File Contains Incorrect Characters");
            }
        }
        System.out.println(text);
    }
}
