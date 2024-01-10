package ch06_method;
public class Asda {

    public static void printInvertedTree(int currentLevel, int totalLevels) {
        if (currentLevel >= 0) {
            printSpaces(totalLevels - currentLevel - 1);
            printStars(2 * currentLevel + 1);
            System.out.println(); 
            printInvertedTree(currentLevel - 1, totalLevels); 
        }
    }

    public static void printSpaces(int count) {
        if (count > 0) {
            System.out.print(" ");
            printSpaces(count - 1); 
        }
    }

    public static void printStars(int count) {
        if (count > 0) {
            System.out.print("*");
            printStars(count - 1);
        }
    }

    public static void main(String[] args) {
        int treeLevels1 = 5;
        printInvertedTree(treeLevels1 - 1, treeLevels1); 
    }
}




