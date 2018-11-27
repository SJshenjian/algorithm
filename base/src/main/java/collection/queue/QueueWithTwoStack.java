package collection.queue;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * 用两个栈模拟队列
 *
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/26
 */
public class QueueWithTwoStack<E> {

    private Stack<E> firstStack;
    private Stack<E> twoStack;

    public QueueWithTwoStack() {
        firstStack = new Stack<>();
        twoStack = new Stack<>();
    }

    public void add(E e) {
        firstStack.push(e);
    }

    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is Empty");
        }
        if (twoStack.isEmpty()) {
            moveFirstStack2TwoStack();
        }
        return twoStack.pop();
    }

    public int size() {
        return firstStack.size() + twoStack.size();
    }

    public boolean isEmpty() {
        return firstStack.size() == 0 && twoStack.size() == 0;
    }

    private void moveFirstStack2TwoStack() {
        while (!firstStack.isEmpty()) {
            twoStack.push(firstStack.pop());
        }
    }
}
