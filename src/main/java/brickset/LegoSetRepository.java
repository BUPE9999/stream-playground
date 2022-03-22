package brickset;

import repository.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

/**
 * Represents a repository of {@code LegoSet} objects.
 */
public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }

    /**
     * Returns the number of LEGO sets with the tag specified.
     *
     * @param tag a LEGO set tag
     * @return the number of LEGO sets with the tag specified
     */
    public long countLegoSetsWithTag(String tag) {
        return getAll().stream()
                .filter(legoSet -> legoSet.getTags() != null && legoSet.getTags().contains(tag))
                .count();
    }

    ArrayList<LegoSet> lego = new ArrayList<LegoSet>();


    // method 1: print all information which packagingType is not none
    public void method1(){
        getAll().stream()
                .filter(LegoSet -> LegoSet.getPackagingType() != PackagingType.NONE)
                .forEach(System.out::println);
    }

    // method 2: print all name start by "A" and sort

    public void method2(){
        getAll().stream()
                .filter(LegoSet -> LegoSet.getName().startsWith("a")||LegoSet.getName().startsWith("A"))
                .map(LegoSet::getName)
                .sorted()
                .forEach(System.out::println);
    }

    // method 3: print length of name is greater than 5 (top 3)
    public void method3(){
        getAll().stream()
                .limit(4)
                .filter(LegoSet -> LegoSet.getName().length() > 5)
                .map(LegoSet::getName)
                .forEach(System.out::println);
    }

    // method 4: print the year of theme which we typed
    public void method4(String theme){
        getAll().stream()
                .filter(legoSet -> legoSet.getTheme() != null && legoSet.getTheme().contains(theme))
                .map(LegoSet::getYear)
                .forEach(System.out::println);
    }


     // method 5: print the number of theme which pieces are greater than 500

    public long method5(){
        return getAll().stream()
                .filter(LegoSet -> LegoSet.getPieces() > 500)
                .map(LegoSet::getTheme)
                .count();
    }
    /**
     * Method_2
     *This method return the Lego bricks which have every information is not null
     * @return Nothing
     */

    /**
     * Method_3
     *This method is used to print the Lego bricks which has the same pieces as the input pieces
     * @param pieces is an int value
     * @return Nothing
     * @throws IllegalArgumentException if input less than 0 or greater than 1000000
     */
    public void printWithPieces(int pieces){
        if(pieces<0||pieces>1000000){
            throw new IllegalArgumentException("Out of range");
        }
        getAll().stream().
                filter(legoSet -> legoSet.getPieces()==pieces&&legoSet.getName()!=null).
                forEach(System.out::println);
    }

    /**
     * Method_4
     * This method is used to print the Lego brick which name is start with the input Sting
     * @param pattern is a  String value
     * @throws IllegalArgumentException if patter contain more one Letter
     */
    public void printWithNameStart(String pattern){
        if(pattern.length()>1){
            throw new IllegalArgumentException("More than one letter");
        }
        getAll().stream().
                map(LegoSet::getName).
                map(String::toLowerCase).
                filter(s->s.startsWith(pattern)).
                forEach(System.out::println);
    }
    /**
     * Method_5
     *This method return an average pieces of Lego bricks
     * @return Double value
     */
    public Double printWithAveragePieces(){
        return getAll().stream().
                mapToInt(LegoSet::getPieces).
                filter(Objects::nonNull).
                average().
                getAsDouble();
    }


}
