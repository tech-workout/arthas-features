package com.arthas.features;

/**
 * @author Sujith Ramanthan
 *
 * commands
 * <li>retransform /Users/atc/Sujith/intellij/practice/tech-workout/arthas-features/class-file/HotReload.class</li>
 *
 * Documentation
 * https://arthas.aliyun.com/en/doc/retransform.html
 */
public class HotReload {

  public void greet() {
    try {
      System.out.println("Hello world !!!");
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    HotReload hReload = new HotReload();
    while(true) {
      hReload.greet();
    }
  }

}
