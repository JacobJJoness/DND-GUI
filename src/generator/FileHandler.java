package generator;

import java.util.*;
import java.io.*;

/**
 * The FileHandler class creates a new FileHandler object 
 * that reads input text files containing PlayerCharacter 
 * information. Additionally, the FileHandler object can 
 * take an existing CharacterSheet and write its list's 
 * contents to an output text file. The FileHandler object 
 * can also read default input text files that can be used 
 * for randomly generated PlayerCharacter information.
 * 
 * @author Ila Wallace 
 * @since November 20, 2022
 */
public class FileHandler {
    private static final int MAX_ITEMS = 120; //CONSTANT - MAX NUMBER OF ITEMS
    private int fileSize = 0; //file size of a text file

    /**
     * Returns the file size of the most recently processed text file.
     * 
     * @return fileSize
     */
    public int getFileSize(){
        return fileSize;
    }

    /**
     * Reads an input text file's contents and then 
     * returns the values as the String array items.
     * 
     * @param path the path to the input text file
     * 
     * @exception FileNotFoundException input text file was not found
     * 
     * @return items 
     */
    public String[] readFile(String path) {
        String [] items = new String[MAX_ITEMS];
        fileSize = 0;

        try {
            Scanner input = new Scanner(new File(path));
            while(input.hasNext()) {
                items[fileSize++] = input.nextLine();
            }
            input.close();
        } catch(FileNotFoundException e) {
            System.out.println("Error! " + path + " was not found");
        }

        if(fileSize == 0) {
            System.out.println("Error! The input file is empty");
            items = null;
        }
        return items;
    }

    /**
     * Writes the values in the items String array 
     * into a target output text file located in a 
     * user's 'Downloads' directory.
     * 
     * @param items
     * 
     * @exception IOException unable to write items into target output text file
     * 
     * @return true if writes to file successfully
     * @return false if failed
     */
    public boolean writeFile(String[] items) {
        String path = "Downloads";
        try {
            String home = System.getProperty("user.home");
            File f = new File(new File(home, "Downloads"), "output.txt");
            path = f.getPath();
            FileWriter writer = new FileWriter(path);
            for(int i = 0; i < items.length; i++) {
                writer.write(items[i] + "\n");
            }
            writer.close();
            return true;
        } catch(IOException e) {
            System.out.println("Error! " + path + " was not found");
        }
        return false;
    }
}