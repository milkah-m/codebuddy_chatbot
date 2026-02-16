# 🤖 CodeBuddy Chatbot: Your Java Sidekick

### Prompt-Powered Kickstart: Learning Java by Building a CLI Chatbot

**By Milkah Gathoni Mwangi**

---

## Who is this toolkit for?

> "This toolkit is intended for developers with prior programming experience (e.g. JavaScript) who want a fast, practical introduction to Java using AI-assisted learning."

---

## 1. Title & Objective

### What technology did I choose?

**Java** — a strongly typed, compiled, object-oriented programming language widely used in backend development, Android apps, and enterprise software.

### Why Java?

Honestly? Because I had never touched it before. I came into this project as a JavaScript developer and I wanted to pick something completely outside my comfort zone. Java felt like the right challenge — it's widely used, it's been around forever, and I've heard it said that it is *complex*. I wanted to find out for myself.

### What were my end goals?

I had two goals going into this project:

1. **Learn how to use AI as a learning tool** — not just to get answers, but to actually understand what I was building
2. **Experience learning a new language on speed mode** — using effective AI prompting as a study method

The chatbot was merely a means to an end. The real growth for me was in the learning process itself.

---

## 2. Quick Summary of Java

### What is Java?

Java is a **statically typed, compiled, object-oriented programming language** first released in 1995. Unlike JavaScript (which runs in the browser or via Node.js), Java code is compiled into **bytecode** that runs on the **Java Virtual Machine (JVM)** — meaning it can run on any operating system that has the JVM installed.

### Where is it used?

- Backend web development (Spring Boot)
- Android mobile app development
- Enterprise software systems
- Banking and financial systems
- Big data tools (Apache Hadoop, Kafka)

### One real-world example

**Android apps** — the majority of Android applications have historically been built in Java. When you use an app like Equity Mobile or Bolt on Android, there's a good chance there's some Java in there somewhere.

### Key difference from JavaScript

| Feature | JavaScript | Java |
|---------|-----------|------|
| Typing | Dynamic (`let x = 5`) | Static (`int x = 5`) |
| Execution | Interpreted (runs directly) | Compiled (compile → run) |
| Entry point | Top of file / any function | `public static void main()` |
| String comparison | `===` | `.equals()` |
| Everything in a class? | No | Yes |

My main takeaway: *Java is JavaScript but verbose. Very, very verbose. Can we say it in two words instead of 15? Well... apparently not.* 😄

---

## 3. System Requirements

| Requirement | Details |
|-------------|---------|
| Operating System | Windows (with WSL - Ubuntu), macOS, or Linux |
| Java JDK | OpenJDK 17 or newer |
| Code Editor | VS Code (with Java Extension Pack) |
| Terminal | WSL (Ubuntu) terminal on Windows, or native terminal on Mac/Linux |
| Extensions | VS Code: WSL (Microsoft) + Extension Pack for Java (Microsoft) |

---

## 4. Installation & Setup Instructions

### Step 1: Install Java JDK (WSL/Ubuntu)

Open your WSL terminal and run:

```bash
# Update package list
sudo apt update

# Install Java JDK 17
sudo apt install openjdk-17-jdk -y
```

Verify installation:

```bash
java -version
javac -version
```

Expected output:

```
openjdk version "17.0.x" ...
javac 17.0.x
```

---

### Step 2: Set Up VS Code for Java

1. Install the **WSL** extension in VS Code (by Microsoft)
2. Install the **Extension Pack for Java** in VS Code (by Microsoft)
3. Open VS Code connected to WSL:

```bash
# From your WSL terminal
code .
```

Confirm it's working: the bottom-left corner of VS Code should show **"WSL: Ubuntu"** in green.

---

### Step 3: Create Your Project Folder

```bash
mkdir ~/java-chatbot
cd ~/java-chatbot
code .
```

---

### Step 4: Verify with Hello World

Create a file called `HelloWorld.java`:

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello from Java!");
    }
}
```

Compile and run:

```bash
javac HelloWorld.java
java HelloWorld
```

Expected output:

```
Hello from Java!
```

**Key Java Feature:** Java requires TWO steps — compile first (`javac`), then run (`java`). Every time you make a change, you must recompile!

---

## 5. Minimal Working Example

### Project: JavaBot — A CLI Chatbot in Java

A terminal-based chatbot that accepts user input, detects keywords, and responds with predefined (randomly varied) responses.

### Full Source Code

```java
import java.util.Scanner;
import java.util.Random;

