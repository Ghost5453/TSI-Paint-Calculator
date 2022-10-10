import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int coats, inputInt = 0, wallNumber;
        float inputFloat, m3CoveredBy1Lite = 6f, totalPaint, totalArea, pricePerLDulux, pricePerLHome, pricePerLPremeum, paintPrice, totalPrice, wallArea, missingArea, obstructionArea;
        boolean error = false;
        String input, message;
        String[] dimensionsStr = new String[]{"Height in m: ", "Width in m: ", "Depth in m: "};
        float[] dimensionsFloat = new float[3];

        int[] obstetricalByWall;
        float[][] walls;
        float[][][] obstructions;
        Scanner userInput = new Scanner(System.in);

        //Scanner userInput = new Scanner(System.in);

        pricePerLDulux = 26f/2.5f;
        pricePerLHome = 21f/5f;
        pricePerLPremeum = 26f;

        // Number of walls

        inputInt = GuardedInputInteger("How may walls do you want to paint: ", false, userInput);
        wallNumber = inputInt;

        walls = new float[wallNumber][2];
        obstructions = new float[wallNumber][][];
        obstetricalByWall = new  int[wallNumber];

        // Wall size
        // Add constant height
        // Add cuboid rooms

        for (int myWall = 0; myWall < wallNumber; myWall++)
        {
            for (int xy = 0; xy < 2; xy++)
            {
                if (xy ==0)
                {
                    message = "What is the width of wall number: " + myWall + " in m";
                } else
                {
                    message = "What is the height of wall number: " + myWall + " in m";
                }

                inputFloat = GuardedInputFloat(message, false, userInput);
                walls[myWall][xy] = inputFloat;
            }
        }


        // number of obstructions

        for (int myWalls = 0; myWalls < wallNumber; myWalls++)
        {
            message = "How many obstructions are there on wall number " + myWalls + " (dimensions: " + walls[myWalls][0] + " m, " + walls[myWalls][1] + " m)";
            inputInt = GuardedInputInteger(message, true, userInput);

            if (inputInt == 0)
            {
                obstetricalByWall[myWalls] = -1;
            }
            else
            {
                obstetricalByWall[myWalls]= inputInt;
            }
        }

        for (int myWall = 0; myWall < wallNumber; myWall++)
        {
            if (obstetricalByWall[myWall] == -1)
            {
                obstructions[myWall] = new float[1][1];

            }else {
                obstructions[myWall] = new float[obstetricalByWall[myWall]][2];
            }
        }

        // obstruction size
        System.out.println("All obstructions need to be rectangular");

        for (int myWall = 0; myWall < wallNumber; myWall++ )
        {
            int myObstructions = 0;
            do{
                if (obstetricalByWall[myWall] <= 0)
                    break;

                for (int xy = 0; xy < 2; xy++)
                {
                    if (xy ==0)
                    {
                        message = "What is the width of obstruction number: " + myObstructions + " on wall number: " + myWall + " (width: " + walls[myWall][0] + " m and height: " + walls[myWall][1] + " m)";
                    } else
                    {
                        message = "What is the height of obstruction number: " + myObstructions + " on wall number: " + myWall + " (width: " + walls[myWall][0] + " m and height: " + walls[myWall][1] + " m)";
                    }

                    inputFloat = GuardedInputFloat(message, false, userInput);
                    obstructions[myWall][myObstructions][xy] = inputFloat;
                }

                myObstructions++;

            }  while (myObstructions < obstetricalByWall[myWall]);

        }
        
        message = "What paint do you want (1: Home, 2: Dulux, or 3: Premium)";
        inputInt = GuardedInputInteger(message, false, userInput);

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

        message = "How many coats: ";
        inputInt = GuardedInputInteger(message, false, userInput);
        coats = inputInt;
        
        // correct

        totalArea = 0;
        wallArea = 0;

        for (int myWall = 0; myWall < wallNumber; myWall++)
        {
            missingArea = 0;
            obstructionArea = 0;
            wallArea = walls[myWall][0] * walls[myWall][1];
            totalArea += wallArea;

           if(obstetricalByWall[myWall] == -1)
               continue;

           for (int myObstructions = 0; myObstructions < obstetricalByWall[myWall]; myObstructions++)
           {
                obstructionArea = obstructions[myWall][myObstructions][0] * obstructions[myWall][myObstructions][1];
                missingArea += obstructionArea;
           }

           if (missingArea >= wallArea)
           {
               System.out.println("Too many obstructions, skipping this wall: ");
               totalArea -= wallArea;
           }else
           {
               totalArea -= obstructionArea;
           }
        }

        totalPaint = totalArea / m3CoveredBy1Lite;
        totalPrice = totalPaint * paintPrice;

        System.out.println("The amount of paint needed for 4 walls of a cuboid room is: " + totalPaint + " L");
        System.out.println("Assuming 1 L of paint covers 6 m2");

        System.out.println("The cost of the paint is: £" + totalPrice);
    }

//    public static float GuardedInputFloat(String _message)
//    {
//        return GuardedInputFloat(_message, false);
//    }
//
//    public static int GuardedInputInteger(String __message)
//    {
//        return GuardedInputInteger(__message, false);
//    }

    public static float GuardedInputFloat(String _message, boolean _canBeZero, Scanner myInput)
    {
        boolean _error;
        float _inputFloat = 0f;
        String _input;

        do{

            _error = false;
            System.out.println(_message);
            _input = myInput.nextLine();

            try{
                _inputFloat = Float.valueOf(_input).floatValue();
            }catch (Exception err)
            {
                _error = true;
                System.out.println("Invalid input use a number");
            }

            if(!_error)
            {
                if (_canBeZero)
                {
                    if (_inputFloat < 0)
                    {
                        System.out.println("Use a positive number");
                        _error = true;
                        _inputFloat = -1;
                    }
                }
                else
                {
                    if (_inputFloat <= 0)
                    {
                        System.out.println("Use a positive number greater than 0");
                        _error = true;
                        _inputFloat = -1;
                    }
                }
            }
        }while (_error);

        return _inputFloat;
    }

    public static int GuardedInputInteger(String _message, boolean _canBeZero, Scanner myInput)
    {
        boolean _error;
        int _inputInt = 0;
        String _input;

        do{
            _error = false;
            System.out.println(_message);
            _input = myInput.nextLine();

            try{
                _inputInt = Integer.valueOf(_input);
            }catch (Exception err)
            {
                _error = true;
                System.out.println("Invalid input use a hole number");
                _inputInt = -1;
            }

            if(!_error)
            {
                if (_canBeZero)
                {
                    if (_inputInt < 0)
                    {
                        System.out.println("Use a positive number");
                        _error = true;
                        _inputInt = -1;
                    }
                }
                else
                {
                    if (_inputInt <= 0)
                    {
                        System.out.println("Use a positive number greater than 0");
                        _error = true;
                        _inputInt = -1;
                    }
                }
            }

        }while (_error);
        return _inputInt;
    }
}