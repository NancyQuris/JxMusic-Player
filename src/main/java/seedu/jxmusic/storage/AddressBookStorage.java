package seedu.jxmusic.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.jxmusic.commons.exceptions.DataConversionException;
import seedu.jxmusic.model.ReadOnlyLibrary;

/**
 * Represents a storage for {@link seedu.jxmusic.model.AddressBook}.
 */
public interface AddressBookStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getAddressBookFilePath();

    /**
     * Returns AddressBook data as a {@link ReadOnlyLibrary}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ReadOnlyLibrary> readAddressBook() throws DataConversionException, IOException;

    /**
     * @see #getAddressBookFilePath()
     */
    Optional<ReadOnlyLibrary> readAddressBook(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlyLibrary} to the storage.
     * @param addressBook cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveAddressBook(ReadOnlyLibrary addressBook) throws IOException;

    /**
     * @see #saveAddressBook(ReadOnlyLibrary)
     */
    void saveAddressBook(ReadOnlyLibrary addressBook, Path filePath) throws IOException;

}
