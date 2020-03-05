public class Main {
    public static void main(String[] args) {
        String [] strings = {"казак", "шалаш", "малыш", "кабак"};
        for (String str : strings) {
            Deque<Character> deque = new Deque<>();
            for (int i = 0; i < str.length(); i += 1) {
                deque.addFront(str.charAt(i));
            }
            if (isPalidrome(deque)) {
                System.out.println(String.format("%s\t- палидром", str));
            } else {
                System.out.println(String.format("%s\t- не палидром", str));
            }
        }
    }

    public static boolean isPalidrome(Deque deque) {
        while(deque.size() != 1) {
            if (deque.removeTail().toString().equals(deque.removeFront().toString())) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}