import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    private final TodoList todoList = new TodoList();
    private final Scanner scanner = new Scanner(System.in);
    private boolean running = true;

    public void run() {
        System.out.println("=== TODO (Simple) ===");
        while (running) {
            showMenu();
            if (!scanner.hasNextLine())
                break;
            String choice = scanner.nextLine().trim();
            handleChoice(choice);
        }
        System.out.println("Bye!");
    }

    private void showMenu() {
        System.out.println();
        System.out.println("1) Add task");
        System.out.println("2) List tasks");
        System.out.println("3) Mark DONE by id");
        System.out.println("4) Remove by id");
        System.out.println("5) Quit");
        System.out.print("Choose: ");
    }

    private void handleChoice(String choice) {
        if ("1".equals(choice)) {
            addTask();
        } else if ("2".equals(choice)) {
            listTasks();
        } else if ("3".equals(choice)) {
            markDone();
        } else if ("4".equals(choice)) {
            removeTask();
        } else if ("5".equals(choice)) {
            running = false;
        } else {
            System.out.println("[ERROR] Invalid option.");
        }
    }

    private void addTask() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Description: ");
        String desc = scanner.nextLine();
        int id = todoList.add(title, desc);
        System.out.println("[INFO] Added task id " + id);
    }

    private void removeTask() {
        System.out.print("Enter id to remove: ");
        String s = scanner.nextLine();
        int id = Integer.parseInt(s);
        boolean ok = todoList.remove(id);
        System.out.println(ok ? "[INFO] Removed." : "[ERROR] Not found.");
    }

    private void listTasks() {
        ArrayList<TodoItem> items = todoList.getItems();
        if (items.isEmpty()) {
            System.out.println("[INFO] No tasks yet.");
            return;
        }
        System.out.println("--- Tasks ---");
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).summary());
        }
    }

    private void markDone() {
        System.out.print("Enter id to mark DONE: ");
        String s = scanner.nextLine();
        try {
            int id = Integer.parseInt(s);
            boolean ok = todoList.markDone(id);
            System.out.println(ok ? "[INFO] Marked DONE." : "[ERROR] Not found.");
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Please enter a numeric id.");
        }
    }
}
