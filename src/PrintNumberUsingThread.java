 public class PrintNumberUsingThread {
    public static void main(String[] args) {
        Thread thread1=new Thread(new SequenceGenrator(1),"Thread-1");
        Thread thread2=new Thread(new SequenceGenrator(2),"Thread-2");
        Thread thread3=new Thread(new SequenceGenrator(0),"Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
  class SequenceGenrator implements Runnable{
    public int numberUpto=10;
    static int number=1;
    int rem;
    static Object lock=new Object();
    public SequenceGenrator(int rem){
        this.rem=rem;
    }

      @Override
      public void run() {
        synchronized (lock) {
          while (number < numberUpto-1) {
                  while (number % 3 != rem) { // wait for numbers other than remainder
                      try {
                         lock. wait();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
                  System.out.println(Thread.currentThread().getName() + " " + number);
                  number++;
                  lock.notifyAll();
              }
          }
      }
  }

