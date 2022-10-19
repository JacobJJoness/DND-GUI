import java.util.*;
import java.util.Random;

class character {

    //Hashtable dictionary data structure
    Hashtable<String, String> statsDict = new Hashtable<String, String>();
    private String name;
    private String description;

    //randomized character constructor current a W.I.P
    character(){
        this.name="Ragnar";
        this.description="Empty";

        //inserting elements into the dictionary
        statsDict.put("INT","20");
        statsDict.put("DEX","20");
        statsDict.put("STR","20");
        statsDict.put("CON","20");
        statsDict.put("CHR","20");
        statsDict.put("WIS","20");
    }

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
    public void setName(String newName){
        this.name = newName;
    }
    public void setDesc(String newDesc){
        this.description = newDesc;
    }
}