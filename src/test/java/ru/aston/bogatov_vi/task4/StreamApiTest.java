package ru.aston.bogatov_vi.task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiTest {
    private static Stream<Person> stream;
    private static  Stream<Integer> intStream;

    @BeforeEach
    void init(){
        stream = Stream.of(
                new Person("Vlad", "Bogatov", 24, City.KAZAN),
                new Person("Ruslan", "Akhmetov", 23, City.MOSCOW),
                new Person("Sasha", "Konov", 22, City.ARKHANGELSK),
                new Person("Tamerlan", "Nureyev", 22, City.KAZAN),
                new Person("Adelina", "Magdeeva", 21, City.MINSK)
        );

        intStream = Stream.iterate(0, i -> i + 1).limit(100);
    }


    @Test
    @DisplayName("Вывести все четные числа в диапазоне от 1 до 100")
    void evenNumbers(){
        intStream
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Посчитать сумму чисел в массиве [1, 2, 3, 4, 5], используя reduce()")
    void sumNumbers(){
        Optional<Integer> sum = intStream.limit(5).reduce((x, y) -> x + y);
        System.out.println(sum.get());
    }

    @Test
    @DisplayName("Найти первый четный элемент в списке [1, 2, 3, 4, 5]")
    void findEvenNumbers(){
        List<Integer> listNumber = intStream.toList();
        Optional<Integer> evenNumber = listNumber.stream()
                .limit(10)
                .skip(1)
                .filter(n -> n % 2 == 0)
                .findFirst();
        System.out.println(evenNumber.get());
    }

    @Test
    @DisplayName("Выведите на экран элементы списка, которые не входят в другой список.")
    void testList(){
        List<Integer> intList = Stream.iterate(0, i -> i + 1).limit(20).toList();

        intStream
                .filter(number -> {
                    for (Integer integer : intList){
                        if (number.equals(integer)){
                            return false;
                        }
                    }
                    return true;
                })
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Создайте Stream, который выводит на экран четные числа от 2 до 30.")
    void outputEvenNumbers(){
        intStream.skip(2)
                .limit(30)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Создайте три Stream-а из массивов чисел 1…10, 5…20 и 10…30 соответственно. " +
            "Объедините их в один Stream и выведите числа, которые кратны 3 или 5.")
    void joinArrayNumbers(){
        Stream<Integer> integerStream1 = intStream = Stream.iterate(1, i -> i + 1).limit(10);
        Stream<Integer> integerStream2 = intStream = Stream.iterate(5, i -> i + 1).limit(20);
        Stream<Integer> integerStream3 = intStream = Stream.iterate(10, i -> i + 1).limit(30);

        Stream.of(integerStream1, integerStream2, integerStream3)
                .flatMap(integerStream -> integerStream)
                .filter(numbers -> numbers % 3 == 0 || numbers % 5 == 0).forEach(System.out::println);
    }

    @Test
    @DisplayName("Создайте Stream чисел от 2 до 10. " +
            "Умножьте их на 2 и выведите результат на экран, ограничьтесь первыми десятью результатами.")
    void sumStream(){
        intStream
                .skip(2)
                .limit(9)
                .map(number -> number * 2)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Соберите числа в Stream в одно число, перемножив их между собой и выведите результат.")
    void outputNumberStream(){
        Optional<Integer> integer = intStream
                .skip(1).limit(10)
                .reduce((x, y) -> x * y);
        System.out.println(integer.get());
    }

    @Test
    @DisplayName("Задан массив строк. Используя средства StreamAPI отсортировать строки в лексикографическом порядке")
    void sortNamePerson(){
        stream.sorted(Comparator.comparing(Person::getName))
                .map(Person::getName)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Разделить числа в Stream на три группы по остатку от деления на 3 (0, 1, 2), " +
            "посчитать сумму чисел в каждой группе.")
    void groupNumbers(){
        intStream
                .collect(Collectors.groupingBy(number -> number % 3))
                .forEach((key, number) -> System.out.println(key + ":" + number));
    }
}