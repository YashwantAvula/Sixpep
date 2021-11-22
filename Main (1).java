import java.util.*;
import java.lang.*;
import java.util.Random;
import java.time.LocalTime; 



class Main
{
  //Arraylist to add all used words to prevent repitition. Current Score and High score variables initialized below.
  private static ArrayList<String> usedWord =new ArrayList<String>();
  private static int currScore = 0;
  private static int highScore = 0;
  private static String currentWord = "";

  //Word Array of all the words.
  private static String[] wordArr = new String[] {"moscow", "india", "brazil","pune","mumbai","camera","squid","origin","cat","tennis","winner","news","cocoa","plan","car","trek","drive","smile","trip","mango","ice","portal","panda","snake","parrot","wagon","laser","acorn","wind","tree","smile","dune","sand","worm","vapor","union","table","store","sheep","sonic","sign","shark","rock","race","fast","speed"};

  //Random Word generator and print function
  public static void randWord(String[] strArray)
  {
    Random rand = new Random();
    int numOfWords = strArray.length;
    int i = rand.nextInt(numOfWords-1);

    //If loop checks if newly generated word has already been used.
    if(usedWord.contains(strArray[i]))
    {
      i = rand.nextInt(numOfWords-1);
    }
    else
    {
      printWord(strArray,i);
    }
  }

  //Function to print and add the word to the "Used word" list.
  public static void printWord(String[] strArray, int i)
  {
    usedWord.add(strArray[i]);
    currentWord = strArray[i];
    Scanner sc = new Scanner(System.in);
    System.out.println("Your new word is: "+ strArray[i]+"\nType now...");
    long t0 = System.currentTimeMillis();
    String entryWord = sc.next();
    long t1 = System.currentTimeMillis();
    float timetaken = (t1-t0)/1000f;
    System.out.println("Time taken to type: "+ Float.toString(timetaken) + " seconds");
    checkWord(entryWord, timetaken);

  }

  //Function to check the entered word and assign points.
  public static void checkWord(String input, float time)
  {
    int x = 0;
    if(input.equals(currentWord))
    {
      if(time > 3F)
      {
        x = 0;
      }
      if((time < 3f) && (time > 2f))
      {
        currScore+= 1;
         x = 1;
      }
      if(time < 2f)
      {
        currScore+= 2;
         x = 2;
      }  
    }
    else 
    {
      x = 0;
      currScore -= 1;
    }
    if(currScore > highScore){
      highScore = currScore;
    }
    System.out.println("You scored "+x+" points, and your total is "+ currScore);
    displayMenu(wordArr);
  }


  //Function to display Menu
  public static void displayMenu(String[] wordArr)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("MENU \n1.New Word   2.Score   3.Highscore   4.Save & Quit ");
    int m = scan.nextInt();
    System.out.println("You have entered "+m);
    if(m==1)
    {
      randWord(wordArr);
    }
    if(m==2)
    {
      System.out.println("Your current score is: "+currScore);
      displayMenu(wordArr);
    } 
    if(m==3)
    {
      System.out.println("The highest score is: "+highScore);
      displayMenu(wordArr);
    }
    if(m==4)
    {System.out.println("Saving score and exiting application.");
    System.exit(0);
    }
  }

  public static void main(String[] args)
  {

    displayMenu(wordArr);
    } 
}


