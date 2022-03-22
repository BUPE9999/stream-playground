package brickset;

import repository.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class LegoSetRepository extends Repository<LegoSet> {

    public LegoSetRepository() {
        super(LegoSet.class, "brickset.json");
    }


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



}
