/**
 * @project AimsProject
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.aims.media;

public class Media {
    private static int nbMedias = 0;
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(String title) {
        this.title = title;
        this.id = ++nbMedias;
    }

    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        this.id = ++nbMedias;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbMedias;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
