import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int coats, inputNum;
        float m3CoveredBy1Lite = 6f, wallHeight, wallDepth, wallWith, totalPaint, totalArea, pricePerLDulux, pricePerLHome, pricePerLPremeum, paintPrice, totalPrice;
        //boolean error = false;
        String input;
        Scanner userInput = new Scanner(System.in);

        pricePerLDulux = 26f/2.5f;
        pricePerLHome = 21f/5f;
        pricePerLPremeum = 26f;

        System.out.println("What paint do you want (1: Home, 2: Dulux, or 3: Premium)");
        input = userInput.nextLine();
        System.out.println(input);

        inputNum = Integer.valueOf(input);

        if (inputNum == 1)
        {
            paintPrice = pricePerLHome;
        } else if(inputNum == 2){
            paintPrice = pricePerLDulux;
        } else if(inputNum == 3){
            paintPrice = pricePerLPremeum;
        } else {
            System.out.println("No valid input so using Home paint");
            paintPrice = pricePerLHome;
        }


        System.out.println("Height in m: ");
        input = userInput.nextLine();
        wallHeight = Float.valueOf(input).floatValue();

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
        totalPrice = totalPaint * paintPrice;

        System.out.println("The amount of paint needed for 4 walls of a cuboid room is: " + totalPaint + " L");
        System.out.println("Assuming 1 L of paint covers 6 m2");

        System.out.println("The cost of the paint is: £" + totalPrice);
    }
}