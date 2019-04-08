package socket.servertcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketRobertina{
  private final Socket socket;

  public SocketRobertina(Socket socket){
    this.socket = socket;
  }

  public void calcula() throws IOException{
    DataInputStream in   = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    double investimentoInicial = in.readDouble();
    double patrimonioDesejado  = in.readDouble();
    double tempo               = in.readDouble();

    double valor = patrimonioDesejado / investimentoInicial;
    double juros = (Math.pow(valor, (1/tempo))) - 1;

    System.out.println("Para obter o Patrimônio de R$" + patrimonioDesejado + " em " + tempo + " meses, a taxa de juros será de R$" + juros);

    in.close();
    out.close();
    socket.close();
  }
}
