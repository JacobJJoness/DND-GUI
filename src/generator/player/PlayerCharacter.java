package generator.player;

import generator.FileHandler;
import generator.player.stats.Mental;
import generator.player.stats.Physical;

import java.util.*;

/**
 * The PlayerCharacter class creates a new player character object 
 * containing its first name, last name, class type, race type, and 
 * its stat attributes. Additionally, the player character object has 
 * overrided its equals method for character comparisons.
 * 
 * @author Ila Wallace 
 * @since November 20, 2022
 */
public class PlayerCharacter {
    private static final String[] STAT_LABELS = {"Int: ", " Dex: ", " Str: ", " Con: ", " Chr: ", " Wis: "}; //attribute labels

    private static final String FIRST_PATH = "files/firstnames.txt"; //path to text file containing first names
    private static final String LAST_PATH = "files/lastnames.txt"; //path to text file containing last names
    private static final String CLASS_PATH = "files/classes.txt"; //path to text file containing classes
    private static final String RACE_PATH = "files/races.txt"; //path to text file containing races
    private static final String RACE_INFO_PATH = "files/raceinfo.txt"; //path to text file containing race info
    private static final int MAX_SUM = 90; //max total sum of attributes
    private static final int MIN_SUM = 48; //min total sum of attributes

    private String firstName; //first name of character
    private String lastName; //last name of character
    private String classType; //class of character
    private String raceType; //race of character
    private String descType;//description of character race
    private int[] attributes; //attributes of character
    private int sum; //sum of attributes of character

    /**
     * Default Constructor for Player Character.
     */
    public PlayerCharacter() {
        this(FIRST_PATH, LAST_PATH, CLASS_PATH, RACE_PATH);
    }

    /**
     * Constructor for Player Character with a given first name.
     * 
     * @param first 
     */
    public PlayerCharacter(String first) {
        this(first, LAST_PATH, CLASS_PATH, RACE_PATH);
    }

    /**
     * Constructor for Player Character with a given first and last name.
     * 
     * @param first
     * @param last
     */
    public PlayerCharacter(String first, String last) {
        this(first, last, CLASS_PATH, RACE_PATH);
    }

    /**
     * Constructor for Player Character with a given first name, last name, 
     * and class.
     * 
     * @param first
     * @param last
     * @param classy
     */
    public PlayerCharacter(String first, String last, String classy) {
        this(first, last, classy, RACE_PATH);
    }

    /**
     * Constructor for Player Character with a given first name, last name, 
     * class, and race.
     * 
     * @param first
     * @param last
     * @param classy
     * @param race
     */
    public PlayerCharacter(String first, String last, String classy, String race) {
        attributes = new int[6];
        sum = 0;
        setFirstName(first);
        setLastName(last);
        setClassType(classy);
        setRaceType(race, RACE_INFO_PATH);
        generatePlayerAttributes();
    }

    /**
     * Constructor for Player Character with a given first name, last name, 
     * class, race, race description, and stat attributes.
     * 
     * @param first
     * @param last
     * @param classy
     * @param race
     * @param stats
     * @param desc
     */
    public PlayerCharacter(String first, String last, String classy, String race, int[] stats, String desc) {
        setFirstName(first);
        setLastName(last);
        setClassType(classy);
        setRaceType(race, desc);
        setPlayerAttributes(stats);
    }

    /**
     * Returns a player character's first name.
     * 
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets a player character's first name.
     * 
     * @param first
     */
    private void setFirstName(String first) {
        if(first.equals(FIRST_PATH)) {
            FileHandler fileHandler = new FileHandler();
            String [] fileList = fileHandler.readFile(first);
            Random num = new Random();
            firstName = fileList[num.nextInt(100)];
        } else {
            firstName = first;
        }
    }

    /**
     * Returns a player character's last name.
     * 
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets a player character's last name.
     * 
     * @param last
     */
    private void setLastName(String last) {
        if(last.equals(LAST_PATH)) {
            FileHandler fileHandler = new FileHandler();
            String [] fileList = fileHandler.readFile(last);
            Random num = new Random();
            lastName = fileList[num.nextInt(100)];
        } else {
            lastName = last;
        }
    }  

    /**
     * Returns a player character's first and last name 
     * in one String value separated by space.
     * 
     * @return player character's full name
     */
    public String getName() {
        return firstName + " " + lastName;
    }
    
    /**
     * Returns a player character's class type.
     * 
     * @return classType
     */
    public String getClassType() {
        return classType;
    }

    /**
     * Sets a player character's class type.
     * 
     * @param classy
     */
    private void setClassType(String classy) {
        if(classy.equals(CLASS_PATH)) {
            FileHandler fileHandler = new FileHandler();
            String [] fileList = fileHandler.readFile(classy);
            Random num = new Random();
            classType = fileList[num.nextInt(11)];
        } else {
            classType = classy;
        }
    }

