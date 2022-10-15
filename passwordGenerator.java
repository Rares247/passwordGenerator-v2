import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class passwordGenerator implements ActionListener {

    //the label that will display the password
    JTextField passwd = new JTextField("Click the Button");
    
    //class constructor that creates the GUI
    public passwordGenerator() {

        //create GUI elements
        JFrame frame = new JFrame("Password Generator");
        JButton button = new JButton("Generate Password");
        button.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        passwd.setMaximumSize(new Dimension(100,30));
        

        //add them to the interface
        frame.add(panel);
        panel.add(Box.createRigidArea(new Dimension(5,40)));
        panel.add(passwd);
        panel.add(Box.createRigidArea(new Dimension(5,5)));
        panel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwd.setAlignmentX(Component.CENTER_ALIGNMENT);
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(300,200);
        frame.setLocation((int)(size.getWidth()/2) - 100, (int)(size.getHeight()/2) - 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    //function that tells the button what to do
    public void actionPerformed(ActionEvent e){
        String s = new String(password());
        passwd.setText(s);
    }

    //function that generates the password
    public char[] password() {

        //arrays for the selection
        int[] ar1 = new int[]{'0','1','2','3','4','5','6','7','8','9'};
        char[] ar2 = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] ar3 = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] ar4 = new char[]{'!','"','#','$','%','&','*','+','-','/',':',';','<','=','>','?','@','[',']','^','_','{','}','|'};
        char[] pass = new char[10];

        //random number
        Random random = new Random();

        //for each digit of the password, it is randomly decided which array to select a digit from
        for(int i=0; i<10; i++) {
            int r = random.nextInt(4);
            int r2 = random.nextInt(26);
            int r4 = random.nextInt(24);
            int r1 = random.nextInt(10);
            
            if(r == 0){
                pass[i] = (char) ar1[r1];      
            }
            
            if(r == 1){
                pass[i] = ar2[r2];
            }
            
            if(r == 2){
                pass[i] = ar3[r2];  
            }
            
            if(r == 3){
                pass[i] = ar4[r4];
            } 
        }
        return pass;
    }

    public static void main(String args[]) {
        new passwordGenerator();
    }  
}

