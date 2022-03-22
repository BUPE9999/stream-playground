package brickset;

public class main {

    public static void main(String[] args) {
        LegoSetRepository lego = new LegoSetRepository();

        System.out.println("method 1: ");
        lego.printInfoWithPackagingType();
        System.out.println();

        System.out.println("method 2:");
        lego.printNameStartByA();
        System.out.println();

        System.out.println("method 3:");
        lego.printNameLengthGreaterThan5();
        System.out.println();

        System.out.println("method 4:");
        lego.printSubTheme("Promotional");
        System.out.println();

        System.out.println("method 5:");
        System.out.println(lego.countNumOfTheme());


    }
}
