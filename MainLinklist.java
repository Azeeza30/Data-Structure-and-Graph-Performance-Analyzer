import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static LinkedList linkedList = new LinkedList();

    public static void linkedListMenu() {

        int choice;

        do {

            System.out.println();
            System.out.println("---------------------------------------------");
            System.out.println("          LINKED LIST OPERATIONS");
            System.out.println("---------------------------------------------");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            System.out.println("---------------------------------------------");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter value to insert: ");
                    int insertValue = scanner.nextInt();

                    linkedList.insert(insertValue);

                    System.out.println("Value inserted successfully.");
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    int deleteValue = scanner.nextInt();

                    if (linkedList.delete(deleteValue)) {
                        System.out.println("Value deleted successfully.");
                    } else {
                        System.out.println("Value not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter value to search: ");
                    int searchValue = scanner.nextInt();

                    if (linkedList.search(searchValue)) {
                        System.out.println("Value found in the Linked List.");
                    } else {
                        System.out.println("Value not found.");
                    }
                    break;

                case 4:
                    linkedList.display();
                    break;

                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }
}
