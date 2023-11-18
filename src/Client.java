import javax.swing.*;
import java.awt.*;

public class Client extends JFrame {

    ClientProtocol cp = new ClientProtocol();

    JPanel startPage = new JPanel();
    JButton startGameBtn = new JButton("Start new game");

    public void showRandomPlayerPage(){
        JPanel newP = new JPanel(new BorderLayout());
        setContentPane(newP);
        setTitle("Find Player");
        JButton randomPlayerBtn = new JButton("Random Player");
        newP.add(randomPlayerBtn,BorderLayout.SOUTH);
        randomPlayerBtn.addActionListener(e -> {
            showPlayPage();
        });

        setVisible(true);
    }

    public void showPlayPage(){
        JPanel newP = new JPanel(new BorderLayout());
        setContentPane(newP);
        setTitle("Entry To Game");
        JButton randomPlayerBtn = new JButton("Play");
        newP.add(randomPlayerBtn,BorderLayout.NORTH);
        randomPlayerBtn.addActionListener(e -> {

        });

        setVisible(true);
    }

    Client(){
        setLayout(new BorderLayout());
        setSize(300,400);
        setTitle("New Game");
        add(startPage,BorderLayout.CENTER);
        startPage.add(startGameBtn);
        startGameBtn.addActionListener(e -> {
            showRandomPlayerPage();
        });

        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Client c = new Client();
    }
}
