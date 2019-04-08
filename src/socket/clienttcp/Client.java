

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.DecimalFormat;


public class ClientTest extends JFrame{

    public ClientTest() {
        Container panel = getContentPane();
        final JTextField q0 = new JTextField(5);
        final JTextField qf = new JTextField(5);
	final JTextField t =  new JTextField(5);
        JButton ok = new JButton("SOMAR");
        final JTextArea area = new JTextArea(50, 50);

        panel.setLayout(new FlowLayout());
        panel.add(q0);
        panel.add(qf);
	panel.add(t);
        
        panel.add(ok);
        panel.add(area);

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
        	        String s1 = q0.getText();
	                String s2 = qf.getText();
			String s3 = t.getText();

                    double soma = new ClientSocket().soma(Double.parseDouble(s1), Double.parseDouble(s2), Double.parseDouble(s3));
			DecimalFormat df = new DecimalFormat("###.#####");
                    area.append("Soma (" + s1 + " + " + s2 + "): " + df.format(soma));

                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        ClientTest frame  = new ClientTest();
        frame.setSize(700,400);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
