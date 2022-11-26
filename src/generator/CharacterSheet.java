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

    private ArrayList <PlayerCharacter> characterList; //list of PlayerCharacter objects
    private String[] displayList; //string list of PlayerCharacter objects

    /**
     * Default Constructor for CharacterSheet.
     */
    public CharacterSheet() {
        characterList = new ArrayList<PlayerCharacter>();
    }

    public void clearList() {
        characterList.clear();
        updateDisplayList();
    }

    private void updateDisplayList() {
        displayList = new String[characterList.size()];

        for(int i = 0; i < characterList.size(); i++) {
            displayList[i] = characterList.get(i).toString();
        }
    }

    public void addPlayerCharacter(PlayerCharacter pc) {
        if(!characterList.contains(pc)) {
            characterList.add(pc);
            updateDisplayList();
        } else {
            System.out.println("Error! Cannot add duplicate characters to the list");
        }
    }

    public void removePlayerCharacter(PlayerCharacter pc) {
        if(characterList.contains(pc)) {
            characterList.remove(pc);
            updateDisplayList();
        } else {
            System.out.println("Error! Cannot remove ungenerated characters from the list");
        }
        
    }

    /**
     * Returns the displayList, which is a String array of 
     * PlayerCharacters that can be found in the characterList.
     * 
     * @return displayList
     */
    public String[] getDisplayList() {
        updateDisplayList();
        return displayList;
    }

    /**
     * Returns the displayList, which is a String array of 
     * PlayerCharacters that can be found in the characterList.
     * 
     * @return displayList
     */
    public ArrayList<PlayerCharacter> getCharacterList() {
        return characterList;
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
        int size = fileHandler.getFileSize();

        if(size == 0) {
            System.out.println("Import failed! Your input file is empty");
        } else if(size > MAX_SIZE * 6) {
            System.out.println("Import failed! Your input file is too large");
        } else {
            convertToPlayers(list, size);
        }
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
        try {
            for(int i = 0; i < fileSize; i+=6) {
                String f = list[i];
                String l = list[i+1];
                String c = list[i+2];
                String r = list[i+3];
                int [] s = convertToIntegerArray(list[i+4]);
                String d = list[i+5];

                PlayerCharacter pc = new PlayerCharacter(f, l, c, r, s, d);
                addPlayerCharacter(pc);
            }
        } catch(IllegalArgumentException e) {
            System.out.println("Error! Unexpected character information recieved");
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