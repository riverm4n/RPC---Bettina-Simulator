package socket.servertcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketRobertina{
  /*
  O atributo privado é útil para que possamos armazenar a instância da comunicação
  estabelecida com o servidor e para que não seja necessária a reconexão com o
  mesmo.
  */
  private final Socket socket;

  //Aqui utilizamos o construtor passando um Socket. No caso, o mesmo retornado
  //pelo método accept() na classe Server.java.
  public SocketRobertina(Socket socket){
    this.socket = socket;
  }

  public void calcula() throws IOException{
    //Leitura de dados submetidos pelo cliente.
    DataInputStream in   = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    double investimentoInicial = in.readDouble(); //Quanto foi investido inicialmente, apontado como Q0 na fórmula.
    double patrimonioDesejado  = in.readDouble(); //Patrimônio final que deseja-se obter, representado por Qf na fórmula.
    double tempo               = in.readDouble(); //Tempo em meses no qual deseja-se obter o patrimônio desejado.

    double valor = patrimonioDesejado / investimentoInicial; //Divisão entre o patrimônioDesejado e o investimentoInicial, apresentada na parte interna da raíz.
    //Fórmula do cálculo de juros mensal i, representado pela subtração da raíz t da divisão entre patrimonioDesejado e investimentoInicial com 1.
    double juros = (Math.pow(valor, (1/tempo))) - 1;

    System.out.println("Para obter o Patrimônio de R$" + patrimonioDesejado + " em " + tempo + " meses, a taxa de juros mensal será de " + juros + " % ao mês");
    out.writeDouble(juros);

    //Fechamento do Stream de dados nessa conexão e consequente finalização da sessão.
    in.close();
    out.close();
    socket.close();
  }
}
