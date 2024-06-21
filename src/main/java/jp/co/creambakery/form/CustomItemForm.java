package jp.co.creambakery.form;

import java.util.*;

import jp.co.creambakery.entity.*;
public class CustomItemForm {
    private String name;
    private String reading;
    private String description;
    private Bread bread;
    private List<Cream> creams;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getReading() {
        return reading;
    }
    public void setReading(String reading) {
        this.reading = reading;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Bread getBread() {
        return bread;
    }
    public void setBread(Bread bread) {
        this.bread = bread;
    }
    public List<Cream> getCreams() {
        return creams;
    }
    public void setCreams(List<Cream> creams) {
        this.creams = creams;
    }

}






















