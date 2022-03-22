package brickset;

import repository.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fang Dongzhou
 */


public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

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
