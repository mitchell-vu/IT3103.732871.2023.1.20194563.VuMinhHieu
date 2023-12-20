/**
 * @project AimsProject
 * @author Vu Minh Hieu
 * @since November 2023
 */

package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final ArrayList<Media> itemsOrdered = new ArrayList<>();

    public void addMedia(Media... medias) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full.");
            return;
        }

        for (Media media : medias) {
            if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
                this.itemsOrdered.add(media);
                System.out.printf("The media %s has been added.\n", media.getTitle());
            } else {
                System.out.printf("The media %s cannot be added.\n", media.getTitle());
            }
        }
    }

    public void removeMedia(Media item) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Empty cart. Please add some items.");
            return;
        }
        System.out.printf("The media %s has been removed.\n", item.getTitle());
        itemsOrdered.remove(item);
    }

    public void removeMedia(int id) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("Empty cart. Please add some items.");
            return;
        }
        if (id < itemsOrdered.size()) {
            System.out.printf("The media %s has been removed.\n", itemsOrdered.get(id).getTitle());
            itemsOrdered.remove(id);
        }
    }

    public float totalCost() {
        float cost = 0;

        for (Media item : itemsOrdered) {
            cost += item.getCost();
        }
        return cost;
    }

    public void print() {
        System.out.println("********************** CART **********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, itemsOrdered.get(i).toString());
        }
        System.out.printf("Total cost: %.2f\n", totalCost());
        System.out.println("***************************************************");
    }

    public void search(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found the DVD:");
                System.out.println(media.toString());
                return;
            }
        }
        System.out.println("DVD not found!");
    }

    public void search(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equals(title)) {
                System.out.println("Found the DVD:");
                System.out.println(media.toString());
                return;
            }
        }
        System.out.println("DVD not found!");
    }
}
