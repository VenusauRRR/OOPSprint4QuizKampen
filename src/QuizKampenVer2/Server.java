package QuizKampenVer2;

import java.io.IOException;
import java.net.ServerSocket;


public class Server {
    int port = 22222;
    Server(){

        try (ServerSocket serverListener = new ServerSocket(port);
        ) {
            while (true){
                GampPlayerCoordinator game = new GampPlayerCoordinator();

            GamePlayer player1 = new GamePlayer(serverListener.accept(), game);
//            GamePlayer player2 = new GamePlayer(serverListener.accept(), game);
            player1.start();
//            player2.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Server s = new Server();
    }
}
