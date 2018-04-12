package learnmore.projet.learnmore.Model;

import java.util.List;

import learnmore.projet.learnmore.R;

/**
 * Created by khalil on 26/03/2018.
 */

public class Course {
    private String Id;
    private String title;
    private String categorie;
    private String price;
    private String imageUrl;



    public Course() {
    }

    public Course(String title, String categorie, String price, String imageUrl) {
        this.title = title;
        this.categorie = categorie;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }


    public String getTitle() {
        return title;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getPrice() {
        return price;
    }

    public String  getImageUrl() {
        return imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl= imageUrl;
    }

}
