import java.util.*;

public class PalindromeCheckerApp1 {

    public static void main(String[] args) {

        System.out.println("Welcome to the Palindrome Checker Management System");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully.\n");

        uc2_HardcodedPalindrome();
        uc3_StringReverse();
        uc4_CharArrayMethod();
        uc5_StackMethod();
        uc6_QueueStackMethod();
        uc7_DequeMethod();
        uc8_LinkedListPalindrome();
        uc9_RecursivePalindrome();
        uc10_CaseInsensitiveSpaceIgnoredPalindrome();
        uc11_ObjectOrientedPalindromeService();
        uc12_StrategyPatternPalindrome();
        uc13_PerformanceComparison();
    }

    // UC2: Hardcoded Palindrome
    public static void uc2_HardcodedPalindrome() {
        String input = "madam";
        boolean isPalindrome = true;

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("UC2 Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome + "\n");
    }

    // UC3: String Reverse
    public static void uc3_StringReverse() {
        String input = "level";
        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        boolean isPalindrome = input.equals(reversed);

        System.out.println("UC3 Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome + "\n");
    }

    // UC4: Char Array Method
    public static void uc4_CharArrayMethod() {
        String input = "radar";
        char[] chars = input.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("UC4 Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome + "\n");
    }

    // UC5: Stack Method
    public static void uc5_StackMethod() {
        String input = "noon";
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindrome = true;
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("UC5 Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome + "\n");
    }

    // UC6: Queue + Stack Method
    public static void uc6_QueueStackMethod() {
        String input = "civic";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("UC6 Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome + "\n");
    }

    // UC7: Deque Method
    public static void uc7_DequeMethod() {
        String input = "refer";
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.add(c);
        }

        boolean isPalindrome = true;
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("UC7 Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome + "\n");
    }

    // UC8: Linked List Based Palindrome Checker
    public static void uc8_LinkedListPalindrome() {
        String input = "level";
        Node head = null;

        for (char c : input.toCharArray()) {
            head = append(head, c);
        }

        boolean isPalindrome = isPalindromeLinkedList(head);

        System.out.println("UC8 Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome + "\n");
    }

    static class Node {
        char data;
        Node next;
        Node(char d) { data = d; }
    }

    static Node append(Node head, char c) {
        if (head == null) return new Node(c);
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = new Node(c);
        return head;
    }

    static boolean isPalindromeLinkedList(Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // UC9: Recursive Method
    public static void uc9_RecursivePalindrome() {
        String input = "madam";
        boolean isPalindrome = isPalindromeRecursive(input, 0, input.length() - 1);

        System.out.println("UC9 Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome + "\n");
    }

    static boolean isPalindromeRecursive(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return isPalindromeRecursive(s, start + 1, end - 1);
    }

    // UC10: Case Insensitive & Space Ignored
    public static void uc10_CaseInsensitiveSpaceIgnoredPalindrome() {
        String input = "A man a plan a canal Panama";
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindrome = isPalindromeRecursive(normalized, 0, normalized.length() - 1);

        System.out.println("UC10 Input : " + input);
        System.out.println("Normalized : " + normalized);
        System.out.println("Is Palindrome? : " + isPalindrome + "\n");
    }

    // UC11: OOP Service
    public static void uc11_ObjectOrientedPalindromeService() {
        String input = "racecar";
        PalindromeChecker checker = new PalindromeChecker();

        boolean isPalindrome = checker.checkPalindrome(input);

        System.out.println("UC11 Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome + "\n");
    }

    static class PalindromeChecker {
        public boolean checkPalindrome(String input) {
            Stack<Character> stack = new Stack<>();

            for (char c : input.toCharArray())
                stack.push(c);

            for (char c : input.toCharArray()) {
                if (c != stack.pop())
                    return false;
            }
            return true;
        }
    }

    // UC12: Strategy Pattern
    public static void uc12_StrategyPatternPalindrome() {
        String input = "level";

        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy dequeStrategy = new DequeStrategy();

        System.out.println("UC12 Input : " + input);
        System.out.println("StackStrategy Result : " + stackStrategy.isPalindrome(input));
        System.out.println("DequeStrategy Result : " + dequeStrategy.isPalindrome(input) + "\n");
    }

    interface PalindromeStrategy {
        boolean isPalindrome(String input);
    }

    static class StackStrategy implements PalindromeStrategy {
        public boolean isPalindrome(String input) {
            Stack<Character> stack = new Stack<>();
            for (char c : input.toCharArray()) stack.push(c);
            for (char c : input.toCharArray()) {
                if (c != stack.pop()) return false;
            }
            return true;
        }
    }

    static class DequeStrategy implements PalindromeStrategy {
        public boolean isPalindrome(String input) {
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : input.toCharArray()) deque.add(c);

            while (deque.size() > 1) {
                if (!deque.removeFirst().equals(deque.removeLast()))
                    return false;
            }
            return true;
        }
    }

    // UC13: Performance Comparison
    public static void uc13_PerformanceComparison() {
        String input = "level";

        long startStack = System.nanoTime();
        boolean stackResult = new StackStrategy().isPalindrome(input);
        long stackTime = System.nanoTime() - startStack;

        long startDeque = System.nanoTime();
        boolean dequeResult = new DequeStrategy().isPalindrome(input);
        long dequeTime = System.nanoTime() - startDeque;

        long startRecursive = System.nanoTime();
        boolean recursiveResult = isPalindromeRecursive(input, 0, input.length() - 1);
        long recursiveTime = System.nanoTime() - startRecursive;

        System.out.println("UC13 Input : " + input);
        System.out.println("--------------------------------------------");
        System.out.println("Algorithm           | Result | Time (ns)");
        System.out.println("--------------------------------------------");
        System.out.printf("StackStrategy       | %-6s | %d%n", stackResult, stackTime);
        System.out.printf("DequeStrategy       | %-6s | %d%n", dequeResult, dequeTime);
        System.out.printf("Recursive           | %-6s | %d%n", recursiveResult, recursiveTime);
        System.out.println("--------------------------------------------\n");
    }
}