// 代码生成时间: 2025-09-20 19:19:42
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * BackupService provides functionality for data backup and recovery.
 * It uses serialization to save and load data objects to/from files.
 */
public class BackupService<T> {

    private static final Logger LOGGER = Logger.getLogger(BackupService.class.getName());

    /**
     * Backups the given data object to a file.
     * 
     * @param data the data object to backup
     * @param filename the file to backup to
     * @return true if backup was successful, false otherwise
     */
    public boolean backupData(T data, String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(data);
            return true;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to backup data: ", e);
            return false;
        }
    }

    /**
     * Recovers the data object from a file.
     * 
     * @param filename the file to recover from
     * @return the recovered data object, or null if recovery failed
     */
    @SuppressWarnings("unchecked")
    public T recoverData(String filename) {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (T) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Failed to recover data: ", e);
            return null;
        }
    }

    /**
     * Deletes the backup file after successful recovery.
     * 
     * @param filename the file to delete
     * @return true if deletion was successful, false otherwise
     */
    public boolean deleteBackup(String filename) {
        File file = new File(filename);
        if (file.delete()) {
            return true;
        } else {
            LOGGER.log(Level.WARNING, "Failed to delete backup file: " + filename);
            return false;
        }
    }
}
