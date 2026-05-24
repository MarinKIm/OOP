package multithread;

import java.util.ArrayList;

public class Buffer {
    private ArrayList<Double> buffer;
    private int size;

    public Buffer(int size) {
        this.size = size;
        buffer = new ArrayList<>();
    }

    public synchronized void add(double item) {
        while (buffer.size() == size) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        buffer.add(item);
        System.out.println("Adding item " + item);
        notifyAll();
    }

    public synchronized double remove() {
        while (buffer.isEmpty()) {
            try {
                System.out.println("Buffer is empty.");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        double item = buffer.remove(buffer.size() - 1);
        System.out.println("Removing item " + item);
        notifyAll();
        return item;
    }
}