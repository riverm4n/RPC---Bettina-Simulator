package socket.servertcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
  public static void main(String[] args) throws IOException{
    try{
      /*
      Ṕara se estabelecer uma comunicação, se faz necessário que o soquete esteja
      vinculado a uma porta local e um endereço IP do computador no qual ele é
      executado. Para o caso, foi escolhida a 2019. No caso selecionamos a 2019,
      porém é possível escolher até 2^16 portas.
      */
      int serverPort = 2019;

      /*
      A classe ServerSocket é responsável por aguardar a conexão do cliente. O
      construtor utilizado solicita a porta que queremos utilizar para escutar
      a conexão.
      */
      ServerSocket serverSocket = new ServerSocket(serverPort);

      System.out.println("Server running at port " + serverPort);

      while(true){
        /*
        O método accept() escuta uma conexão e a aceita. Ele bloqueia o restante
        da aplicação até que uma conexão seja feita. Seu retorno é um Socket.
        O laço while permite que sejam aceitas diversas conexões.
        */
        Socket socketListen = serverSocket.accept();

        //O método calcula realiza a operação solicitada no trabalho.
        new SocketRobertina(socketListen).calcula();
      }
    }
    catch(IOException e){
      System.out.println("Listen: " + e.getMessage());
    }
  }
}
