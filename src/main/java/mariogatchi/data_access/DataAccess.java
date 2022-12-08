package mariogatchi.data_access;

import com.harium.postgrest.Condition;
import com.harium.supabase.SupabaseClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.harium.postgrest.Insert.Row;
import org.json.JSONArray;

public class DataAccess implements DataAccessInterface{

    private SupabaseClient supabaseClient;

    private final String DIR = System.getProperty("user.dir") + "\\src\\main\\java\\mariogatchi\\";


    /**
     * Used for serializing objects
     * @param filename the Directory and name of the file
     * @param obj the object to be serialized
     */
    @Override
    public void saveObject(final String filename, Serializable obj){
        try{
            FileOutputStream fos = new FileOutputStream(DIR + filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            fos.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public DataAccess(){
        this.supabaseClient = new SupabaseClient("https://gycfpjqqktwayjlojpcu.supabase.co",
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Imd5Y2ZwanFxa3R3YXlqbG9qcGN1Iiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTY2OTM0MjgwMSwiZXhwIjoxOTg0OTE4ODAxfQ.uGQIakc4-WnrA5fmdy8nDuYsTQYhUP2yBO_GOLuMAkM");
    }

    /**
     * Loads a serialized object
     * @param filename the Directory and name of the file
     * @return the object
     */
    @Override
    public Serializable loadObject(final String filename){
        Serializable obj = null;
        try{
            FileInputStream fis = new FileInputStream(DIR + filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            try{
                obj = (Serializable) ois.readObject();
            }catch(ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
            ois.close();
            fis.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return obj;
    }

    /**
     *
     * @param filepath The file Directory and name
     * @return the File object
     */
    @Override
    public File loadFile(String filepath) {
        return new File(DIR + filepath);
    }

    /**
     * Deletes a file
     * @param file the file to delete
     * @return returns if the file was deleted
     */
    @Override
    public boolean deleteFile(File file) {
        return file.delete();
    }

    @Override
    public boolean insertDBRow(String tableName, Row entry){
        try{
            this.supabaseClient.insert(tableName, entry);
            return true;
        } catch (IOException e){
            return false;
        }
    }

    @Override
    public JSONArray loadDBTable(String tableName){
        try{
            return new JSONArray(this.supabaseClient.findAll(tableName));
        } catch (IOException e){
            return new JSONArray("[]");
        }
    }

    @Override
    public boolean deleteDBRow(String tableName, Condition condition){
        try{
            this.supabaseClient.delete(tableName, condition);
            return true;
        } catch (IOException e){
            return false;
        }
    }
}
