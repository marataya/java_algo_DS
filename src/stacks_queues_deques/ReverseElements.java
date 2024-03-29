package stacks_queues_deques;

import java.util.Arrays;
import java.util.Random;

public class ReverseElements {
    public static <E> void reverse(E[] a) {
        Stack<E> buffer = new ArrayStack<>(a.length);
        for (int i = 0; i < a.length; i++) {
            buffer.push(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = buffer.pop();
        }
    }

    public static void main(String[] args) {
        var a = new Integer[10];
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            a[i] = rand.nextInt();
        }
        System.out.println(Arrays.toString(a));
    }
}
