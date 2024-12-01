/*
 * Author Petar Velkovski // 20240142@student.act.edu
 * Title: Course Project
 * DATE: 4/11/2024
 * FINISHED CODING : 27/11/2024
 * 
 * DESCRIPTION: A seven-option program with it's own seperate programs. It is complimeted by the attached report.
 * LICENSING: This code is shared as open source under the GNU public license agreement. 
 * This code was created from a self-written template.
 * 
 * COMMENTS:
 * - methods and hashtables used, outside of main CS105 course material
 */

import java.io.*;
import java.util.*; // for use of random numbers, hashtables etc.

class courseProject {
    public static void main(String[] args) throws IOException {
        menu(); // this is done so I can call to menu from other parts of the program.
    }

    public static void menu() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in); // Input stream is an object that reads keystrokes
        BufferedReader br = new BufferedReader(isr); // Variable (object) storing the input stream temporarily
        String inputMenu; // Text variable to receive the user's input, this can be also anything else

        int menuChoice = 0;

        System.out.println("-- Welcome to Petar Velkovski's CS105 Course Project! --");
        System.out.println("-------- To continue, please select a menu number:------");
        System.out.println("1: Integer Detection");
        System.out.println("2: Factorial Calculation");
        System.out.println("3: Text to Morse Code converter");
        System.out.println("4: Number Guessing Game");
        System.out.println("5: Fibonacci Sequence");
        System.out.println("6: Pythagorean triples");
        System.out.println("7: Exit");
        System.out.println("----------------------------------------------------");
        try {
            inputMenu = br.readLine();
            menuChoice = Integer.parseInt(inputMenu); // reads input for variable menuChoice
            switch (menuChoice) { // simple case switch to choose a menu
                case 1:
                    first(); // goes to first program
                    System.out.print("\u000C"); // clears screen in BlueJ
                    break;
                case 2:
                    second(); // goes to second program
                    System.out.print("\u000C");
                    break;
                case 3:
                    third(); // goes to third program
                    System.out.print("\u000C");
                    break;
                case 4:
                    fourth(); // goes to fourth program
                    System.out.print("\u000C");
                    break;
                case 5:
                    fifth(); // goes to fifth program
                    System.out.print("\u000C");
                    break;
                case 6:
                    sixth(); // goes to sixth program
                    System.out.print("\u000C");
                    break;
                case 7:
                    System.out.println("Thank you. Exiting program...");
                    System.exit(0);
                    break;
                default: // handles number input outside of 1-7
                    System.out.println("Invalid input. Going back..");
                    menu();
            }
        } catch (NumberFormatException e) { // input error handling for non-number inputs.
            System.out.print("\u000C");
            System.out.println("Invalid input. Going back..");
            System.out.println("----------------------------------------------------");
            menu();
        }
    }

    public static void first() throws IOException {
        /*
         * Build a program which displays all integers between 0 and
         * 2000 which are exactly divisible by 1, 2, 3, 4, 5, 6 and 7. Your program
         * should also state how many such integers it has discovered, their sum and
         * average
         */
        System.out.println("----------------------------------------------");
        System.out.println("--------------Integer Detection---------------");
        System.out.println("----------------------------------------------");
        System.out.println("This program displays all integers between 0");
        System.out.println("and 2000 that are divisible by integers 1-7.");
        System.out.println("----------------------------------------------");
        System.out.println("");

        int counter = 0;
        int limit = 2000;
        int amount = 0;
        int sum = 0, avg = 0;

        while (counter < limit) {
            if (counter % 1 == 0 && counter % 2 == 0 && counter % 3 == 0 && counter % 4 == 0
                    && counter % 5 == 0 && counter % 6 == 0 && counter % 7 == 0) {  // checks proper division for all integers 1-7
                System.out.println(counter + " is exactly divisible by all numbers 1-7.");
                counter++;
                sum = sum + counter;
                amount++;
                avg = sum / amount;
            } else {
                counter++;
            }
        }
        System.out.println("-----------------------------------------------------------");
        System.out.println("There are exactly " + amount + " of these numbers.");
        System.out.println("-----------------------------------------------------------");
        System.out.println("Their sum is " + sum + " and their average is " + avg + ".");
        goingback();

    }

    public static void second() throws IOException {
        /*
         * Asks the user to input 5 integers between 0 and 12.
         * Proceeds to calculate and display the
         * factorial of the integer which happens to be closest to the group's average.
         * You may need to look up the factorial formula in a mathematics book. You
         * should code the calculation of the factorial yourselves,
         * rather than use a built-in Java command.
         */
        InputStreamReader isr = new InputStreamReader(System.in); // Input stream is an object that reads keystrokes
        BufferedReader br = new BufferedReader(isr); // Variable (object) storing the input stream temporarily
        String inData;
        double userNum = 0.0;
        int tempsum = 0;
        int counter = 1;
        double avg = 0;
        long factorial = 1; // factorials are big numbers, initialized as 1 to avoid multiplying by 0

        System.out.println("----------------------------------------------");
        System.out.println("-------------Factorial Calculator-------------");
        System.out.println("----------------------------------------------");
        System.out.println("Input 5 integers between 0 and 12.");
        System.out.println("I will calculate the group's average, and the factorial");
        System.out.println("of the integer which happens to be the closest to it.");
        System.out.println("Any real numbers will be rounded to their base integer.\n\n");

        do {
            System.out.print("Enter number:");
            inData = br.readLine();
            userNum = Double.parseDouble(inData);
            int number = (int) userNum;
            if (number >= 0 && number <= 12) {
                tempsum = tempsum + number;
                counter++;
                System.out.print("Registered. \n");
            } else {
                System.out.print("Number out of range. Try again\n");
            }
        } while (counter <= 5);

        avg = tempsum / 5;
        System.out.println("\n\nThe average of these numbers is: " + avg);
        long avgInt = Math.round(avg); // has to be long to be a matching datatype

        for (int count = 1; count <= avgInt; count++) {
            factorial *= count;
        }
        System.out.println("The factorial of " + avgInt + " is: " + factorial + ". \n");

        goingback();
    }

    public static void third() throws IOException {
        /*
         * Build a program which automatically converts English text to Morse code and
         * vice versa.
         * The user should be asked at the beginning which of the 2 conversion
         * functions they wish to trigger. Use the “_” and “.” symbols to
         * display and accept Morse code, as well as the space character to separate
         * the encoded letters. You will have to look up Morse code.
         */

        InputStreamReader isr = new InputStreamReader(System.in); // Input stream is an object that reads keystrokes
        BufferedReader br = new BufferedReader(isr); // Variable (object) storing the input stream temporarily
        String inData;

        System.out.println("----------------------------------------------");
        System.out.println("---------Text to Morse Code Converter---------");
        System.out.println("----------------------------------------------");
        System.out.println("");
        System.out.println("Note: This converter only accepts characters a-z in latin alphabet.");
        System.out.println("Any other illegal characters will be printed as //.");

        int choice = 0;
        String text = "";
        String morse = "";

        Hashtable<String, String> TTMorse = new Hashtable<>();
        Hashtable<String, String> MTText = new Hashtable<>();

        // initializing letters for morse code
        TTMorse.put("A", "._");
        TTMorse.put("B", "_...");
        TTMorse.put("C", "_._.");
        TTMorse.put("D", "_..");
        TTMorse.put("E", ".");
        TTMorse.put("F", ".._.");
        TTMorse.put("G", "__.");
        TTMorse.put("H", "....");
        TTMorse.put("I", "..");
        TTMorse.put("J", ".___");
        TTMorse.put("K", "_._");
        TTMorse.put("L", "._..");
        TTMorse.put("M", "__");
        TTMorse.put("N", "_.");
        TTMorse.put("O", "___");
        TTMorse.put("P", ".__.");
        TTMorse.put("Q", "__._");
        TTMorse.put("R", "._.");
        TTMorse.put("S", "...");
        TTMorse.put("T", "_");
        TTMorse.put("U", ".._");
        TTMorse.put("V", "..._");
        TTMorse.put("W", ".__");
        TTMorse.put("X", "_.._");
        TTMorse.put("Y", "_.__");
        TTMorse.put("Z", "__..");
        TTMorse.put(" ", "\n");
        TTMorse.put("a", "._");
        TTMorse.put("b", "_...");
        TTMorse.put("c", "_._.");
        TTMorse.put("d", "_..");
        TTMorse.put("e", ".");
        TTMorse.put("f", ".._.");
        TTMorse.put("g", "_ _.");
        TTMorse.put("h", "....");
        TTMorse.put("i", "..");
        TTMorse.put("j", ".___");
        TTMorse.put("k", "_._");
        TTMorse.put("l", "._..");
        TTMorse.put("m", "__");
        TTMorse.put("n", "_.");
        TTMorse.put("o", "___");
        TTMorse.put("p", ".__.");
        TTMorse.put("q", "__._");
        TTMorse.put("r", "._.");
        TTMorse.put("s", "...");
        TTMorse.put("t", "_");
        TTMorse.put("u", ".._");
        TTMorse.put("v", "..._");
        TTMorse.put("w", ".__");
        TTMorse.put("x", "_.._");
        TTMorse.put("y", "_.__");
        TTMorse.put("z", "__..");

        // initializing morse code for letters
        MTText.put("._", "A");
        MTText.put("_...", "B");
        MTText.put("_._.", "C");
        MTText.put("_..", "D");
        MTText.put(".", "E");
        MTText.put(".._.", "F");
        MTText.put("__.", "G");
        MTText.put("....", "H");
        MTText.put("..", "I");
        MTText.put(".___", "J");
        MTText.put("_._", "K");
        MTText.put("._..", "L");
        MTText.put("__", "M");
        MTText.put("_.", "N");
        MTText.put("___", "O");
        MTText.put(".__.", "P");
        MTText.put("__._", "Q");
        MTText.put("._.", "R");
        MTText.put("...", "S");
        MTText.put("_", "T");
        MTText.put(".._", "U");
        MTText.put("..._", "V");
        MTText.put(".__", "W");
        MTText.put("_.._", "X");
        MTText.put("_.__", "Y");
        MTText.put("__..", "Z");
        MTText.put(" ", " ");

        do {
            System.out.println("Please choose whether you would like to convert from Text to Morse, or vice-versa.");
            System.out.println("1: Text to Morse Code");
            System.out.println("2: Morse Code to Text");
            try {
                inData = br.readLine();
                choice = Integer.parseInt(inData);
            } catch (Exception e) {
                choice = 7;
            }
            if (choice == 1) {
                System.out.println("----------------------------------------------");
                System.out.println("------Converting from Text to Morse Code------");
                System.out.println("----------------------------------------------");
                System.out.println("");
                System.out.println("Please input the text you would like to convert to Morse Code:");
                text = br.readLine();
                char[] textArray = text.toCharArray();
                StringBuilder morseString = new StringBuilder();
                // returns the string into a char array e.g. ('h','i') instead of hi
                for (char c : textArray) {
                    String tempChar = String.valueOf(c);
                    if (TTMorse.containsKey(tempChar)) {
                        morseString.append(TTMorse.get(tempChar));
                        morseString.append("  "); // empty space between characters
                    } else {
                        morseString.append("//"); // appends // to denote invalid character input
                        morseString.append("  ");
                    }
                }
                System.out.println("\n" + morseString); // prints the genereated string of morse code
                System.out.println("\n\nDone translating.");
                break;

            } else if (choice == 2) {
                System.out.println("----------------------------------------------");
                System.out.println("------Converting from Morse Code to Text------");
                System.out.println("----------------------------------------------");
                System.out.println("");
                System.out.println("Input morse code associating for your letter in English.");
                System.out.println("Morse Code Syntax: \".\" for a short signal and \"_\" for a long signal.");
                System.out.println("To stop translating and see result, enter \"-1\" or type \"end\".");
                System.out.println("");
                StringBuilder textString = new StringBuilder();
                do {
                    morse = br.readLine();
                    if (MTText.containsKey(morse)) {
                        textString.append(MTText.get(morse));
                        System.out.println("Registered. Insert next signal.");
                    } else if (morse.equals("end") || morse.equals("End") || morse.equals("END")
                            || morse.equals("-1")) {
                        System.out.println("Ending translation...");
                        break;
                    } else {
                        System.out.println("Input not recognized. Check syntax.");
                    }

                } while (true);
                System.out.print("\nYour translation is: " + textString);
                System.out.println("\n\nDone translating.");
                break;

            } else {
                System.out.println("---------------------------------");
                System.out.println("Invalid input. Please try again.");
                System.out.println("--------------------------------");
            }
        } while (true);
        goingback(); // goes to a seperate menu with a choice to exit or to restart program
    }

    public static void fourth() throws IOException {
        /*
         * The program picks a random integer between 0 and 65 and then asks the user to
         * guess what it is.
         * Every time the user misses a guess the program tells them if their guess was
         * higher or lower
         * than the target number. In the end, when the user guesses correctly they are
         * congratulated
         * and told how many guesses it took for them to find the number.
         * You may need to look up the random integer generation functions in the Java
         * help files.
         */

        InputStreamReader isr = new InputStreamReader(System.in); // Input stream is an object that reads keystrokes
        BufferedReader br = new BufferedReader(isr); // Variable (object) storing the input stream temporarily
        String inData;
        Random randomizing = new Random();       // creating object 
        int randomInt = randomizing.nextInt(66); // using the method before to set a limit and generate a random num assigned to randomINT
        int inputInt = 0;
        int guessamt = 1;
        String hint = "";

        System.out.println("----------------------------------------------");
        System.out.println("---------Random Number Guessing Game----------");
        System.out.println("----------------------------------------------");
        System.out.println("I will pick a random integer between 0 and 65,");
        System.out.println("and you'll have to guess it. Don't worry, I'll help you.");
        System.out.println("----------------------------------------------");
        System.out.println("");
        System.out.println("Okay! I'm ready, you can start guessing.");
        do {
            inData = br.readLine();
            inputInt = Integer.parseInt(inData);
            if (inputInt < randomInt) {
                hint = "lower";
            }
            if (inputInt > randomInt) {
                hint = "higher";
            }
            if (inputInt != randomInt) {
                System.out.println("Wrong! That's not the number I was thinking of...");
                guessamt++;
                System.out.println("Try again? If it helps, your guess was " + hint + " than my number...");
            } else if (inputInt == randomInt) {
                if (guessamt == 1) {
                    System.out.println("Damn! Are you a genie? You got that in your first try!");
                    System.out.println("I guess you beat me.... >:(");
                    break;

                } else if (guessamt > 1 && guessamt < 5) {
                    System.out.println("Not bad! Less than 5 tries.");
                    System.out.println("Well to be exact... it took you " + guessamt + " tries...");
                    System.out.println("I guess you beat me.... >:(");
                    break;

                } else if (guessamt >= 5 && guessamt <= 10) {
                    System.out.println("Okay! You got it! It took you " + guessamt + " attempts though...");
                    System.out.println("I guess you finally beat me.... >:(");
                    break;

                } else if (guessamt > 11) {
                    System.out.println("Took you a while! You finally guessed it after " + guessamt + " times.");
                    System.out.println("I guess you finally beat me.... >:(");
                    break;
                }
            }
        } while (true);
        goingback();
    }

    public static void fifth() throws IOException {
        /*
         * A Fibonacci sequence is a chain of integers, where the next number is
         * generated by adding the previous ones. So starting with 0 and 1 as
         * the first integers in the chain, the Fibonacci sequence proceeds
         * as follows: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, [...]
         * Build code which asks the user which term of the Fibonacci sequence they
         * would like to see, then calculates and displays it (from the 1st
         * integer in the chain all the way up to the 30th).
         * For instance, if the user requests the 7th term, the answer should be “8”, if
         * they request the 10th term it should be “34”, and so on.
         */

        InputStreamReader isr = new InputStreamReader(System.in); // Input stream is an object that reads keystrokes
        BufferedReader br = new BufferedReader(isr); // Variable (object) storing the input stream temporarily
        String inData;

        int inputNum = 0;
        int fibbonacinum = 1; // initialized as 1 to not cause logic errors
        int first = 0, second = 1, next = 0; // initialized as 1 as needed for calculations

        System.out.println("----------------------------------------------");
        System.out.println("--------Fibonacci Sequence Generator----------");
        System.out.println("----------------------------------------------");
        System.out.println("Enter a number, and you'll get the Nth integer");
        System.out.println("of the Fibonnaci sequence of that number.-----");
        System.out.println("----------------------------------------------");

        System.out.println("Insert number:");
        try {
            inData = br.readLine();
            inputNum = Integer.parseInt(inData);

            if (inputNum <= 0) { // input error handling (non-positive numbers)
                System.out.println("Please enter a positive integer.\n\n");
                return; // returns to start of method
            }

            if (inputNum == 1)
                fibbonacinum = 0;
            if (inputNum == 2)
                fibbonacinum = 1;

            // loop used to calculate the fibbonacci number

            for (int i = 3; i <= inputNum; i++) {
                next = first + second; // the next num in the sequence is the sum of the two preceding nums
                first = second; // reassign first as second to move forward
                second = next; // assign second num as calculated third (next num)
            }
            fibbonacinum = second; // assigning the number from the seq.

            System.out.println("The " + inputNum + " term of the Fibonnaci sequence is: " + fibbonacinum);
            System.out.println("----------------------------------------------");
            System.out.println("Okay. I'm printing a Fibonnaci sequence up to " + inputNum + " terms:");
            System.out.println("----------------------------------------------");

            // exactly the same loop used to calculate - just with a print command.

            first = 0; // resetting values to recalculate the sequence w/ printing
            second = 1;
            next = 0;

            System.out.print("0"); // always the sequence starts with 0
            while (next <= fibbonacinum) { // loops UNTIL the next number is the fibbonaci num, with it.
                System.out.print(", " + second);
                next = first + second;
                first = second;
                second = next;
            }

            System.out.println("\n\n");

        } catch (NumberFormatException e) { // input error handling (non-number inputs)
            System.out.println("Invalid input. Please enter a valid integer.");
        }
        goingback();
    }

    public static void sixth() throws IOException {
        /*
         * Look up "Pythagorean triples" online or in a mathematics
         * book. There exist exactly 7 such triples involving integers smaller than or
         * equal to 120. Write a
         * program which scans all possible integer combinations, discovers the triples
         * and displays them on
         * screen. Triples which are duplicates (for instance [3, 4, 5], [4, 3, 5]) or
         * multiples (for instance [9,
         * 12, 15] which is 3×[3, 4, 5]) should also be displayed your output list, but
         * marked in brackets and
         * followed by a comment identifying them as such
         */

        System.out.println("----------------------------------------------");
        System.out.println("-------------Pythagorean Triples--------------");
        System.out.println("----------------------------------------------");
        System.out.println("");
        System.out.println("This program will calculate the pythagorean triples up to 120.");
        System.out.println("Ready? It will go quick, be ready to read fast!");
        try {
            Thread.sleep(1000); // dramatic effect while printing
        } catch (Exception e) {
            //
        }

        int limit = 120;
        int[][] triples = new int[500][3]; // twodimensional array first is amount of triples, second is nums in triple     
        int count = 0;

        boolean duplicateCheck = false;
        boolean multipleCheck = false;

        for (int a = 1; a < limit; a++) {
            for (int b = 1; b < limit; b++) {
                for (int c = 1; c < limit; c++) {
                    if ((Math.pow(a, 2) + Math.pow(b, 2)) == Math.pow(c, 2)) { 
                        // checks conditions for a triple to be a pythagorean triple
                        triples[count][0] = a; // at row 'count' the first num is a
                        triples[count][1] = b; // at row 'count' the second num is b
                        triples[count][2] = c; // at row 'count' the third num is c
                        count++;
                    }
                }
            }
        }

        System.out.println("Found triples:");
        int tripleAmt = 0; // to count unique triples

        for (int j = 0; j < count; j++) {
            duplicateCheck = false;
            multipleCheck = false;                                       // we start the loop assuming it is neither a multiple or duplicate
            int a = triples[j][0], b = triples[j][1], c = triples[j][2]; // for simpler referencing

            if (a == 0 || b == 0 || c == 0) {
                continue; // skips if the array element is empty, mosty due to an oversized array
            }

            for (int k = 0; k < j; k++) { // loops for every found triple b
                int tempA = triples[k][0];
                int tempB = triples[k][1];
                int tempC = triples[k][2];
                // a set of temp values counting from 0 again for comparison
                if ((a == tempA && b == tempB && c == tempC) || (a == tempB && b == tempA && c == tempC)) {
                    duplicateCheck = true; // sets the bool as true so a later check will tag the triple
                    break;
                }
                if (a % tempA == 0 && b % tempB == 0 && c % tempC == 0 && a / tempA == b / tempB
                        && b / tempB == c / tempC) {
                    // checks whether the triple is a multiple
                    multipleCheck = true;
                    break;
                }
            }

            try {
                Thread.sleep(100); // slows down print
            } catch (Exception e) {
                continue; // i don't think a thread.sleep would ever not work but ok
            }

            if (duplicateCheck == true) {
                System.out.println("[" + a + ", " + b + ", " + c + "]" + " (duplicate)"); // tags the duplicates
                continue;
            } else if (multipleCheck == true) {
                System.out.println("[" + a + ", " + b + ", " + c + "]" + " (multiple)"); // tags the multiples
                continue;
            } else {
                System.out.println("\t\t\t UNIQUE TRIPLE: " + a + ", " + b + ", " + c); // visually seperates unique triples
                tripleAmt++;
            }
        }
        System.out.println("\nI found "+tripleAmt+ " such triples!");
        goingback();
    }

   public static void goingback() throws IOException {
        int input = 0;
        InputStreamReader isr = new InputStreamReader(System.in); // Input stream is an object that reads keystrokes
        BufferedReader br = new BufferedReader(isr); // Variable (object) storing the input stream temporarily
        String inData;
        
        
        do{
            System.out.println("----------------------------------------------");
            System.out.println("The subprogram finished executing.");
            System.out.println("Would you like to go back to the main menu, or exit the program?.");
            System.out.println("Input 1 for menu, 0 for exit.");
            System.out.println("-----------------------------------------------------------");
            inData = br.readLine();
            input = Integer.parseInt(inData);

            if (input == 0) {
                System.out.println("Understood. Exiting program.");
                System.exit(0);
            } else if (input == 1) {
                System.out.println("Going back to menu...");
                System.out.println("\u000C");
                menu();
            } else {
                System.out.println("\u000C");
                System.out.println("Invalid input. Resetting.");
            }
        } while (true);

    }
}

/*
 * Thank you for reading my code!
 */
