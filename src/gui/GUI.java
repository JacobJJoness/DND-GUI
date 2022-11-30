package gui;

import generator.*;
import generator.player.PlayerCharacter;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import javax.swing.border.TitledBorder;

//import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
//import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
//import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
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
        try{
            MusicAdder test = new MusicAdder();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("failed");

        }
        
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
    JButton remove; //
    JButton clear; //
    JButton help; //
    JButton about;
    

    //initializing panels
    JPanel charaPanel;
    JPanel genPanel;
    JPanel infoPanel;
    JPanel disPanel;
    JPanel helPanel;
    JPanel outputPanel;

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

    //initializing list of PlayerCharacters
    JList pcList; //PlayerCharacter list
    JScrollPane pcPane;
    DefaultListModel pcModel; 
    JLabel pcSheet;

    //initializing console display
    JList conList;
    JScrollPane conPane;
    DefaultListModel conModel;
    JLabel conSheet;

    /**
     * Default Constructor for Frame object.
     */
    Frame() {
        //adjusts frame to screensize
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenHeight = 7 * screenSize.height / 12;
        int screenWidth = 3 * screenSize.width / 4;
        
        setTitle("\"Dungeons & Dragons\" Random Character Generator"); //sets application title
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //controls how exit works, also HIDE_ON_CLOSE and NOTHING_ON_CLOSE
        setResizable(true); //will lock the frame from being resized
        setLayout(null); //sets layout to null
        setSize(screenWidth, screenHeight); //sets x and y dimension
        setVisible(true); //makes the frame visible
        getContentPane().setBackground(new Color(20,20,20));
        
        setLayout(new FlowLayout()); //sets layout to new default FlowLayout

        //code for setting our own Icon Style
        ImageIcon logoImage = new ImageIcon("images/updatedLogo.png");
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
        displayPanel(background);
        helPanel(background);
        outputPanel(background);
        
        pack();
    }


    private void outputPanel(JLabel item) {
        outputPanel = new JPanel();
        outputPanel.setBounds(0, 0, 500, 50);
        outputPanel.setPreferredSize(new Dimension(600, 100));

        //title border
        TitledBorder listBorder = BorderFactory.createTitledBorder("Notifications");
        listBorder.setTitleColor(Color.WHITE);
        listBorder.setTitleJustification(TitledBorder.CENTER);
        outputPanel.setBorder(listBorder);

        //add console sheet to panel
        setConsoleSheet(outputPanel);

        //list model initialization 
        conModel = new DefaultListModel();
        ArrayList<String> tempConList = new ArrayList<String>();

        //add greeting to console list
        conModel.addElement("Welcome to the \"Dungeons & Dragons\" Random Character Generator!");

        //initialization of list
        conList = new JList(conModel);
        conList.setVisibleRowCount(1);
        conList.setFixedCellHeight(30);
        conList.setFixedCellWidth(500);
        conList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //initialization of scroll list
        conPane = new JScrollPane(conList);
        outputPanel.add(conPane);

        //button for clearing console list
        clear = new JButton();
        clear.setText("Clear User Log");
        clear.addActionListener(this);
        clear.setFocusable(false);
        outputPanel.add(clear);
        
        outputPanel.setBackground(panelColor);//A value determines transparency
        item.add(new AlphaContainer(outputPanel));
    }
    /**
     * Creates the help panel, which allows 
     * a user to select the help button.
     * 
     * @param item
     */
    private void helPanel(JLabel item) {
        helPanel = new JPanel();
        helPanel.setBounds(0,250,290,50);
        helPanel.setPreferredSize(new Dimension(300,100));

        

        //title border
        TitledBorder listBorder = BorderFactory.createTitledBorder("Help and Information");
        listBorder.setTitleColor(Color.WHITE);
        listBorder.setTitleJustification(TitledBorder.CENTER);
        helPanel.setBorder(listBorder);

        //button for about information
        about = new JButton();
        about.setText("About");
        about.addActionListener(this);
        about.setFocusable(false);
        helPanel.add(about);

        //button for help information
        help = new JButton();
        help.setText("How to Use");
        help.addActionListener(this);
        help.setFocusable(false);
        helPanel.add(help);

        helPanel.setBackground(panelColor); //A value determines transparency
        item.add(new AlphaContainer(helPanel));
    }

    ////
    private void displayPanel(JLabel item) {
        //panel structure and style
        disPanel = new JPanel();

        //size and bounds of display panel
        disPanel.setBounds(0, 0, 500, 300);
        disPanel.setPreferredSize(new Dimension(600, 400));

        //title border
        TitledBorder listBorder = BorderFactory.createTitledBorder("List of Saved Characters");
        listBorder.setTitleColor(Color.WHITE);
        listBorder.setTitleJustification(TitledBorder.CENTER);
        disPanel.setBorder(listBorder);
        
        //add character sheet to panel
        setCharacterSheet(disPanel);

        //list model initialization 
        pcModel = new DefaultListModel();
        ArrayList<PlayerCharacter> tempDisList = characterList.getCharacterList();

        //add to model list
        for(int i = 0; i < tempDisList.size(); i++) {
            pcModel.addElement(tempDisList.get(i).getDisplayString());
        }

        //initialization of list
        pcList = new JList(pcModel);
        pcList.setVisibleRowCount(10);
        pcList.setFixedCellHeight(30);
        pcList.setFixedCellWidth(500);
        pcList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //initialization of scroll list
        pcPane = new JScrollPane(pcList);
        disPanel.add(pcPane);

        //button for removing character
        remove = new JButton();
        remove.setText("Remove Character from List");
        remove.addActionListener(this);
        remove.setFocusable(false);
        disPanel.add(remove);

        //button for exporting character sheet
        export = new JButton();
        export.setText("Export List to Downloads");//text inside button
        export.addActionListener(this);//adding button action
        export.setFocusable(false);//removing a default box around text
        disPanel.add(export);//adding button to panel

        //code to wrap panel to make it partially transparent
        disPanel.setBackground(panelColor);//A value determines transparency
        item.add(new AlphaContainer(disPanel));
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
        genPanel.setBounds(0,0,290,350);
        genPanel.setPreferredSize(new Dimension(300,400));

        TitledBorder generatorBorder = BorderFactory.createTitledBorder("Character Generator");
        generatorBorder.setTitleColor(Color.WHITE);
        generatorBorder.setTitleJustification(TitledBorder.CENTER);
        genPanel.setBorder(generatorBorder);

        characterImagePanel(genPanel);
        informationPanel(genPanel);

        //Button for character generation
        generator = new JButton();
        generator.setText("Generate New");//text inside button
        generator.addActionListener(this);//adding button action
        generator.setFocusable(false);//removing a default box around text
        genPanel.add(generator);//adding button to panel

        //button for saving character
        save = new JButton(); 
        save.setText("Save to List");
        save.addActionListener(this);
        save.setFocusable(false);
        genPanel.add(save);

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
    private void characterImagePanel(JPanel item) {
        //Created a new character information panel
        charaPanel = new JPanel();
        charaPanel.setBounds(0,0,200,250);
        charaPanel.setPreferredSize(new Dimension(250,160));//setting to a preference size, this is due to the fact that Jpanels will automatically just fill around components
        charaPanel.setLayout(new BoxLayout(charaPanel, BoxLayout.Y_AXIS));

        //adding name
        setNameLabel(charaPanel);
        //adding class label
        setClassLabel(charaPanel);
        //adding race label
        setRaceLabel(charaPanel);
        //adding description label
        setDescLabel(charaPanel);

        charaPanel.setBackground(Color.WHITE);//A value determines transparency
        item.add(charaPanel);
    }

    /**
     * Displays the currently generated character's
     * stat information for the user to view.
     * 
     * @param item
     */
    
    private void informationPanel(JPanel item) {
        //panel setup
        infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        
        infoPanel.setBounds(0,220,100,100);
        infoPanel.setPreferredSize(new Dimension(250,140));//setting to a preference size, this is due to the fact that Jpanels will automatically just fill around components
        //Header for panel
        JLabel statHeader = new JLabel();
        statHeader.setText("Character Stats:");
        statHeader.setFont(new Font("New Peninim MT",Font.BOLD,20));

        infoPanel.add(statHeader); //adding statistic labels
        setStatLabels(infoPanel); //adding generated stats

        //code to wrap panel to make it partially transparent
        infoPanel.setBackground(Color.WHITE);//A value determines transparency
        item.add(infoPanel);
    }
    
    /**
     * Sets the race label.
     * 
     * @param item
     */
    private void setRaceLabel(JPanel item) {
        race = new JLabel();
        race.setText("Race: "+ randomCharacter.getRaceType());
        race.setFont(new Font("New Peninim MT",Font.PLAIN,14));
        item.add(race);
    }

    /**
     * Sets the race description label.
     * 
     * @param item
     */
    private void setDescLabel(JPanel item) {
        desc = new JLabel();
        String temp = "<html>" + randomCharacter.getDescType() + "</html>";
        desc.setText(temp);
        desc.setFont(new Font("New Peninim MT",Font.ITALIC,14));
        item.add(desc);
    }

    /**
     * Sets the class label.
     * 
     * @param item
     */
    private void setClassLabel(JPanel item) {
        classType = new JLabel();
        classType.setVerticalAlignment(JLabel.CENTER);
        classType.setText("Class: " + randomCharacter.getClassType() );
        classType.setFont(new Font("New Peninim MT",Font.PLAIN,14));
        item.add(classType);
    }

    /**
     * Sets the name label.
     * 
     * @param item
     */
    private void setNameLabel(JPanel item) {
        name = new JLabel();
        name.setText( randomCharacter.getName() );
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setFont(new Font("New Peninim MT",Font.BOLD,20));
        item.add(name);
    }

    /**
     * Sets the stats label.
     * 
     * @param item
     */
    private void setStatLabels(JPanel item) {
        //storing then accessing stats
        int[] stats = randomCharacter.getAttributes(); //grabbing character stats

        strStatDisp = new JLabel();
        strStatDisp.setText("Strength: " + stats[0]);
        strStatDisp.setFont(new Font("New Peninim MT",Font.PLAIN,12));

        dexStatDisp = new JLabel();
        dexStatDisp.setText("Dexterity: " + stats[1]);
        dexStatDisp.setFont(new Font("New Peninim MT",Font.PLAIN,12));

        conStatDisp = new JLabel();
        conStatDisp.setText("Constitution: " + stats[2]);
        conStatDisp.setFont(new Font("New Peninim MT",Font.PLAIN,12));

        intStatDisp = new JLabel();
        intStatDisp.setText("Intelligence: " + stats[3]);//setting character stat to display generated stats
        intStatDisp.setFont(new Font("New Peninim MT",Font.PLAIN,12));

        wisStatDisp = new JLabel();
        wisStatDisp.setText("Wisdom: " + stats[4]);
        wisStatDisp.setFont(new Font("New Peninim MT",Font.PLAIN,12));

        chrStatDisp = new JLabel();
        chrStatDisp.setText("Charisma: " + stats[5]);
        chrStatDisp.setFont(new Font("New Peninim MT",Font.PLAIN,12));

    
        //adding all items
        item.add(strStatDisp);
        item.add(dexStatDisp);
        item.add(conStatDisp);
        item.add(intStatDisp);
        item.add(wisStatDisp);
        item.add(chrStatDisp);
    }

    private void setCharacterSheet(JPanel item) {
         pcSheet = new JLabel();

         pcSheet.setHorizontalAlignment(SwingConstants.LEFT);
         pcSheet.setFont(new Font("New Peninim MT",Font.ITALIC,20));

         item.add(pcSheet);
    }

    private void setConsoleSheet(JPanel item) {
        conSheet = new JLabel();

        conSheet.setHorizontalAlignment(SwingConstants.CENTER);
        conSheet.setFont(new Font("New Peninim MT",Font.ITALIC,20));

        item.add(conSheet);
   }

    /**
     * Updates the stats label.
     */
    private void updateStatLabels() {
        //accessing stat labels and updating when generate is used
        int[] stats = randomCharacter.getAttributes(); 

        //setting character stat to display generated stats
        strStatDisp.setText("Strength: " + stats[0]);
        dexStatDisp.setText("Dexterity: " + stats[1]);
        conStatDisp.setText("Constitution: " + stats[2]);
        intStatDisp.setText("Intelligence: " + stats[3]);
        wisStatDisp.setText("Wisdom: " + stats[4]);
        chrStatDisp.setText("Charisma: " + stats[5]);
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
    private void updateClassLabel() {
        classType.setText("Class: " + randomCharacter.getClassType());
    }

    /**
     * Updates the race label.
     */
    private void updateRaceLabel() {
        race.setText("Race: "+ randomCharacter.getRaceType());
    }

    /**
     * Updates the race description label.
     */
    private void updateDescriptionLabel() {
        String temp = "<html>" + randomCharacter.getDescType() + "</html>";
        desc.setText(temp);
    }

    private void helpPopUpDialogBox() {

    }

    private void aboutPopUpDialogBox() {

    }

   
    /**
     * Perfoms actions based on which button 
     * the user selected using their mouse.
     * 
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        conModel.clear();

        //generates a new character
        if(e.getSource() == generator) {
            randomCharacter = new PlayerCharacter();
            updateStatLabels();
            updateNameLabel();
            updateClassLabel();
            updateRaceLabel();
            updateDescriptionLabel();
            conModel.addElement("Success! A new character was created.");
        }

        //saves a character to the character sheet
        if(e.getSource() == save) {
            if(characterList.addPlayerCharacter(randomCharacter)) {
                pcModel.addElement(randomCharacter.getDisplayString());
                conModel.addElement("Success! Character added to your list.");
            } else if(characterList.containsPlayerCharacter(randomCharacter)) {
                conModel.addElement("Error! Character is already in your list.");
            } else {
                conModel.addElement("Error! Your list contains the max number of characters. Please remove one.");
            }
        }

        //saves a character to the character sheet
        if(e.getSource() == remove) {
            int[] pos = pcList.getSelectedIndices();
            
            for(int i = (pos.length-1); i >=0; i--) {
                if(characterList.removePlayerCharacter(characterList.getPlayerCharacter(pos[i]))) {
                    pcModel.remove(pos[i]);
                    conModel.addElement("Success! Character(s) removed from your list.");
                } else {
                    conModel.addElement("Error! Cannot remove characters from an empty list.");
                }
            }
        }

        //exports the character sheet to an output text file
        if(e.getSource() == export) {
            FileHandler outputter = new FileHandler();
            if(outputter.writeFile(characterList.getDisplayList())) {
                conModel.addElement("Success! The list of characters was added to your 'Downloads' folder.");
            } else {
                conModel.addElement("Error! The list of characters was not added to your 'Downloads' folder.");
            }
        } 

        if(e.getSource() == clear) {
            conModel.clear();
        }

        if(e.getSource() == about) {
            aboutPopUpDialogBox();
        }

        if(e.getSource() == help) {
            helpPopUpDialogBox();
        }

        //ensures the console scrollable list stays at the bottom
        if(conModel.size() > 0) {
           conList.ensureIndexIsVisible(conModel.indexOf(conModel.lastElement()));
        }

        //ensures the character sheet scrollable list stays at the bottom
        if(pcModel.size() > 0) {
            pcList.ensureIndexIsVisible(pcModel.indexOf(pcModel.lastElement()));
        }
        
    }
}