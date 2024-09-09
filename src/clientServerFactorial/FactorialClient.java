package clientServerFactorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FactorialClient {
    public static void main(String[] args) {
        try {
            System.out.println("Client Started!");
            Socket clientSocket = new Socket("localhost", 9806);

            // used to read the data from the keyboard
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a number: ");
            int number = Integer.parseInt(userInput.readLine()); // to convert the String to int

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(number);

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println(in.readLine());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
