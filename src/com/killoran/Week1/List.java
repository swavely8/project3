package com.killoran.Week1;


/**
 * Created by 111618 on 2/27/2019.
 */
public class List implements Comparable<List> {
    private String Title;
    private String Decrip;
    private int priority;

    public List(String title, String decrip, int priority) {
        Title = title;
        Decrip = decrip;
        this.priority = priority;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDecrip() {
        return Decrip;
    }

    public void setDecrip(String decrip) {
        Decrip = decrip;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Title + ": " + Decrip + " - " + "priority: " + priority;
    }

    @Override
    public int compareTo(List o) {
        if (!Title.equals(o.Title)) {
            return Title.compareTo(o.Title);
        } else {
            return Title.compareTo(o.Title);
        }
    }

}
