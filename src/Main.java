
public class Main {
    public static void main(String[] args) {
        int choice;
        do {
            student[] students = handler.read();
            Menu.displayMenu();
            choice = Menu.getUserChoice();
            Menu.selection(choice, students);
        } while (choice != 0);
    }
}
