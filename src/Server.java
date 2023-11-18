import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    String ip = "127.0.0.1";
    int port = 22222;
    Server(){
        try (ServerSocket serverListener = new ServerSocket(port);
        ) {
            while (true){

            GamePlayer player1 = new GamePlayer(serverListener.accept(),"One");
            player1.play();
//            GamePlayer player2 = new GamePlayer(serverListener.accept(),"Two");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Server s = new Server();
    }
}
