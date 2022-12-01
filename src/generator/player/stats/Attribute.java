package generator.player.stats;

import java.util.Random;

/**
 * The Attribute abstract class creates a new Attribute 
 * object that is implemented in its child classes Mental 
 * and Physcial, both representing the mental based attributes 
 * and physical based attributes respectively. Additionally, 
 * the Attribute abstract class implements the interface 
 * Number in order to generate a random number for assigning 
 * PlayerCharacter stat attributes.
 * 
 * @author Ila Wallace 
 * @since November 20, 2022
 */
public abstract class Attribute implements Number {
    
    private int random; //random integer value
    public abstract int[] getAttributes(); //abstract method getAttributes to be implemented in child classes
    public abstract void setAttributes(); //abstract method setAttributes to be implemented in child classes

    /**
     * Generates and sets a random integer value to random.
     */
    public void generateRandomNumber() {
        Random rand = new Random(); //new random object
        int upperLimit = 19; //initializing a upperlimit value
        int lowerLimit = 6;
        random = rand.nextInt(upperLimit - lowerLimit) + lowerLimit;
    }

    /**
     * Returns random, which is a randomly generated 
     * integer value using the method generateRandomNumber.
     * 
     * @return random
     */
    public int getRandom() {
        return random; 
    }
}