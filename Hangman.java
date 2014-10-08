package hangman;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Matt Tupper
 */
public class Hangman {
    
    // accesses specific text file, creates arraylist of words
    @SuppressWarnings("empty-statement")
    public static ArrayList<String> create(String file) throws FileNotFoundException{
        ArrayList<String> words = new ArrayList<>();
        Scanner in = new Scanner(new FileReader(file));
        while (in.hasNext()){words.add(in.next());};
        return words;
    }
    
    
    public static String getRandom(ArrayList<String> words){
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(words.size());
        System.out.println("Number of Letters: " + (words.get(index)).length());
        return words.get(index);
    }
    
    // prints what letters you have discovered so far, undiscovered letters printed as "*"
    public static void printResult(String[] result){
        String r = "";
        int i;
        for(i = 0; i < result.length; i++){
            r = r + result[i];
        }
        System.out.println(r);
    }
    
    // if user tries to enter a discovered letter...
    public static boolean containsLoop(String[] arr, String targetValue) {
	for(String s: arr){
		if(s.equals(targetValue))
			return true;
	}
	return false;
}
    
        
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException{
        
        int open = 0;
        int wins = 0;
        int losses = 0;
        while(open == 0){
        ArrayList<String> used = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String random;
        int rLength;
        int i;
        
        words = create("dictionary.txt");
        random = getRandom(words);
        rLength = random.length();
        
        String[] result = new String[rLength];
        for(i = 1; i <= rLength; i++){
            result[i-1] = "*";
    }
        printResult(result);
        
        int hangman = 0;
        int winIf = random.length();
        int tally = 0;
        String letter = "";
        Scanner user_input = new Scanner(System.in);
        
        while(hangman < 10 && tally < winIf){
            int cont = 0;
            int trip = 0;
            while(cont == 0){                
                System.out.print("Enter a letter: ");
                letter = user_input.next();
                if (letter.length() != 1){
                    System.out.println("You must enter only one letter!");
                }
                else if(containsLoop(result, letter)) {
                    System.out.println("Letter already used!");
                }
                else cont = 1;
                }
            
            used.add(letter);
            
            //check if inputed letter in answer
            for(i = 0; i < random.length(); i++){
                String rChar = "" + random.charAt(i);
                if(rChar.equals(letter)){
                    tally = tally + 1;
                    trip = 1;
                    result[i] = letter;
                }
            }
            if (trip == 0){
                hangman = hangman + 1;
                System.out.println("Letter not in word!");
            }
            else System.out.println("Letter in word!");
            
            printResult(result);
            
            // convert used array to printable string
            //String listString = "";            
            for (String s : used){
                sb.append(s);
                sb.append(", ");
            }
            
            System.out.println("Hangman: " + hangman);
            System.out.println("Used: " + sb.toString());
            sb.setLength(0);
            }
        
       if (hangman == 10) {
           losses++;
           System.out.println("You lost!");
           System.out.println("Answer: " + random);
           System.out.println("Wins: " + wins + ", Losses: " + losses);
           System.out.println("Starting new game.");
           System.out.println("-----------------------------------------------------------------------------------");
       }
       else {
           wins++;
           System.out.println("You won!");
           System.out.println("Wins: " + wins + ", Losses: " + losses);
           System.out.println("Starting new game.");
           System.out.println("------------------------------------------------------------------------------------");
       }
       
    }
    }  
}
