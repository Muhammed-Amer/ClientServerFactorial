package clientServerFactorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FactorialServer {
    public static void main(String[] args) {
        try {
            System.out.println("waiting for clients!");
            ServerSocket serverSocket = new ServerSocket(9806); // port number
            Socket socket = serverSocket.accept();
            System.out.println("Connection established!");

            // used to read the data from the socket input stream
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            int number = Integer.parseInt(input.readLine());

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Factorial = " + calculateFactorial(number));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static int calculateFactorial(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
