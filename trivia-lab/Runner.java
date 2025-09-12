import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

public class Runner {

    public static String mathEasy1(int num1, int num2) {
        return "What is the area of the rectangle with the length " + num1 + " and width " + num2 + "? Round to the nearest hundredth.";
    }

    public static String mathEasy2(int num1) {
        return "What is the area of a circle with the radius " + num1 + "? Round to the nearest hundredth.";
    }

    public static String mathEasy3(int num1, int num2) {
        return "What is the perimeter of a rectangle with length " + num1 + " and width " + num2 + "? Round to the nearest hundredth.";
    }

    public static String mathEasy4(int num1, int num2) {
        return "What is the volume of a box with length " + num1 + ", width " + num2 + ", and height " + num1 + "? Round to the nearest hundredth." ;
    }

    public static String mathEasy5(int num1, int num2) {
        return "What is the area of a right triangle with base " + num1 + " and height " + num2 + "? Round to the nearest hundredth.";
    }

    public static String mathEasy6(int num1, int num2) {
        return "What is the area of a trapezoid with bases " + num1 + " and " + num2 + " and height " + num1 + "? Round to the nearest hundredth.";
    }

    public static String mathHard1(int num1, int num2) {
        return "What is the length of the hypotenuse of a right triangle with legs " + num1 + " and " + num2 + "? Round to the nearest hundredth.";
    }

    public static String mathHard2(int num1, int num2) {
        return "What is the volume of a cone with radius " + num1 + " and height " + num2 + "? Round to the nearest hundredth.";
    }

    public static String mathHard3(int num1, int num2) {
        return "What is the surface area of a cylinder with radius " + num1 + " and height " + num2 + "? Round to the nearest hundredth.";
    }

    public static String geoEasy1() {
        return "What is the largest continent in the world?";
    }

    public static String geoEasy2() {
        return "What is the longest river in the world?";
    }

    public static String geoEasy3() {
        return "What is the highest mountain on Earth? Answer without the mount part.";
    }

    public static String geoEasy4() {
        return "Which country is both an island and a continent?";
    }

    public static String geoEasy5() {
        return "What is the capital city of France?";
    }

    public static String geoEasy6() {
        return "Which ocean is on the west coast of the United States? Answer with the name of the ocean only.";
    }

    public static String geoHard1() {
        return "Which two countries are the only pair in the world that are completely surrounded by just one other country? Answer with the one located in Africa.";
    }

    public static String geoHard2() {
        return "Which country shares a border with only one other country, but that border is longer than 3,000 km?";
    }

