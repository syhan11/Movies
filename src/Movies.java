/*
 * Create an application which will prompt the user to enter the name of their favorite Movie.
 * Add the Movie to an array list.  Use a loop to continue adding movies to the array until
 * the user presses q or Q.
 *
 * Once the user presses Q then print the list of movies before exiting the program.

 * HINT: You can use the .toLowerCase() method of the String class to convert the 'Q' to 'q'.
 * So if your response is stored in a variable called userAnswer then userAnswer.toLowerCase()
 * will evaluate to a 'q'. Alternatively, you can use the userAnswer.equalsIgnoreCase("q") method.


 * BONUS: Print out the list of movies sorted in alphabetical order.
 * BONUS x2: Suggest a movie to the user to watch by randomly selecting a movie from
 * the list of movies entered.
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Movies {
    public static void main (String[] args) {
        ArrayList <String> movieList = new ArrayList<String>();
        Scanner keyboard = new Scanner(System.in);
        String msg;
        boolean flag = true;

        while (flag){
            System.out.println("Enter a movie name or type 'Q' or 'q' to quit.");
            msg = keyboard.nextLine();
            if (msg.equalsIgnoreCase("q") ||
                msg.equalsIgnoreCase("Q"))
                flag = false;
            else {
                movieList.add(msg);
            }
        }

        int maxSz = movieList.size();
        Random random = new Random();

        if (maxSz != 0) {
            // print out the user's list
            System.out.println("\nYou have entered following movies.");
            for (String item : movieList)
                System.out.println(item);

            System.out.println("\nMovies in he alphabetical order are:");
            Collections.sort(movieList);
            for (String item : movieList)
                System.out.println(item);

            flag = true;
            int randNo = 0;
            String movie = "";

            while (flag) {
                System.out.println("\nWould you like to watch a movie? or type 'Q' or 'q' to quit.");
                msg = keyboard.nextLine();
                if (msg.equalsIgnoreCase("q") ||
                        msg.equalsIgnoreCase("Q"))
                    flag = false;
                else {
                    randNo = random.nextInt(maxSz);
                    movie = movieList.get(randNo);
                    System.out.println("How about " + movie + "?\n");
                }
            }
        }

    }
}
