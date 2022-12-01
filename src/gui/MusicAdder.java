package gui;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *The MusicAdder class adds the background music to wherever it is 
 * Instantiated. As long as the program continues to run, it will
 * play music.
 * 
 * @author Jacob Jones 
 * @since November 28, 2022
 */
public class MusicAdder {
    
    /**
     * Default constructor for the MusicAdder object, 
     * which creates a music loop for the application.
     * 
     * @throws UnsupportedAudioFileException if wrong file type
     * @throws IOException if IO error occurs while playing
     * @throws LineUnavailableException if no line available 
     */
    MusicAdder() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //creating soundfile clip
        File soundFile = new File("music/soundtrack.wav");
        AudioInputStream soundStream = AudioSystem.getAudioInputStream(soundFile);
        Clip fullClip = AudioSystem.getClip();
  
        //play and loop soundfile clip forever while application continues to run
        fullClip.open(soundStream);
        fullClip.start();
        fullClip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}