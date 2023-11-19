package QuizKampenVer3;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    static int gameState;

    static String playerName;

    Client(){


        try (Socket sock = new Socket("127.0.0.1", 22222);
             ObjectInputStream inObj = new ObjectInputStream(sock.getInputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()),true)
        ) {
            String temp;
            while (true){
                if ((temp = in.readLine()) != null){
                    System.out.println(temp);
                } else
            out.println("Venus");
            System.out.println("Connected");
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Client c = new Client();
    }
}