    public static String geoHard3() {
        return "Which country has coastlines on both the Atlantic Ocean and the Mediterranean Sea, but is not in Europe?";
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Trivia Game!");
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int score = 0;

        System.out.println("Choose a category");
        System.out.println("1. Math");
        System.out.println("2. Geography");
        int category = scan.nextInt();

        if (category == 1) {
            System.out.println("Math section: ");
            int num1 = rand.nextInt(19) + 1;
            int num2 = rand.nextInt(19) + 1;
            System.out.println(mathEasy1(num1, num2));
            double answer1 = scan.nextDouble();

            double correct = num1 * num2;

            if (answer1 == correct) {
                score++;
                System.out.println("Correct! Your score is now " + score + "\n");
            } else {
                System.out.println("Incorrect. The correct answer is " + (num1 * num2) + ". Your score is still " + score + "\n");
            }

            scan.nextLine();

            num1 = rand.nextInt(19) + 1;
            System.out.println(mathEasy2(num1));
            answer1 = scan.nextDouble();

            correct = Math.round(Math.PI * Math.pow(num1, 2) * 100.0) / 100.0;

            if (answer1 == correct) {
                score++;
                System.out.println("Correct! Your score is now " + score + "\n");
            } else {
                System.out.println("Incorrect. The correct answer is " + correct + ". Your score is still " + score + "\n");
            }

            scan.nextLine();

            num1 = rand.nextInt(19) + 1;
            num2 = rand.nextInt(19) + 1;
            System.out.println(mathEasy3(num1, num2));
            answer1 = scan.nextDouble();

            correct = 2 * num1 + 2 * num2;

            if (answer1 == correct) {
                score++;
                System.out.println("Correct! Your score is now " + score + "\n");
            } else {
                System.out.println("Incorrect. The correct answer is " + correct + ". Your score is still " + score + "\n");
            }

            scan.nextLine();

            if (score == 3) {
                num1 = rand.nextInt(19) + 1;
                num2 = rand.nextInt(19) + 1;
                System.out.println(mathHard1(num1, num2));
                answer1 = scan.nextDouble();

                correct = Math.round(Math.sqrt(Math.pow(num1, 2) + Math.pow(num2, 2)) * 100.0) / 100.0;

                if (answer1 == correct) {
                    score++;
                    System.out.println("Correct! Your score is now " + score + "\n");
                } else {
                    System.out.println("Incorrect. The correct answer is " + correct + ". Your score is still " + score + "\n");
                }

                scan.nextLine();

                num1 = rand.nextInt(19) + 1;
                num2 = rand.nextInt(19) + 1;
                System.out.println(mathHard2(num1, num2));
                answer1 = scan.nextDouble();

                correct = Math.round((Math.PI * Math.pow(num1, 2) * num2 / 3.0) * 100.0) / 100.0;

                if (answer1 == correct) {
                    score++;
                    System.out.println("Correct! Your score is now " + score + "\n");
                } else {
                    System.out.println("Incorrect. The correct answer is " + correct + ". Your score is still " + score + "\n");
                }

                scan.nextLine();

                num1 = rand.nextInt(19) + 1;
                num2 = rand.nextInt(19) + 1;
                System.out.println(mathHard3(num1, num2));
                answer1 = scan.nextDouble();

                correct = Math.round(2 * Math.PI * num1 * (num1 + num2) * 100.0) / 100.0;

                if (answer1 == correct) {
                    score++;
                    System.out.println("Correct! Your score is now " + score + "\n");
                } else {
                    System.out.println("Incorrect. The correct answer is " + correct + ". Your score is still " + score + "\n");
                }

                scan.nextLine();

            } else {
                num1 = rand.nextInt(1, 20);
                num2 = rand.nextInt(1, 20);
                System.out.println(mathEasy4(num1, num2));
                answer1 = scan.nextDouble();

                correct = num1 * num2 * num1;

                if (answer1 == correct) {
                    score++;
                    System.out.println("Correct! Your score is now " + score + "\n");
                } else {
                    System.out.println("Incorrect. The correct answer is " + correct + ". Your score is still " + score + "\n");
                }

                scan.nextLine();

                num1 = rand.nextInt(1, 20);
                num2 = rand.nextInt(1, 20);
                System.out.println(mathEasy5(num1, num2));
                answer1 = scan.nextDouble();

                correct = Math.round((0.5 * num1 * num2) * 100.0) / 100.0;

                if (answer1 == correct) {
                    score++;
                    System.out.println("Correct! Your score is now " + score + "\n");
                } else {
                    System.out.println("Incorrect. The correct answer is " + correct + ". Your score is still " + score + "\n");
                }

                scan.nextLine();

                num1 = rand.nextInt(1, 20);
                num2 = rand.nextInt(1, 20);
                System.out.println(mathEasy6(num1, num2));
                answer1 = scan.nextDouble();

                correct = Math.round((((num1 + num2) / 2.0) * num1) * 100.0) / 100.0;

                if (answer1 == correct) {
                    score++;
                    System.out.println("Correct! Your score is now " + score + "\n");
                } else {
                    System.out.println("Incorrect. The correct answer is " + correct + ". Your score is still " + score + "\n");
                }

                scan.nextLine();
            }

            if (score == 6) {
                System.out.println("You got an A! Congratulations!");
            } else if (score == 5) {
                System.out.println("You got a B! Great job!");
            } else if (score == 4) {
                System.out.println("You got a C! Not bad!");
            } else if (score == 3) {
                System.out.println("You got a D! You can do better!");
            } else {
                System.out.println("You got an F! Better luck next time!");
            }

        } else if (category == 2) {
            System.out.println("Geography section: ");
            System.out.println(geoEasy1());
            scan.nextLine();
            String answer1 = scan.nextLine().toLowerCase();

            String correct = "asia";

            if (answer1.equals(correct)) {
                score++;
                System.out.println("Correct! Your score is now " + score + "\n");
            } else {
                System.out.println("Incorrect. The correct answer is " + correct + ". Your score is still " + score + "\n");
            }

            System.out.println(geoEasy2());
            answer1 = scan.nextLine().toLowerCase();

            correct = "nile";

            if (answer1.equals(correct)) {
                score++;
                System.out.println("Correct! Your score is now " + score + "\n");
            } else {
                System.out.println("Incorrect. The correct answer is " + correct + ". Your score is still " + score + "\n");
            }

            System.out.println(geoEasy3());
            answer1 = scan.nextLine().toLowerCase();

            correct = "everest";

            if (answer1.equals(correct)) {
                score++;
                System.out.println("Correct! Your score is now " + score + "\n");
            } else {
                System.out.println("Incorrect. The correct answer is " + correct + ". Your score is still " + score + "\n");
            }

            if (score == 3) {
                System.out.println(geoHard1());
                answer1 = scan.nextLine().toLowerCase();

                correct = "lesotho";

                if (answer1.equals(correct)) {
                    score++;
                    System.out.println("Correct! Your score is now " + score + "\n");
                } else {
                    System.out.println("Incorrect. The correct answer is " + correct + ". Your score is still " + score + "\n");
                }

                System.out.println(geoHard2());
                answer1 = scan.nextLine().toLowerCase();

                correct = "canada";

                if (answer1.equals(correct)) {
                    score++;
                    System.out.println("Correct! Your score is now " + score + "\n");
                } else {
                    System.out.println("Incorrect. The correct answer is " + correct + ". Your score is still " + score + "\n");
                }

                System.out.println(geoHard3());
                answer1 = scan.nextLine();

                correct = "morocco";

                if (answer1.equals(correct)) {
                    score++;
                    System.out.println("Correct! Your score is now " + score + "\n");
                } else {
                    System.out.println("Incorrect. The correct answer is " + correct + ". Your score is still " + score + "\n");
                }
            } else {
                System.out.println(geoEasy4());
                answer1 = scan.nextLine().toLowerCase();

                correct = "australia";

                if (answer1.equals(correct)) {
                    score++;
                    System.out.println("Correct! Your score is now " + score + "\n");
                } else {
                    System.out.println("Incorrect. The correct answer is " + correct + ". Your score is still " + score + "\n");
                }

                System.out.println(geoEasy5());
                answer1 = scan.nextLine().toLowerCase();

                correct = "paris";

                if (answer1.equals(correct)) {
                    score++;
                    System.out.println("Correct! Your score is now " + score + "\n");
                } else {
                    System.out.println("Incorrect. The correct answer is " + correct + ". Your score is still " + score + "\n");
                }

                System.out.println(geoEasy6());
                answer1 = scan.nextLine();

                correct = "pacific";

                if (answer1.equals(correct)) {
                    score++;
                    System.out.println("Correct! Your score is now " + score + "\n");
                } else {
                    System.out.println("Incorrect. The correct answer is " + correct + ". Your score is still " + score + "\n");
                }
            }

            if (score == 6) {
                System.out.println("You got an A! Congratulations!");
            } else if (score == 5) {
                System.out.println("You got a B! Great job!");
            } else if (score == 4) {
                System.out.println("You got a C! Not bad!");
            } else if (score == 3) {
                System.out.println("You got a D! You can do better!");
            } else {
                System.out.println("You got an F! Better luck next time!");
            }
        }
    }
}
