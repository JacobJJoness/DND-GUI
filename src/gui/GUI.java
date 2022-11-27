package gui;

import generator.*;
import generator.player.PlayerCharacter;

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
import java.awt.Toolkit;
import java.awt.Image;

/**
 * The GUI class intitlizes the Frame object to display 
 * the application's GUI.
 * 
 * @author Jacob Jones
 * @since November 14, 2022
 */
public class GUI {
    public static void main(String[] args) {
        Frame frame = new Frame();
    }
}

/**
 * The Frame class creates the frame of the GUI by 
 * extending the JFrame class and implementing 
 * ActionListener class.
 */
class Frame extends JFrame implements ActionListener {
    private PlayerCharacter randomCharacter = new PlayerCharacter(); //new random PlayerCharacter object
    private CharacterSheet characterList = new CharacterSheet(); //new character sheet object
    Color panelColor = new Color(150,150,150,150); //panel Color

    //initializing buttons
    JButton generator; 
    JButton save;
    JButton export;

    //initializing panels
    JPanel charaPanel;
    JPanel genPanel;
    JPanel infoPanel;

    //initializing labels
    JLabel intStatDisp; //stat
    JLabel dexStatDisp; //stat
    JLabel conStatDisp; //stat
    JLabel chrStatDisp; //stat
    JLabel strStatDisp; //stat
    JLabel wisStatDisp; //stat
    JLabel name; //character name
    JLabel classType; //character class
    JLabel race; //character race
    JLabel desc; //character description

    /**
     * Default Constructor for Frame object.
     */
    Frame() {
        //adjusts frame to screensize
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = 19 * screenSize.width / 20;
        
        setTitle("\"Dungeons & Dragons\" Random Character Generator"); //sets application title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //controls how exit works, also HIDE_ON_CLOSE and NOTHING_ON_CLOSE
        setResizable(true); //will lock the frame from being resized
        setLayout(null); //sets layout to null
        setSize(screenWidth, screenHeight); //sets x and y dimension
        setVisible(true); //makes the frame visible

        setLayout(new FlowLayout()); //sets layout to new default FlowLayout

        //code for setting our own Icon Style--NOT YET COMPLETE
        ImageIcon logoImage = new ImageIcon("images/logo.png");
        setIconImage(logoImage.getImage());

        // background picture
        ImageIcon backImg = new ImageIcon("images/background.jpg");
        ImageIcon scaleImage = new ImageIcon(backImg.getImage().getScaledInstance(screenWidth, screenHeight, Image.SCALE_DEFAULT));
        JLabel background = new JLabel("",scaleImage,JLabel.CENTER);
        background.setBounds(0,0,screenWidth,screenHeight);
        background.setLayout(new FlowLayout());
        
        add(background); //add background image

        //content panels
        generatorPanel(background);
        characterImagePanel(background);
        informationPanel(background);
        
        pack();
    }

    /**
     * Creates the generator panel, which allows 
     * a user to select an action e.
     * 
     * @param item
     */
    private void generatorPanel(JLabel item) {
        //panel structure and style
        genPanel = new JPanel();
        
        //size and bounds of generator panel
        genPanel.setBounds(0,0,250,250);
        genPanel.setPreferredSize(new Dimension(300,400));

        //Button for character generation
        generator = new JButton();
        generator.setText("Generate");//text inside button
        generator.addActionListener(this);//adding button action
        generator.setFocusable(false);//removing a default box around text
        genPanel.add(generator);//adding button to panel

        //button for saving character
        save = new JButton(); 
        save.setText("Save");
        save.addActionListener(this);
        save.setFocusable(false);
        genPanel.add(save);

        //button for exporting character sheet
        export = new JButton();
        export.setText("Export");//text inside button
        export.addActionListener(this);//adding button action
        export.setFocusable(false);//removing a default box around text
        genPanel.add(export);//adding button to panel

        //code to wrap panel to make it partially transparent
        genPanel.setBackground(panelColor);//A value determines transparency
        item.add(new AlphaContainer(genPanel));
    }

    /**
     * Displays the currently generated character and 
     * all of its related personal information for the 
     * user to view.
     * 
     * @param item
     */
    private void characterImagePanel(JLabel item) {
        //Created a new character information panel
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
        //adding description label
        setDescLabel(charaPanel);
        //code to wrap panel to make it partially transparent
        charaPanel.setBackground(panelColor);//A value determines transparency

        item.add(new AlphaContainer(charaPanel));
    }

    /**
     * Displays the currently generated character's
     * stat information for the user to view.
     * 
     * @param item
     */
    private void informationPanel(JLabel item) {
        //panel setup
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        
        infoPanel.setBounds(0,250,500,250);
        infoPanel.setPreferredSize(new Dimension(300,400));//setting to a preference size, this is due to the fact that Jpanels will automatically just fill around components
        //Header for panel
        JLabel statHeader = new JLabel();
        statHeader.setText("Character Stats");
        statHeader.setFont(new Font("New Peninim MT",Font.ITALIC,25));

        infoPanel.add(statHeader); //adding statistic labels
        setStatLabels(infoPanel); //adding generated stats

        //code to wrap panel to make it partially transparent
        infoPanel.setBackground(panelColor);//A value determines transparency
        item.add(new AlphaContainer(infoPanel));
    }
    
