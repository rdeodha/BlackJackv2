package blackjackUI;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BlackJack {

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MenuFrame("BlackJack Menu");
                frame.setSize(300, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }
            
        });

        
    }
}
