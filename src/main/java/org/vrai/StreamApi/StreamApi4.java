package org.vrai.StreamApi;

import org.vrai.StreamApi.helper.Employee;
import org.vrai.StreamApi.helper.Person;
import org.vrai.StreamApi.helper.Person2;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi4 {
    public static void main(String[] args){

        //33 find the all unique domain in Employee list.
        Employee e1 = new Employee("vinayak","vrai@gmail.gom");
        Employee e4 = new Employee("vinayak2","vrai2@gmail.gom");
        Employee e2 = new Employee("sanchit","sanchit@yahoo.com");
        Employee e3 = new Employee("Amit","Amit@hotmail.com");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);

        Set<String> setOfDomain = employeeList.stream().map(e-> e.getEmail().split("@")[1]).collect(Collectors.toSet());
        System.out.println(setOfDomain);

        //34 Print fibonacci using stream
        List<Integer> fibonacci = Stream.iterate(new int[] {0,1},f-> new int[] {f[1], f[0]+f[1]})
                .limit(10)
                .map(f->f[0])
                .toList();

        System.out.println(fibonacci);


        //35 Given a list of Person, return a single string o representing names separated by |
        List<Person> persons = Arrays.asList(new Person("Vinayak",24),
                new Person("Amit",25),
                new Person("Sanchit",66),
                new Person("ram",26));


        //Creating out custom collector
        Collector<Person,StringJoiner,String> personCollector = Collector.of(
                () -> new StringJoiner(" |"),
                (j,p) -> j.add(p.getName().toUpperCase()),
                (j1,j2) -> j1.merge(j2),
                StringJoiner::toString);

        String finalString = persons.stream().collect(personCollector);
        System.out.println(finalString);

        //Return the Person having highest age.
        Person p = persons.stream().sorted(Comparator.comparing(Person::getAge).reversed()).findFirst().get();
        System.out.println("Person with max age:" + p.getName() +" "+ p.getAge());

        //36 Given a list of string groupBy first character of each string

        List<String> stringList = Arrays.asList("apple","banana","aeroplane","ball","zebra");

        Map<Character, Long> map = stringList.stream().collect(Collectors.groupingBy(x->x.charAt(0),Collectors.counting()));
        System.out.println(map);

        //37 Given a list of Person2 having name and city, groupThem based on city
        List<Person2> person2List = Arrays.asList(new Person2("vinayak","noida"),
                new Person2("sanchit","delhi"),
                new Person2("Vabhav","gurugram"),
                new Person2("Ashmeet","delhi"));

        Map<String,List<Person2>> stringListMap = person2List.stream()
                .collect(Collectors.groupingBy(Person2::getCity,Collectors.toList()));
        System.out.println(stringListMap);

        //38 Given a list of Integer return product of all integers;
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);

        Integer ans = integerList.stream().reduce(1,(a,b)->a*b);
        System.out.println(ans);

        //39 Example to re-use a stream
        //Create a supplier of stream then we can re-use it.

        List<String> nameList = Arrays.asList("Vinayak","Amit","Sanchit","ETC");

        Supplier<Stream<String>> stringStreamSupplier = ()-> nameList.stream();

        //Use 1
        stringStreamSupplier.get().forEach(System.out::println);
        //Use 2
        System.out.println(stringStreamSupplier.get().count());

        //40 Given a list of string convert them to Uppercase and them concatenate them;
        List<String> stringList1 = Arrays.asList("a","b","c","d");

        String ans1 = stringList1.stream().map(String::toUpperCase)
                .reduce("",(a,b)->a+b);
        System.out.println(ans1);

        //41 Concatenate two stream
        Stream<String> stream1 = Stream.of("Vinayak","Amit");
        Stream<String> stream2 = Stream.of("Noida","Delhi");

        Stream<String> concatenatedStream = Stream.concat(stream1,stream2);
        concatenatedStream.forEach(System.out::println);
    }
}
