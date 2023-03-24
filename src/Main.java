import java.util.ArrayList;
import java.util.List;
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
    }
}
