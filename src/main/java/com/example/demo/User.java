package com.example.demo;
import java.util.regex.Pattern;

public class User {
    private int id;
    private  String firstName;
    private String lastName;
    private String email;
    private String password;

    public User(String firstName, String lastName, String email,String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    public int getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public boolean valid_firstName(String firstName){
        return firstName.length() > 4;
    }

    public boolean valid_lastName(String lastName){
        return lastName.length() > 4;
    }
    public boolean valid_email(String email){
        Pattern pattern = Pattern.compile("[A-Za-z0-9_]+");
        boolean valid = (email != null) && pattern.matcher(email).matches();
        return valid;
    }
    public boolean valid_password(String password){
        return password.length() > 4;
    }
}
