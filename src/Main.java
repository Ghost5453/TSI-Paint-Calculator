import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float m3CoveredBy1Lite = 6f;
        int coats;
        float wallHeight = 0f;
        float wallDepth = 0f;
        float wallWith = 0f;
        float totalPaint;
        float totalArea;
        boolean error = false;
        String input;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Height in m: ");
        input = userInput.nextLine();
        wallHeight = Float.valueOf(input).floatValue();

//        while (error)
//        {
//            error = false;
//            System.out.println("Height in m: ");
//            input = userInput.nextLine();
//
//            try{
//                wallHeight = Float.valueOf(input).floatValue();
//            } catch (Exception err)
//            {
//                error = true;
//                wallHeight = 0f;
//            }
//        }

        System.out.println("With in m: ");
        input = userInput.nextLine();
        wallWith = Float.valueOf(input).floatValue();

        System.out.println("Depth in m: ");
        input = userInput.nextLine();
        wallDepth = Float.valueOf(input).floatValue();

        System.out.println("How many coats: ");
        input = userInput.nextLine();
        coats = Integer.valueOf(input);

        totalArea = coats * 2 * (wallHeight * wallDepth + wallWith * wallHeight);
        totalPaint = totalArea / m3CoveredBy1Lite;

        System.out.println("The amount of paint needed for 4 walls of a cuboid room is: " + totalPaint + " L");
        System.out.println("Assuming 1 L of paint covers 6 m2");
    }
}