/**
 * @project AimsProject
 * @author Mitchell Vu
 * @since November 2023
 */

package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private static final int DEFAULT_CAPACITY = 20;
    private final DigitalVideoDisc[] itemsInStore;
    private int itemCount;

    public Store() {
        this.itemsInStore = new DigitalVideoDisc[DEFAULT_CAPACITY];
    }

    public Store(int capacity) {
        this.itemsInStore = new DigitalVideoDisc[capacity];
    }

    public void addDVD(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc dvd : dvds) {
            if (itemCount < itemsInStore.length) {
                itemsInStore[itemCount] = dvd;
                itemCount++;
                System.out.println("DVD added to the store: " + dvd.getTitle());
            } else {
                System.out.println("Store is full. Cannot add more DVDs.");
            }
        }
    }

    public void removeDVD(String... titles) {
        for (String title : titles) {
            for (int i = 0; i < itemCount; i++) {
                if (itemsInStore[i].getTitle().equals(title)) {
                    System.out.println("DVD removed from the store: " + title);
//                    Move the last item to the position of the removed item
                    itemsInStore[i] = itemsInStore[itemCount - 1];
//                    Clear the last position
                    itemsInStore[itemCount - 1] = null;
                    itemCount--;
                    break;
                }
            }
        }
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in the store:");
        for (int i = 0; i < itemCount; i++) {
            System.out.printf("%d. %s\n", i + 1, itemsInStore[i].toString());
        }
        System.out.println("*****************************************************");
    }
}
