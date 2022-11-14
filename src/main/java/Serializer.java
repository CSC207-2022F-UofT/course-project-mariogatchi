import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serializer {
    public void save(final String filename, Serializable obj){
        try{
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            fos.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public Serializable load(final String filename){
        Serializable obj = null;
        try{
            FileInputStream fis = new FileInputStream(filename);
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
}
