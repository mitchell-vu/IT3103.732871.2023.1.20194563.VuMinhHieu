/**
 * @project AimsProject
 * @author Mitchell Vu
 * @since November 2023
 */

package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private static final int DEFAULT_CAPACITY = 20;

    private ArrayList<Media> itemsInStore;
    private int capacity;

    public Store() {
        this.itemsInStore = new ArrayList<>(DEFAULT_CAPACITY);
        this.capacity = DEFAULT_CAPACITY;
    }

    public Store(int capacity) {
        this.itemsInStore = new ArrayList<>(capacity);
        this.capacity = capacity > 0 ? capacity : DEFAULT_CAPACITY;
    }

    public void addMedia(Media... medias) {
        for (Media media : medias) {
            if (itemsInStore.size() < capacity) {
                itemsInStore.add(media);
                System.out.println("Media added to the store: " + media.getTitle());
            } else {
                System.out.println("Store is full. Cannot add more medias.");
            }
        }
    }

    public void removeMedia(String... titles) {
        for (String title : titles) {
            for (Media item : itemsInStore) {
                if (item.getTitle().equals(title)) {
                    System.out.println("Media removed from the store: " + title);
                    itemsInStore.remove(item);
                    break;
                }
            }
        }
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in the store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, itemsInStore.get(i).toString());
        }
        System.out.println("*****************************************************");
    }
}
