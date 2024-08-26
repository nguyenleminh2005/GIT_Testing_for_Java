public class Main {
  public static void main(String[] args) {
      for(int i = 1; i <= 5; i++){
        MyThread myThread = new MyThread(i);
        myThread.start(); 
        try {
           Thread.sleep(1000);
        } catch (InterruptedException e) {
          System.out.println("Main thread bị gián đoạn");
        }
      }
  }
}