import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws IOException {

        System.out.println("Сервер включен:");
        int port = 8080;
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                System.out.printf("Новое соединение, Порт: %d%n ", clientSocket.getPort());
                out.println("Как тебя зовут?");
                final String name = in.readLine();
                System.out.println(name);
                out.println(String.format("Привет %s, Ваш порт %d. \nТы ребенок? (да/нет)", name, clientSocket.getPort()));
                final String answer = in.readLine();
                System.out.println(answer);
                if (answer.equalsIgnoreCase("да")) {
                    out.println(String.format("Добро пожаловать в детский уголок, " + name + "! Давай играть!"));
                } else if (answer.equalsIgnoreCase("нет")) {
                    out.println(String.format("Добро пожаловать во взрослую зону, " + name + "! Хорошего отдыха или хорошего рабочего дня!"));
                } else {
                    out.println(String.format(name + ", не правильный ответ!"));
                }
                final String answer2 = in.readLine();
                System.out.println(answer2);
                out.println(answer2);
                System.out.println();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}