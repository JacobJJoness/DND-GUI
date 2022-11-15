import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.FlowLayout;


class Frame extends JFrame implements ActionListener{
    private character mainChara = new character();

    //panel Color
    Color panelColor = new Color(150,150,150,150);
    //initializing buttons
    JButton generator;

    //initializing panels
    JPanel charaPanel;
    JPanel genPanel;
    JPanel infoPanel;


    //initializing labels
   
    JLabel intStatDisp; //stat
    JLabel dexStatDisp; //stat
    JLabel conStatDisp;//stat
    JLabel chrStatDisp;//stat
    JLabel strStatDisp;//stat
    JLabel wisStatDisp;//stat
    JLabel name;//character name
    JLabel classType; //character class
    JLabel race;//character race
    JLabel raceDesc;//character race description

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
        genPanel.setPreferredSize(new Dimension(300,400));

        //Button for character generation
        generator = new JButton();
        generator.setText("Generate");//text inside button
        generator.addActionListener(this);//adding button action
        generator.setFocusable(false);//removing a default box around text
        genPanel.add(generator);//adding button to panel


        //code to wrap panel to make it partially transparent
        genPanel.setBackground(panelColor);//A value determines transparency
        item.add(new AlphaContainer(genPanel));
        
    }


    //may be used to give the user a Avatar for the character of sorts
    private void characterImagePanel(JLabel item){
        charaPanel = new JPanel();
        charaPanel.setBounds(250,0,250,250);
        charaPanel.setPreferredSize(new Dimension(300,400));//setting to a preference size, this is due to the fact that Jpanels will automatically just fill around components
        charaPanel.setLayout(new BoxLayout(charaPanel, BoxLayout.Y_AXIS));
        //adding name
        setNameLabel(charaPanel);
        //adding class label
        setClassLabel(charaPanel);
        //adding race label
        setRaceLabel(charaPanel);
        //adding race description label
        setDescLabel(charaPanel);
        //code to wrap panel to make it partially transparent
        charaPanel.setBackground(panelColor);//A value determines transparency
        item.add(new AlphaContainer(charaPanel));
       
       
    }


    //should display character information, stats,description,etc
    private void informationPanel(JLabel item){
        //panel setup
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        
        infoPanel.setBounds(0,250,500,250);
        infoPanel.setPreferredSize(new Dimension(300,400));//setting to a preference size, this is due to the fact that Jpanels will automatically just fill around components
        //Header for panel
        JLabel statHeader = new JLabel();
        statHeader.setText("Character Stats");
        statHeader.setFont(new Font("New Peninim MT",Font.ITALIC,25));
        
        //ADDING LABELS++++++++++

        infoPanel.add(statHeader);
        //adding statistic labels
        setStatLabels(infoPanel);//adding generated stats
        //++++++++++++

        //code to wrap panel to make it partially transparent
        infoPanel.setBackground(panelColor);//A value determines transparency
        item.add(new AlphaContainer(infoPanel));

    }
    
    
    

    //label setters below
    private void setDescLabel(JPanel item){
        raceDesc = new JLabel();
        raceDesc.setFont(new Font("New Peninim MT",Font.ITALIC,20));
        raceDesc.setText(mainChara.getDesc(mainChara.getName()));
        item.add(raceDesc);
    }
    private void setRaceLabel(JPanel item){
        race = new JLabel();
        race.setText("Race"+ mainChara.getRace());
        race.setFont(new Font("New Peninim MT",Font.ITALIC,20));
        item.add(race);
    }
    private void setClassLabel(JPanel item){
        classType = new JLabel();
        classType.setVerticalAlignment(JLabel.CENTER);
        classType.setText("Class: " + mainChara.getClassType() );
        classType.setFont(new Font("New Peninim MT",Font.ITALIC,20));
        
        item.add(classType);

    }
    private void setNameLabel(JPanel item){
        name = new JLabel();
        name.setText( mainChara.getName() );
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setFont(new Font("New Peninim MT",Font.ITALIC,25));
       
        item.add(name);
        

    }

    private void setStatLabels(JPanel item){
        
        //storing then accessing stats
        Hashtable<String, String> stats = mainChara.getStats(); //grabbing character stats

        intStatDisp = new JLabel();
        intStatDisp.setText("Int : " + stats.get("INT"));//setting character stat to display generated stats
        intStatDisp.setFont(new Font("New Peninim MT",Font.ITALIC,20));

        dexStatDisp = new JLabel();
        dexStatDisp.setText("Dex : " + stats.get("DEX"));
        dexStatDisp.setFont(new Font("New Peninim MT",Font.ITALIC,20));

        conStatDisp = new JLabel();
        conStatDisp.setText("Str: " + stats.get("STR"));
        conStatDisp.setFont(new Font("New Peninim MT",Font.ITALIC,20));

        chrStatDisp = new JLabel();
        chrStatDisp.setText("CON: " + stats.get("CON"));
        chrStatDisp.setFont(new Font("New Peninim MT",Font.ITALIC,20));

        strStatDisp = new JLabel();
        strStatDisp.setText("Chr: " + stats.get("CHR"));
        strStatDisp.setFont(new Font("New Peninim MT",Font.ITALIC,20));

        wisStatDisp = new JLabel();
        wisStatDisp.setText("Wis: " + stats.get("WIS"));
        wisStatDisp.setFont(new Font("New Peninim MT",Font.ITALIC,20));

        //adding all items
        item.add(intStatDisp);
        item.add(dexStatDisp);
        item.add(conStatDisp);
        item.add(chrStatDisp);
        item.add(strStatDisp);
        item.add(wisStatDisp);
    }

    //UPDATER FUNCTIONS
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
    private void updateNameLabel(){
        name.setText(mainChara.getName());
    }
    private void updateClassLabel(){
        classType.setText("Class: " + mainChara.getClassType());
    }
    private void updateRaceLabel(){
        race.setText("Race: "+mainChara.getRace());
    }
    private void updateDescLabel(){
        raceDesc.setText(mainChara.getDesc(mainChara.getName()));
    }
   
        
    
   


  
    @Override
    public void actionPerformed(ActionEvent e) {
        // If we use checks similar to  the one below we may use multiple buttons to do 
        //various tasks

        if(e.getSource()==generator){

            mainChara.newCharacter();
            updateStatLabels();
            updateNameLabel();
            updateClassLabel();
            updateRaceLabel();
            updateDescLabel();
            
        }
        
    }
}


public class GUI{
    public static void main(String[] args){
        Frame frame = new Frame();
    }
}
