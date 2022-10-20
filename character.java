import java.util.*;
import java.util.Random;



class character {

    //Hashtable dictionary data structure
    Hashtable<String, String> statsDict = new Hashtable<String, String>();
    //different character variables defined here
    private String name;
    private String race;
    private String classType;
    private String description;

    //randomized character constructor current a W.I.P
    character(){
        this.name="Ragnar";//needs random generation
        this.description="The mighty character " + this.name+ " has the following stats ";//needs random generation
        this.race = "human";//needs random generation
        this.classType = "Paladin";//needs random generation
        //inserting elements into the dictionary
        statsDict.put("INT",statGenerator());
        statsDict.put("DEX",statGenerator());
        statsDict.put("STR",statGenerator());
        statsDict.put("CON",statGenerator());
        statsDict.put("CHR",statGenerator());
        statsDict.put("WIS",statGenerator());
    }


    // statGenerator
    //This function takes no paramaters
    //but instead returns a randomly
    //generated string value to be used as a stat
    private String statGenerator(){
        Random rand = new Random();//new random object
        int upperLimit = 20;//initializing a upperlimit value
        int generatedStat = rand.nextInt(upperLimit);
        String stringStat = String.valueOf(generatedStat);
        return stringStat;

    }
    // GETTERS and SETTERS below

    public String getName(){
        return this.name;
    }
    public String getDesc(){
        return this.description;
    }
    public String getClassType(){
        return this.classType;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public void setDesc(String newDesc){
        this.description = newDesc;
    }
    public Hashtable<String, String> getStats(){
        return this.statsDict;
    }
    public void setClass(String newClass){
        this.name = newClass;
    }
   
    public String getRace(){
        return this.race;
    }
    public void setRace(String newRace){
        this.race = newRace;
    }
}