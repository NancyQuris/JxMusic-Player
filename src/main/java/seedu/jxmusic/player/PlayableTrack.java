package seedu.jxmusic.player;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * Playlist1 structure used by Player
 */
public class PlayableTrack implements Playable {
    private static MediaPlayer mediaPlayer;
    // static cos otherwise java garbage collects mediaplayer in like 5 seconds
    // then the track only play for 5 seconds before it suddenly stop
    private String fileName;

    public PlayableTrack() { // todo take in Track model as parameter
        fileName = "library/scarborough fair.mp3";
        Media media = new Media(new File(fileName).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnReady(() -> {
            System.out.println("ready");
        });
    }

    @Override
    public void play() {
        System.out.println("playabletrack play");
        mediaPlayer.play();
    }

    @Override
    public void stop() {
        System.out.println("playabletrack stop");
        mediaPlayer.setStartTime(new Duration(0));
        mediaPlayer.stop();
    }

    @Override
    public void pause() {
        System.out.println("playabletrack pause");
        mediaPlayer.pause();
    }

    @Override
    public void seek(Duration time) {
        System.out.println("playabletrack seek to " + time.toSeconds() + " second(s)");
        mediaPlayer.seek(time);
    }

    public void setOnEndOfMedia(Runnable runnable) {
        mediaPlayer.setOnEndOfMedia(runnable);
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
}
