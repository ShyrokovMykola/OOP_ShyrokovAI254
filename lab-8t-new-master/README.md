# Лабораторная работа 8. Узагальнене програмування

## Цілі лабораторної роботи:

- Вивчити принципи та мету механізму узагальненого програмування;
- Навчитися створювати узагальнені класи та інтерфейси;
- Розібратися з процесом створення узагальнених методів.

## Завдання на лабораторну роботу

### Завдання 1

У Java є клас `java.util.Optional<T>`, який використовується для безпечної роботи з можливою відсутністю значення (наприклад, користувач може не мати по-батькові; API-виклик може повернути null замість даних і т.д.).

Ваше завдання — створити спрощену версію такого класу: `MyOptional<T>`.

Цей клас:

- всередині зберігає або значення типу `T`, або "порожній стан" (немає значення);
- не дозволяє звертатися до значення напряму, поки ви не перевірили, що воно існує;
- надає зручні методи, щоб працювати без `null`.

У звичайному Java-коді дуже часто трапляється ситуація "значення може бути, а може не бути".

Приклади з життя:

- пошук користувача в базі по логіну: такий користувач може існувати, а може й ні.
- у користувача може бути друге ім’я / по-батькові, а може не бути.
- HTTP-запит міг повернути тіло відповіді (дані), а міг повернути помилку, і тоді тіла немає.
- для налаштувань програми: користувач може задати свою кастомну тему інтерфейсу, а може залишити стандартну.

Традиційно в таких випадках у Java просто повертали `null`. Наприклад:

```java
User user = repository.findUser("admin"); // може повернути або User, або null
```

Проблема: дуже легко забути перевірку `if (user != null)` і далі отримати `NullPointerException` десь зовсім в іншому місці коду. Це класика типу "все працювало, поки не впало у клієнта".

#### Яку проблему вирішує Optional

Ідея `Optional<T>` — зробити відсутність значення явною і керованою.

Замість того, щоб повертати або `User`, або `null`, ми повертаємо `Optional<User>` (або наш `MyOptional<User>`). Це означає буквально:
- "Ось контейнер, у ньому АБО є `User`, АБО немає `User`. Ти мусиш це обробити."

Таким чином немає "магічного `null`", який трошки сховався і потім вибухнув.

Приклад:

```java
MyOptional<User> maybeUser = authService.findUserByLogin("admin");

if (maybeUser.isPresent()) {
    // ок, користувач є
    System.out.println("Hello, " + maybeUser.get().getUsername());
} else {
    // користувача не знайшли
    System.out.println("Access denied.");
}
```

Тут компілятор майже змушує тебе думати про обидва сценарії:
- значення існує;
- значення відсутнє.

Це одразу робить код безпечнішим і зрозумілішим.

#### Де таке реально використовується

`Optional<T>` (вбудований у стандартну бібліотеку Java починаючи з Java 8) масово використовується в реальних проєктах у таких місцях:

1. Пошук по ID / логіну / email / токену. Наприклад:

```java
Optional<User> findByEmail(String email)
```

Тому що користувача з таким `email` може не бути, і це НЕ є помилка сервера — це нормальний сценарій.

2. Конфігурація / налаштування. Наприклад:

```java
Optional<String> getCustomTitle();
```

Якщо користувач не встановив собі кастомний заголовок — повертаємо порожній `Optional`, а не `null`.

3. Парсинг значень. Наприклад:

```java
Optional<Integer> tryParseInt(String text)
```
Якщо текст неможливо перетворити на число — це не аварія, це просто "не вдалося", і ми повертаємо порожній варіант.

4. Робота з необов’язковими полями у формах. Наприклад, номер телефону не є обов’язковим, але якщо він є - ми хочемо його використати.


#### Чому не просто кидати виняток?

Можна сказати: якщо не знайшли користувача - кинемо `Exception`. Проблема в тому, що "не знайшли користувача" - це не аварія. Це нормальна бізнес-ситуація:

- користувач ввів неправильний логін? Звісно, що таке буде зустрічатися постійно.
- людина не ввела по-батькові в анкеті? Це не помилка програми.

Винятки в нормальному коді повинні описувати НЕОЧІКУВАНІ ситуації (БД впала, файл не можна прочитати, немає прав доступу), а не "звичайно, так теж могло статись".

'Optional' якраз відділяє "нормально, просто даних нема" від "аварія, все погано".

#### Чому не просто залишити `null` і перевіряти?

