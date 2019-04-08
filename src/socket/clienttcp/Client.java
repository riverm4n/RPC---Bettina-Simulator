package socket.clienttcp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.DecimalFormat;


public class Client extends JFrame{
    public Client(){
    	Container panel = getContentPane();
    	final JLabel lbQ0 = new JLabel("Investimento Inicial - Q0");
    	final JLabel lbQf = new JLabel("Patrimônio Desejado - Qf");
    	final JLabel lbT = new JLabel("Tempo - t");
      final JTextField investimentoInicial = new JTextField(7);
      final JTextField patrimonioDesejado = new JTextField(7);
      final JTextField tempo =  new JTextField(7);
      JButton ok = new JButton("REVELAR");
      final JTextArea area = new JTextArea(50, 50);

      // JPanel panel = new JPanel();
      //panel.setLayout(new GridLayout(15, 2, 2, 2));
      //panel.setLayout(new FlowLayout());
      setLayout(null);

        lbQ0.setBounds(50,40,200,20);
        lbQf.setBounds(50,80,200,20);
        lbT.setBounds(50,120,200,20);
        ok.setBounds(50,160,100,20);

        investimentoInicial.setBounds(250,40,100,20);
        patrimonioDesejado.setBounds(250,80,100,20);
        tempo.setBounds(250,120,100,20);
        area.setBounds(250,160,100,20);

        panel.add(lbQ0);
        panel.add(investimentoInicial);
        panel.add(lbQf);
        panel.add(patrimonioDesejado);
        panel.add(lbT);
        panel.add(tempo);

        panel.add(ok);
        panel.add(area);
        setContentPane(panel);
        pack();



        ok.addActionListener(new ActionListener()
        {
        	int indice = 0;
            public void actionPerformed(ActionEvent e)
            {
                try {
        	        String s1 = investimentoInicial.getText();
	                String s2 = patrimonioDesejado.getText();
	                String s3 = tempo.getText();

                    double soma = new SocketRobertinaC().soma(
                    		Double.parseDouble(s1),
                    		Double.parseDouble(s2),
                    		Double.parseDouble(s3));

                    DecimalFormat df = new DecimalFormat("###.#####");
                    indice++;
                    area.append(indice+") Soma (" + s1 + " + " + s2 + "): " + df.format(soma));

                } catch (NumberFormatException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        Client frame  = new Client();
        frame.setSize(400,250);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
