package QuizKampenVer3;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    static int gameState;

    static String playerName;

    Client(){

        Response rTemp = new Response();


        try (Socket sock = new Socket("127.0.0.1", 22222);
             ObjectInputStream inObj = new ObjectInputStream(sock.getInputStream());
//             BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()),true)
        ) {
//            String temp;
//            while (true){
//                if ((temp = in.readLine()) != null){
//                    System.out.println(temp);
//                } else
//            out.println("Venus");
//            System.out.println("Connected");
//            }
            Object temp;
            while ((temp = inObj.readObject()) != null){
                if (temp instanceof Response){
                    Response r = (Response) temp;
                    rTemp = r;
                    rTemp.startNewGame();
                }
            }

        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Client c = new Client();
//        Response r = new Response();
    }

//    public void printResponse(Response r){
//        System.out.println("i can print");
//    }
}
