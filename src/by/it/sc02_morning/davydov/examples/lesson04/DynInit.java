package by.it.sc02_morning.davydov.examples.lesson04;

// Demonstrate dynamic initialization.
class DynInit { 
    public static void main(String args[]) { 
      double radius = 4, height = 5; 
 
      // dynamically initializ volume 
      double volume = 3.1416 * radius * radius * height; 
 
      System.out.println("Volume is " + volume); 
    } 
}