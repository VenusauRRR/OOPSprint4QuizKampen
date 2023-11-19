package QuizKampenVer3;

import java.io.IOException;
import java.net.ServerSocket;


public class Server {
    int port = 22222;
    Server(){

        try (ServerSocket serverListener = new ServerSocket(port);
        ) {
            while (true){

                ServerSideGame game = new ServerSideGame();

                GamePlayer player1 = new GamePlayer(serverListener.accept());
                player1.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Server s = new Server();
    }
}
