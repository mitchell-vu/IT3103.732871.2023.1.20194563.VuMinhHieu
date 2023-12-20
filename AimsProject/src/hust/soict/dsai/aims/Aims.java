/**
 * @project AimsProject
 * @author Vu Minh Hieu
 * @since November 2023
 */

package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King",
                "Animation",
                19.95f,
                87,
                "Roger Allers");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars",
                "Science Fiction",
                24.95f,
                124,
                "George Lucas");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Aladdin",
                "Animation",
                18.99f,
                90,
                "John Musker");

        anOrder.addMedia(dvd1, dvd2, dvd3);

        System.out.printf("Total cost is: %f\n", anOrder.totalCost());

        anOrder.removeMedia(dvd2);
        System.out.printf("Total cost is: %f\n", anOrder.totalCost());
    }
}
