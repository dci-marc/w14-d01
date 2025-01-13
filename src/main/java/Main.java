import interfaces.Account;
import interfaces.Book;
import interfaces.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Main {
  private static final String SEPARATOR = "--------------------------------------------------";

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    numbers
      .stream()
      .filter(n -> n % 2 == 0)
            .forEach(System.out::println)
    ;

    System.out.println(Main.SEPARATOR);

    List<Student> students = new ArrayList<>(Arrays.asList(
      new Student("Alice", 90),
      new Student("Bob", 80),
      new Student("Charlie", 70),
      new Student("David", 60),
      new Student("Eve", 50)
    ));

    students
      .stream()
      .filter(s -> s.getGrade() > 60)
            .forEach(s -> System.out.println(s.getName() + " passed!"))
    ;

    System.out.println(Main.SEPARATOR);

    Account account = new Account() {
      @Override
      public String toString() {
        return "Account";
      }

      @Override
      public String getId() {
        return "12345";
      }
    };

    System.out.println("Account name: " + account + "; Account ID: " + account.getId());

    System.out.println(Main.SEPARATOR);

    // functional interfaces
    Book book = () -> "Java Programming";
    System.out.println(book.getBookName());

    System.out.println(Main.SEPARATOR);

//  Instance    | Signature      | Body
    Math math = (a, b) -> a + b;
    System.out.println("Sum of 5 and 7 is: " + math.add(5, 7));

    System.out.println(Main.SEPARATOR);

    // Predicate
    Predicate<Integer> isEven = n -> n % 2 == 0;
    System.out.println("Is 10 even? " + isEven.test(10));
    IntPredicate isOdd = n -> n % 2 != 0;
    System.out.println("Is 11 odd? " + isOdd.test(11));

    System.out.println(Main.SEPARATOR);

    // Function
    Function<Integer, Integer> number = n -> n * 2;
    System.out.println("Double of 5 is: " + number.apply(5));

    System.out.println(Main.SEPARATOR);

    // BiFunction
    BiFunction<Integer, Integer, Integer> sum = (a, b) -> a + b;
    System.out.println("Sum of 5 and 7 is: " + sum.apply(5, 7));

    System.out.println(Main.SEPARATOR);

    // Predict Student
    Predicate<Student> isPass = s -> s.getGrade() > 60;
    students
      .stream()
      .filter(isPass)
            .forEach(s -> System.out.println(s.getName() + " passed!"))
    ;

    System.out.println(Main.SEPARATOR);

    // PrePredicate
    BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
    System.out.println("Is 5 greater than 7? " + isGreater.test(5, 7));

    System.out.println(Main.SEPARATOR);

    // Function for square()
    Function<Integer, Integer> square = n -> n * n;
    System.out.println("Square of 5 is: " + square.apply(5));

    System.out.println(Main.SEPARATOR);

    // Consumer
    Consumer<String> print = System.out::println;
    print.accept("Hello, World!");

    System.out.println(Main.SEPARATOR);

    // BiConsumer
    BiConsumer<String, String> concat = (a, b) -> System.out.println(a + b);
    concat.accept("Hello, ", "World!");

    System.out.println(Main.SEPARATOR);

    // Supplier
    Supplier<String> message = () -> "Hello, World!";
    System.out.println(message.get());

    System.out.println(Main.SEPARATOR);

    // UnaryOperator
    UnaryOperator<Integer> increment = n -> n + 1;
    System.out.println("Increment of 5 is: " + increment.apply(5));

    System.out.println(Main.SEPARATOR);
  }
}