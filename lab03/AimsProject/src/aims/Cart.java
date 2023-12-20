/**
 * @project AimsProject
 * @author Vu Minh Hieu
 * @since November 2023
 */

package aims;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int quantityOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        // Check the cart is already full or not
        if (quantityOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full.");
            return;
        }

        this.itemsOrdered[this.quantityOrdered++] = disc;
        System.out.printf("The disc %s has been added.\n", disc.getTitle());
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if (quantityOrdered == 0) {
            System.out.println("The cart is empty.");
            return;
        }

        for (int i = 0; i < quantityOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < quantityOrdered - 1; j++)
                    itemsOrdered[j] = itemsOrdered[j + 1];
                itemsOrdered[--quantityOrdered] = null;
                break;
            }
        }

        System.out.printf("The disc %s has been removed.\n", disc.getTitle());
    }

    public float totalCost() {
        float cost = 0;

        for (int i = 0; i < quantityOrdered; i++) {
            cost += itemsOrdered[i].getCost();
        }
        return cost;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");

        for (int i = 0; i < quantityOrdered; i++) {
            System.out.printf("%d. %s\n", i + 1, itemsOrdered[i].toString());
        }
        System.out.printf("Total cost: %.2f\n", totalCost());
        System.out.println("***************************************************");
    }
}
