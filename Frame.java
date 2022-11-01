import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

class Frame extends JFrame{
    Frame(){
        
        setTitle("DND Chracter Generator");   //sets title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// controls how exit works, also HIDE_ON_CLOSE and NOTHING_ON_CLOSE
        //frame.setResizeable(false); //will lock the frame from being resized
        setSize(600,800);     //sets x and y dimension
        setVisible(true);     //makes the frame visible

        setLayout(new FlowLayout());

        //code for setting our own Icon Style
        ImageIcon logoImage = new ImageIcon("public/logo.png");
        setIconImage(logoImage.getImage());
        getContentPane().setBackground(new Color(140,140,140));   //change color of background
        
        //ADDING LABELS TO DISPLAY
        setStatLabel();


        
    }
    //creates labels and sets them to their corresponding values
    private void setStatLabel(){
        JLabel intStatDisp = new JLabel();
        intStatDisp.setText("20");

        JLabel dexStatDisp = new JLabel();
        dexStatDisp.setText("20");

        JLabel conStatDisp = new JLabel();
        conStatDisp.setText("20");

        JLabel chrStatDisp = new JLabel();
        chrStatDisp.setText("20");

        JLabel strStatDisp = new JLabel();
        strStatDisp.setText("20");

        JLabel wisStatDisp = new JLabel();
        wisStatDisp.setText("20");

        add(intStatDisp);
        add(dexStatDisp);
        add(conStatDisp);
        add(chrStatDisp);
        add(strStatDisp);
        add(wisStatDisp);

    }
}


public class App{
    public static void main(String[] args){
        Frame frame = new Frame();
    }
}