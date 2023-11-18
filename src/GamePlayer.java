import java.io.*;
import java.net.Socket;

public class GamePlayer extends Thread{
    String player;
    String opponent;
    Socket playerSock;

    BufferedReader toServer;

    PrintWriter fromServer;

    GamePlayer(Socket serverSocket, String player){
        this. playerSock = serverSocket;
        try {
            this.toServer = new BufferedReader(new InputStreamReader(this.playerSock.getInputStream()));
            this.fromServer = new PrintWriter(new OutputStreamWriter(this.playerSock.getOutputStream()),true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.player = player;
    }

    public void setOpponent(String opponent){
        this.opponent = opponent;
    }

    public void play(){
        fromServer.println("hello");
    }




}
