public class Main {
    public static void main(String[] args) {
        Thread thread = new myThread();
//        thread.setDaemon(true);
        thread.start();

    }

    static class myThread extends Thread {
        @Override
        public void run() {
            System.out.println("name of the thread is "+Thread.currentThread().getName());
            System.out.println("before the sleep");
            try {
                Thread.currentThread().sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("after the sleep");
        }
    }
}