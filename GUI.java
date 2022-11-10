import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.FlowLayout;


class Frame extends JFrame implements ActionListener{
    private character mainChara = new character();

    //initializing buttons
    JButton generator;

    //initializing panels
    JPanel charaPanel;
    JPanel genPanel;
    JPanel infoPanel;


    //initializing labels
    JLabel intStatDisp;
    JLabel dexStatDisp;
    JLabel conStatDisp;
    JLabel chrStatDisp;
    JLabel strStatDisp;
    JLabel wisStatDisp;

    Frame(){
        
        setTitle("DND Chracter Generator");   //sets title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// controls how exit works, also HIDE_ON_CLOSE and NOTHING_ON_CLOSE
        setResizable(false); //will lock the frame from being resized
        setLayout(null);
        setSize(1920,1080);     //sets x and y dimension
        setVisible(true);     //makes the frame visible

        setLayout(new FlowLayout());

        //code for setting our own Icon Style--NOT YET COMPLETE
        ImageIcon logoImage = new ImageIcon("public/logo.png");
        setIconImage(logoImage.getImage());

        //adjust color of the window--can take rgb or hexadecimal
        // getContentPane().setBackground(new Color(220,220,220));   //change color of background

        // background picture
        //To layer over background we must do background.add
        ImageIcon backImg = new ImageIcon("public/background.jpg");
        JLabel background = new JLabel("",backImg,JLabel.CENTER);
        background.setBounds(0,0,1920,1080);
        background.setLayout(new FlowLayout());
        
        add(background);

        
        

        //content panels
        generatorPanel(background);
        characterImagePanel(background);
        informationPanel(background);
        

        pack();
        
    }
    //will contain a button that is capable of generating a new character
    private void generatorPanel(JLabel item){
        //panel structure and style
        genPanel = new JPanel();
        
        
        genPanel.setBounds(0,0,250,250);
        genPanel.setPreferredSize(new Dimension(300,300));

        //Button for character generation
        generator = new JButton();
        generator.setText("Generate");//text inside button
        generator.addActionListener(this);//adding button action
        generator.setFocusable(false);//removing a default box around text
        genPanel.add(generator);//adding button to panel


        //code to wrap panel to make it partially transparent
        genPanel.setBackground(new Color(100,100,100,150));//A value determines transparency
        item.add(new AlphaContainer(genPanel));
        
    }


    //may be used to give the user a Avatar for the character of sorts
    private void characterImagePanel(JLabel item){
        charaPanel = new JPanel();

        charaPanel.setBounds(250,0,250,250);
        charaPanel.setPreferredSize(new Dimension(250,250));//setting to a preference size, this is due to the fact that Jpanels will automatically just fill around components
        //code to wrap panel to make it partially transparent
        charaPanel.setBackground(new Color(100,100,100,150));//A value determines transparency
        item.add(new AlphaContainer(charaPanel));
    }


    //should display character information, stats,description,etc
    private void informationPanel(JLabel item){
        infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout());
        
        infoPanel.setBounds(0,250,500,250);
        infoPanel.setPreferredSize(new Dimension(250,250));//setting to a preference size, this is due to the fact that Jpanels will automatically just fill around components
        
        //adding statistic labels
        setStatLabels(infoPanel);//adding generated stats

        //code to wrap panel to make it partially transparent
        infoPanel.setBackground(new Color(100,100,100,150));//A value determines transparency
        item.add(new AlphaContainer(infoPanel));

    }
    
    
    



    private void setStatLabels(JPanel item){
        
        //storing then accessing stats
        Hashtable<String, String> stats = mainChara.getStats(); //grabbing character stats

        intStatDisp = new JLabel();
        intStatDisp.setText("Int : " + stats.get("INT"));//setting character stat to display generated stats

        dexStatDisp = new JLabel();
        dexStatDisp.setText("Dex : " + stats.get("DEX"));

        conStatDisp = new JLabel();
        conStatDisp.setText("Str: " + stats.get("STR"));

        chrStatDisp = new JLabel();
        chrStatDisp.setText("CON: " + stats.get("CON"));

        strStatDisp = new JLabel();
        strStatDisp.setText("Chr: " + stats.get("CHR"));

        wisStatDisp = new JLabel();
        wisStatDisp.setText("Wis: " + stats.get("WIS"));

        //adding all items
        item.add(intStatDisp);
        item.add(dexStatDisp);
        item.add(conStatDisp);
        item.add(chrStatDisp);
        item.add(strStatDisp);
        item.add(wisStatDisp);
    }

    private void updateStatLabels(){
        //accessing stat labels and updating when generate is used
        Hashtable<String, String> stats = mainChara.getStats(); 
        intStatDisp.setText("Int : " + stats.get("INT"));//setting character stat to display generated stats
        
        dexStatDisp.setText("Dex : " + stats.get("DEX"));

        conStatDisp.setText("Str: " + stats.get("STR"));

        chrStatDisp.setText("CON: " + stats.get("CON"));

        strStatDisp.setText("Chr: " + stats.get("CHR"));

        wisStatDisp.setText("Wis: " + stats.get("WIS"));
    }
   
        
    
   


  
    @Override
    public void actionPerformed(ActionEvent e) {
        // If we use checks similar to  the one below we may use multiple buttons to do 
        //various tasks

        if(e.getSource()==generator){

            mainChara.newCharacter();
            updateStatLabels();
            
        }
        
    }
}


public class GUI{
    public static void main(String[] args){
        Frame frame = new Frame();
    }
}
