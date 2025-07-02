package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> pizzas = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        boolean isExit = false;

        System.out.println("----- Welcome to Dzelle's Pizza -----");
        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. View Orders");
        System.out.println("5. Exit");

        while (!isExit) {
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Pizza type: ");
                    String pizzaType = scanner.nextLine();

                    System.out.print("Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    addOrder(pizzas, quantities, pizzaType, quantity);
                    break;
                case 2:
                    System.out.print("Order number to update: ");
                    int iOfPizzaToUpdate = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("New quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine();

                    updateOrder(quantities, iOfPizzaToUpdate - 1, newQuantity);
                    break;
                case 3:
                    System.out.print("Order number to remove: ");
                    int iOfPizzaToRemove = scanner.nextInt();
                    scanner.nextLine();

                    removeOrder(pizzas, quantities, iOfPizzaToRemove - 1);
                    break;
                case 4:
                    printOrders(pizzas, quantities);
                    break;
                case 5:
                    isExit = true;
                    System.out.println("---Thank you!---");
                    break;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }

        scanner.close();
    }

    // === Add Order ===
    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity) {
        if (quantity > 0) {
            pizzas.add(pizzaType);
            quantities.add(quantity);
        } else {
            System.out.println("Quantity must be positive.");
        }
        System.out.println();
    }

    // === Update Order Quantity ===
    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity) {
        if (index >= 0 && index < quantities.size()) {
            if (newQuantity > 0) {
                quantities.set(index, newQuantity);
            } else {
                System.out.println("Quantity must be positive.");
            }
        } else {
            System.out.println("Invalid order number.");
        }
        System.out.println();
    }

    // === Remove Order ===
    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index) {
        if (index >= 0 && index < pizzas.size()) {
            String removedPizza = pizzas.remove(index);
            int removedQuantity = quantities.remove(index);
        } else {
            System.out.println("Invalid order number.");
        }
        System.out.println();
    }

    // === Print Current Orders ===
    public static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities) {
        System.out.println("\n--- Current Orders ---");

        if (pizzas.isEmpty()) {
            System.out.println("No current orders.");
        } else {
            for (int i = 0; i < pizzas.size(); i++) {
                System.out.printf("%d. %s x %d\n", i + 1, pizzas.get(i), quantities.get(i));
            }
        }
        System.out.println();
    }
}