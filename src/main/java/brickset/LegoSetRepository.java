package brickset;

import repository.Repository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Fang Dongzhou
 */


public class LegoSetRepository extends Repository<LegoSet> {


    // Homework "stream(2)"
    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

    /**
     * New Method 1
     * Return a boolean value that check if there are objects which pieces greater than 500 and name Start with A
     * @return the boolean value that satisfied the requirement
     */
    public boolean aBooleanExitPieceGreaterThan500NameContainsA(){
        return getAll().stream()
                .anyMatch(a -> a.getPieces()>500 && a.getName().contains("A"));
    }

    /**
     * New Method 2
     * print the name by uppercase and also lowercase that name length smaller than 10 and dimension is null
     * @return nothing
     */
    public void printNameLengthSmallerThan10DimensionNullWithUpperLowerCase (){
        getAll().stream()
                .filter(a -> a.getName().length()<10 && a.getDimensions() == null)
                .map(LegoSet::getName)
                .flatMap(a -> Stream.of(a.toUpperCase(), a.toLowerCase()))
                .forEach(System.out::println);
    }

    /**
     * New Method 3
     * Return a number of pieces that sub theme name is null and name contains D
     * @return the long type value satisfied requirement
     */
    public long reducePiecesSubthemeNullNameContainD(){
        return getAll().stream()
                .filter(LegoSet -> LegoSet.getSubtheme()==null && LegoSet.getName().contains("D"))
                .map(LegoSet::getPieces)
                .reduce(0,(a,b)->a+b);
    }

    /**
     * New Method 4
     * Return a map that theme name length is 5 and subtheme is null with groupingBy method
     * @return the map that satisfied requirement
     */
    public Map MapNameThemeNameLengthIs5SubthemeNull(){
        return getAll().stream()
                .filter(LegoSet -> LegoSet.getTheme().length() == 5 && LegoSet.getSubtheme()==null)
                .collect(Collectors.groupingBy(LegoSet::getName));
    }

    /**
     * New Method 5
     * Return a map that name is not null with groupingBy and summingLong method
     * @return the map that satisfied requirement
     */
    public Map MapNameNotNull(){
        return getAll().stream()
                .filter(LegoSet -> LegoSet.getName() != null)
                .collect(Collectors.groupingBy(LegoSet::getTheme, Collectors.summingLong(LegoSet::getPieces)));
    }







    // Homework "stream"
    /**
     * Method 1
     * count the number of object which packagingType is not none and subtheme is not null
     * @return number of object which satisfied the requirement
     */
    public long countObject(){
        return getAll().stream()
                .filter(LegoSet -> LegoSet.getPackagingType() != PackagingType.NONE && LegoSet.getSubtheme()!=null)
                .count();
    }


    /**
     * Method 2
     * return LEGOSET which name contains element we typed
     * @param name is a string from LEGO set para: name
     * @return LEGO set with name specified
     */
    public List<LegoSet> printLegoSetNameWith (String name){
        return getAll().stream()
                .filter(LegoSet -> LegoSet.getName().contains(name))
                .collect(Collectors.toList());
    }


    /**
     * Method 3
     * Print name which length is greater than 5 and theme name start with "A"
     * @return nothing
     */
    public void printNaLenGrThan5ThemeNaStartWithA(){
        getAll().stream()
                .filter(LegoSet -> LegoSet.getName().length() > 5 && LegoSet.getTheme().startsWith("A"))
                .map(LegoSet::getName)
                .forEach(System.out::println);
    }

    /**
     * Method 4
     * @param theme from LEGO set para: theme
     * Print the subtheme name which theme specified
     * @return nothing
     */
    public void printSubTheme(String theme){
        getAll().stream()
                .filter(legoSet -> legoSet.getTheme() != null && legoSet.getTheme().contains(theme))
                .map(LegoSet::getSubtheme)
                .forEach(System.out::println);
    }

    /**
     * Method 5
     * count the number of theme which pieces are greater than 500
     * @return the number of LEGO sets with the theme which satisfied requirement
     */
    public long countNumOfTheme(){
        return getAll().stream()
                .filter(LegoSet -> LegoSet.getPieces() > 500)
                .map(LegoSet::getTheme)
                .count();
    }


}
