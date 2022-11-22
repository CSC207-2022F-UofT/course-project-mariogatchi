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

    public static class User implements Serializable{
        private String name;
        private List<Inventory> inventory;
        private List<Mariogatchi> mariogatchis;
        private List<User> friends;

        public User(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        public List<Inventory> getInventory(){
            return inventory;
        }

        public void setInventory(List<Inventory> inventory){
            this.inventory = inventory;
        }

        public List<Mariogatchi> getMariogatchis(){
            return mariogatchis;
        }

        public void setMariogatchis(List<Mariogatchi> mariogatchis){
            this.mariogatchis = mariogatchis;
        }

        public List<User> getFriends(){
            return friends;
        }

        public void setFriends(List<User> friends){
            this.friends = friends;
        }

        public void addMariogatchi(Mariogatchi mariogatchi){
            this.mariogatchis.add(mariogatchi);
        }
    }
}
