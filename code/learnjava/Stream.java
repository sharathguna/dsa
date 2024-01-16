package code.learnjava;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Stream {
  public static void main(String[] args) {
    List<User> users =
        List.of(new User(1L, "Amirhosein", "Gharaati", "amirgh1380@gmail.com", 22, List.of("computer", "board games")),
            new User(2L, "Mohammad", "Shoja", "rezajsh@yahoo.com", 20, List.of("computer", "guitar")),
            new User(3L, "Babak", "Ahmadi", "babakahmadi@gmail.com", 33, List.of("shopping")),
            new User(4L, "Robin", "Eklund", "robin.eklund@twitter.com", 28, List.of("reading")),
            new User(5L, "Amir", "Gharaati", "amirtvkli@gmail.com", 30, List.of("reading", "computer", "cooking")),
            new User(6L, "Sharath", "G", "Sharath@focalpay.se", 26, List.of("computer", "photography")),
            new User(7L, "Santosh", "G", "santosh@focalpay.se", 24, List.of("computer", "music")),
            new User(8L, "Vidya", "G", "vidya@focalpay.se", 24, List.of("mehandi")),
            new User(9L, "Nadhiya", "B", "nadhiya@focalpay.se", 19, List.of("computer", "songs")),
            new User(10L, "Bhavya", "G", "bhavya@focalpay.se", 21, List.of("sleeping")),
            new User(11L, "Ganesh", "P", "ganesh@focalpay.se", 27, List.of("social")),
            new User(12L, "Chethan", "B", "chethan@focalpay.se", 26, List.of("travel")));

    List<User> result = users.stream().filter(a -> a.getAge() < 25).limit(3).sorted().collect(Collectors.toList());

    Predicate<User> ageGreaterThan23 = user -> user.getAge() > 30;

    List<User> usersGreaterThan23 = users.stream().filter(ageGreaterThan23).collect(Collectors.toList());

    usersGreaterThan23.forEach(System.out::println);
    System.out.println("---------------------------");
    Comparator<User> compareFirstName = (user1, user2) -> user1.getFirstName().compareTo(user2.getFirstName());
    usersGreaterThan23.stream().limit(5).sorted(compareFirstName).forEach(System.out::println);
    System.out.println("---------------------------");
    Comparator<User> compareEmail = Comparator.comparing(User::getEmail);
    usersGreaterThan23.stream().sorted(compareEmail).forEach(System.out::println);
    System.out.println("---------------------------");
    Function<User, String> nameAndAge = user -> user.getFirstName() + " " + user.getAge();
    List<String> nameWithAge = users.stream().map(nameAndAge).collect(Collectors.toList());

    nameWithAge.stream().sorted().forEach(System.out::println);

    System.out.println("---------------------------");

    Optional<User> ageGreaterThan32 = users.stream().filter(ageGreaterThan23).findAny();
    System.out.println(ageGreaterThan32.isPresent() ? ageGreaterThan32.get() : "No user available");

    System.out.println("---------------------------");

    long computerInterests =
        users.stream().map(User::getInterests).filter(interest -> interest.contains("computer")).count();
    System.out.println("People with computer interests are  : " + computerInterests);

    System.out.println("---------------------------");
    users.stream().map(User::getInterests).flatMap(List::stream).distinct().forEach(System.out::println);

    System.out.println("---------------------------");
    Function<User, Integer> ages = User::getAge;
    users.stream().map(ages).distinct().sorted().forEach(System.out::println);

    System.out.println("---------------------------");
    Map<String, Long> interestMap = users.stream()
        .map(User::getInterests)
        .flatMap(Collection::stream)
        .collect(Collectors.groupingBy(interest -> interest, Collectors.counting()));

    for (Map.Entry<String, Long> entry : interestMap.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue());
    }

    System.out.println("---------------------------");
    List<Long> ids = List.of(1L, 2L, 7L,25L,50L);

    ids.stream().map(id -> users.stream().filter(user -> user.getId().equals(id)).findFirst()).flatMap(Optional::stream).forEach(System.out::println);
    users.stream().map( user -> ids.contains(user.getId()) ? user : null).filter(Objects::nonNull).forEach(System.out::println);

    System.out.println("---------------------------");
    Set<String> duplicatedLastNames;

    duplicatedLastNames = users.stream().collect(Collectors.groupingBy(User::getLastName,Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() > 1).map(
        Map.Entry::getKey).collect(Collectors.toSet());

    duplicatedLastNames.forEach(System.out::println);
    System.out.println("---------------------------");
    String value = "this is a duplicated values containing string";
    System.out.println(value.chars().distinct().mapToObj(ch -> (char)ch).map(Object::toString).collect(Collectors.joining()));

    System.out.println("---------------------------");
    value.chars().mapToObj(ch->(char)ch).peek(System.out::print).map(Object::toString).collect(Collectors.toList());
    System.out.println(value.chars().peek(ch -> System.out.println((char)ch)).count());

    System.out.println(IntStream.of(1,3,5,9,7).reduce(100, Integer::sum));
    }
}
