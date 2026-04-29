import java.io.*;
import java.net.*;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server waiting for clients...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            String clientMessage;
            String serverMessage;

            while (true) {
                clientMessage = in.readLine();
                if (clientMessage.equalsIgnoreCase("bye")) {
                    break;
                }
                System.out.println("Client: " + clientMessage);

                System.out.print("Server: ");
                serverMessage = consoleInput.readLine();
                out.println(serverMessage);
            }

            serverSocket.close();
            clientSocket.close();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}