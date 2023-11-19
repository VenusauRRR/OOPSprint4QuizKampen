package QuizKampen.Client;

import QuizKampen.POJOs.ClientProtocol;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client extends JFrame {
        static String msgFromServer;

    ClientProtocol cp = new ClientProtocol();

    JPanel startPage = new JPanel();
    JButton startGameBtn = new JButton("Start new game");

    public void showRandomPlayerPage(){
        JPanel newP = new JPanel(new BorderLayout());
        setContentPane(newP);
        setTitle("Find Player");
        JButton randomPlayerBtn = new JButton("Random Player");
        newP.add(randomPlayerBtn,BorderLayout.NORTH);
        randomPlayerBtn.addActionListener(e -> {
            showPlayPage();
        });

        setVisible(true);
    }

    public void showPlayPage(){
        JPanel newP = new JPanel(new BorderLayout());
        setContentPane(newP);
        setTitle("Entry To Game");
        JButton randomPlayerBtn = new JButton("Play");
        newP.add(randomPlayerBtn,BorderLayout.NORTH);
        randomPlayerBtn.addActionListener(e -> {
            showQuestionPage();
        });

        setVisible(true);
    }

    public void showQuestionPage(){


        JPanel newP = new JPanel(new BorderLayout());
        JTextArea tArea = new JTextArea(30,30);
        JTextField tField = new JTextField(30);
        setContentPane(newP);
        setTitle("Question Page");
        JButton contBtn = new JButton("Continue");
        newP.add(contBtn,BorderLayout.NORTH);
        newP.add(tArea,BorderLayout.CENTER);
        newP.add(tField,BorderLayout.SOUTH);
        contBtn.addActionListener(e -> {
        });

        setVisible(true);
        Thread recMsg = new Thread();

        Thread connection = new Thread(() -> {

        try (Socket client = new Socket("127.0.0.1", 22222);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()),true)) {
            while ((msgFromServer = in.readLine()) != null){
                out.println(tField.getText());
            tField.setText("");
            tArea.setText(msgFromServer);
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        });
        connection.start();

    }

    Client(){
        setLayout(new BorderLayout());
        setSize(300,400);
        setTitle("New Game");
        add(startPage,BorderLayout.CENTER);
        startPage.add(startGameBtn);
        startGameBtn.addActionListener(e -> {
            showRandomPlayerPage();
        });

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Client c = new Client();

    }
}
