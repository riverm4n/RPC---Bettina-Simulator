package socket.clienttcp;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketRobertinaC {
	public double soma(double investimentoInicial,
						double patrimonioDesejado,
						double tempo) throws IOException {
		
		Socket socket = new Socket("10.208.1.241", 2019);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        out.writeDouble(investimentoInicial);
        out.writeDouble(patrimonioDesejado);
        out.writeDouble(tempo);




        double soma = in.readDouble();

        in.close();
        out.close();
        socket.close();

        return soma;
    }
}
