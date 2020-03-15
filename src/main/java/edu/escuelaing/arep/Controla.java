package edu.escuelaing.arep;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SocketHandler;
/**
 * 
 * @author sergio.nunez
 *
 */

public class Controla {


	public static void main( String[] args ) throws Exception{
		int i =0;
		ExecutorService pool = Executors.newFixedThreadPool(10);
		while(true) {
			i++;
			ServerSocket serverSocket = null;
			int puerto = getPort();
			try {
				serverSocket = new ServerSocket(puerto);
				System.out.println(puerto);
			} catch (IOException e) {
				System.err.println("Could not listen on port:" + getPort());
				System.exit(1);
				System.out.println(puerto);
			}

			Socket clientSocket = null;
			try {
				System.out.println("Listo para recibir ..."+i);
				clientSocket = serverSocket.accept();
			} catch (IOException e) {
				System.err.println("Accept failed.");
				System.exit(1);
			}
			HttpServer ap=new HttpServer(clientSocket);
			pool.execute(ap);
			try {
				serverSocket.close();
			} catch (IOException ex) {
				Logger.getLogger(HttpServer.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	/**
	 * Metodo que retorna el puerto en que necesita mostrar la pagina
	 * @return
	 */
	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567;
	}
}