public class Chatbot {

    // Shared across all methods - no object needed
    static Random random = new Random();

    // Helper method: takes a String array and returns one random item
    static String pickRandom(String[] options) {
        return options[random.nextInt(options.length)];
    }

    public static void main(String[] args) {

        // Setup
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        // ASCII art welcome screen
        System.out.println("     ██╗ █████╗ ██╗   ██╗ █████╗ ");
        System.out.println("     ██║██╔══██╗██║   ██║██╔══██╗");
        System.out.println("     ██║███████║██║   ██║███████║");
        System.out.println("██   ██║██╔══██║╚██╗ ██╔╝██╔══██║");
        System.out.println("╚█████╔╝██║  ██║ ╚████╔╝ ██║  ██║");
        System.out.println(" ╚════╝ ╚═╝  ╚═╝  ╚═══╝  ╚═╝  ╚═╝");
        System.out.println("      Java-Powered Chatbot v1.0    ");
        System.out.println("==========================================");
        System.out.println("👋 Hey there! I'm JavaBot - your coding sidekick!");
        System.out.println("💡 Type 'help' to see what I can do.");
        System.out.println("==========================================\n");

        // Keeps conversation alive until user explicitly exits
        while (isRunning) {
            System.out.print("You: ");

            // Clean input - lowercase and trim whitespace
            String input = scanner.nextLine().toLowerCase().trim();

            // Handle empty input gracefully
            if (input.isEmpty()) {
                System.out.println("Bot: Say something! I'm all ears 😊");
                continue;
            }

            // RESPONSES: ordered from specific to general to avoid keyword conflicts
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
                System.out.println("Bot: I'm still learning 😊 But that makes two of us, right?");

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

            // Blank line between exchanges for readability
            System.out.println();
        }

        scanner.close();
    }
}
```

### How to Run

```bash
javac Chatbot.java && java Chatbot
```

### Expected Output

```
     ██╗ █████╗ ██╗   ██╗ █████╗
     ...
👋 Hey there! I'm JavaBot - your coding sidekick!
💡 Type 'help' to see what I can do.
==========================================

You: hello
Bot: Hey there! Great to see you! 😄

You: tell me a joke
Bot: Why do programmers prefer dark mode?
Bot: Because light attracts bugs! 🐛

