import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.FlowLayout;

class Frame extends JFrame implements ActionListener{
    private character mainChara = new character();

    JButton generator;
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
        
        

        //content panels
        generatorPanel();
        characterImagePanel();
        informationPanel();
        


        
    }
    //will contain a button that is capable of generating a new character
    private void generatorPanel(){
        //panel structure and style
        JPanel genPanel = new JPanel();
        genPanel.setBackground(Color.blue);
        genPanel.setBounds(0,0,250,250);
        //Button for character generation
        generator = new JButton();
        generator.setText("Generate");//text inside button
        generator.addActionListener(this);//adding button action
        generator.setFocusable(false);//removing a default box around text
        genPanel.add(generator);//adding button to panel

        
        add(genPanel);
    }
    //may be used to give the user a Avatar for the character of sorts
    private void characterImagePanel(){
        JPanel charaPanel = new JPanel();
        charaPanel.setBackground(Color.red);
        charaPanel.setBounds(250,0,250,250);
        add(charaPanel);
    }
    //should display character information, stats,description,etc
    private void informationPanel(){
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.green);
        infoPanel.setBounds(0,250,250,250);
        
        setStatLabels(infoPanel);//adding generated stats
        
       

        

        add(infoPanel);

    }
    private void setStatLabels(JPanel item){
         
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

        item.add(intStatDisp);
        item.add(dexStatDisp);
        item.add(conStatDisp);
        item.add(chrStatDisp);
        item.add(strStatDisp);
        item.add(wisStatDisp);
    }
        
    



  
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==generator){
            System.out.println("poo");
        }
        
    }
}


public class GUI{
    public static void main(String[] args){
        Frame frame = new Frame();
    }
}
