/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep;

/**
 *
 * @author sergio.nunez
 */

import java.net.*;
import java.util.Set;

import javax.imageio.ImageIO;

import edu.escuelaing.arep.newAnotacion.Web;

import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class HttpServer implements Runnable{

	private Socket clientSocket;


	public HttpServer(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	/**
	 * realiza todas las operaciones necesarias para que inicie el servidor y 
	 * revise lo que se le escribe en el para asi retornar el recurso que se le pide.
	 * @param args
	 * @throws IOException
	 */

	@Override
	public void run(){

		try {
			PrintWriter out = new PrintWriter(
					clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(
					new InputStreamReader(clientSocket.getInputStream()));

			String inputLine;

			try {
				if ((inputLine = in.readLine()) != null) {
					//System.out.println("Recib�: " + inputLine);
					if (inputLine.contains("GET")) {

						String[] palabra = inputLine.split("/");
						String [] palabra2 =  palabra[1].split(" ");

						if(inputLine.contains(palabra2[0])) {
							if(palabra2[0].contains(".jpg")) {
								imagen("/src/main/Resource/"+palabra2[0],clientSocket.getOutputStream(),out);
							}
							else if(palabra2[0].contains(".html")) {
								leenos("/src/main/Resource/"+palabra2[0],clientSocket.getOutputStream(),out);
							}
							else if(palabra2[0].contains(".js")){
								leenos("/src/main/Resource/"+palabra2[0],clientSocket.getOutputStream(),out);
							}
							else {
								out.println("HTTP/1.1 404 Not Found \r\nContent-Type: text/html \r\n\r\n <!DOCTYPE html> <html>"
					                    + "<head><title>404</title></head>" + "<body> <h1>404 Not Found " 
					                    + "</h1></body></html>");
							}
						}
					}
					//serverSocket.close();
				}
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			out.close();
			in.close();
			clientSocket.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * Metodo que recibe una direccion para asi poder buscar la imagen y mostrarla en la pagina
	 * @param element
	 * @param clientOutput
	 * @param out
	 * @throws IOException
	 */
	@Web("/imagen")
	private static void imagen(String element, OutputStream clientOutput, PrintWriter out) throws IOException {
		try {
			BufferedImage image = ImageIO.read(new File(System.getProperty("user.dir") + element));
			ByteArrayOutputStream ArrBytes = new ByteArrayOutputStream();
			DataOutputStream writeimg = new DataOutputStream(clientOutput);
			String imagen = "HTTP/1.1 404 Not Found \r\n"
					+ "Content-Type: text/html; charset=\"utf-8\" \r\n"
					+ "\r\n";
			//out.write(imagen.getBytes());
			ImageIO.write(image, "PNG", ArrBytes);
			writeimg.writeBytes("HTTP/1.1 200 OK \r\n");
			writeimg.writeBytes("Content-Type: image/png \r\n");
			writeimg.writeBytes("\r\n");
			writeimg.write(ArrBytes.toByteArray());
			//System.out.println(System.getProperty("user.dir") + "/resources/imagenes/" + element);
		} catch (IOException e) {
		}

	}
	/**
	 * Metodo que recibe una direccion para asi poder buscar el html y mostrarlo en la pagina
	 * @param pag
	 * @param out
	 */
	@Web("/html")
	public static void leenos(String pag,OutputStream clientOutput, PrintWriter out) {
		try {
            String text = "";
            String temp;
            BufferedReader t = new BufferedReader(new FileReader(System.getProperty("user.dir") + pag));
            while ((temp = t.readLine()) != null) {
                text = text + temp;
            }
            clientOutput.write(("HTTP/1.1 201 Found  \r\n"
                    + "Content-Type: text/html; charset=\"utf-8\" \r\n"
                    + "\r\n"
                    + text).getBytes());
        } catch (IOException e) {
        } 
	}



}