package QuizKampen.Server;

import QuizKampen.POJOs.GamePlayer;

import java.io.*;
import java.net.ServerSocket;


public class Server {
    int port = 22222;
    Server(){

        try (ServerSocket serverListener = new ServerSocket(port);
        ) {
            while (true){

            GamePlayer player1 = new GamePlayer(serverListener.accept(),"One");
            GamePlayer player2 = new GamePlayer(serverListener.accept(),"Two");
            player1.start();
            player2.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Server s = new Server();
    }
}