Проблема в `null` така:

- він тихо проходить через купу методів;
- наступний розробник (або ти через 2 тижні) забуде зробити `if (x != null)` в одному місці;
- воно грохнеться в неочікуваному місці, і дебажити важко.

`Optional` робить відсутність значення частиною типу. Тобто ти по сигнатурі методу вже бачиш поведінку:

```java
User findUserByLogin(String login)           // може повернути null
MyOptional<User> findUserByLogin(String login) // завжди повертає об’єкт, але той об’єкт може бути "порожнім"
```

Друга сигнатура чесніша. Вона не бреше.

#### Завдання

Реалізуйте свій клас `MyOptional<T>` (узагальнений клас) зі створенням об’єктів через конструктори.

Вимоги до класу `MyOptional<T>`

Створіть клас:

```java
public class MyOptional<T> {
    // поля, конструктори, методи - див. нижче
}
```

1. Приватні поля:

- `private T value;`
- `private boolean present` - означає, що значення реально існує всередині.

2. Конструктор без параметрів (порожній):

```java
public MyOptional() {
    // створює "порожній" об'єкт
}
```

Результат: `present == false`. Це означає "значення відсутнє".

3. Конструктор з параметром:

```java
public MyOptional(T value) {
    // створює об'єкт зі значенням
}
```

Вимоги:

- зберегти `value` у поле;
- встановити `present = true;`;
- якщо `value == null`, потрібно кинути IllegalAr`gumentException з повідомленням типу "MyOptional не приймає null".

Пояснення: ми не дозволяємо створити `MyOptional`, який начебто "має значення", але значення насправді `null`. Це небезпечно і незрозуміло.

4. Метод `boolean isPresent()`

```java
public boolean isPresent() {
    // повертає true, якщо значення є
}
```

5. Метод `boolean isEmpty()`

```java
public boolean isEmpty() {
    // повертає true, якщо значення немає
}
```

Підказка: `isEmpty()` просто повертає `!isPresent()`.

6. Метод `T get()`

```java
public T get() {
    // якщо значення є -> повернути його
    // якщо значення немає -> кинути IllegalStateException
}
```

7. Метод `T orElse(T defaultValue)`

```java
public T orElse(T defaultValue) {
    // якщо значення є -> повернути його
    // якщо нема -> повернути defaultValue
}
```

Приклад очікуваної поведінки:

- якщо в нас є new `MyOptional<>("admin")`, то `orElse("guest")` повертає "admin";
- якщо в нас new `MyOptional<>() (порожній)`, тоді `orElse("guest")` повертає "guest".

8. Метод `toString()`

```java
@Override
public String toString() {
    // якщо значення є -> "MyOptional[value=admin]"
    // якщо значення немає -> "MyOptional[empty]"
}
```

#### Протестуйте свій клас у методі `main`

```java
public class ua.opnu.Main {
    public static void main(String[] args) {

        // 1. Порожнє значення (наприклад, у користувача немає по-батькові)
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName); // MyOptional[empty]
        System.out.println("isPresent: " + middleName.isPresent()); // false
        System.out.println("orElse: " + middleName.orElse("немає")); // "немає"

        // 2. Заповнене значення (наприклад, логін користувача)
        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username); // MyOptional[value=admin]
        System.out.println("isPresent: " + username.isPresent()); // true
        System.out.println("get(): " + username.get()); // "admin"
        System.out.println("orElse: " + username.orElse("guest")); // "admin"

        // 3. Перевіримо, що get() на порожньому об'єкті кидає помилку
        try {
            String test = middleName.get(); // має кинути IllegalStateException
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        // 4. Перевіримо, що конструктор не приймає null
        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }
    }
}
```


### Завдання 2

Дан клас `BookData`, який моделює інформацію про книгу в інтернет-магазині. Поле `reviews` зберігає загальну кількість оцінок користувачів, а `total` зберігає загальну суму оцінок. Рейтинг книги вираховується як `total / reviews`.

```java
class BookData {

    private String title;
    private String author;
    private int reviews;
    private double total;
}
```

Необхідно зробити так, щоб клас підтримував узагальнений інтерфейс `Comparable<>`. Книга з більш високим рейтингом повинна бути "менше", ніж книга з меншим рейтингом. У разі рівності рейтингів, книги порівнюються за назвою у звичайному порядку.

### Завдання 3

Даний наступний код

```java
import java.lang.reflect.Method;
public class ua.opnu.Main {
    public static void main(String[] args) {
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
    }
}

