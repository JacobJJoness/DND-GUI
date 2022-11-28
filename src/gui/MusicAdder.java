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

public class MusicAdder {
    

    MusicAdder() throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        File file = new File("C:/Users/genja/OneDrive/Documents/GitHub/DND-GUI/files/theme.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

       
        
       
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
