package multithread;

public class ProdCon {

    private Buffer buffer;
    private Producer producer;
    private Consumer consumer;

    public ProdCon() {
        buffer   = new Buffer(10);
        producer = new Producer();
        consumer = new Consumer();
    }

    public void startThreads() {
        producer.start();
        consumer.start();
    }


    private class Producer extends Thread {

        public void produce() {
            while (true) {
                for (int i = 0; i < 10; i++) {
                    double item = Math.random() * 100;
                    buffer.add(item);
                }
            }
        }

        @Override
        public void run() {
            produce();
        }
    }

    private class Consumer extends Thread {

        public void consume() {
            while (true) {
                for (int i = 0; i < 10; i++) {
                    buffer.remove();
                }
            }
        }

        @Override
        public void run() {
            consume();
        }
    }

    public static void main(String[] args) {
        ProdCon pTest = new ProdCon();
        pTest.startThreads();
    }
}