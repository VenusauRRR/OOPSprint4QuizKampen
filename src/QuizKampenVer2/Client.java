package QuizKampenVer2;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends JFrame {
        static String msgFromServer;
    JPanel startPage = new JPanel();
    JButton startGameBtn = new JButton("Start new game");

    Client(){
        setLayout(new BorderLayout());
        setSize(300,400);
        add(startPage,BorderLayout.CENTER);
        startPage.add(startGameBtn);

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        Client c = new Client();
        QuizProtocol quizP = new QuizProtocol(c);
        quizP.start();
    }
}
