package QuizKampenVer2;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Locale;

public class Client extends JFrame {
        static String msgFromServer;


    Client(){
        setLayout(new BorderLayout());
        setSize(300,400);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        try (Socket sock = new Socket("127.0.0.1", 22222);
            ObjectInputStream in = new ObjectInputStream(sock.getInputStream());
            PrintWriter out = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()),true)
            ) {
            Client c = new Client();
            QuizProtocol quizP = new QuizProtocol(c,in,out);
            quizP.start();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