    /**
     * Sets the race label.
     * 
     * @param item
     */
    private void setRaceLabel(JPanel item){
        race = new JLabel();
        race.setText("Race: "+ randomCharacter.getRaceType());
        race.setFont(new Font("New Peninim MT",Font.ITALIC,20));
        item.add(race);
    }

    /**
     * Sets the race description label.
     * 
     * @param item
     */
    private void setDescLabel(JPanel item){
        desc = new JLabel();
        String temp = "<html>" + randomCharacter.getDescType() + "</html>";
        desc.setText(temp);
        desc.setFont(new Font("New Peninim MT",Font.ITALIC,18));
        item.add(desc);
    }

    /**
     * Sets the class label.
     * 
     * @param item
     */
    private void setClassLabel(JPanel item){
        classType = new JLabel();
        classType.setVerticalAlignment(JLabel.CENTER);
        classType.setText("Class: " + randomCharacter.getClassType() );
        classType.setFont(new Font("New Peninim MT",Font.ITALIC,20));
        item.add(classType);
    }

    /**
     * Sets the name label.
     * 
     * @param item
     */
    private void setNameLabel(JPanel item){
        name = new JLabel();
        name.setText( randomCharacter.getName() );
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setFont(new Font("New Peninim MT",Font.ITALIC,25));
        item.add(name);
    }

    /**
     * Sets the stats label.
     * 
     * @param item
     */
    private void setStatLabels(JPanel item){
        //storing then accessing stats
        int[] stats = randomCharacter.getAttributes(); //grabbing character stats

        intStatDisp = new JLabel();
        intStatDisp.setText("Int : " + stats[0]);//setting character stat to display generated stats
        intStatDisp.setFont(new Font("New Peninim MT",Font.ITALIC,20));

        dexStatDisp = new JLabel();
        dexStatDisp.setText("Dex : " + stats[1]);
        dexStatDisp.setFont(new Font("New Peninim MT",Font.ITALIC,20));

        conStatDisp = new JLabel();
        conStatDisp.setText("Str: " + stats[2]);
        conStatDisp.setFont(new Font("New Peninim MT",Font.ITALIC,20));

        chrStatDisp = new JLabel();
        chrStatDisp.setText("Con: " + stats[3]);
        chrStatDisp.setFont(new Font("New Peninim MT",Font.ITALIC,20));

        strStatDisp = new JLabel();
        strStatDisp.setText("Chr: " + stats[4]);
        strStatDisp.setFont(new Font("New Peninim MT",Font.ITALIC,20));

        wisStatDisp = new JLabel();
        wisStatDisp.setText("Wis: " + stats[5]);
        wisStatDisp.setFont(new Font("New Peninim MT",Font.ITALIC,20));

        //adding all items
        item.add(intStatDisp);
        item.add(dexStatDisp);
        item.add(conStatDisp);
        item.add(chrStatDisp);
        item.add(strStatDisp);
        item.add(wisStatDisp);
    }

    /**
     * Updates the stats label.
     */
    private void updateStatLabels(){
        //accessing stat labels and updating when generate is used
        int[] stats = randomCharacter.getAttributes(); 

        //setting character stat to display generated stats
        intStatDisp.setText("Int : " + stats[0]);
        dexStatDisp.setText("Dex : " + stats[1]);
        conStatDisp.setText("Str: " + stats[2]);
        chrStatDisp.setText("Con: " + stats[3]);
        strStatDisp.setText("Chr: " + stats[4]);
        wisStatDisp.setText("Wis: " + stats[5]);
    }

    /**
     * Updates the name label.
     */
    private void updateNameLabel() {
        name.setText(randomCharacter.getName());
    }

    /**
     * Updates the class label.
     */
    private void updateClassLabel(){
        classType.setText("Class: " + randomCharacter.getClassType());
    }

    /**
     * Updates the race label.
     */
    private void updateRaceLabel(){
        race.setText("Race: "+ randomCharacter.getRaceType());
    }

    /**
     * Updates the race description label.
     */
    private void updateDescriptionLabel() {
        String temp = "<html>" + randomCharacter.getDescType() + "</html>";
        desc.setText(temp);
    }
   
    /**
     * Perfoms actions based on which button 
     * the user selected using their mouse.
     * 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //generates a new character
        if(e.getSource() == generator){
            randomCharacter = new PlayerCharacter();
            updateStatLabels();
            updateNameLabel();
            updateClassLabel();
            updateRaceLabel();
            updateDescriptionLabel();
        }

        //saves a character to the character sheet
        if(e.getSource() == save){
            FileHandler outputter = new FileHandler();
            characterList.addPlayerCharacter(randomCharacter);
        }

        //exports the character sheet to an output text file
        if(e.getSource() == export) {
            FileHandler outputter = new FileHandler();
            outputter.writeFile(characterList.getDisplayList());
        }
    }
}