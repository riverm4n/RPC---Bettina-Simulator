package socket.servertcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws IOException{
    try{
      int serverPort = 2019;
      ServerSocket serverSocket = new ServerSocket(serverPort);

      System.out.println("Server running at port " + serverPort);

      while(true){
        Socket socketListen = serverSocket.accept();
      }
    }
    catch(IOException e){
      System.out.println("Listen: " + e.getMessage());
    }
  }
}
