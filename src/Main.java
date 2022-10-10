import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int coats, inputInt;
        float m3CoveredBy1Lite = 6f, wallHeight, wallDepth, wallWith, totalPaint, totalArea, pricePerLDulux, pricePerLHome, pricePerLPremeum, paintPrice, totalPrice;
        boolean error = false;
        String input;
        String[] dimensionsStr = new String[]{"Height in m: ", "Width in m: ", "Depth in m: "};
        float[] dimensionsFloat = new float[3];
        Scanner userInput = new Scanner(System.in);

        pricePerLDulux = 26f/2.5f;
        pricePerLHome = 21f/5f;
        pricePerLPremeum = 26f;

//        do {
//            error = false;
//
//            System.out.println("What paint do you want (1: Home, 2: Dulux, or 3: Premium)");
//            input = userInput.nextLine();
//
//            try{
//                inputInt = Integer.valueOf(input);
//            } catch (Exception err)
//            {
//                error = true;
//                System.out.println("Invalid input ues 1, 2 or 3");
//                inputInt = 0;
//            }
//
//        } while (error);

        inputInt = GuardedInt("What paint do you want (1: Home, 2: Dulux, or 3: Premium)", false, userInput);

        if (inputInt == 1)
        {
            paintPrice = pricePerLHome;
        } else if(inputInt == 2){
            paintPrice = pricePerLDulux;
        } else if(inputInt == 3){
            paintPrice = pricePerLPremeum;
        } else {
            System.out.println("Out of range input so using home paint");
            paintPrice = pricePerLHome;
        }

        for (int i = 0; i < dimensionsFloat.length; i++)
        {
            do{
                error = false;

                System.out.println(dimensionsStr[i]);
                input = userInput.nextLine();

                try{
                    dimensionsFloat[i] = Float.valueOf(input).floatValue();
                }catch (Exception err)
                {
                    error = true;
                    System.out.println("Invalid input use a number");
                }
            }while (error);
        }

        do{
            error = false;

            System.out.println("How many coats: ");
            input = userInput.nextLine();

            try{
                coats = Integer.valueOf(input);
            }catch (Exception err)
            {
                error = true;
                System.out.println("Invalid input type a hole number");
                coats = 0;
            }

        }while (error);

//        do{
//            error = false;
//        } while (error);
//
//        System.out.println("Height in m: ");
//        input = userInput.nextLine();
//        wallHeight = Float.valueOf(input).floatValue();
//
//        System.out.println("With in m: ");
//        input = userInput.nextLine();
//        wallWith = Float.valueOf(input).floatValue();
//
//        System.out.println("Depth in m: ");
//        input = userInput.nextLine();
//        wallDepth = Float.valueOf(input).floatValue();

        totalArea = coats * 2 * (dimensionsFloat[0] * dimensionsFloat[2] + dimensionsFloat[1] * dimensionsFloat[2]);
        totalPaint = totalArea / m3CoveredBy1Lite;
        totalPrice = totalPaint * paintPrice;

        System.out.println("The amount of paint needed for 4 walls of a cuboid room is: " + totalPaint + " L");
        System.out.println("Assuming 1 L of paint covers 6 m2");

        System.out.println("The cost of the paint is: £" + totalPrice);
    }
    public static int GuardedInt(String myMessage, boolean myCanHaveZero, Scanner myInput)
    {
        int inputInt, testInt;
        String input;
        boolean error;

        do{
            error = false;

            System.out.println(myMessage);
            input = myInput.nextLine();

            try {

                testInt = Integer.valueOf(input);

            } catch (Exception fail) {

                error = true;
                System.out.println("Invalid input type a hole number");
                testInt = -1;

            }

            if (!error)
            {
                if (myCanHaveZero)
                {
                    if (testInt < 0)
                    {
                        System.out.println("The number cannot be negative");
                        error = true;
                        inputInt = -1;
                    }
                }else
                {
                    if (testInt <= 0)
                    {
                        System.out.println("The number must be greater than 0");
                        error = true;
                        inputInt = -1;
                    }
                }
            }

        } while (error);

        inputInt = testInt;

        return inputInt;
    }



}