import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }


    public static void task1() {
        System.out.println("Задание 1");

//  Напишите реализации функционального интерфейса Predicate, которые проверяют, является ли число положительным.
//  Если число положительное, то предикат должен возвращать true, в противном случае — false.
//  Реализуйте Predicate в двух вариантах:
//  через анонимный класс,
//  через лямбду.

        Nums num1 = new Nums(1_000);
        Nums num2 = new Nums(-1_000);
        Nums num3 = new Nums(100);
        Nums num4 = new Nums(-100);
        Nums num5 = new Nums(10);
        Nums num6 = new Nums(-10);
        Nums num7 = new Nums(5);
        Nums num8 = new Nums(3);
        Nums num9 = new Nums(1);
        Nums num10 = new Nums(-1);

        List<Nums> numList = new ArrayList<>();

        numList.add(num1);
        numList.add(num2);
        numList.add(num3);
        numList.add(num4);
        numList.add(num5);
        numList.add(num6);
        numList.add(num7);
        numList.add(num8);
        numList.add(num9);
        numList.add(num10);

        numList.removeIf(new Predicate<Nums>() {
            @Override
            public boolean test(Nums nums) {
                return nums.getNum() < 0;
            }
        });

        numList.removeIf(num -> num.getNum() < 0);


        for (Nums num : numList) {
            System.out.println(num);
        }
    }

    public static void task2() {
        System.out.println("Задание 2");
//  Создайте функциональный интерфейс Consumer, который принимает на вход имя человека и выводит в консоль приветствие в его адрес.
//  Реализуйте его в двух вариантах: через анонимный класс и через лямбду.

        Person person1 = new Person("Стивен Хокинг");
        Person person2 = new Person("Илон Маск");
        Person person3 = new Person("Стив Джобс");
        Person person4 = new Person("Павел Дуров");
        Person person5 = new Person("Билл Гейтс");
        Person person6 = new Person("Марк Цукерберг");
        Person person7 = new Person("Тим Кук");

        List<Person> listPerson = new ArrayList<>();

        listPerson.add(person1);
        listPerson.add(person2);
        listPerson.add(person3);
        listPerson.add(person4);
        listPerson.add(person5);
        listPerson.add(person6);
        listPerson.add(person7);

        Consumer<Person> consumer = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println("Мое почтение, " + person.getName() + "!");
            }
        };
//        Consumer <Person> consumer = (Person person) -> {
//            System.out.println("Мое почтение, " + person.getName() + "!");
//        };

        for (Person person : listPerson) {
            consumer.accept(person);
        }
    }

    public static void task3() {
        System.out.println("Задание 3");

//        Реализуйте функциональный интерфейс Function, который принимает на вход вещественное число типа Double,
//        а возвращает его округленный вариант типа Long.
//        Реализуйте его в двух вариантах: через анонимный класс и через лямбду.

        Double doubleN1 = new Double(3.14d);
        Double doubleN2 = new Double(6.283d);
        Double doubleN3 = new Double(2.718d);
        Double doubleN4 = new Double(0.57d);
        Double doubleN5 = new Double(0.55d);


        List<Double> dList = new ArrayList<>();
        dList.add(doubleN1);
        dList.add(doubleN2);
        dList.add(doubleN3);
        dList.add(doubleN4);
        dList.add(doubleN5);

//        Function <Double, Long> function = new Function<Double, Long>() {
//            @Override
//            public Long apply(Double aDouble) {
//                return (long) aDouble.getNum() ;
//            }
//        };

        Function<Double, Long> function = aDouble -> (long) aDouble.getNum();

        for (Double aDouble : dList) {
            System.out.println(function.apply(aDouble));
        }
    }

    public static void task4() {
        System.out.println("Задание 4");
//        Напишите Supplier, который возвращает случайное число из диапазона от 0 до 100.
//        Реализуйте его в двух вариантах: через анонимный класс и через лямбду

//        Supplier <Integer> randomNum = new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//               int num = (int) (Math.random() * 100);
//                return num;
//            }
//        };

        Supplier<Integer> randomNum = () -> {
            Random random = new Random();
            int num = (int) (Math.random() * 100);
            return num;
        };
        System.out.println(randomNum.get());
    }

    public static void task5() {
        System.out.println("Задание 5");

//  Теперь попрактикуемся в комбинировании нескольких функций в одну сложную конструкцию.
//  Для примера построим следующую комбинацию.
// Дан предикат condition и две функции: ifTrue и ifFalse.
//Напишите метод ternaryOperator, который из предиката и двух функций построит новую функцию,
// возвращающую значение функции ifTrue, если предикат выполнен, а в остальных случаях — ifFalse.
//
//public static <T, U> Function<T, U> ternaryOperator(
//   Predicate<? super T> condition,
//   Function<? super T, ? extends U> ifTrue,
//   Function<? super T, ? extends U> ifFalse) {
//   ...
//}
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer > 18) {
                    return false;
                }
                return true;
            }
        };
        Function<Integer, Integer> function = a -> (int) Math.random();
        Function<Integer, String> function2 = a -> a.toString();
        System.out.println(ternaryOperator(predicate, function, function2).apply(1));
    }
    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return a -> condition.test(a) ? ifTrue.apply(a) : ifFalse.apply(a);
    }
}



