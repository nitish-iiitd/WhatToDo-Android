package com.example.nitish.whattodo;

/**
 * Created by nitish on 31/10/16.
 */

public class ToDo {

    private String title;
    private String details;
    private int importance;

    public ToDo() {
    }

    public ToDo(String title, String details, int importance) {
        this.title = title;
        this.details = details;
        this.importance = importance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }
}
