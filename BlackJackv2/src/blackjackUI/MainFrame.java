package blackjackUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ai.Normal;
import card.Card;
import player.Dealer;
import player.Player;
import player.User;

public class MainFrame extends JFrame {
   
    private static final long serialVersionUID = 1L;
    private Player user = new User("Rushi");
    private Player dealer = new Dealer(new Normal());
    private Random randCard = new Random();
    private LinkedList<Card> deck = new LinkedList<Card>();
    
    public MainFrame(String title) {
        super(title);
        setLayout(new BorderLayout());
        JButton hit = new JButton("Hit");
        hit.setPreferredSize(new Dimension(100, 20));
        JButton stay = new JButton("Stay");
        stay.setPreferredSize(new Dimension(100, 20));
        Container c = getContentPane();
        
        JPanel buttons = new JPanel();
        buttons.add(hit);
        buttons.add(stay);
        buttons.setBackground(new Color(30, 109, 62));
        c.add(buttons, BorderLayout.NORTH);    
        
        cardPanelGrid cardSpace = new cardPanelGrid();
        cardSpace.setBackground(new Color(30, 109, 62));
        c.add(cardSpace);
        
        
        generateDeck();
        
        for (int i = 0; i < 2; i++) {
            Card car = deck.remove(randCard.nextInt(deck.size()));
            String path;
            dealer.addCard(car);
            
            if (i == 0) {
                path = "images/back.png";
            } else {
                path = "images/" + Integer.toString(car.getName()) + Integer.toString(car.getSuit()) + ".png";
            }
            
            BufferedImage im = null;
            try {
                im = ImageIO.read(new File(path));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            cardSpace.addDealer(im);
            
            car = deck.remove(randCard.nextInt(deck.size()));
            user.addCard(car);
            
            path = "images/" + Integer.toString(car.getName()) + Integer.toString(car.getSuit()) + ".png";
            im = null;
            try {
                im = ImageIO.read(new File(path));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            cardSpace.addUser(im);
            
        }
        
        
        hit.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e) {
                Card car = deck.remove((randCard.nextInt(deck.size())));
                user.addCard(car);
                String path = "images/" + Integer.toString(car.getName()) + Integer.toString(car.getSuit()) + ".png";
                
                if (user.busted()) {
                    hit.setEnabled(false);
                }
                
                
                BufferedImage i = null;
                try {
                    i = ImageIO.read(new File(path));
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                cardSpace.addUser(i);
            }
            
        });
        
    }

    private void generateDeck() {
        for (int k = 1; k < 6; k++) {
            for (int i = 1; i < 5; i++) {
                for (int j = 1; j < 14; j++) {
                    deck.add(new Card(i, j));
                }
            }
            System.out.println("Deck number " + k + " loaded...");
        }
        
    }
    
}