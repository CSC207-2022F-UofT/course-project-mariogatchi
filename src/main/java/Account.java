import java.io.Serializable;
import java.util.List;

public class Account implements Serializable {
    private String username;
    private byte[] hashedPassword;
    private List<User> users;

    /**
     * Creates an account with a username and a hashed password
     * @param username The username of the account
     * @param hashedPassword The hashed password of the account
     */
    public Account(String username, byte[] hashedPassword){
        this.username = username;
        this.hashedPassword = hashedPassword;
    }

    @Override
    public String toString(){
        return username + " " + hashedPassword;
    }

    /**
     * Gets the username of the account
     * @return The username of the account
     */
    public String getUsername(){
        return username;
    }

    /**
     * Sets the username of the account
     * @param username The new username
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * Gets the hashed password of the account
     * @return The hashed password of the account
     */
    public byte[] getHashedPassword(){
        return hashedPassword;
    }

    /**
     * Sets the hashed password of the account
     * @param hashedPassword The new hashed password
     */
    public void setHashedPassword(byte[] hashedPassword){
        this.hashedPassword = hashedPassword;
    }

    /**
     * Gets a list of users in the account
     * @return The list of users of the account
     */
    public List<User> getUsers(){
        return users;
    }

    /**
     * Sets the list of users in the account
     * @param users The new list of users
     */
    public void setUsers(List<User> users){
        this.users = users;
    }
}
