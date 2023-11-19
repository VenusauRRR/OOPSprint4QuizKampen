package QuizKampenVer3;

import java.io.*;
import java.net.Socket;

public class GamePlayer extends Thread{

    String playerName;
    ServerSideGame game;
    Socket sock;
    BufferedReader in;

    ObjectOutputStream outObj;
    PrintWriter out;

    public GamePlayer(Socket sock) {
        this.sock = sock;
        this.game = game;
        try {
            in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()),true);
            outObj = new ObjectOutputStream(sock.getOutputStream());
            out.println("hellow from server");
            outObj.writeObject(new Response());
            } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void run() {
        String temp;
        while (true) {
            try {
                if ((temp = in.readLine()) != null) {

                    playerName = temp;
                    System.out.println(playerName);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
