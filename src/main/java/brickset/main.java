package brickset;

public class main {

    public static void main(String[] args) {
        LegoSetRepository lego = new LegoSetRepository();

        System.out.println("method 1: ");
        lego.InfoWithPackagingType();
        System.out.println();

        System.out.println("method 2:");
        lego.NameStartByA();
        System.out.println();

        System.out.println("method 3:");
        lego.NameLengthGreaterThan5();
        System.out.println();

        System.out.println("method 4:");
        lego.SubThemePrint("Promotional");
        System.out.println();

        System.out.println("method 5:");
        System.out.println(lego.NumOfTheme());


    }
}
