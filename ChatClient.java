import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connected to server");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            String serverMessage;
            String clientMessage;

            while (true) {
                System.out.print("Client: ");
                clientMessage = consoleInput.readLine();
                out.println(clientMessage);

                if (clientMessage.equalsIgnoreCase("bye")) {
                    break;
                }

                serverMessage = in.readLine();
                System.out.println("Server: " + serverMessage);
            }

            socket.close();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
} 