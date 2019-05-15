package blackjackUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelpFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    
    public HelpFrame(String title) {
        super(title);        
        setLayout(new BorderLayout());
         
        JButton ok = new JButton("Ok");
        JPanel button = new JPanel();
        button.add(ok);
        
        Container c = getContentPane();
        c.add(button, BorderLayout.SOUTH);
        
        HelpPanel hp = new HelpPanel();
        c.add(hp);
        
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                
            }
            
        });
    }
}
