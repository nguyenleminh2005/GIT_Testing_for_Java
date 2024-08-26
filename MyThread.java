public class MyThread extends Thread {
  public int ThreadNumber; 

  public MyThread(int _ThreadNumber) {
    ThreadNumber = _ThreadNumber;
  }

  @Override
  public void run() {
      for (int i = 1; i <= 5; i++) {
          System.out.println(i + " Thread " + ThreadNumber);
          try {
              Thread.sleep(1000);
          } catch (InterruptedException e) {
              System.out.println("Thread bị gián đoạn");
              // Có thể thêm các hành động khôi phục khác ở đây
          }
      }
  }
}