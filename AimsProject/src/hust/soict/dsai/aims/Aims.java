/**
 * @project AimsProject
 * @author Vu Minh Hieu
 * @since November 2023
 */

package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static final Store store = new Store(100);
    private static final Cart cart = new Cart();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CompactDisc cd1 = new CompactDisc(
                "folklore",
                "Pop",
                19.69f,
                67,
                "Taylor Swift");
        CompactDisc cd2 = new CompactDisc(
                "reputation",
                "Pop",
                22.57f,
                56,
                "Taylor Swift");
        DigitalVideoDisc dvd = new DigitalVideoDisc(
                "Folklore: The Long Pond Studio Sessions",
                "Documentary",
                22.57f,
                106,
                "Taylor Swift");
        Book book = new Book(
                "The Hunger Games",
                "Science fiction",
                10.99f);
        store.addMedia(cd1, cd2, dvd, book);
        handleShowMenu();
    }

    public static int optionScanner(int from, int to) {
        int option;
        do {
            option = scanner.nextInt();
            scanner.nextLine();
        } while (option < from | option > to);
        return option;
    }

    public static Media getMediaInStoreWithTitle() {
        System.out.println("Enter the title of the media in store: ");
        String title = scanner.nextLine();

        for (Media media : store.getItemsInStore()) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        System.out.println("Media not found in store!");
        return null;
    }

    public static Media getMediaInCartWithTitle() {
        System.out.println("Enter the title of the media in cart: ");
        String title = scanner.nextLine();

        for (Media media : store.getItemsInStore()) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        System.out.println("Media not found in cart!");
        return null;
    }

    /**
     * Main menu
     */
    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    /**
     * Handle logic from Main menu
     */
    public static void handleShowMenu() {
        while (true) {
            showMenu();
            switch (optionScanner(0, 3)) {
                case 1 -> handleStoreMenu();
                case 2 -> handleUpdateStore();
                case 3 -> handleCartMenu();
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Menu from option
     * > 1. View store
     */
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    /**
     * Handle logic from option
     * > 1. View store
     */
    public static void handleStoreMenu() {
        while (true) {
            store.print();
            storeMenu();
            switch (optionScanner(0, 4)) {
                case 1 -> handleMediaDetailsMenu();
                case 2 -> handleAddMediaToCart();
                case 3 -> {
                    Media media = getMediaInStoreWithTitle();
                    handlePlayMedia(media);
                }
                case 4 -> handleCartMenu();
                case 0 -> {
                    return;
                }
            }
        }
    }

    /**
     * Menu from option
     * > 1. View store
     * > 1. See a media's details
     */
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void handleMediaDetailsMenu() {
        Media media = getMediaInStoreWithTitle();

        if (media == null)
            return;
        while (true) {
            System.out.println(media.toString());
            mediaDetailsMenu();
            switch (optionScanner(0, 2)) {
                case 1 -> cart.addMedia(media);
                case 2 -> handlePlayMedia(media);
                case 0 -> {
                    return;
                }
            }
        }
    }

    /**
     * Handle logic from option
     * > 1. View store
     * > 2. Add a media to cart
     */
    public static void handleAddMediaToCart() {
        Media media = getMediaInStoreWithTitle();

        if (media == null)
            return;
        cart.addMedia(media);
    }

    /**
     * Handle logic from option
     * > 1. View store
     * > 3. Play a media
     */
    public static void handlePlayMedia(Media media) {
        if (media == null)
            return;

        if (media instanceof CompactDisc cd) {
            cd.play();
            return;
        }
        if (media instanceof DigitalVideoDisc dvd) {
            dvd.play();
            return;
        }
        System.out.println("Cannot be played.");
    }

    /**
     * Menu from option
     * > 2. Update store
     */
    public static void updateStoreMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to store");
        System.out.println("2. Remove from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    /**
     * Menu from option
     * > 2. Update store
     * > 1. Add to store
     */
    public static void addToStoreMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add CD");
        System.out.println("2. Add DVD");
        System.out.println("3. Add Book");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    /**
     * Handle logic from option
     * > 2. Update store
     */
    public static void handleUpdateStore() {
        updateStoreMenu();
        switch (optionScanner(0, 2)) {
            case 1 -> {
                addToStoreMenu();
                int option = optionScanner(0, 3);

                System.out.print("Enter item title: ");
                String mediaTitle = scanner.nextLine();
                System.out.print("Enter item category: ");
                String mediaCategory = scanner.nextLine();
                System.out.print("Enter item cost: ");
                float mediaCost = scanner.nextFloat();

                switch (option) {
                    case 1 -> {
                        System.out.print("Enter CD's length: ");
                        int mediaLength = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter CD's artist: ");
                        String mediaArtist = scanner.nextLine();

                        CompactDisc cd = new CompactDisc(mediaTitle, mediaCategory, mediaCost, mediaLength,
                                mediaArtist);

                        System.out.print("Enter CD's number of tracks: ");
                        int itemTrackNumber = scanner.nextInt();
                        scanner.nextLine();

                        for (int i = 0; i < itemTrackNumber; i++) {
                            System.out.printf("Enter CD track [%d] name: ", i + 1);
                            String itemTrackName = scanner.nextLine();
                            System.out.printf("Enter CD track [%d] length: ", i + 1);
                            int itemTrackLength = scanner.nextInt();
                            scanner.nextLine();
                            Track track = new Track(itemTrackName, itemTrackLength);
                            cd.addTrack(track);
                        }
                        store.addMedia(cd);
                    }
                    case 2 -> {
                        System.out.print("Enter DVD's length: ");
                        int mediaLength = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter DVD's director: ");
                        String mediaDirector = scanner.nextLine();

                        DigitalVideoDisc dvd = new DigitalVideoDisc(mediaTitle, mediaCategory, mediaCost,
                                mediaLength, mediaDirector);
                        store.addMedia(dvd);
                    }
                    case 3 -> {
                        System.out.print("Enter book's author: ");
                        Book book = new Book(mediaTitle, mediaCategory, mediaCost);
                        int itemAuthorNumber = scanner.nextInt();
                        scanner.nextLine();

                        for (int i = 0; i < itemAuthorNumber; i++) {
                            System.out.printf("Enter book author [%d] name: ", i + 1);
                            String itemAuthorName = scanner.nextLine();
                            book.addAuthor(itemAuthorName);
                        }

                        store.addMedia(book);
                    }
                }
            }
            case 2 -> {
                Media media = getMediaInStoreWithTitle();

                if (media == null)
                    return;
                store.removeMedia(media);
            }
            case 0 -> {
                return;
            }
        }
    }

    /**
     * Menu from option
     * > 3. See current cart
     */
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    /**
     * Menu from option
     * > 3. See current cart
     * > 1. Filter medias in cart
     */
    public static void sortFilterMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    /**
     * Menu from option
     * > 3. See current cart
     * > 2. Sort medias in cart
     */
    public static void sortCartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    /**
     * Handle logic from option
     * > 3. See current cart
     */
    public static void handleCartMenu() {
        while (true) {
            cart.print();
            cartMenu();
            switch (optionScanner(0, 5)) {
                case 1 -> {
                    sortFilterMenu();
                    switch (optionScanner(0, 2)) {
                        case 1 -> {
                            System.out.print("Enter Media ID: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            cart.search(id);
                        }
                        case 2 -> {
                            System.out.print("Enter Media title: ");
                            String title = scanner.nextLine();
                            cart.search(title);
                        }
                    }
                }
                case 2 -> {
                    sortCartMenu();
                    switch (optionScanner(0, 2)) {
                        case 1 -> cart.sortByTitleCost();
                        case 2 -> cart.sortByCostTitle();
                    }
                }
                case 3 -> {
                    Media media = getMediaInCartWithTitle();

                    if (media == null)
                        return;
                    cart.removeMedia(media);
                }
                case 4 -> {
                    Media media = getMediaInCartWithTitle();

                    if (media == null)
                        return;
                    handlePlayMedia(media);
                }
                case 5 -> {
                    System.out.println("An order is created.");
                    cart.empty();
                }
                case 0 -> {
                    return;
                }
            }
        }
    }
}
