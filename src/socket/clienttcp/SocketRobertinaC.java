package socket.clienttcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketRobertinaC {
	public double operacao(double investimentoInicial, double patrimonioDesejado,double tempo) throws IOException {
		//Objeto da classe socket, identificado pelo par(IP, porta). Por padrão utilizamos o localhost, porém, o cliente pode fazer as alterações necessárias.
		Socket socket = new Socket("localhost", 2019);

		/*
		A Classe DataInputStream é de fundamental importância para ambientes distribuídos, uma vez que permite
		que uma aplicação leia tipos primitivos de dados do Java de algum outro stream de uma forma que independe
		da máquina. Uma aplicação utiliza um data output stream para escrever dados que podem mais tarde ser lidos
		por um data input stream.
		*/
    DataInputStream in = new DataInputStream(socket.getInputStream());
		DataOutputStream out = new DataOutputStream(socket.getOutputStream());

		/*
		Abaixo o DataOutputStream faz o envio para a aplicação Servidor faz a conversão da entrada para um Double,
		com a sua quantidade de bits específica. O OutputStream escreve os bytes que representam um valor em Double,
		e não a versão legível daquele número.
		*/
    out.writeDouble(investimentoInicial);
    out.writeDouble(patrimonioDesejado);
    out.writeDouble(tempo);

		//Variável que armazena o valor retornado ao Client pelo procedimento receive.
    double valor = in.readDouble();

		//Encerramento do Stream e consequentemente da comunicação:
    in.close();
    out.close();
    socket.close();

    return valor;
    }
}
