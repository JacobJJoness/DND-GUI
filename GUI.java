import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

class Frame extends JFrame{
    private character mainChara = new character();
    Frame(){
        
        setTitle("DND Chracter Generator");   //sets title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// controls how exit works, also HIDE_ON_CLOSE and NOTHING_ON_CLOSE
        //frame.setResizeable(false); //will lock the frame from being resized
        setSize(600,800);     //sets x and y dimension
        setVisible(true);     //makes the frame visible

        setLayout(new FlowLayout());

        //code for setting our own Icon Style--NOT YET COMPLETE
        ImageIcon logoImage = new ImageIcon("public/logo.png");
        setIconImage(logoImage.getImage());

        //adjust color of the window--can take rgb or hexadecimal
        getContentPane().setBackground(new Color(170,170,170));   //change color of background
        
        //ADDING LABELS TO DISPLAY
        setStatLabel();


        
    }
    //will contain a button that is capable of generating a new character
    private void generatorPanel(){
        return;
    }
    //may be used to give the user a Avatar for the character of sorts
    private void characterImagePanel(){
        return;
    }
    //should display character information, stats,description,etc
    private void informationPanel(){

    }



    //creates labels and sets them to their corresponding values
    private void setStatLabel(){
        
        Hashtable<String, String> stats = mainChara.getStats(); //grabbing character stats

        JLabel intStatDisp = new JLabel();
        intStatDisp.setText("Int : " + stats.get("INT"));//setting character stat to display generated stats

        JLabel dexStatDisp = new JLabel();
        dexStatDisp.setText("Dex : " + stats.get("DEX"));

        JLabel conStatDisp = new JLabel();
        conStatDisp.setText("Str: " + stats.get("STR"));

        JLabel chrStatDisp = new JLabel();
        chrStatDisp.setText("CON: " + stats.get("CON"));

        JLabel strStatDisp = new JLabel();
        strStatDisp.setText("Chr: " + stats.get("CHR"));

        JLabel wisStatDisp = new JLabel();
        wisStatDisp.setText("Wis: " + stats.get("WIS"));

        add(intStatDisp);
        add(dexStatDisp);
        add(conStatDisp);
        add(chrStatDisp);
        add(strStatDisp);
        add(wisStatDisp);

    }
}


public class GUI{
    public static void main(String[] args){
        Frame frame = new Frame();
    }
}
