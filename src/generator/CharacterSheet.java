package generator;

import generator.player.PlayerCharacter;

import java.util.ArrayList;

/**
 * The CharacterSheet class creates a new CharacterSheet object 
 * that creates an ArrayList containing a list of PlayerCharacters 
 * and their respective object information. Additionally, the 
 * CharacterSheet object can take an existing CharacterSheet and 
 * write its list's contents to an output text file as well as 
 * import an existing list from a desginated input text file.
 * 
 * @author Ila Wallace 
 * @since November 20, 2022
 */
public class CharacterSheet {
    private static final int MAX_SIZE = 20; //CONSTANT - MAX NUMBER OF PLAYERCHARACTERS 
    private static final int MAX_ITEMS = 120; //CONSTANT - MAX NUMBER OF ITEMS

    private ArrayList <PlayerCharacter> characterList; //list of PlayerCharacter objects
    private String[] displayList; //string list of PlayerCharacter objects
    private int fileSize; //size of file list
    private int location; //current location in file list

    /**
     * Default Constructor for CharacterSheet.
     */
    public CharacterSheet() {
        characterList = new ArrayList<PlayerCharacter>();
        displayList = new String[MAX_ITEMS];
        clearDisplayList();
    }

    /**
     * Clears the Arraylist of PlayerCharacter objects and then 
     * fills the String array displayList with all empty Strings.
     */
    public void clearDisplayList() {
        characterList.clear();
        fileSize = 0;
        location = 0;
        fillEmptyList();
    }

    /**
     * Fills the entire String array displayList with all empty 
     * String values.
     */
    private void fillEmptyList() {
        String temp = "";
        for(int i = 0; i < MAX_ITEMS; i++) {
            displayList[i] = temp;
        }
    }

    /**
     * Updates the displayList array to reflect a new addition 
     * to the characterList.
     * 
     * @param pc
     */
    public void updateDisplayList(PlayerCharacter pc) {
        if(!characterList.isEmpty()) {
           convertToList(pc);
        } else {
            clearDisplayList();
        }
    }


    /**
     * Adds a new PlayerCharacter to the CharacterSheet through 
     * the characterList and displayList. Then, returns a message 
     * as a String about the resulting outcome of the method.
     * 
     * @param pc
     * 
     * @return Character was succesfully added to the list.
     * @return Character is already in the list.
     * @return Max number of characters reached. Please remove an existing character or create a new list.
     */
    public String addPlayerCharacter(PlayerCharacter pc) {
        if(characterList.size() < MAX_SIZE + 1) {
            if(!characterList.contains(pc)) {
                characterList.add(pc);
                fileSize++;
                convertToList(pc);
                return "Character was succesfully added to the list.";
            }
            return "Character is already in the list.";
        }
        return "Max number of characters reached. Please remove an existing character or create a new list.";
    }

    /**
     * Removes a PlayerCharacter from the CharacterSheet through 
     * the characterList and displayList. Then, returns a message 
     * as a String about the resulting outcome of the method.
     * 
     * @param pc
     * 
     * @return Character was successfully removed from the list.
     * @return Character was not found in the list.
     * @return Cannot remove Character from an empty list.
     */
    public String removePlayerCharacter(PlayerCharacter pc) {
        if(!characterList.isEmpty()) {
            if(characterList.contains(pc)) {
                int pos = searchCharacterList(pc);
                displayList[pos] = "";
                characterList.remove(pc);
                return "Character was successfully removed from the list.";
            }
            return "Character was not found in the list.";
        } 
        return "Cannot remove Character from an empty list.";
    }


    /**
     * Searches the characterList for a specific PlayerCharacter 
     * and then returns its position in the ArrayList.
     * 
     * @param pc
     * 
     * @return position of PlayerCharacter in characterList
     */
    public int searchCharacterList(PlayerCharacter pc) {
        return characterList.indexOf(pc);
    }

    /**
     * Converts a PlayerCharacter in the characterList 
     * into the displayList as a String array.
     * 
     * @param pc
     */
    private void convertToList(PlayerCharacter pc) {
        String temp = "";
        for(int x: pc.getAttributes()){
            temp += x + " ";
        }

        displayList[location++] = pc.getFirstName();
        displayList[location++] = pc.getLastName();
        displayList[location++] = pc.getClassType();
        displayList[location++] = pc.getRaceType();
        displayList[location++] = temp;
        displayList[location++] = pc.getDescType();
    }

    /**
     * Returns the displayList, which is a String array of 
     * PlayerCharacters that can be found in the characterList.
     * 
     * @return displayList
     */
    public String[] getDisplayList() {
        return displayList;
    }

    /**
     * Exports the characterList into an output text 
     * file designed by the String path.
     * 
     * @param path
     */
    public void exportCharacterList() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.writeFile(getDisplayList());
    }

    /**
     * Imports PlayerCharacters from an input text file, 
     * desingated by the String path, to be added to the 
     * characterList.
     * 
     * @param path
     */
    public void importCharacterList(String path) {
        FileHandler fileHandler = new FileHandler();
        String[] list = fileHandler.readFile(path);
        convertToPlayers(list, fileHandler.getFileSize());
    }

    /**
     * Converts the list String array full of PlayerCharacter 
     * data into PlayerCharacter objects. Then, the PlayerCharacter 
     * objects are added to the characterList and the displayList.
     * 
     * @param list
     * @param fileSize
     */
    private void convertToPlayers(String[] list, int fileSize) {
        if(fileSize % 6 != 0) 
            System.out.println("File is not formatted correctly.");
        else {
            for(int i = 0; i < fileSize * 6; i+=1) {
                String fname = list[i++];
                String lname = list[i++];
                String pclas = list[i++];
                String prace = list[i++];
                int[] stats = convertToIntegerArray(list[i++]);
                String desc = list[i];

                PlayerCharacter pc = new PlayerCharacter(lname, pclas, pclas, prace, stats, desc);
                String output = addPlayerCharacter(pc);
            }
        }
    }

    /**
     * Converts the String elements into the integer array temp.
     * 
     * @param elements
     * 
     * @return temp
     */
    private int[] convertToIntegerArray(String elements) {
        int[] temp = new int[6];
        String[] s = elements.split(" ");
        for(int i = 0; i < 6; i++) {
            temp[i] = Integer.parseInt(s[i]);
        }

        return temp;
    }
}