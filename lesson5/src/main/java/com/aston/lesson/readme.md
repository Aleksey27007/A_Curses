------------------------
### Лямбда выражения, функциональные интерфейсы, Stream API

------------------------

▎Лямбда-выражения

• Лямбда-выражение — это способ представления анонимной функции, который позволяет создавать экземпляры функциональных интерфейсов с помощью более компактного синтаксиса.

• Синтаксис:

(аргументы) -> { тело_метода }


• Пример:

// Простой пример лямбда-выражения
Runnable runnable = () -> System.out.println("Hello from a lambda!");
runnable.run(); // Вывод: Hello from a lambda!


------------------------
▎Функциональные интерфейсы

• Функциональный интерфейс — это интерфейс, который содержит только один абстрактный метод. Они могут иметь несколько методов по умолчанию или статических методов.

• Примеры встроенных функциональных интерфейсов:

• Runnable: не принимает аргументов и не возвращает значения.

• Callable<V>: принимает аргумент и возвращает значение.

• Consumer<T>: принимает объект типа T и ничего не возвращает.

• Supplier<T>: не принимает аргументов и возвращает объект типа T.

• Function<T, R>: принимает объект типа T и возвращает объект типа R.

• Predicate<T>: принимает объект типа T и возвращает boolean.

------------------------
▎Пример функционального интерфейса

@FunctionalInterface
interface MyFunctionalInterface {
void execute(String message);
}

// Использование лямбда-выражения для реализации функционального интерфейса
MyFunctionalInterface myFunc = (msg) -> System.out.println(msg);
myFunc.execute("Hello, Functional Interface!"); // Вывод: Hello, Functional Interface!


------------------------
▎Stream API

• Stream API — это мощный инструмент для обработки коллекций данных с использованием функционального подхода. Позволяет работать с последовательностями элементов, поддерживает операции фильтрации, сортировки, преобразования и агрегации.

------------------------
▎Основные операции Stream API

1. Создание потока:

   • Из коллекций:

   List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
   Stream<String> stream = names.stream();


2. Промежуточные операции:

   • filter: фильтрует элементы по условию.

   • map: преобразует элементы.

   • sorted: сортирует элементы.

   • distinct: удаляет дубликаты.

3. Терминальные операции:

   • forEach: выполняет действие над каждым элементом.

   • collect: собирает элементы в коллекцию.

   • reduce: сводит элементы к единственному значению.

▎Примеры использования Stream API

------------------------
1. Фильтрация и вывод

   List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
   >names.stream()
   >>.filter(name -> name.startsWith("A")) // Фильтруем имена, начинающиеся на "A"
   >> 
   >>>.forEach(System.out::println); // Вывод: Alice


2. Преобразование и сбор в список

   List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
   List<String> upperCaseNames = names.stream()
   >.map(String::toUpperCase) // Преобразуем в верхний регистр
   >>.collect(Collectors.toList());
   >>>System.out.println(upperCaseNames); // Вывод: [ALICE, BOB, CHARLIE]


3. Сортировка

   List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
   List<String> sortedNames = names.stream()
   >.sorted() // Сортируем по алфавиту
   >>.collect(Collectors.toList());
   >>>System.out.println(sortedNames); // Вывод: [Alice, Bob, Charlie]


4. Агрегация

   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
   int sum = numbers.stream()
   >.reduce(0, Integer::sum); // Суммируем числа
   >>System.out.println(sum); // Вывод: 15


5. Уникальные элементы

   List<String> names = Arrays.asList("Alice", "Bob", "Alice", "Charlie");
   List<String> uniqueNames = names.stream()
   >.distinct() // Удаляем дубликаты
   >>.collect(Collectors.toList());
   >>>  System.out.println(uniqueNames); // Вывод: [Alice, Bob, Charlie]
   ▎Заключение

------------------------
Лямбда-выражения и Stream API позволяют писать более читаемый и лаконичный код в 
Java. Они делают работу с коллекциями более удобной и эффективной благодаря 
функциональному стилю программирования.