You: bye
Bot: See you later! You're doing great! 🚀
```

### What the Code Does

- **Scanner** reads keyboard input from the user
- **while loop** keeps the conversation going until the user exits
- **.toLowerCase().trim()** cleans the input so capitalisation and spaces don't break matching
- **.contains()** detects keywords anywhere in a sentence (not just exact matches)
- **if/else chain** (ordered from specific to general) routes input to the right response
- **pickRandom()** selects a random response from an array so the bot doesn't repeat itself
- **ASCII art** gives the chatbot a polished, professional welcome screen

---

## 6. AI Prompt Journal

For this project, I chose to use Claude (claude.ai). I had actually never interacted with Claude until I started this course and honestly, I am so grateful that I discovered this platform.

### My Core Prompting Strategy

One of my most consistent and effective prompting strategies throughout this project was asking Claude to **test my understanding after every major concept** by ending explanations with follow-up questions. For example:

> *"...give me the logic behind it and then ask me 3 follow up questions to test my understanding please and thank you"*

> *"...please follow up questions to test my understanding and comprehension"*

> *"...please ask me 3 follow up questions"*

Rather than just receiving information and moving on, this forced me to actually process and own each concept before progressing. My answers to those questions often revealed gaps in my understanding I didn't know I had — and Claude would correct them immediately. This pattern was one of the most valuable things I did throughout the entire project.

---

### The AI-Generated Project Plan

My very first prompt produced this 7-phase roadmap, which I then followed step by step:

> **Phase 1: Environment Setup** *(30-45 min)*
> Install Java JDK, choose an IDE, create the first project, write and run "Hello World" to verify everything works.
>
> **Phase 2: Understanding Java Basics** *(1-2 hours)*
> Learn static typing, the main method, classes, compilation vs interpretation, and String comparison — all using JavaScript analogies.
>
> **Phase 3: Input/Output Basics** *(45 min - 1 hour)*
> Learn the Scanner class for reading user input and System.out.println() for output.
>
> **Phase 4: Build the Input Loop** *(1 hour)*
> Build a while loop with a boolean flag that keeps the chatbot running until the user types an exit command.
>
> **Phase 5: Conditional Responses** *(1.5 - 2 hours)*
> Use if/else and String methods like .toLowerCase(), .contains(), and .equals() to respond based on keywords.
>
> **Phase 6: Add Personality & Polish** *(1-2 hours)*
> Add random varied responses, an ASCII art welcome screen, a bot name and backstory, and handle edge cases like empty input.
>
> **Phase 7: Testing & Refinement** *(30 min - 1 hour)*
> Test all keywords, fix bugs, clean up code, and add meaningful comments.
>
> **Total estimated time: 8-10 hours**

Having this roadmap upfront meant I was never lost — I always knew exactly what phase I was in and what the next step would look like.

---

### Prompt 1 — Project Scoping

**My prompt:**

> *"Act as my senior software developer mentor and guide me through building a beginner-friendly Java CLI chatbot. Keep in mind that I am completely new to Java. I have some JavaScript knowledge so please use analogies that relate with JavaScript especially to help me understand new concepts in Java. For the chatbot please help me design a minimal feature set that is simple, interactive, and suitable for a learning project. Give me a step-by-step breakdown of what this process will look like and a time estimate of how long it should take."*

**Response summary:** Claude took on the role of senior developer mentor, designed the 7-phase roadmap above, and outlined a feature set for a themed CLI chatbot with an input loop, conditional responses, and an exit command. Time estimate: 8-10 hours.

**Reflection:** Starting with a scoping prompt was the right call. It gave me a clear map before writing a single line of code. Asking Claude to *act as* a mentor — rather than just answer questions — meant the responses were structured for teaching, not just information delivery. I also specified my background (JavaScript) so the analogies would be relevant to me specifically.

---

### Prompt 2 — Environment Setup with Full Context

**My prompt:**

> *"I'm currently using VS Code and when I ran the Java version I got command not found. My OS: I'm using WSL so I'm using Linux on Windows."*

**Response summary:** Claude gave me WSL-specific installation commands (`sudo apt install openjdk-17-jdk`), VS Code extension recommendations (WSL + Extension Pack for Java), and instructions for opening VS Code in WSL mode using `code .`

**Reflection:** Giving Claude my full context upfront — VS Code, no Java installed, WSL on Windows — meant the instructions were immediately tailored to my exact setup. Generic Java tutorials don't account for WSL's specific behaviour. This is a good example of how specificity in prompting saves time.

---

### Prompt 3 — Debugging by Sharing Terminal Evidence

**My prompt (across several messages):**

> *"still no class file...?"*
>
> *(shared `ls -la` output showing no HelloWorld.class file)*
>
> *(shared `cat HelloWorld.java` output — which showed the entire code was commented out)*

**Response summary:** Claude attempted to give me several solutions including flagging the commented out code, but the eventual root cause was that I had simply not saved the file before compiling 😂.

**Reflection:** The most effective thing I did here was share the actual terminal output rather than just describing the problem. Claude could diagnose the issue directly from evidence. The lesson: when debugging, show your AI the exact output — not just a description of what you think is happening.

---

### Prompt 4 — Asking WHY, Not Just How

**My prompt:**

> *"hey Claude so I've actually written this code. The only issue I'm facing is that when I make a change and save it, the change is not being reflected in what is being printed to the terminal. Why could that be?"*

**Response summary:** Claude explained that Java requires recompilation after every change — unlike JavaScript where `node index.js` always reads the latest source file. Running `java Chatbot` runs the old `.class` bytecode file until `javac` is run again.

**Reflection:** I specifically asked *why* the change wasn't reflecting rather than just asking how to fix it. Understanding the underlying reason — compiled vs interpreted languages — meant I'd never make that mistake again, rather than just following a fix I didn't fully understand.

---

### Prompt 5 — Stopping to Ask for Clarification Mid-Phase

**My prompt:**

> *"hmmm... i don't quite get what you mean here about ordering my if/else carefully. care to break it down?"*

**Response summary:** Claude demonstrated with a concrete example how `input.contains("java")` would incorrectly match the word "javascript" if placed first in the chain, and established the rule: specific keyword checks must come before general ones.

**Reflection:** I had moved on to building the chatbot but stopped to ask about something that confused me rather than copy-pasting past it. That *"I don't quite get it, care to break it down?"* pattern was one of my most used throughout the project. It's also worth noting this bug had already happened to me in real life (typing "javascript" triggered the wrong response) — which made the explanation land much harder than if I'd just read it theoretically.

---

### Prompt 6 — Using Follow-Up Questions to Test Understanding

**My prompt:**

> *"OK so now I have a question about this line. I want to understand the difference between public class, static, and public static void main because now I'm a bit confused with the naming... is it like an oxymoron? Because public means it can be used anywhere, but static here means it belongs to the class. So what exactly does that mean? [...] please ask me 3 follow up questions to test my understanding and my comprehension"*

**Response summary:** Claude untangled `public`, `static`, `void`, and `main` — explaining that public and static answer completely different questions (who can access it vs how it is accessed), then asked three comprehension questions.

**My answers revealed:** I had confused parameters and return type for Q1 (thinking `void` meant removing parameters), but correctly identified the chicken-and-egg problem for Q2, and correctly explained why `pickRandom` doesn't need `public` using a JavaScript scoping analogy I came up with myself.

**Reflection:** The follow-up question pattern was my most powerful learning tool. Answering those questions in my own words forced me to actually own the concept. Getting one wrong didn't feel like failure — it felt like finding exactly where my understanding had a gap, which is far more useful than thinking I understood something I didn't.

---

### Prompt 7 — Requesting a Thorough, Nit-Picky Code Review

**My prompt:**

> *"hey claude so in response to this, here's my code. please let me know if it meets these criteria. according to me it does but i may have missed something. be as thorough and nit-picky as possible 😅"*
>
> *(attached final Chatbot.java)*

**Response summary:** Claude found 6 issues: `System.err` instead of `System.out` for empty input handling, space before parentheses in method/constructor calls, missing space in the class declaration, "what" comments instead of "why" comments, calling `pickRandom` a "variable" instead of a "method" in a comment, and a missing comment explaining the blank line spacer.

**Reflection:** Asking to be reviewed against a checklist AND explicitly requesting nit-picking produced far more useful feedback than a vague "does this look good?" The `System.err` bug was the most important catch — it would have printed a message in red, which looks alarming for a completely harmless empty input. The comment quality lesson was also unexpectedly valuable: good comments explain *why* something is done, not *what* the code does (the code already shows that).

---

## 7. Common Issues & Fixes

| Error | Cause | Fix |
|-------|-------|-----|
| `command not found: java` | Java not installed | Run `sudo apt install openjdk-17-jdk -y` |
| `Error: Could not find or load main class HelloWorld` | Not compiled yet, or in wrong directory | Run `javac HelloWorld.java` first, then `java HelloWorld` |
| `error: Class names are only accepted if annotation processing is explicitly requested` | Ran `javac HelloWorld` without `.java` extension | Always use `javac HelloWorld.java` (with extension) |
| Changes not showing after editing | Forgot to recompile after saving | Always run `javac Chatbot.java` after every change |
| Forgot to save before compiling | Classic human error 😅 | Enable VS Code Auto Save or use `Ctrl+S` habitually |
| `System.err` printing in red | Used error stream instead of standard output | Replace `System.err.println()` with `System.out.println()` |
| Wrong response for "javascript" | `java` keyword check placed before `javascript` in if/else chain | Put specific keywords (`javascript`) before general ones (`java`) |
| Space before parenthesis: `new Scanner (System.in)` | Style/convention issue | Remove space: `new Scanner(System.in)` |

---

## 8. References

- [Official Java Documentation](https://docs.oracle.com/en/java/javase/17/)
- [OpenJDK Download](https://openjdk.org/)
- [VS Code Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
- [W3Schools Java Tutorial](https://www.w3schools.com/java/)
- [Java String Methods Reference](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/String.html)
- [ASCII Art Generator](https://patorjk.com/software/taag/) — used to generate the JavaBot logo
- [WSL Setup Guide (Microsoft)](https://learn.microsoft.com/en-us/windows/wsl/install)
- [Claude AI](https://claude.ai) — primary AI learning tool used throughout this project

---

*Built with ☕ Java and a lot of patience. Prompted with Claude AI.*