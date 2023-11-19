package QuizKampenVer2;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class QuizProtocol extends Thread{
    Client f;
    int gameState;

    QuizProtocol(Client player){
        this.f = player;
        this.gameState = 0;
    }

    @Override
    public void run(){
        if (gameState == 0){
            showPlayPage();
        } else if (gameState == 1){
            showRandomPlayerPage();
        }
    }

    public void showPlayPage(){
        JPanel newP = new JPanel(new BorderLayout());
        f.setContentPane(newP);
        f.setTitle("Entry To Game");
        JButton randomPlayerBtn = new JButton("Play");
        newP.add(randomPlayerBtn,BorderLayout.NORTH);
        randomPlayerBtn.addActionListener(e -> {
            showRandomPlayerPage();
            gameState = 1;
        });

        f.setVisible(true);
    }

    public void showRandomPlayerPage(){
        JPanel newP = new JPanel(new BorderLayout());
        f.setContentPane(newP);
        f.setTitle("Find Player");
        JButton randomPlayerBtn = new JButton("Random Player");
        newP.add(randomPlayerBtn,BorderLayout.NORTH);
        randomPlayerBtn.addActionListener(e -> {
            gameState = 2;
        });

        f.setVisible(true);
    }

//
//    public void showQuestionPage(){
//
//
//        JPanel newP = new JPanel(new BorderLayout());
//        JTextArea tArea = new JTextArea(30,30);
//        JTextField tField = new JTextField(30);
//        f.setContentPane(newP);
//        f.setTitle("Question Page");
//        JButton contBtn = new JButton("Continue");
//        newP.add(contBtn,BorderLayout.NORTH);
//        newP.add(tArea,BorderLayout.CENTER);
//        newP.add(tField,BorderLayout.SOUTH);
//        contBtn.addActionListener(e -> {
//        });
//
//        f.setVisible(true);
//        Thread recMsg = new Thread();
//
//        Thread connection = new Thread(() -> {
//
//            try (Socket client = new Socket("127.0.0.1", 22222);
//                 BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
//                 PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()),true)) {
//                while ((msgFromServer = in.readLine()) != null){
//                    out.println(tField.getText());
//                    tField.setText("");
//                    tArea.setText(msgFromServer);
//                }
//
//            } catch (UnknownHostException e) {
//                throw new RuntimeException(e);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        connection.start();
//
//    }

}
