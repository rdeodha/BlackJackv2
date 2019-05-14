package blackjackUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import player.Player;

public class cardPanelGrid extends JPanel {
    private ArrayList<BufferedImage> userCards;
    private ArrayList<BufferedImage> dealerCards;   
    private Player dealer;
    private Player user;
    
    private static final long serialVersionUID = 1L;
    
    public cardPanelGrid(Player dealer, Player user) {
        userCards = new ArrayList<BufferedImage>(11);
        dealerCards = new ArrayList<BufferedImage>(11);
        this.dealer = dealer;
        this.user = user;
    }
    
    @Override
    public void paintComponent(Graphics g) {      
        super.paintComponent(g);
        
        if (user.busted()) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.setColor(new Color(255, 255, 255));
            g.drawString("Busted!", 530, 70);
        }
        
        if (dealer.busted()) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.setColor(new Color(255, 255, 255));
            g.drawString("Busted!", 530, 370);
        }
        
        String userTot = "Total: " + user.getTotal();
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.setColor(new Color(255, 255, 255));
        g.drawString(userTot, 500, 155);
        
        String dealerTot = "Total: " + dealer.getTotal();
        g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        g.setColor(new Color(255, 255, 255));
        g.drawString(dealerTot, 500, 280);
        
        
        for (int i = 0; i < 6; i++) {
            g.setColor(Color.BLACK);
            g.drawRect(110 + (i * 70), 20, 50, 75);
        }
        
        for (int i = 0; i < 5; i++) {
            g.setColor(Color.BLACK);
            g.drawRect(147 + (i * 70), 110, 50, 75);
        }
        
        g.setColor(Color.BLACK);
        g.drawLine(0, 210, 640, 210);
        
        for (int i = 0; i < 5; i++) {
            g.setColor(Color.BLACK);
            g.drawRect(147 + (i * 70), 230, 50, 75);
        }
        
        for (int i = 0; i < 6; i++) {
            g.setColor(Color.BLACK);
            g.drawRect(110 + (i * 70), 320, 50, 75);
        }

        for (int i = 0; i < userCards.size(); i++) {
            
            if (i < 6) {
                g.drawImage(userCards.get(i), 111 + (70 * i), 21, null);
            } else if (i > 5 && i < 12) {
                g.drawImage(userCards.get(i), 148 + (70 * (i - 6)), 111, null);
            } else {
                throw new IllegalArgumentException();
            }
        }
        
        for (int i = 0; i < dealerCards.size(); i++) {
            
            if (i < 6) {
                g.drawImage(dealerCards.get(i), 148 + (70 * i), 231, null);
            } else if (i > 5 && i < 12) {
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
    
    public void revealDealer(BufferedImage i) {
        dealerCards.remove(0);
        dealerCards.add(0, i);
        repaint();
    }
    
    public void reset() {
        userCards.clear();
        dealerCards.clear();
        repaint();
    }

}
