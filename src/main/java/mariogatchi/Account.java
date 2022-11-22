package mariogatchi;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable {
    private String username;
    private byte[] hashedPassword;
    private List<User> users;

    public Account(String username, byte[] hashedPassword){
        this.username = username;
        this.hashedPassword = hashedPassword;
    }

    @Override
    public String toString(){
        return username + " " + hashedPassword;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public byte[] getHashedPassword(){
        return hashedPassword;
    }

    public void setHashedPassword(byte[] hashedPassword){
        this.hashedPassword = hashedPassword;
    }

    public List<User> getUsers(){
        return users;
    }

    public void setUsers(List<User> users){
        this.users = users;
    }

    public void addUser(String name) {
        this.users.add(new User(name));
    }

    public void addUserInstance(User user) {this.users.add(user);}

    public void delUser(User user) {
        this.users.remove(user);
    }
}
