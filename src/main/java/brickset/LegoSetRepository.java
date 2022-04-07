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
     * Check if pieces greater than 500 and name Start with A
     * @return the boolean value that satisfied the requirement
     */
    public boolean isPieceGreaterThan500AndNameContainsA(){
        return getAll().stream()
                .anyMatch(a -> a.getPieces()>500 && a.getName().contains("A"));
    }

    //The second method must use the flatMap() intermediate operation.
    /**
     * New Method 2
     *
     * @return nothing
     */
//    public void method2(){
//        getAll().stream()
//                .flatMap(LegoSet::getName, Stream::n)
//                .forEach(System.out::println);
//    }

    /**
     * New Method 3
     * get the number of pieces that sub theme name is null and name contains D
     * @return the long type value satisfied requirement
     */
    public long piecesSubthemeNullNameContainD(){
        return getAll().stream()
                .filter(LegoSet -> LegoSet.getSubtheme()==null && LegoSet.getName().contains("D"))
                .map(LegoSet::getPieces)
                .reduce(0,(a,b)->a+b);
    }

    /**
     * New Method 4
     * Got map that theme name length is 5 and subtheme is null
     * @return the map that satisfied requirement
     */
    public Map NameThemeNameGreaterIs5SubthemeNull(){
        return getAll().stream()
                .filter(LegoSet -> LegoSet.getTheme().length() == 5 && LegoSet.getSubtheme()==null)
                .collect(Collectors.groupingBy(LegoSet::getName));
    }

    /**
     * New Method 5
     * Got map that name is not null
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
