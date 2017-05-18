package lab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;
    private final GameServer server;
     // Create the constructor that receives a reference to the server and to the client socket


    public ClientThread ( Socket socket ) { this.socket = socket ;
        this.server = null;
    }

    public void run() {
       try {
           BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //client -> server stream
           String request = in.readLine();
           String response = execute(request);
           PrintWriter out = new PrintWriter(socket.getOutputStream()); //server -> client stream
           out.println(response);
           System.out.println(request);
           out.flush();
       }
       catch (IOException e) {
           System.err.println("Eroare IO \n" + e);
       } finally { // Inchidem socketul deschis pentru clientul curent
           try {
               socket.close();
           } catch ( IOException e) { System.err. println (e); }
       }
    }
    private String execute(String request) {
        try {
            if (request.equals ("Stop"))
                server.stop();
            } catch (IOException e) {
                e.printStackTrace();
            }
            catch(NullPointerException e) {
                e.printStackTrace();
            }

            return request;
    }
}

