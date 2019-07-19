package com.owen.nakurutravellers;

public class TravelDeals {

    private String id;
    private String price;
    private String title;
    private String description;
    private String imageUrl;

    //create an empty constructor;
    public TravelDeals()
    {

    }



    public TravelDeals( String price, String title, String description, String imageUrl) {
        this.setId(id);
        this.setPrice(price);
        this.setTitle(title);
        this.setDescription(description);
        this.setImageUrl(imageUrl);
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
