package io.smth.models;

public class Auto {
    private final String title;
    private final String description;
    private final String price;
    private final String link;

    public Auto(String title, String description, String price, String link) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.link = link;
    }




    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getPrice() {
        return price;
    }
    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return String.format("Title: %-40s, Description: %s, Price: %s, Link: %s", getTitle(), getDescription(), getPrice(), getLink());
    }
}
