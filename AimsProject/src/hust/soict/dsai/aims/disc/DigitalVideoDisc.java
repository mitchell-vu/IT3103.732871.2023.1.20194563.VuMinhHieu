/**
 * @project AimsProject
 * @author Vu Minh Hieu
 * @since November 2023
 */

package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 0;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private final int id;

    public DigitalVideoDisc(String title) {
        super();
        this.title = title;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
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

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "DVD [" + this.getId() + "]"
                + " - " + this.getTitle()
                + " - " + this.getCategory()
                + " - " + this.getDirector()
                + " - " + this.getLength()
                + " - " + this.getCost() + "$";
    }

//    Matching rules in Lab 02
//    Comparison is case-insensitive
    public boolean isMatch(String title) {
        String[] words = title.split(" ");

        for (String word : words) {
            if (!this.title.toLowerCase().contains(word.toLowerCase()))
                return false;
        }

        return true;
    }
}
