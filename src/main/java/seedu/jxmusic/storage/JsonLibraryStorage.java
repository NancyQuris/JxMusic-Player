package seedu.jxmusic.storage;

import static java.util.Objects.requireNonNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import seedu.jxmusic.commons.core.LogsCenter;
import seedu.jxmusic.commons.exceptions.DataConversionException;
import seedu.jxmusic.commons.util.FileUtil;
import seedu.jxmusic.model.Library;
import seedu.jxmusic.model.ReadOnlyLibrary;
import seedu.jxmusic.model.Track;

/**
 * A class to access library data stored as an json file on the hard disk.
 */
public class JsonLibraryStorage implements LibraryStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonLibraryStorage.class);

    private Path filePath;

    public JsonLibraryStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getLibraryFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyLibrary> readLibrary() throws DataConversionException, IOException {
        return readLibrary(filePath);
    }

    /**
     * Similar to {@link #readLibrary()}
     * @param filePath location of the data. Cannot be null
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<ReadOnlyLibrary> readLibrary(Path filePath) throws DataConversionException,
                                                                                 FileNotFoundException {
        requireNonNull(filePath);

        if (!Files.exists(filePath)) {
            logger.info("Library file " + filePath + " not found");
            return Optional.empty();
        }

        Library loadedLibrary = null;
        try {
            loadedLibrary = JsonFileStorage.loadDataFromFile(filePath);
            Set<Track> trackSet = TracksScanner.scan(Paths.get(Library.LIBRARYDIR));
            loadedLibrary.setTracks(trackSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.of(loadedLibrary);
    }

    @Override
    public void saveLibrary(ReadOnlyLibrary library) throws IOException {
        saveLibrary(library, filePath);
    }

    /**
     * Similar to {@link #saveLibrary(ReadOnlyLibrary)}
     * @param filePath location of the data. Cannot be null
     */
    public void saveLibrary(ReadOnlyLibrary library, Path filePath) throws IOException {
        requireNonNull(library);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        try {
            JsonFileStorage.saveDataToFile(filePath, new Library(library));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
