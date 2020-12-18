package tprime;

import java.util.ArrayList;
import java.util.Scanner;

public class Tprime {
    static Scanner stdin= new Scanner(System.in);
    public static ArrayList<Double> A= new ArrayList<>();
    public static ArrayList<Double> B= new ArrayList<>();

    public static void main(String[] args) {
        inputList(A);
        inputList(B);
        System.out.println("List A:" + A);
        System.out.println("List B:" + B);
        System.out.println("Mean of A " + mean(A));
        System.out.println("Mean of B " + mean(B));
        System.out.println("Standard Deviation of A " + stdev(A));
        System.out.println("Standard Deviation of B " + stdev(B));
        System.out.println("Standard Error of A " + sterr(A));
        System.out.println("Standard Error of B " + sterr(B));
        System.out.println("T prime is " + tp(A, B));
    }

    public Tprime() {

    }

    public static void inputList(ArrayList<Double> E) {
        System.out.println("Enter value. Press enter to end values for this list");
        String str= stdin.nextLine();
        double gre;
        try {
            gre= Double.parseDouble(str);
            E.add(gre);
            inputList(E);
        } catch (Exception e) {

        }
    }

    public static Double mean(ArrayList<Double> E) {
        double total= 0.0;
        for (int i= 0; i <= E.size() - 1; i++ ) {
            total= total + E.get(i);
        }
        return total / E.size();
    }

    public static Double stdev(ArrayList<Double> E) {
        double total= 0.0;
        for (int i= 0; i <= E.size() - 1; i++ ) {
            total= total + Math.pow(E.get(i) - mean(E), 2);
        }
        return Math.sqrt(total / (E.size() - 1));
    }

    public static Double sterr(ArrayList<Double> E) {
        return stdev(E) / Math.sqrt(E.size());
    }

    public static Double tp(ArrayList<Double> x, ArrayList<Double> y) {
        return (mean(x) - mean(y)) / Math.sqrt(Math.pow(sterr(x), 2) + Math.pow(sterr(y), 2));
    }

}
