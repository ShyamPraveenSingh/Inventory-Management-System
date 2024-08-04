package inventory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static ItemService itemService = new ItemService();

    public static void main(String[] args) {

        do{
            displayMenu();
            handleUserInput();
        }while (true);
    }

    //Function to display the options that can be performed in the database
    public static void displayMenu(){
        System.out.println("Inventory Management System");
        System.out.println("----------------------------");
        System.out.println("1. Add Item");
        System.out.println("2. View Item");
        System.out.println("3. View All Items");
        System.out.println("4. Update Item");
        System.out.println("5. Delete Item");
        System.out.println("6. Search Items by Name");
        System.out.println("7. Filter Items by Category");
        System.out.println("8. Exit");
        System.out.println("-----------------------------");
    }

    //Function to handle the user input
    public static void handleUserInput(){
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice){

            case 1:
                System.out.println("Create a new item");
                addItem();
                break;
            case 2:
                System.out.println("View item");
                viewItem();
                break;
            case 3:
                System.out.println("View all item");
                viewAllItems();
                break;
            case 4:
                System.out.println("Update item");
                updateItem();
                break;
            case 5:
                System.out.println("Delete item");
                deleteItem();
                break;
            case 6:
                System.out.println("Search Item by name");
                searchItemsByName();
                break;
            case 7:
                System.out.println("Filter by category");
                filterItemsByCategory();
                break;
            case 8:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                System.out.println("Wrong input");
                break;
        }
    }

    public static void  addItem(){
        System.out.println("Enter the product name: ");
        String name = sc.nextLine();
        System.out.println("Enter the product category: ");
        String category = sc.nextLine();
        System.out.println("Enter the product quantity: ");
        int quantity = sc.nextInt();
        System.out.println("Enter the product price");
        BigDecimal price = sc.nextBigDecimal();

        //Add it to the temp storage
        inventory.Item item = new inventory.Item(0, name, category, quantity, price);
        itemService.addItem(item);
        System.out.println("Item added successfully");

    }

    private static void viewItem() {
        System.out.print("Enter item ID: ");
        int id = sc.nextInt();
        Item item = itemService.getItem(id);
        if (item != null) {
            System.out.println("ID: " + item.getId());
            System.out.println("Name: " + item.getName());
            System.out.println("Category: " + item.getCategory());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("Price: " + item.getPrice());
        } else {
            System.out.println("Item not found.");
        }
    }

    private static void viewAllItems(){

        List<Item> items = itemService.getAllItems();
        for (Item item: items){
            System.out.println("ID: " + item.getId());
            System.out.println("Name: " + item.getName());
            System.out.println("Category: " + item.getCategory());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("Price: " + item.getPrice());
        }
    }

    private static void updateItem(){
        System.out.print("Enter item ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline left by nextInt()
        System.out.print("Enter new item name: ");
        String name = sc.nextLine();
        System.out.print("Enter new item category: ");
        String category = sc.nextLine();
        System.out.print("Enter new item quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter new item price: ");
        BigDecimal price = sc.nextBigDecimal();

       Item item = new Item(id, name, category, quantity, price);
       itemService.updateItem(item);
        System.out.println("Item updated successfully");
    }

    private static void deleteItem(){
        System.out.println("Enter the product ID: ");
        int id = sc.nextInt();
        itemService.deleteItem(id);
        System.out.println("Item deleted successfully");
    }

    private static void searchItemsByName() {
        System.out.print("Enter item name to search: ");
        String name = sc.nextLine();
        List<Item> items = itemService.searchItems(name);
        for (Item item : items) {
            System.out.println("ID: " + item.getId());
            System.out.println("Name: " + item.getName());
            System.out.println("Category: " + item.getCategory());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("Price: " + item.getPrice());
            System.out.println("------------");
        }
    }

    private static void filterItemsByCategory() {
        System.out.print("Enter item category to filter: ");
        String category = sc.nextLine();
        List<Item> items = itemService.filterItemsByCategory(category);
        for (Item item : items) {
            System.out.println("ID: " + item.getId());
            System.out.println("Name: " + item.getName());
            System.out.println("Category: " + item.getCategory());
            System.out.println("Quantity: " + item.getQuantity());
            System.out.println("Price: " + item.getPrice());
            System.out.println("----------------------------");
        }
    }

}
