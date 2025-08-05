package org.example;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApi2 {

    public static void main(String[] args){
        //8 Given the ord find the occurrence of each character.
        String str1 = "Mississippi";
        Map<String,Long> mapOfCount = Arrays.stream(str1.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(mapOfCount);



        //9 Arrange the number in ascending or desc order
        int[] arr= {3,2,1,4,5,6,8};
        Arrays.stream(arr).sorted().forEach(System.out::print);
        System.out.println();
        Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).forEach(System.out::print);
        Integer[] arr1= {3,2,1,4,5,6,8};
        System.out.println();
        Arrays.stream(arr1).sorted(Collections.reverseOrder()).forEach(System.out::print);


        //10 Given an array find the sum of unique int
        System.out.println("Question - 10");
        int[] arr2 = {1,1,2,2,3,3};
        int sum = Arrays.stream(arr2).distinct().sum();
        System.out.println(sum);

        //11 Given a string find the first non-repeated character
        System.out.println("Question - 11");
        String str2 = "Hello World";
        String firstCharacter = Arrays.stream(str2.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(x->x.getValue()==1).map(Map.Entry::getKey).findFirst().get();
        System.out.println(firstCharacter);


        //12 Given a string find the first repeated character
        System.out.println("Question - 12");
        String str3 = "Hello World, I am learning Java";
        String firstRepeatedChar = Arrays.stream(str3.split("")).filter(x->str3.indexOf(x)!=str3.lastIndexOf(x)).findFirst().get();
        System.out.println(firstRepeatedChar);

        //13 Given arr, Group the number based on the there range. For ex:-{0:[1,2,8],10:[11,14],20:[21,28]}
        System.out.println("Question - 13");
        int[] arr3 = {1,2,8,11,14,21,28,31,37,41,51,55,70,71,73};
        Map<Integer, List<Integer>> res = Arrays.stream(arr3).boxed().toList()
                .stream().collect(Collectors.groupingBy(x->x/10*10,LinkedHashMap::new,Collectors.toList()));
        System.out.println(res);

        //14 Given list of string("123","abc"...) return list of numbers only
        System.out.println("Question - 14");
        String[] arr4 = {"123","abc","xyz","789"};
        List<Integer> ans2 = Arrays.stream(arr4)
                .filter(x->x.matches("[0-9]+"))
                .map(Integer::valueOf).toList();
        System.out.println(ans2);


        //15. Given an array return product of first 2 numbers
        System.out.println("Question - 15");
        int[] arr5 = {15,4,6,12,14};
        int product = Arrays.stream(arr5).boxed().toList().stream().limit(2).reduce(1,(a,b)->a*b);
        System.out.println(product);


        //16. Pair the anagrams from a list of string;
        System.out.println("Question - 16");
        String[] str6 = {"tap","pan","pat","team","nap","meat"};
        Collection<List<String>> res4 = Arrays.stream(str6)
                .toList()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                x->Arrays.stream(x.toLowerCase().split("")).sorted().toList()
                        )
                ).values();
        System.out.println(res4);

        //17. Write a stream program to multiply alternate number in an array
        System.out.println("Question - 17");
        int[] arr6 = {1,2,3,4,5,6,7};
        int ans = IntStream.range(0,arr6.length)
                .filter(x->x%2==0)
                .map(x->arr6[x])
                .reduce(1,(a,b)->a*b);
        System.out.println(ans);


        //18. Write a stream to print product of 1st* last, 2nd * 2nd-last, 3rd * 3rd-Last and soo on.
        System.out.println("Question - 18");
        int[] arr7 = {1,2,3,3,2,1};
        IntStream.range(0,arr7.length/2).map(x-> arr7[x]*arr7[arr7.length-x-1]).forEach(System.out::println);

        //19. Move all zeros to the beginnings
        System.out.println("Question - 19");
        int[] arr8 = {5,0,2,0,0,0,7,8,0};
        List<Integer> ans3 = Arrays.stream(arr8).boxed().collect(Collectors.partitioningBy(x->x!=0))
                .values().stream().flatMap(Collection::stream).toList();
        System.out.println(ans3);


        //20 Given a list of Integer return true if it contains only distinct values
        int[] arr9 = {5,1,0,3,0,0,6};
        Set<Integer> set= Arrays.stream(arr9).boxed().collect(Collectors.toSet());
        System.out.println(set.size() == arr9.length);
        
    }
}
