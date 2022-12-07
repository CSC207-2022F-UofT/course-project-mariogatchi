package mariogatchi.data_access;

import java.io.File;
import java.io.Serializable;

public interface DataAccessInterface {


    File loadFile(String filepath);
    boolean deleteFile(File file);

    void saveObject(final String filename, Serializable obj);

    Serializable loadObject(final String filename);
}
