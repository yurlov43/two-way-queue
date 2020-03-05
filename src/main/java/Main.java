public class Main {
    public static void main(String[] args) {
        String [] strings = {"казак", "шалаш", "малыш", "кабак", "абба"};
        for (String str : strings) {
            Deque<Character> deque = new Deque<>();
            for (int i = 0; i < str.length(); i += 1) {
                deque.addFront(str.charAt(i));
            }
            if (isPalindrome(deque)) {
                System.out.println(String.format("%s\t- палиндром", str));
            } else {
                System.out.println(String.format("%s\t- не палиндром", str));
            }
        }
    }

    public static boolean isPalindrome(Deque deque) {
        while(deque.size() != 1 && deque.size() % 2 != 0) {
            if (deque.removeTail().toString().equals(deque.removeFront().toString())) {
                continue;
            } else {
                return false;
            }
        }
        while(deque.size() != 0 && deque.size() % 2 == 0) {
            if (deque.removeTail().toString().equals(deque.removeFront().toString())) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}