class Printer {}
```

Згідно коду, є масив цілих чисел та масив рядків. Напишіть в класі `Printer` узагальнений метод `printArray()`, який може роздруковувати всі елементи як масиву цілих чисел, так і масиву рядків (дивіться код методу `main()`).

Якщо задача вирішена вірно, код в методі `main()` повинен працювати коректно та роздруковувати елементи масивів. **Код методу `main()` змінювати не можна!**

### Задание 4

Даний приклад методу `filter()` з лабораторной роботи 7.

```java
public int[] filter(int[] input, Predicate p) {
    int[] result = new int[input.length];

    int counter = 0;
    for (int i : input) {
        if (p.test(i)) {
            result[counter] = i;
            counter++;
        }
    }

    return Arrays.copyOfRange(result, 0, counter);
}
```

Напишіть узагальнену версію методу `filter()`, який міг би приймати на вхід масив об'єктів типу `T` та узагальнений предикат типу `T`.

Для створення масиву узагальненого типу використовуйте наступну конструкцію

```java
T[] array = (T[])new Object[INITIAL_ARRAY_LENGTH];
```

### Завдання 5

Даний метод `contains()`, що перевіряє входження рядку у масив рядків.

```java
boolean contains(String[] array, String element) {

    for (String str : array)
        if (str.equals(element))
            return true;

    return false;
}
```

Напишіть узагальнену версію методу `contains()`. Узагальнена версія методу приймає на вхід масив типу `T` (тип `T` повинен реалізовувати узагальнений інтерфейс `Comparable`) та об'єкт типу `V` (який повинен бути чи типом `T` чи його підкласом). 

### Завдання 6

Одним ж потужних механізмів, який відсутній в мові Java - це можливість повертати множину об'єктів в результаті роботи методу. Оператор `return` дозволяє вказати тільки один об'єкт, але ми можемо створити об'єкт, який зберігає в собі декілька об'єктів, які ви бажаєте повернути.

Така концепція називається **кортежем** (**tuple**) та представляє собою групу об'єктів, які "загорнуті" в один об'єкт. Отримувач об'єкту може читати елементи, а не може додавати чи змінювати присутні елементи.

Кортежи можуть бути різної довжини, але кожен об'єкт кортежу може мати будь-який тип. Щоб забезпечити типобезпеку такого кортежу, можно використати механізм узагальненого програмування.

Нижче наведений приклад кортежу для двох конкретних типів.

```java
class ConcreteTwoTuple {

    public final String first;
    public final Integer second;

    public ConcreteTwoTuple(String first, Integer second) {
        this.first = first;
        this.second = second;
    }
    
    @Override
    public String toString() {
        return "(" + first + "," + second + ')';
    }
}
```

Нижче представлений приклад використання такого кортежу

```java
StudentRatingTuple tuple = getStudentWithRating("Іванов Петр Петрович");
System.out.println("Студент: " + tuple.first + ", рейтинг: " + tuple.second);

...

public StudentRatingTuple getStudentWithRating(String fullName) {
    Student student = new Student(fullName);
    int rating = student.calculateRating();

    return new StudentRatingTuple(student, rating);
}

...

class StudentRatingTuple {

    public final Student first;
    public final Integer second;

    public StudentRatingTuple(Student first, Integer second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ')';
    }
}
```

Такий підхід не дає достатньої гнучкості, так як для кожного типу `first` чи `second` ми повинні створювати свій окремий клас.

Ми можемо використати тип `Object`

```java
class ObjectTwoTuple {

    public final Object first;
    public final Object second;

    public ObjectTwoTuple(Object first, Object second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + "," + second + ')';
    }
}
```

але такий підхід не зберігає інформацію щодо типу полів `first` та `second`.

Ваше завдання полягає в наступному - вирішити цю проблему за допомогою механізму узагальненого програмування.

1. Напишіть узагальнену версію класу `ConcreteTwoTuple` під назвою `GenericTwoTuple`, в якій поле `first` буде мати тип `T`, а поле `second` - тип `V`.
2. Створіть клас під назвою `GenericThreeTuple` та використовуючи механізм композиції, використайте функціонал класу `GenericTwoTuple` та додайте ще одне поле поле `three` типу `S`.
3. Продемонструйте роботу класу `GenericTwoTuple` та `GenericThreeTuple` на прикладах, які ви придумаєте самостійно.
