/**
 * @project AimsProject
 * @author Vu Minh Hieu
 * @since November 2023
 */

package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private String director;

    public DigitalVideoDisc(String title, int length, String director) {
        super(title, length);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, int length, String director) {
        super(title, category, length);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
        super(title, category, cost, length);
        this.director = director;
    }

    public String getDirector() {
        return director;
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

    public boolean isMatch(String title) {
        String[] words = title.split(" ");

        for (String word : words) {
//            Matching rules in Lab 02. Comparison is case-insensitive
            if (!this.getTitle().toLowerCase().contains(word.toLowerCase())) return false;
        }

        return true;
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
