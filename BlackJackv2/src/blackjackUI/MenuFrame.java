package blackjackUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import ai.AI;
import ai.Hard;
import ai.Normal;

public class MenuFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    public MenuFrame(String title) {
        
        super(title);
        setLayout(new BorderLayout());
        JButton normal = new JButton("Normal");
        normal.setPreferredSize(new Dimension(100, 100));
        JButton hard = new JButton("Hard");
        hard.setPreferredSize(new Dimension(100, 100));  
        JButton help = new JButton("?");
        help.setPreferredSize(new Dimension(20, 20));
        Container c = getContentPane();
        
        JPanel buttons = new JPanel();
        buttons.setBackground(new Color(30, 109, 62));
        buttons.add(normal);
        buttons.add(hard);
        buttons.add(help);
        
        c.add(buttons, BorderLayout.NORTH);
        
        JTextField nameField = new JTextField();
        c.add(nameField, BorderLayout.SOUTH);
        
        MenuGrid men = new MenuGrid();
        c.add(men, BorderLayout.CENTER);
        
        help.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                helpFrame();              
            }
            
        });
        
        
        normal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                String name = nameField.getText();
                if (name.equals("")) {
                    name = "User";
                } else if (name.length() > 7) {
                    String newName = name.substring(0, 7);
                    newName = newName + "...";
                    name = newName;
                }
           
                startMain(new Normal(), name);
            }
        });
        
        hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                
                String name = nameField.getText();
                if (name.equals("")) {
                    name = "User";
                } else if (name.length() > 7) {
                    String newName = name.substring(0, 7);
                    newName = newName + "...";
                    name = newName;
                }
                
                startMain(new Hard(), name);
            }
        });
    }
    
    public void startMain(AI diff, String name) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new MainFrame("BlackJack", diff, name);
                frame.setSize(640, 480);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }
            
        });
    }
    
    public void helpFrame() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new HelpFrame("BlackJack Help");
                frame.setSize(500, 500);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }
            
        });
    }
}
