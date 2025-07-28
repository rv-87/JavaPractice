package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Stream1 {
    //Find the largest word


    public static void main(String[] args) {

        //Find the largest word;
        String str = "Hello I am learning java StreamApi";
        //Using sorted function
        //String ans = Arrays.stream(str.split(" ")).sorted(Comparator.comparing(String::length).reversed()).findFirst().get();

        //Using max function
        String ans = Arrays.stream(str.split(" ")).max(Comparator.comparing(String::length)).get();
        System.out.println(ans);


        //Remove the duplicate from the string and return in same order;
        String str2 = "abaabcddc";
        //Arrays.stream(str2.split("")).distinct().forEach(System.out::print);
        //or
        str2.chars().distinct().mapToObj(X -> (char) X).forEach(System.out::print);


        //Find the word that has the second-highest length
        System.out.println();
        String str3 = "Hello I am learning java StreamApi";
        String res3 = Arrays.stream(str3.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get();
        System.out.println(res3);


        //find the length of the word that has the second-highest length
        String str4 = "Hello I am learning java StreamApi";
        int len = Arrays.stream(str4.split(" ")).map(String::length).sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println(len);

        //Given the sentence find the occurrence of each word.Group by
        String str5 = "Hello I am learning Java and Stream api of Java";
        //Map<String, Long> map = Arrays.stream(str5.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        Map<String, Long> map = Arrays.stream(str5.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);


        //Given a sentence find the word having a specified number of vowels.
        String str6 = "Hello I am learning java stream api";
        Arrays.stream(str6.split( " ")).filter(X->X.replaceAll("[^aeiouAEIOU]","").length()==2).forEach(System.out::println);

        //Given a list of integer divide into list of even and odd number list.
        int[] arr = {2,3,4,5,6,7,8,1};
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        List<List<Integer>> res7 = list.stream()
                .collect(Collectors.groupingBy(x->x%2,Collectors.toList()))
                .values()
                .stream()
                .toList();
        System.out.println(res7);

    }
}
