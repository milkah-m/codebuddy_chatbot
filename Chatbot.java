import java.util.Random;
import java.util.Scanner;

public class Chatbot {

//initiating my random picker
static Random random = new Random();

// helper method - takes a String array and returns one random item from it
//shared across all methods so we don't create a new Random every time
static String pickRandom (String[] options) {
 return options[random.nextInt(options.length)];
}
public static void main(String[] args) {
// reads from keyboard input (System.in)
Scanner scanner = new Scanner(System.in);
 boolean isRunning = true;

//using ASCII to improve user interface on startup
System.out.println("     ██╗ █████╗ ██╗   ██╗ █████╗ ");
System.out.println("     ██║██╔══██╗██║   ██║██╔══██╗");
System.out.println("     ██║███████║██║   ██║███████║");
System.out.println("██   ██║██╔══██║╚██╗ ██╔╝██╔══██║");
System.out.println("╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║");
System.out.println(" ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝");
System.out.println("     Java-Powered Chatbot v1.0     ");
System.out.println("==========================================");
System.out.println("👋 Hey there! I'm Javabot - your coding sidekick!");
System.out.println("💡 Type 'help' to see what I can do.");
System.out.println("==========================================");

// keeps conversation alive until user explicitly exits
while (isRunning){
   System.out.print("You: ");

//cleaning up the input by converting to lowercase and removing whitespace
String input = scanner.nextLine().toLowerCase().trim();

//handling empty responses gracefully
if (input.isEmpty()){
    System.out.println("Bot: Say something! I'm all ears😊");
    continue;
}

//RESPONSES: ordered from specific to general to avoid confusion
   //using .contains to simply detect keywords within the input
 if (input.contains("exit") || input.contains("bye")) {
                String[] goodbyes = {
                    "Bot: Goodbye! Keep coding! 👋",
                    "Bot: See you later! You're doing great! 🚀",
                    "Bot: Bye! Don't forget to compile before you run! 😄"
                };
                System.out.println(pickRandom(goodbyes));
                isRunning = false;

            } else if (input.contains("help")) {
                System.out.println("Bot: Here's what I understand:");
                System.out.println("     👋 Greetings  - say hello or hi");
                System.out.println("     😂 Jokes      - ask for a joke");
                System.out.println("     🤖 About      - ask about me");
                System.out.println("     💻 Coding     - talk about coding");
                System.out.println("     ☕ Java       - talk about Java");
                System.out.println("     🌐 JavaScript - talk about JS");
                System.out.println("     👋 Exit       - say bye or exit");

            } else if (input.contains("hello") || input.contains("hi") || input.contains("hey")) {
                String[] greetings = {
                    "Bot: Hey there! Great to see you! 😄",
                    "Bot: Hello there! Ready to talk code? 💻",
                    "Bot: Hi! Hope you're having an awesome day! ☀️",
                    "Bot: Hey! What's on your mind? 🤔"
                };
                System.out.println(pickRandom(greetings));

            } else if (input.contains("joke")) {
                String[] jokes = {
                    "Bot: Why do Java developers wear glasses?\nBot: Because they don't C#! 😂",
                    "Bot: Why did the developer go broke?\nBot: Because they used up all their cache! 💸",
                    "Bot: How do you comfort a JavaScript bug?\nBot: You console it! 🤣",
                    "Bot: Why do programmers prefer dark mode?\nBot: Because light attracts bugs! 🐛"
                };
                System.out.println(pickRandom(jokes));

            } else if (input.contains("about you") || input.contains("about yourself")) {
                System.out.println("Bot: I'm JavaBot (JB for short) - a chatbot built with Java! ☕");
                System.out.println("Bot: I was created by a JavaScript developer who was brave enough to learn Java 💪");
                System.out.println("Bot: I must admit though... I'm still learning 😊! But that makes two of us, right?");

            } else if (input.contains("javascript") || input.contains("js")) {
                String[] jsResponses = {
                    "Bot: JavaScript! Great language - no semicolons required... wait 😄",
                    "Bot: Ah JS! Did you know Java and JavaScript are as related as Car and Carpet? 🤣",
                    "Bot: JavaScript developer learning Java? Respect! 💪"
                };
                System.out.println(pickRandom(jsResponses));

            } else if (input.contains("java")) {
                String[] javaResponses = {
                    "Bot: Java! Verbose but powerful ☕",
                    "Bot: Java - where you need 10 lines to do what JS does in 2! But worth it 😄",
                    "Bot: You're literally talking to a Java program right now! Meta right? 🤯"
                };
                System.out.println(pickRandom(javaResponses));

            } else if (input.contains("coding") || input.contains("programming")) {
                String[] codingResponses = {
                    "Bot: Coding is tough but you're doing amazing! Keep going! 💪",
                    "Bot: Every expert was once a beginner. You've got this! 🌱",
                    "Bot: Every bug you fix is proof you're getting better! Keep pushing! 🌟"
                };
                System.out.println(pickRandom(codingResponses));

            } else if (input.contains("how are you") || input.contains("how r u")) {
                String[] moodResponses = {
                    "Bot: I'm just a bunch of if/else statements but I'm feeling great! 😄",
                    "Bot: Compiling perfectly today, thanks for asking! ☕",
                    "Bot: Running at 100% efficiency! How about you? 🤖"
                };
                System.out.println(pickRandom(moodResponses));

            } else if (input.contains("name")) {
                System.out.println("Bot: My name is JavaBot or JB for short! ☕ Named after my favourite language!");

            } else {
                String[] confused = {
                    "Bot: Hmm I'm not sure about that one. Try 'help'! 🤔",
                    "Bot: I don't understand that one yet! I'm still learning 😅. Maybe try 'help'?",
                    "Bot: That's beyond my current if/else knowledge 😄 Try 'help'!"
                };
                System.out.println(pickRandom(confused));
            }

             // this adds a blank line between exchanges for readability
            System.out.println(); 
        }

        scanner.close();
    }
}


