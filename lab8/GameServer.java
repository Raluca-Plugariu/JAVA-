package lab8;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class GameServer {
    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    private boolean running = false;

    public static void main(String[] args) {
        GameServer server = null;
        try {
            server = new GameServer();
            server.init();
            server.waitForClients();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
          // Implement the waitForClients() method: while running is true, create a new socket for every incoming client and start a ClientThread to execute its request.

     GameServer() throws IOException {
     }
    // Implement the init() method: create the serverSocket and set running to true
      void init(){
        this.serverSocket = null;
        this.running = true;
    }

    // Implement the waitForClients() method: while running is true, create a new socket for every incoming client and start a ClientThread to execute its request.

    void waitForClients() {
        try {
            this.serverSocket = new ServerSocket(PORT);
            while (this.running == true) {
                System.out.println(" Asteptam un client ...");
                Socket socket = serverSocket.accept();
                // Executam solicitarea clientului intr -un fir de executie

                new ClientThread(socket).start();

                System.out.println(" S-a connectat un client ...");
            }
        } catch (IOException e) {
            System.err.println(" Eroare IO \n" + e);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop() throws IOException {
        this.running = false;
        serverSocket.close();
    }
}
