/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author SebastianBernthJepse
 */
public class User {
    private String email;
    private String username;
    private String password;

    public String getEmail() {
        return email;
    }

    
    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }
    

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
   
    
}
