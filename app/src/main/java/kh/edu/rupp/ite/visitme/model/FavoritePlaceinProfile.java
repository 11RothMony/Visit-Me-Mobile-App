package kh.edu.rupp.ite.visitme.model;


public class FavoritePlaceinProfile {
    private int id;
    private String name;
    private  String imageUrl;
    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imageUrl = imgUrl;
    }

    public String getType() {
        return type;
    }

}

