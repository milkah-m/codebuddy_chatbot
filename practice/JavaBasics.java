package practice;
// public class JavaBasics {
//     public static void main(String[] args) {
//         // 1. Variables with types
//         String greeting = "Hello, Java!";
//         int luckyNumber = 7;
//         double temperature = 23.5;
//         boolean isLearning = true;
        
//         // 2. Printing
//         System.out.println(greeting);
//         System.out.println("My lucky number is: " + luckyNumber);
//         System.out.println("Temperature: " + temperature + "°C");
//         System.out.println("Am I learning? " + isLearning);
        
//         // 3. String comparison (IMPORTANT for chatbot!)
//         String input1 = "hello";
//         String input2 = "hello";
        
//         if (input1.equals(input2)) {
//             System.out.println("✅ Strings match!");
//         }
        
//         // 4. Playing with concatenation
//         String firstName = "Java";
//         String lastName = "Developer";
//         String fullName = firstName + " " + lastName;
//         System.out.println("I am a " + fullName);
//     }
// }



public class JavaBasics {
    public static void main(String[] args) {

        //1. variables with types
        String greeting = "Hello, Java!";
        int luckyNumber = 7;
        double temperature = 23.5;
        boolean isLearning = true;

        //2. printing
        System.out.println(greeting);
        System.out.println("My lucky number is: " + luckyNumber);
        System.out.println(greeting);
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Am I learning: " + isLearning);

        //3. string comparison
         String input1 = "hello";
         String input2 = "hello";

         if (input1.equals(input2)){
         System.out.println("✅ Strings match");
         }

         //4. playing with concatenation
         String first_name = "Java";
         String last_name = "Developer";
         String full_name = first_name + " " + last_name;

         System.out.println("I am a: " + full_name);




    }
}