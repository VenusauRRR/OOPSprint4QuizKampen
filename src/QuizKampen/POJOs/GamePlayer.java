package QuizKampen.POJOs;

import java.io.*;
import java.net.Socket;

public class GamePlayer extends Thread{
    String player;
    GamePlayer opponent;
    Socket playerSock;

    BufferedReader toServer;

    PrintWriter fromServer;

    public GamePlayer(Socket serverSocket, String player){
        this. playerSock = serverSocket;
        try {
            this.toServer = new BufferedReader(new InputStreamReader(this.playerSock.getInputStream()));
            this.fromServer = new PrintWriter(new OutputStreamWriter(this.playerSock.getOutputStream()),true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.player = player;
    }

    public void setOpponent(GamePlayer opponent){
        this.opponent = opponent;
    }

    public void run(){
        Thread sendMsgToOpponent = new Thread(() -> {

        while (true){
            this.opponent.fromServer.println(msgToServer());
        }
        });
    }

    public String msgToServer(){
        String temp;
        while (true){
            try {
                if ((temp = toServer.readLine()) != null){
                    System.out.println(temp);
                    return temp;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }




}
