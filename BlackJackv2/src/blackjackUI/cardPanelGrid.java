package blackjackUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class cardPanelGrid extends JPanel {
    ArrayList<BufferedImage> userCards;
    ArrayList<BufferedImage> dealerCards;
    boolean busted;
    
    private static final long serialVersionUID = 1L;
    
    public cardPanelGrid() {
        userCards = new ArrayList<BufferedImage>(11);
        dealerCards = new ArrayList<BufferedImage>(11);
        busted = false;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        for (int i = 0; i < 6; i++) {
            g.drawRect(110 + (i * 70), 20, 50, 75);
        }
        
        for (int i = 0; i < 5; i++) {
            g.drawRect(147 + (i * 70), 110, 50, 75);
        }
        
        g.drawLine(0, 210, 640, 210);
        
        for (int i = 0; i < 5; i++) {
            g.drawRect(147 + (i * 70), 230, 50, 75);
        }
        
        for (int i = 0; i < 6; i++) {
            g.drawRect(110 + (i * 70), 320, 50, 75);
        }

        for (int i = 0; i < userCards.size(); i++) {
            
            if (i < 6) {
                g.drawImage(userCards.get(i), 111 + (70 * i), 21, null);
            } else if (i > 5 && i < 11) {
                g.drawImage(userCards.get(i), 148 + (70 * (i - 6)), 111, null);
            } else {
                throw new IllegalArgumentException();
            }
        }
        
        for (int i = 0; i < dealerCards.size(); i++) {
            
            if (i < 6) {
                g.drawImage(dealerCards.get(i), 148 + (70 * i), 231, null);
            } else if (i > 5 && i < 11) {
                g.drawImage(dealerCards.get(i), 111 + (70 * (i - 6)), 321, null);
            } else {
                throw new IllegalArgumentException();
            }
        }
        
    }
    
    public void addUser(BufferedImage i) {      
        userCards.add(i);
        repaint();
    }
    
    public void addDealer(BufferedImage i) {       
        dealerCards.add(i);
        repaint();
    }
    
    public void reset() {
        userCards.clear();
        dealerCards.clear();
        busted = false;
        repaint();
    }

}
