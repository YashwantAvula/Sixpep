import java.util.Scanner;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;



class Main {

  private static List<Integer> list1 = new ArrayList<Integer>();

  public static void displayMenu()
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter Stock prices of today, Example: 10,30,12,53,17,39,40,50");
    String line = scan.nextLine();
    String[] l1 = line.split(",");
    System.out.println("Enter the maximum number of transactions: ");
    int x = scan.nextInt();

    for(int i = 0; i < l1.length; i++){
      list1.add(Integer.valueOf(l1[i]));
    }

    stockEx(x);
    //System.out.println(list1);
    //for(String i: l1) intList.add(Integer.valueOf(i));
    //System.out.println("You have entered "+list1);
  }

  public static void stockEx(int x)
  {
    int v1;
    int v2;
    int v3;
    int count = 0;
    int profit = 0;


    for(int i = 0; i < list1.size()-2; i++){
      
      v1 = list1.get(i);
      v2 = list1.get(i+1);
      v3 = list1.get(i+2);

      if(v2>v1 && v3<v2){
        System.out.println("Buy at "+v1+" and Sell at "+v2);
        profit += (v2-v1);
        i++;
        count++;
      }

      else if(v3>v2 && v3>v1){
        System.out.println("Buy at "+v1+" and sell at "+v3); 
        profit += (v3-v1);
        i =i+2;
        count++;
        }
      }
    if(count==x){
      System.out.println("Maximum Transaction Limit Reached");
    }

  }

  public static void main(String[] args) {
    System.out.println("Hello world!");
    displayMenu();
  }
}
