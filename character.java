import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Random;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;



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
        this.name=nameGenerator();//needs random generation
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

    //RANDOM GENERATORS BELOW


    // statGenerator
    //This function takes no paramaters
    //but instead returns a randomly
    //generated string value to be used as a stat
    private String statGenerator(){
        Random rand = new Random();//new random object
        int upperLimit = 18;//initializing a upperlimit value
        int lowerLimit = 6;
        int generatedStat = rand.nextInt(upperLimit);
        while(generatedStat<lowerLimit){
            generatedStat = rand.nextInt(upperLimit);
        }
        String stringStat = String.valueOf(generatedStat);
        return stringStat;

    }

    private String nameGenerator(){
        //grabbing and storing names into arrays
        String[] firstNameArray = grabber("static/name.txt");
        String[] lastNameArray = grabber("static/lastname.txt");
        //random generation
        int upperLimit = 100;
        Random rand = new Random();
        int generatedFirstPosition = rand.nextInt(upperLimit);
        int generatedLastPosition = rand.nextInt(upperLimit);
        // setting up string to return
        String name = firstNameArray[generatedFirstPosition] + " " + lastNameArray[generatedLastPosition];
        
        return name;
        
        
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

    public String[] grabber(String PATH){
        String[] items = new String[110];
        int i = 0; //iterator for while loop
        try {
            File myObj = new File(PATH);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              items[i]= myReader.nextLine();
              i++;
              

            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return items;
    }

    //NEEDED FUNCTIONS BELOW


    // Random Name Generator
    //this function will need to be able to randomly draw a first and last name
    //this can be done by storing a file with a long list of names and reading them
    //into an array, and then generating a random number to then "select" a name
    //the static folder is where we should store non-code files that do not change



    //Random Class Generator
    //similar to above

    //Random Race Generator
    //similar to above


    //newCharacter()
    //this function should completely generate a new character 
    //meaning we will simply call all of our generation methods and store them within the same character
    //this function has been started below
    public void newCharacter(){
        statsDict.put("INT",statGenerator());
        statsDict.put("DEX",statGenerator());
        statsDict.put("STR",statGenerator());
        statsDict.put("CON",statGenerator());
        statsDict.put("CHR",statGenerator());
        statsDict.put("WIS",statGenerator());
        this.name = nameGenerator();

    }

    
}