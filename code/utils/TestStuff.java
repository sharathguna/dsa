package code.utils;

public class TestStuff {
  public static void main(String[] args) {
    Increment();
  }
  public static void Increment(){
    for (int i=0;i<=10;i++) {
      System.out.println("i values is "+i);
      //int x = i++;
      System.out.println("x values is "+ ++i);
    }
  }
}
