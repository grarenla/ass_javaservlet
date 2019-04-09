package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private int id;
    private String username;
    private String password;
    private String fullName;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public User(int id, String username, String password, String fullName, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }

    public User() {
    }

    private HashMap<String, ArrayList<String>> errors = new HashMap<>();

    public boolean isValid() {
        checkErrors();
        System.out.println("error size: " + errors.size());
        return errors.size() == 0;
    }

    private void checkErrors() {
        ArrayList<String> usernameErrors = errors.get("username");
        if (usernameErrors == null) {
            usernameErrors = new ArrayList<>();
        }
        if (username == null || username.length() == 0) {
            usernameErrors.add("username khong duoc de trong");
        }
        if (username != null && (username.length() < 2 || username.length() > 20)) {
            usernameErrors.add("username phai lon hon 2 va nho hon 20 ki tu.");
        }

        if (usernameErrors.size() > 0) errors.put("username", usernameErrors);


        ArrayList<String> passwordErrors = errors.get("password");
        if (passwordErrors == null) {
            passwordErrors = new ArrayList<>();
        }
        if ((password == null) || (password.length() == 0)) {
            passwordErrors.add("password khong duoc de trong");
        }
        if (password != null && (password.length() < 6)) {
            passwordErrors.add("password phai lon hon 6 ki tu.");
        }
        if (passwordErrors.size() > 0) errors.put("password", passwordErrors);


        ArrayList<String> fullNameErrors = errors.get("fullName");
        if (fullNameErrors == null) {
            fullNameErrors = new ArrayList<>();
        }
        if ((fullName == null) || (fullName.length() == 0)) {
            fullNameErrors.add("fullName khong duoc de trong");
        }
        if (fullNameErrors.size() > 0) errors.put("fullName", fullNameErrors);

    }

    public HashMap<String, ArrayList<String>> getErrors() {
        return errors;
    }
}
