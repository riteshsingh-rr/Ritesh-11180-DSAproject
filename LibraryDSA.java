
import java.util.Scanner;
import java.util.Arrays;

class LibraryDSA {

    static int[] bookId = new int[100];
    static String[] bookName = new String[100];
    static int count = 0;

    static Scanner sc = new Scanner(System.in);

    // Add Book
    static void addBook() {
        if (count == 100) {
            System.out.println("Library is full!");
            return;
        }

        System.out.print("Enter Book ID: ");
        bookId[count] = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name: ");
        bookName[count] = sc.nextLine();

        count++;

        System.out.println("Book Added Successfully!");
    }

    // Display Books
    static void displayBooks() {
        if (count == 0) {
            System.out.println("No books available!");
            return;
        }

        System.out.println("\n--- Library Books ---");

        for (int i = 0; i < count; i++) {
            System.out.println(
                "ID: " + bookId[i] +
                " | Name: " + bookName[i]
            );
        }
    }

    // Linear Search by ID
    static void searchBookById() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (bookId[i] == id) {
                System.out.println("Book Found!");
                System.out.println("Book Name: " + bookName[i]);
                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    // Bubble Sort by Book ID
    static void sortBooks() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {

                if (bookId[j] > bookId[j + 1]) {

                    int tempId = bookId[j];
                    bookId[j] = bookId[j + 1];
                    bookId[j + 1] = tempId;

                    String tempName = bookName[j];
                    bookName[j] = bookName[j + 1];
                    bookName[j + 1] = tempName;
                }
            }
        }

        System.out.println("Books Sorted Successfully!");
        displayBooks();
    }

    // Binary Search by Book ID
    static void binarySearch() {
        sortBooks();

        System.out.print("Enter Book ID to Search: ");
        int id = sc.nextInt();

        int low = 0;
        int high = count - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (bookId[mid] == id) {
                System.out.println("Book Found!");
                System.out.println("Book Name: " + bookName[mid]);
                return;
            }

            if (bookId[mid] < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println("Book Not Found!");
    }

    // Fine Calculator
    static void calculateFine() {
        System.out.print("Enter Late Days: ");
        int days = sc.nextInt();

        int fine = 0;

        if (days > 0) {
            fine = days * 5;
        }

        System.out.println("Total Fine: Rs. " + fine);
    }

    // Main Menu
    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book (Linear Search)");
            System.out.println("4. Sort Books (Bubble Sort)");
            System.out.println("5. Search Book (Binary Search)");
            System.out.println("6. Calculate Fine");
            System.out.println("7. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;

                case 2:
                    displayBooks();
                    break;

                case 3:
                    searchBookById();
                    break;

                case 4:
                    sortBooks();
                    break;

                case 5:
                    binarySearch();
                    break;

                case 6:
                    calculateFine();
                    break;

                case 7:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);
    }
}
