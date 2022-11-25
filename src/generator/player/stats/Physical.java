package generator.player.stats;

/**
 * The Physical class creates a new Physical object that contains 
 * the physical player stat attributes strength, consitution, and 
 * dexterity. Additionally, the Physical class is a child class 
 * that extends the abstract class Attribute. As such, the Physical 
 * class also utilizes the interface Number's methods implemented 
 * in the Attribute  class. 
 * 
 * @author Ila Wallace 
 * @since November 20, 2022
 */
public class Physical extends Attribute {
    
    private int[] physicalAttributes; //integer array containing a PlayerCharacter's physical stat attributes
    private int strength; //PlayerCharacter's strength attribute value
    private int constitution; //PlayerCharacter's constitution attribute value
    private int dexterity; //PlayerCharacter's dexterity attribute value

    /**
     * Default Constructor for Physical stat attributes.
     */
    public Physical() {
        physicalAttributes = new int[3];
        setStrength();
        setConstitution();
        setDexterity();
        setAttributes();
    }

    /**
     * Constructor for Physical stat attributes with a 
     * given PlayerChaacter's strength, consitution, 
     * and dexterity.
     * 
     * @param str
     * @param con
     * @param dex
     */
    public Physical(int str, int con, int dex) {
        strength = str;
        constitution = con;
        dexterity = dex;
        setAttributes();
    }

    /**
     * Returns a random integer value generated from 
     * the generateRandomNumber method.
     * 
     * @return generated random number value
     */
    private int randomNumber() {
        generateRandomNumber();
        return getRandom();
    }

    /**
     * Returns a PlayerCharacter's strength physical stat attribute.
     * 
     * @return strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Sets a PlayerCharacter's strength physical stat attribute 
     * to a randomly generated integer value.
     */
    private void setStrength() {
        strength = randomNumber();
    }

    /**
     * Returns a PlayerCharacter's constitution physical stat attribute.
     * 
     * @return consitution
     */
    public int getConstitution() {
        return constitution;
    }

    /**
     * Sets a PlayerCharacter's consitution physical stat attribute 
     * to a randomly generated integer value.
     */
    private void setConstitution() {
        constitution = randomNumber();
    }

    /**
     * Returns a PlayerCharacter's dexterity physical stat attribute 
     * to a randomly generated integer value.
     * 
     * @return dexterity
     */
    public int getDexterity() {
        return dexterity;
    }

    /**
     * Sets a PlayerCharacter's dexterity physical stat attribute 
     * to a randomly generated integer value.
     */
    private void setDexterity() {
        dexterity = randomNumber();
    }

    /**
     * Sets a PlayerCharacter's physical stat attributes
     * to randomly generated integer values.
     */
    public void setAttributes() {
        physicalAttributes[0] = getDexterity(); //adds dexterity to attributes array
        physicalAttributes[1] = getStrength(); //adds strength to attributes array
        physicalAttributes[2] = getConstitution(); //adds constituion to attributes array
    }

    /**
     * Returns a PlayerCharacter's physical stat attributes 
     * as an integer array.
     * 
     * @return physicalAttributes
     */
    public int[] getAttributes() {
        return physicalAttributes;
    }
}