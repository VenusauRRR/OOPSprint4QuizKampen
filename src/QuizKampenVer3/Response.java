package QuizKampenVer3;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Response extends JFrame implements Serializable {
    JPanel pane = new JPanel();

    Response(){

    }

    public void startNewGame(){
        setLayout(new BorderLayout());
        setSize(300,400);
        add(pane);
        pane.setBackground(Color.CYAN);

        setVisible(true);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
