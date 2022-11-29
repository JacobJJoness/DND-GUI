package gui;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.util.*;


/**
 *The MusicAdder class adds the background music to wherever it is 
 * Instantiated. As long as the program continues to run it will
 * play music
 * @author Jacob Jones 
 * @since November 28, 2022
 */
public class MusicAdder {
    

    MusicAdder() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {


        File soundFile = new File("music/soundtrack.wav");
        AudioInputStream soundStream = AudioSystem.getAudioInputStream(soundFile);
        Clip fullClip = AudioSystem.getClip();
  
        fullClip.open(soundStream);
        fullClip.start();
        fullClip.loop(Clip.LOOP_CONTINUOUSLY);
        
        
    
       
    }
}


class TestMusic{
    public static void main(String[] args) 
    {
        try
        {
            MusicAdder music = new MusicAdder();
            System.out.println("success");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("failed");

        }
    }
}
