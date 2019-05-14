package blackjackUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MenuGrid extends JPanel{
    
    private static final long serialVersionUID = 1L;

    public MenuGrid() {
        
    }
    
    @Override
    public void paintComponent(Graphics g) {      
        super.paintComponent(g);
        setBackground(new Color(255, 255, 255));
        
        BufferedImage i = null;
        try {
            i = ImageIO.read(new File("images/deck.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        g.drawImage(i, 0, 0, null);
        
    }
}