    /**
     * Returns a player character's race type.
     * 
     * @return raceType
     */
    public String getRaceType() {
        return raceType;
    }

     /**
     * Returns a player character's race description.
     * 
     * @return descType
     */
    public String getDescType(){
        return descType;
    }

    /**
     * Sets a player character's race type.
     * 
     * @param race
     * @param desc
     */
    private void setRaceType(String race, String desc) {
        if(race.equals(RACE_PATH)) {
            FileHandler fileHandler = new FileHandler();
            String [] fileList = fileHandler.readFile(race);
            String [] descList = fileHandler.readFile(RACE_INFO_PATH);
            Random num = new Random();
            int randNum = num.nextInt(44);
            raceType = fileList[randNum];
            descType = descList[randNum];
            
        } else {
            raceType = race;
            descType = desc;
        }
    }

    /**
     * Sets a player character's physical attributes.
     */
    private void setPhysicalAttributes() {
        Physical p = new Physical();
        int[] temp = p.getAttributes();
        int count = 1;
        for(int x: temp) {
            attributes[count++] = x;
            sum += x;
        }
    }

    /**
     * Sets a player character's mental attributes.
     */
    private void setMentalAttributes() {
        Mental m = new Mental();
        int[] temp = m.getAttributes();
        int count = 0;
        for(int x: temp) {
            attributes[count++] = x;
            if(count == 1) {
                count = 4;
            }
            sum += x;
        }
    }

    /**
     * Sets a player character's player attributes.
     * 
     * @param stats
     */
    private void setPlayerAttributes(int[] stats) { 
        attributes = stats;
    }

    /**
     * Returns a player character's player attributes.
     * 
     * @return attributes
     */
    public int[] getAttributes() {
        return attributes;
    }

    /**
     * Generates a player character's player attributes.
     */
    private void generatePlayerAttributes() {
        while(sum < MIN_SUM || sum > MAX_SUM) {
            sum = 0;
            setMentalAttributes();
            setPhysicalAttributes();
        }
    }

    /**
     * Overrides the equals() method for comparing PlayerCharacter 
     * objects.
     * 
     * @override PlayerCharacter object equals method
     * @param o object to be compared to 
     * 
     * @return isEqual 
     */
    @Override
    public boolean equals(Object o) {
        Boolean isEqual = false;

        if(o == null) {
            return isEqual;
        }

        if( !(o instanceof PlayerCharacter)){
            return isEqual;
        }

        PlayerCharacter temp = (PlayerCharacter) o;
        if(this.firstName == temp.firstName && this.lastName == temp.lastName &&
           this.classType == temp.classType && this.raceType == temp.raceType &&
           this.attributes == temp.attributes) {
            isEqual = true;
        }

        return isEqual;
    }

    /**
     * Returns a PlayerCharacter's attributes separated 
     * with stat labels for easy identification.
     * 
     * @return Fancy String version of PlayerCharacter attributes
     */
    public String getDisplayAttributes() { 
        String temp = "";
        for(int i = 0; i < 6; i++) {
            temp += STAT_LABELS[i] + attributes[i] + "\n";
        }
        return temp;
    }

    /**
     * Returns a PlayerCharacter's attributes separated with spaces.
     * 
     * @return Normal String version of PlayerCharacter attributes
     */
    private String getStringAttributes() { 
        String temp = "";
        for(int i = 0; i < 6; i++) {
            temp += attributes[i] + " ";
        }
        return temp;
    }

    /**
     * Returns the display String of a single PlayerCharacter 
     * object without attributes.
     * 
     * @return Shortened String version of PlayerCharacter object
     */
    public String getChoiceString() {
        return String.format("%s %s %s", getName(), getClassType(), getRaceType());
    }

    /**
     * Returns the display String of a single PlayerCharacter object 
     * without the race description.
     * 
     * @return Shortened String version of PlayerCharacter object 
     */
    public String getDisplayString() {
        return String.format("Name: %s, Class: %s, Race: %s, Stats: %s", getName(), getClassType(), getRaceType(), getStringAttributes());
    }

    /**
     * Returns the display String of a single PlayerCharacter object 
     * for the random character generator.
     * 
     * @return String version of PlayerCharacter object 
     */
    public String getGeneratorString() {
        return String.format("Name: %s%nClass: %s%nRace: %s%n %s%s%n", getName(), getClassType(), getRaceType(), getDisplayAttributes(), getDescType());
    }

    /**
     * Overrides the toString() method for a PlayerCharacter 
     * object.
     * 
     * @return Full String version of a PlayerCharacter object
     */
    @Override
    public String toString() {
        return String.format("%s%n%s%n%s%n%s%n%s%n%s", getFirstName(), getLastName(), getClassType(), getRaceType(), getStringAttributes(), getDescType());
    }
}