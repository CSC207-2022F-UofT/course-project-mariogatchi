package mariogatchi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Account implements Serializable {
    private String username;
    private byte[] hashedPassword;
    private List<User> users;
    private final String FRIEND_CODE;

    /**
     * An instance of an account
     * @param username the username of the account
     * @param hashedPassword the already hashed password
     * @param friendCode the unique friendcode
     */
    public Account(String username, byte[] hashedPassword, String friendCode){
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.FRIEND_CODE = friendCode;
        this.users = new ArrayList<>();
    }

    @Override
    public String toString(){
        return username + " " + Arrays.toString(hashedPassword);
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

    public String getFRIEND_CODE() {
        return this.FRIEND_CODE;
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
