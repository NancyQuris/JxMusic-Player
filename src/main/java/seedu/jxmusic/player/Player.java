package seedu.jxmusic.player;

/**
 * The API of the Player component.
 */
public interface Player {
    void play(); // todo take in Playlist1 model as parameter
    // void play(Track track);
    void stop();
    void pause();
}
