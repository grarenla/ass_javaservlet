package entity;

import java.util.ArrayList;
import java.util.HashMap;

public class Feedback {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String title;
    private String description;
    private int userId;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Feedback() {
    }

    public Feedback(int id, String title, String description, int userId, int status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.status = status;
    }

    private HashMap<String, ArrayList<String>> errors = new HashMap<>();

    public boolean isValid() {
        checkErrors();
        System.out.println("error feedback size: " + errors.size());
        return errors.size() == 0;
    }

    private void checkErrors() {
        ArrayList<String> titleErrors = errors.get("title");
        if (titleErrors == null) {
            titleErrors = new ArrayList<>();
        }
        if (title == null || title.length() == 0) {
            titleErrors.add("Title không được để trống.");
        }

        if (titleErrors.size() > 0) errors.put("username", titleErrors);


        ArrayList<String> descriptionErrors = errors.get("description");
        if (descriptionErrors == null) {
            descriptionErrors = new ArrayList<>();
        }
        System.out.println("description: " + description);
        if ((description == null) || (description.length() == 0)) {
            descriptionErrors.add("Description không được để trống.");
        }

        if (descriptionErrors.size() > 0) errors.put("password", descriptionErrors);
    }

    public HashMap<String, ArrayList<String>> getErrors() {
        return errors;
    }
}
