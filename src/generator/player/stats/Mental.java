package generator.player.stats;

/**
 * The Mental class creates a new Mental object that contains 
 * the mental player stat attributes intelligence, wisdom, and 
 * charisma. Additionally, the Mental class is a child class 
 * that extends the abstract class Attribute. As such, the Mental 
 * class also utilizes the interface Number's methods implemented 
 * in the Attribute  class. 
 * 
 * @author Ila Wallace 
 * @since November 20, 2022
 */
public class Mental extends Attribute {
    
    private int[] mentalAttributes; //integer array containing a PlayerCharacter's physical stat attributes
    private int intelligence; //PlayerCharacter's intelligence attribute value
    private int wisdom; //PlayerCharacter's wisdom attribute value
    private int charisma; //PlayerCharacter's charisma attribute value

    /**
     * Default Constructor for Mental stat attributes.
     */
    public Mental() {
        mentalAttributes = new int[3];
        setIntelligence();
        setWisdom();
        setCharisma();
        setAttributes();
    }

    /**
     * Constructor for Mental stat attributes with a 
     * given PlayerChaacter's intelligence, wisdom, 
     * and charisma.
     * 
     * @param intel
     * @param wisdo
     * @param chari
     */
    public Mental(int intel, int wisdo, int chari) {
        intelligence = intel;
        wisdom = wisdo;
        charisma = chari;
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
     * Returns a PlayerCharacter's intelligence mental stat attribute.
     * 
     * @return intelligence
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Sets a PlayerCharacter's intelligence mental stat attribute 
     * to a randomly generated integer value.
     */
    private void setIntelligence() {
        intelligence = randomNumber();
    }

    /**
     * Returns a PlayerCharacter's wisdom mental stat attribute.
     * 
     * @return wisdom
     */
    public int getWisdom() {
        return wisdom;
    }

    /**
     * Sets a PlayerCharacter's wisdom physical stat attribute 
     * to a randomly generated integer value.
     */
    private void setWisdom() {
        wisdom = randomNumber();
    }

    /**
     * Returns a PlayerCharacter's charisma mental stat attribute.
     * 
     * @return charisma
     */
    public int getCharisma() {
        return charisma;
    }

    /**
     * Sets a PlayerCharacter's charisma mental stat attribute 
     * to a randomly generated integer value.
     */
    private void setCharisma() {
        charisma = randomNumber();
    }

    /**
     * Sets a PlayerCharacter's mental stat attributes
     * to randomly generated integer values.
     */
    public void setAttributes() {
        mentalAttributes[0] = getIntelligence(); // adds intelligence to attributes array
        mentalAttributes[1] = getCharisma(); // adds charisma to attributes array
        mentalAttributes[2] = getWisdom(); // adds wisdom to attributes array
    }

    /**
     * Returns a PlayerCharacter's mental stat attributes 
     * as an integer array.
     * 
     * @return mentalAttributes
     */
    public int[] getAttributes() {
        return mentalAttributes;
    }
}