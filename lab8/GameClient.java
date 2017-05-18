package lab8;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class GameClient {

    private final static String SERVER_ADDRESS = "127.0.0.1";
    private final static int PORT = 8100;

    public static void main(String[] args) throws IOException {
        GameClient client = new GameClient();
        while (true) {
            String request = client.readFromKeyboard();
            if (request.equalsIgnoreCase("exit")) {
                break;
            } else {
                client.sendRequestToServer(request);
            }
        }
    }
    //Implement the sendRequestToServer method
     void sendRequestToServer(String request) {
         Socket socket = null ;

        try {
            PrintWriter out = null ;
            BufferedReader in = null ;
             socket = new Socket (SERVER_ADDRESS, PORT);
            System.out.println("Te-ai conenctat");
             // Trimitem o cerere la server
             out = new PrintWriter (socket.getOutputStream(), true);
             //request = "Duke";
             out.println (request);


             in = new BufferedReader (
                     new InputStreamReader(socket.getInputStream ()));
            String response = in.readLine();

             System.out.println(response);
            System.out.println("\n");
             in.close();
             out.close();
         } catch ( UnknownHostException e) {
             System.err.println (e);
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
    private String readFromKeyboard() {
        Scanner scanner = new Scanner(in);
        return scanner.next();
    }
}
