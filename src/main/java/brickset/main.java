package brickset;

public class main {

    public static void main(String[] args) {
        LegoSetRepository lego = new LegoSetRepository();

        System.out.println("method 1: ");
        lego.method1();
        System.out.println();

        System.out.println("method 2:");
        lego.method2();
        System.out.println();

        System.out.println("method 3:");
        lego.method3();
        System.out.println();

        System.out.println("method 4:");
        lego.method4("Promotional");
        System.out.println();

        System.out.println("method 5:");
        System.out.println(lego.method5());


    }
}
