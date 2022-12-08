package mariogatchi.data_access;

import com.harium.postgrest.Condition;
import com.harium.postgrest.Insert;
import org.json.JSONArray;

import java.io.File;
import java.io.Serializable;

public interface DataAccessInterface {


    File loadFile(String filepath);
    boolean deleteFile(File file);

    void saveObject(final String filename, Serializable obj);

    Serializable loadObject(final String filename);

    boolean insertDBRow(String tableName, Insert.Row entry);

    JSONArray loadDBTable(String tableName);

    boolean deleteDBRow(String tableName, Condition condition);

}
