import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.out;


public class Hamdy_PA3{

    public static int generateQuestion(int n,int m)
    {
        float a = 0;float b = 0;
        int ran;
        float answer = 0;
        float correct = 0;
        int min = 1;
        int max = 4;

        SecureRandom random = new SecureRandom();

        Scanner scanner = new Scanner(System.in);
        if(n == 1)
        {
            a = random.nextInt(10);
            b = random.nextInt(10);
        }
        else if(n == 2)
        {

            max = 99;
            min = 10;
            a = random.nextInt(max-min+1)+min;
            b = random.nextInt(max-min+1)+min;
        }
        else if(n == 3)
        {

            max = 999;
            min = 100;
            a = random.nextInt(max-min+1)+min;
            b = random.nextInt(max-min+1)+min;
        }
        else if(n == 4)
        {

            max = 9999;
            min = 1000;
            a = random.nextInt(max-min+1)+min;
            b = random.nextInt(max-min+1)+min;
        }
        if(m == 1)
        {
            System.out.println("What is " + a + " + " + b + " ?");
            answer = scanner.nextFloat();
            correct = a+b;
        }
        else if(m == 2)
        {
            System.out.println("What is " + a + " * " + b + " ?");
            answer = scanner.nextFloat();
            correct = a*b;
        }
        else if(m == 3)
        {
            System.out.println("What is " + a + " - " + b + " ?");
            answer = scanner.nextFloat();
            correct = a-b;
        }
        else if(m == 4)
        {
            System.out.println("What is " + a + " / " + b + " ?");
            answer = scanner.nextFloat();
            correct = a/b;
        }
        else if(m == 5)
        {
            ran = random.nextInt(max-min+1)+min;


            if(ran == 1)
            {
                System.out.println("What is " + a + " + " + b + " ?");
                answer = scanner.nextFloat();
                correct = a+b;
            }
            else if(ran == 2)
            {
                System.out.println("What is " + a + " * " + b + " ?");
                answer = scanner.nextFloat();
                correct = a*b;
            }
            else if(ran == 3)
            {
                System.out.println("What is " + a + " - " + b + " ?");
                answer = scanner.nextFloat();
                correct = a-b;
            }
            else if(ran == 4)
            {
                System.out.println("What is " + a + " / " + b + " ?");
                answer = scanner.nextFloat();
                correct = a/b;
            }
        }


        if(Float.compare(answer, correct) == 0)
        {
            return 1;
        }
        else if (Float.compare(answer, correct) < 0)
        {
            return 0;
        }
        else
        {
            return 9999;
        }

    }

    public static void getResult(int result)
    {
        if (result > 75) {
            System.out.println("You scored " + result + "%.");
            System.out.println("Congratulations, you are ready to go to the next level!");
        } else if (result < 75) {
            System.out.println("You scored " + result + "%.");
            System.out.println("Please ask your teacher for extra help.");

        }
    }
    public static int getOperation()
    {
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What operation would you like? Enter 1 for addition, 2 for multiplication, 3 for subtraction, 4 for division, and 5 for random");
        choice = scanner.nextInt();
        if(choice == 1)
        {
            return 1;
        }
        else if(choice == 2)
        {
            return 2;
        }
        else if(choice == 3)
        {
            return 3;
        }
        else if(choice == 4)
        {
            return 4;
        }
        else if(choice == 5)
        {
            return 5;
        }
        else
        {
            return 9999;
        }
    }

    public static int getDifficultyLevel()
    {
        int diff;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What difficulty level would you like? (1-4)");
        diff = scanner.nextInt();
        System.out.println("You got it! Starting difficulty level " + diff + ".");
        return diff;

    }

    public static void displayCorrectMessage()
    {
        int n;
        int response[] = {1, 2, 3, 4};
        SecureRandom random = new SecureRandom();
        n = random.nextInt(4);
        switch (response[n]) {
            case 1:
                System.out.println("Excellent!");
                break;
            case 2:
                System.out.println("Very Good!");
                break;
            case 3:
                System.out.println("Keep Up The Good Work!");
                break;
            case 4:
                System.out.println("Nice Work!");
                break;
        }
    }
    public static void displayWrongMessage()
    {
        int n;
        n = 0;
        int response[] = {1, 2, 3, 4};
        SecureRandom random = new SecureRandom();
        n = random.nextInt(4);
        switch (response[n]) {
            case 1:
                System.out.println("No. Please try again.");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don't give up!");
                break;
            case 4:
                System.out.println("No. Keep trying.");
                break;
        }
    }



    public static void main(String[] args) {
        int choice,i, q, r;
        int counter = 0;
        int c = 0;
        int score = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to my math helper! Press 1 to begin and 2 to exit");
        choice = scanner.nextInt();

        while (choice == 1)
        {
            q = getDifficultyLevel();
            r = getOperation();

            for(i = 0; i <10; i++)
            {
                if(generateQuestion(q,r) == 1)
                {
                    displayCorrectMessage();
                    c++;
                }
                else
                {
                    displayWrongMessage();
                }
                counter++;
            }
            if(counter == 10)
            {
                score = c * 10;
                getResult(score);
                System.out.println("Press 1 to start another session and 2 to exit");
                choice = scanner.nextInt();
                counter = 0;
                c = 0;
            }
        }





    }
}
