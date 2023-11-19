package QuizKampenVer2;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class QuizProtocol extends Thread{
    Client f;
    ObjectInputStream fromServer;
    PrintWriter toServer;
    int gameState;
    String playerName;

QuizProtocol(Client player, ObjectInputStream fromServer, PrintWriter toServer){
        this.fromServer = fromServer;
        this.toServer = toServer;
        this.f = player;
        this.gameState = 0;
    }

    @Override
    public void run(){
    }

    public void startNewGame(){
        JPanel startPage = new JPanel(new GridLayout(3,1));
        f.setTitle("Welcome to QuizKampen");
        JLabel askNameLabel = new JLabel("Enter your name");
        JTextField askName = new JTextField();
        JButton startGameBtn = new JButton("Start new game");

        f.add(startPage,BorderLayout.CENTER);
        startPage.add(askNameLabel);
        startPage.add(askName);
        startPage.add(startGameBtn);
        f.setVisible(true);


        startGameBtn.addActionListener(e -> {
            playerName = askName.getText();
//            showPlayPage();
            gameState = 1;
        });
    }

    public void showPlayPage(){
        JPanel newP = new JPanel(new BorderLayout());
        f.setContentPane(newP);
        f.setTitle(playerName + ": Entry To Game");
        JButton randomPlayerBtn = new JButton("Play");
        newP.add(randomPlayerBtn,BorderLayout.NORTH);
        randomPlayerBtn.addActionListener(e -> {
//            showRandomPlayerPage();
            gameState = 2;
        });


        f.setVisible(true);
    }

    public void showRandomPlayerPage(){
        JPanel newP = new JPanel(new BorderLayout());
        f.setContentPane(newP);
        f.setTitle(playerName + ": Find Player");
        JButton randomPlayerBtn = new JButton("Random Player");
        newP.add(randomPlayerBtn,BorderLayout.NORTH);
        randomPlayerBtn.addActionListener(e -> {
            gameState = 3;
//            showQuestionPage();
        });

        f.setVisible(true);
    }
    public void showQuestionPage(){
        JPanel newP = new JPanel(new BorderLayout());
        f.setContentPane(newP);
        f.setTitle(playerName + ": Question Page");
        JButton contBtn = new JButton("Continue");
        newP.add(contBtn,BorderLayout.NORTH);
        contBtn.addActionListener(e -> {


        });

        f.setVisible(true);
    }

    public void showScorePage(){

    }

}
