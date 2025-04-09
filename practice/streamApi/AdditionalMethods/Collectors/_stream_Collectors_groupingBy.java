package practice.streamApi.AdditionalMethods.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class _stream_Collectors_groupingBy {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("John", "New York", "Qwe"),
                new Person("Amlie", "London","Ury"),
                new Person("Abc", "New York","Qwe")
        );

        Map<String, List<Person>> result = people.stream()
                .collect(Collectors.groupingBy(Person::getCity));

        for(Map.Entry<String,List<Person>> entry : result.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        //System.out.println(people.stream().collect(Collectors.mapping(Person::getLastName, toSet())));
    }
}

class Person{
    private String name;
    private String city;
    private String lastName;

    public Person(String name, String city, String lastName) {
        this.name = name;
        this.city = city;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString(){
        return name + " (" + lastName + ") from " + city;
    }
}
