import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        int port = 8080;
        try (Socket clientSocket = new Socket("netology.homework", port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Алексей");
            final String resp = in.readLine();
            System.out.println(resp);
            out.println("Нет");
            final String resp2 = in.readLine();
            System.out.println(resp2);
            out.println("Спасибо");
            final String resp3 = in.readLine();
            System.out.println(resp3);
            final String resp4 = in.readLine();
            System.out.println(resp4);
            final String resp5 = in.readLine();
            System.out.println(resp5);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
