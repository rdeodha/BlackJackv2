package blackjackUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BlackJack {

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new MainFrame("BlackJack");
                frame.setSize(640, 480);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setVisible(true);
            }
            
        });

        
    }
}
