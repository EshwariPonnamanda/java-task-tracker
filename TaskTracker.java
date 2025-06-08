import java.util.ArrayList;
import java.util.Scanner;

public class TaskTracker {
    static ArrayList<String> tasks = new ArrayList<>();
    static ArrayList<Boolean> completed = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Preloaded tasks
        tasks.add("Complete Day 2 GitHub project");
        completed.add(false);
        tasks.add("Push code to GitHub");
        completed.add(false);
        tasks.add("Drink 2L of water");
        completed.add(false);
        tasks.add("Stretch for 5 minutes");
        completed.add(false);

        while (true) {
            System.out.println("\n========= Task Tracker =========");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter a new task: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    completed.add(false);
                    System.out.println("✅ Task added!");
                    break;

                case 2:
                    System.out.println("\n📋 Your Tasks:");
                    for (int i = 0; i < tasks.size(); i++) {
                        String status = completed.get(i) ? "✅ Done" : "❌ Pending";
                        System.out.println((i + 1) + ". " + tasks.get(i) + " [" + status + "]");
                    }
                    break;

                case 3:
                    System.out.print("Enter task number to mark as done: ");
                    try {
                        int doneIndex = Integer.parseInt(scanner.nextLine()) - 1;
                        if (doneIndex >= 0 && doneIndex < completed.size()) {
                            completed.set(doneIndex, true);
                            System.out.println("🎉 Marked as done!");
                        } else {
                            System.out.println("⚠️ Invalid task number.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Invalid input. Please enter a number.");
                    }
                    break;

                case 4:
                    System.out.println("👋 Goodbye, Pinky! Keep up your streak!");
                    return;

                default:
                    System.out.println("⚠️ Invalid choice. Try again.");
            }
        }
    }
}
