package seedu.jxmusic.model;

import java.util.ArrayList;
import java.util.List;

import seedu.jxmusic.commons.util.CollectionUtil;

/**
 * Represents a playlist in JxMusic
 */
public class Playlist1 {
    // playlist name
    private final String name;
    // playlist's list of track
    private List<Track> tracks;

    public Playlist1(String name) {
        CollectionUtil.requireAllNonNull(name);
        this.name = name;
    }

    /**
     * Adds a track into the playlist
     * @param track to be added to the playlist
     */
    public void addTrack(Track track) {
        if (tracks == null) {
            tracks = new ArrayList<>();
        }
        tracks.add(track);
    }

    public String getName() {
        return name;
    }

    public List<Track> getTracks() {
        return tracks;
    }
}
