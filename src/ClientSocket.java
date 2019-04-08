

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocket {
    public double soma(double q0, double qf, double t) throws IOException {
        Socket socket = new Socket("10.208.1.241", 2019);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        out.writeDouble(q0);
        out.writeDouble(qf);
	out.writeDouble(t);




        double soma = in.readDouble();

        in.close();
        out.close();
        socket.close();

        return soma;
    }
}
