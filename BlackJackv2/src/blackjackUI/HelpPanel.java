package blackjackUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class HelpPanel extends JPanel{
    
    private static final long serialVersionUID = 1L;
    
    public HelpPanel() {
        super();
    }
    
    @Override
    public void paintComponent(Graphics g) {      
        super.paintComponent(g);
        setBackground(new Color(0, 89, 33));
        BufferedImage i = null;
        try {
            i = ImageIO.read(new File("images/handvalues.png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        g.drawImage(i, 0, 0, null);
        
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        g.setColor(new Color(255, 255, 255));
        g.drawString("Get as close to 21 as possible.", 3, 320);
        g.drawString("If you go over 21 (bust), you lose.", 3, 335);
        g.drawString("Aces are value 11 or 1, to your benefit", 3, 350);
        g.drawString("Hit: Get another card from the deck", 3, 365);
        g.drawString("Stay: End your turn", 3, 380);
        
        
        
        
    }
        
     

}
