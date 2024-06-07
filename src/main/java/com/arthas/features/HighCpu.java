package com.arthas.features;

/**
 * @author Sujith Ramanathan
 * <p>
 * Command:- dashboard -i 2000
 *
 * <ul>
 * <li>Documentation link</li>
 * <li>https://arthas.aliyun.com/en/doc/dashboard.html</li>
 * </ul>
 */

public class HighCpu {

  public static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static long fibonacci(int n) {
    if (n == 0 || n == 1)
      return 1L;
    else
      return fibonacci(n - 1) + fibonacci(n - 2);
  }

  public static void main(String[] args)throws Exception {
    System.out.println("Hit Return / Enter to continue ");
    System.in.read();
    Thread t1 = new Thread(() -> {
      String tName = Thread.currentThread().getName();
      for (int i = 1; i < 100; i++) {
        long result = fibonacci(i);
        System.out.println(String.format("%s - fib(%d): %d ", tName, i, result));
      }
    }, "app-thread-1");

    Thread t2 = new Thread(() -> {
      String tName = Thread.currentThread().getName();
      while (true) {
        for (int i = 1; i < 10; i++) {
          long result = fibonacci(i);
          System.out.println(String.format("%s - fib(%d): %d ", tName, i, result));
        }
        sleep(10000);
      }
    }, "app-thread-2");
    t1.start();
    t2.start();
  }

}
