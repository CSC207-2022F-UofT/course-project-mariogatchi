package mariogatchi.data_access;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DataAccess implements DataAccessInterface{

    private final String DIR = System.getProperty("user.dir") + "\\src\\main\\java\\mariogatchi\\";
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

    @Override
    public File loadFile(String filepath) {
        return new File(DIR + filepath);
    }

    @Override
    public boolean deleteFile(File file) {
        return file.delete();
    }
}
