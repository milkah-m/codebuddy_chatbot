package practice;
// import java.util.Scanner;

// public class InputTest {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         System.out.println("Say hello to me!");
//         String input = scanner.nextLine();

//         // Remember: .equals() not == for strings!
//         if (input.equals("hello")) {
//             System.out.println("Hey there! 👋");
//         } else if (input.equals("hi")) {
//             System.out.println("Hi yourself! 😄");
//         } else {
//             System.out.println("I don't understand '" + input + "' yet!");
//         }

//         scanner.close();
//     }
// }

//1. import statement
import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) {

        //2, create a scanner which serves as my ears for input
        Scanner scanner = new Scanner(System.in);

        //3. initiate conversation with the user
        System.out.println("Start a conversation by saying a simple hello to your coding sidekick!");
        String greeting = scanner.nextLine() .toLowerCase();
       

       if (greeting.equals("hello")){
         System.out.println("Heyyy there 😊");
       }
       else if (greeting.equals("hi")){
        System.out.println("Hi yourself 😀");
       }
       else{
        System.out.println("Sorry, unfortunately I do not know how to respond to " + greeting + " yet");
    };

        //6. close the scanner when i am done
        scanner.close();


    }
}

// 1. import statement
// import java.util.Scanner;

// public class InputTest {
//     public static void main(String[] args) {

//         //2, create a scanner which serves as my ears for input
//         Scanner scanner = new Scanner(System.in);

//         //3. initiate conversation with the user
//         System.out.println("What is your name?");

//         //4. wait to read the user's input
//         String name = scanner.nextLine();

//         System.out.println("What is your fave programming language?? I'm curious");
//         String language = scanner.nextLine();

//         //5.respond to user
//         System.out.println("Hey " + name + "! Welcome to Java! 🚀");
//         System.out.println(language + " is great! But between you and me, I think Java is better😁");

//         //6. close the scanner when i am done
//         scanner.close();


//     }
// }