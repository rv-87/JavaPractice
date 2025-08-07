package org.vrai.StreamApi;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamApi3 {
    public static void main(String[] args){
        //21 Given the list of string group the string based on middle character
        String[] str = {"aws","gcp","pws","acb","abc","pbc","pcb","xyz","abcd"};
        List<List<String>> ans = Arrays.stream(str)
                .collect(Collectors.groupingBy(x->x.charAt(x.length()/2)))
                .values()
                .stream()
                .toList();
        System.out.println(ans);

        //22 Given a list of Integer find the sum of all entires.
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        //int sum = list.stream().reduce(0, Integer::sum);
        //System.out.println(sum);
        //Note mapToInt(Integer:;intValue) is here converting Stream to IntStream;
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);


        //23 Sort a list of String in alphabetical order
        String[] str2 = {"xyz","abc","prq","str"};
        List<String> sortedString = Arrays.stream(str2).sorted().toList();
        System.out.println(sortedString);

        //24 Convert a list of Integer to list of squares;
        int[] arr = {1,2,3,4,5};
        List<Integer> squares = Arrays.stream(arr).boxed().map(x->x*x).toList();
        System.out.println(squares);

        //25 Given a list of Integer find the all unique odd number;
        int[] arr2 = {1,2,3,4,3,5,6,5,7,8,9,9};
        List<Integer> uniqueOdds = Arrays.stream(arr2).boxed().distinct().filter(x->x%2==1).toList();
        System.out.println(uniqueOdds);

        //26 given a list in Integer, find kth smallest number;
        int[] arr3 = {7,5,8,9,2,3,5};
        int k = 3;
        int kthSmallest = Arrays.stream(arr3).boxed().sorted().skip(k-1).findFirst().get();
        System.out.println(kthSmallest);

        //27 remove all non-numeric character string from a list of string
        String[] str4 = {"123","abc","6789","xyz","pqr"};
        List<String> nonNumericList= Arrays.stream(str4).filter(s->s.matches("[^1-9]+")).toList();
        System.out.println(nonNumericList);

        //remove all non-numeric characters from string
        //i/p ["1ab2c3","4tf56","123xyz"]
        //o/p ["123","456","123"]
        String[] str5 = {"1ab2c3","4tf56","123xyz"};
        Pattern pattern = Pattern.compile("[^1-9]");
        List<String> listNonNumeric = Arrays.stream(str5)
                .map(x->pattern.matcher(x).replaceAll(""))
                .toList();
        System.out.println(listNonNumeric);

        //28 Given a list of string return a list of strings containing number string only
        String[] str6 = {"123str","123","45","abc","1a2b3c","000"};
        List<String> onlyNumberList = Arrays.stream(str6).filter(x->x.matches("[0-9]+")).toList();
        System.out.println(onlyNumberList);

        //29 Given a list of string convert them to uppercase
        String[] str7 ={"abcd","got","breaking bad","squid game"};
        List<String> toUpperCase = Arrays.stream(str7).map(String::toUpperCase).toList();
        System.out.println(toUpperCase);

        //30 Given the list if Integer return average;
        int[] arr4 = {1,2,3,4,5};
        int avg = Arrays.stream(arr4).sum()/arr4.length;
        System.out.println(avg);

        //31 find the Intersection of two list;
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(3,4,5,6);
        List<Integer> intersectionList = list1
                .stream()
                .filter(list2::contains)
                .toList();
        System.out.println(intersectionList);

    }
}
