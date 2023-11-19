package QuizKampenVer2;

import java.io.*;
import java.net.Socket;

public class GamePlayer extends Thread{
    GampPlayerCoordinator game;
    String player;
    GamePlayer opponent;
    Socket sock;

    BufferedReader toServer;

    PrintWriter fromServer;

    public GamePlayer(String player){
        this.player = player;
    }

    public GamePlayer(Socket serverSocket, GampPlayerCoordinator game){
        this.game = game;
        this. sock = serverSocket;
        try {
            this.toServer = new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
            this.fromServer = new PrintWriter(new OutputStreamWriter(this.sock.getOutputStream()),true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.player = player;
    }

    public void setOpponent(GamePlayer opponent){
        this.opponent = opponent;
    }

    public String getPlayer() {
        return player;
    }

    public void run(){
//        Thread sendMsgToOpponent = new Thread(() -> {
//
//        while (true){
//            this.opponent.fromServer.println(msgToServer());
//        }
//        });
    }
//
//    public String msgToServer(){
//        String temp;
//        while (true){
//            try {
//                if ((temp = toServer.readLine()) != null){
//                    System.out.println(temp);
//                    return temp;
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }




}
