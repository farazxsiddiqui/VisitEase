package com.farazzz.visitease;

public class Visitor {
    private String name;
    private String destination;
    private String comments;

    public Visitor(String name, String destination, String comments) {
        this.name = name;
        this.destination = destination;
        this.comments = comments;
    }
    public Visitor(String destination, String comments) {
        this.destination = destination;
        this.comments = comments;
    }
    public Visitor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
