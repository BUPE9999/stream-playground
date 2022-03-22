package brickset;

import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
        LegoSetRepository lego = new LegoSetRepository();

        ArrayList<Class> LegoSet = new ArrayList<>();

        System.out.println("method 1: ");
        System.out.println(lego.countObject());
        System.out.println();

        System.out.println("method 2:");
        System.out.println(lego.printLegoSetNameWith("Knight"));
        System.out.println();

        System.out.println("method 3:");
        lego.printNaLenGrThan5ThemeNaStartWithA();
        System.out.println();

        System.out.println("method 4:");
        lego.printSubTheme("Promotional");
        System.out.println();

        System.out.println("method 5:");
        System.out.println(lego.countNumOfTheme());


    }
}
