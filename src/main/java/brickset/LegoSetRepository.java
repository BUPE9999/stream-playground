package brickset;

import repository.Repository;

import java.util.ArrayList;

/**
 * @author Fang Dongzhou
 */


public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

    /**
     * Method 1
     * print all information which packagingType is not none
     * @return nothing
     */
    public void method1(){
        getAll().stream()
                .filter(LegoSet -> LegoSet.getPackagingType() != PackagingType.NONE)
                .forEach(System.out::println);
    }

    /**
     * Method 2
     * print all name start by "A" and sort
     * @return nothing
     */
    public void method2(){
        getAll().stream()
                .filter(LegoSet -> LegoSet.getName().startsWith("a")||LegoSet.getName().startsWith("A"))
                .map(LegoSet::getName)
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * Method 3
     * Print length of name is greater than 5 (top 3)
     * @return nothing
     */
    public void method3(){
        getAll().stream()
                .limit(4)
                .filter(LegoSet -> LegoSet.getName().length() > 5)
                .map(LegoSet::getName)
                .forEach(System.out::println);
    }

    /**
     * Method 4
     * @param theme from LEGO set para: theme
     * Print the subtheme of theme which we typed
     * @return nothing
     */
    public void method4(String theme){
        getAll().stream()
                .filter(legoSet -> legoSet.getTheme() != null && legoSet.getTheme().contains(theme))
                .map(LegoSet::getSubtheme)
                .forEach(System.out::println);
    }

    /**
     * Method 5
     * Print the number of theme which pieces are greater than 500
     * @return the number of LEGO sets with the theme
     */
    public long method5(){
        return getAll().stream()
                .filter(LegoSet -> LegoSet.getPieces() > 500)
                .map(LegoSet::getTheme)
                .count();
    }



}
