import java.util.*;

class PalindromeCheckerApp1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("===================================");
        System.out.println("   PALINDROME CHECKER APPLICATION  ");
        System.out.println("===================================");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Check Palindrome (Two Pointer)");
            System.out.println("2. Check Palindrome (Reverse Loop)");
            System.out.println("3. Check Palindrome (Using Stack)");
            System.out.println("4. Check Palindrome (Stack + Queue)");
            System.out.println("5. Check Palindrome (Deque)");
            System.out.println("6. Check Palindrome (LinkedList)");
            System.out.println("7. Check Palindrome (Recursion)");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice >= 1 && choice <= 7) {

                System.out.print("Enter a string: ");
                String input = sc.nextLine();

                // Normalize input
                String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
                int n = cleaned.length();
                boolean result = false;

                switch (choice) {
                    case 1:
                        result = isPalindromeMethod1(cleaned);
                        break;
                    case 2:
                        result = isPalindromeMethod2(cleaned);
                        break;
                    case 3:
                        result = isPalindromeMethod3(cleaned);
                        break;
                    case 4:
                        result = isPalindromeMethod4(cleaned);
                        break;
                    case 5:
                        result = isPalindromeMethod5(cleaned);
                        break;
                    case 6:
                        result = isPalindromeMethod6(cleaned);
                        break;
                    case 7:
                        result = isPalindromeMethod7(cleaned, 0, n - 1);
                        break;
                }

                System.out.println(result
                        ? "It is a Palindrome!"
                        : "Not a Palindrome.");

            } else if (choice == 8) {
                System.out.println("Exiting application...");
            } else {
                System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 8);

        System.out.println("Thank you for using the Palindrome Checker App!");
        sc.close();
    }

    // Method 1: Two Pointer (Best - O(1) Space)
    public static boolean isPalindromeMethod1(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    // Method 2: Reverse Loop
    public static boolean isPalindromeMethod2(String s) {
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        return s.equals(reversed.toString());
    }

    // Method 3: Stack
    public static boolean isPalindromeMethod3(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        for (char c : s.toCharArray()) {
            if (c != stack.pop())
                return false;
        }
        return true;
    }

    // Method 4: Stack + Queue
    public static boolean isPalindromeMethod4(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (char c : s.toCharArray()) {
            stack.push(c);
            queue.add(c);
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll()))
                return false;
        }
        return true;
    }

    // Method 5: Deque
    public static boolean isPalindromeMethod5(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            deque.add(c);
        }

        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast()))
                return false;
        }
        return true;
    }

    // Method 6: LinkedList
    public static boolean isPalindromeMethod6(String s) {
        LinkedList<Character> list = new LinkedList<>();

        for (char c : s.toCharArray()) {
            list.add(c);
        }

        while (list.size() > 1) {
            if (!list.removeFirst().equals(list.removeLast()))
                return false;
        }
        return true;
    }

    // Method 7: Recursion
    public static boolean isPalindromeMethod7(String s, int i, int n) {
        if (i >= n) return true;

        if (s.charAt(i) != s.charAt(n)) {
            return false;
        }

        return isPalindromeMethod7(s, i + 1, n - 1);
    }
}
