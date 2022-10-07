public class Main {
    public static void main(String[] args) {
        float paintLetersPerMetersCubed = 0.5f;
        float wallHeight = 3f;
        float wallWith = 5.5f;
        float totalPaint;
        float totalArea;

        totalArea = wallHeight * wallWith * 4;
        totalPaint = totalArea * paintLetersPerMetersCubed;

        System.out.println("The amount of paint needed for 4 walls of a cuboid room is: " + totalPaint + " L");
        System.out.println("Assuming 1 L of paint covers 0.5 m2");
    }
}