import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class OrderLogs {
    private ArrayDeque<String> orderLogs;

    public OrderLogs() {
        orderLogs = new ArrayDeque<>();
    }

    public void addOrderLog(String log) {
        orderLogs.push(log);
    }

    private void mostRecentLogEntry() {
        if (!orderLogs.isEmpty()) {
            System.out.println(orderLogs.peek());
        } else {
            System.out.println("The log is empty.");
        }
    }

    private String getOrderLog() {
        if (!orderLogs.isEmpty()) {
            return orderLogs.pop();
        } else {
            System.out.println("The log is empty.");
            return null;
        }
    }

    private void removeAllLogEntries() {
        orderLogs.clear();
    }

    private boolean orderLogsEmpty() {
        return orderLogs.isEmpty();
    }

    public void handleLogs() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Choose what you want to do with order logs:");
            System.out.println("1. Display all the logs");
            System.out.println("2. Display the most recent logs");
            System.out.println("3. Remove a log entry");
            System.out.println("4. Remove all log entries");
            System.out.println("5. Check if the log is completely empty");
            System.out.print("Enter your choice (1 - 5): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayOrderLogs();
                    break;
                case 2:
                    mostRecentLogEntry();
                    break;
                case 3:
                    getOrderLog();
                    break;
                case 4:
                    removeAllLogEntries();
                    break;
                case 5:
                    if (orderLogsEmpty()) {
                        System.out.println("The log is completely empty");
                    } else {
                        System.out.println("The log is not completely empty");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    private void displayOrderLogs() {
        if (!orderLogs.isEmpty()) {
            for (String log : orderLogs) {
                System.out.println(log);
            }
        } else {
            System.out.println("The log is empty.");
        }
    }
}

class PizzeriaQueue {
    private Queue<String> pizzaOrders;

    public PizzeriaQueue() {
        pizzaOrders = new LinkedList<>();
    }

    public void addPizzaOrder(String order) {
        pizzaOrders.add(order);
    }

    public void processOrders() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Choose what you want to do with pizza orders:");
            System.out.println("1. Add a new pizza order");
            System.out.println("2. Display the next order to be processed");
            System.out.println("3. Process the next order");
            System.out.println("4. Check if there are any orders");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1 - 5): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the pizza order details: ");
                    String newOrder = scanner.nextLine();
                    addPizzaOrder(newOrder);
                    break;
                case 2:
                    if (!pizzaOrders.isEmpty()) {
                        System.out.println("Next order to be processed: " + pizzaOrders.peek());
                    } else {
                        System.out.println("No orders in queue.");
                    }
                    break;
                case 3:
                    if (!pizzaOrders.isEmpty()) {
                        System.out.println("Processing order: " + pizzaOrders.poll());
                    } else {
                        System.out.println("No orders in queue.");
                    }
                    break;
                case 4:
                    if (!pizzaOrders.isEmpty()) {
                        System.out.println("There are orders in the queue.");
                    } else {
                        System.out.println("No orders in queue.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting order processing.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
        scanner.close();
    }
}

class Main {
    public static void main(String[] args) {
        OrderLogs logs = new OrderLogs();
        PizzeriaQueue queue = new PizzeriaQueue();
        Scanner scanner = new Scanner(System.in);
        int mainChoice;
        do {
            System.out.println("Choose which operation you want to perform:");
            System.out.println("1. Manage order logs");
            System.out.println("2. Manage pizza orders queue");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1 - 3): ");
            mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1:
                    logs.handleLogs();
                    break;
                case 2:
                    queue.processOrders();
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (mainChoice != 3);
        scanner.close();
    }
}