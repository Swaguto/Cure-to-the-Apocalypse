
import java.io.File;
import javax.sound.sampled.*;
import javax.swing.JOptionPane;
import java.util.concurrent.TimeUnit;

public class PlayMusicJavaSuperSimple {
    public static void main(String[] args) {
        new PlayMusicJavaSuperSimple();
    }

    private static Clip currentClip = null;

    // filepath variables
    static String filepath = "Nanashi no Game Sound EP： 01-Nameless Theme.wav";
    static String filepathLab = "Halo Infinite - Through the Trees (8-bit).wav";
    static String filepathEncounter = "8-bit RPG Music ｜ Boss Battle.wav";
    static String filepathBoss = "BOSS BATTLE - Chiptune Epic Intense Battle Music ｜ Royalty-Free.wav";

    // Play music method
    public static void PlayMusic(String location) {
        try {
            File musicFile = new File(location);
            if (musicFile.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile); 
                currentClip = AudioSystem.getClip();  // Get a new clip instance
                currentClip.open(audioInput);
                currentClip.loop(Clip.LOOP_CONTINUOUSLY); // Keep clip looping forever
                currentClip.start();
                // System.out.println("Music started.");
            } else {
                System.err.println("Can't find file: " + location);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Stop music method
    public static void StopMusic() {
        if (currentClip != null && currentClip.isRunning()) {
            currentClip.stop();  // Stop the currently playing clip
            currentClip.close();  // Optionally close the clip when done
            // System.out.println("Music stopped.");
        } else {
            // System.err.println("No music is currently playing.");
        }
    }
}


