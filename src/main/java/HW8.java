
import java.util.Random;

public class HW8 {

    //Задание 8.1
    //Приведите пример использование хеш-таблиц.
    // - быстрый поиск информации в базе данных по ключу
    //Задание 8.2
    //Приведите примеры ключей и коллизий.
    // - примеры ключей: ключем может быть логин при регистрации, название товара в базе данных
    // - пример коллизий: когда хеш от двух разных товаров указывает на одну и тоже строку базы данных
    //Задание 8.3
    //Приведите примеры популярных и эффективных хеш-функций.
    // - Хеширование MD5 для проверки целостности файлов,  SHA256 - применяется в различных криптоалгоритма
    //Задание 8.4
    //На основе данных массива из задания 2.3 реализуйте хеш-таблицу с помощью открытой адресации, а конкретнее метода линейного пробирования
    //Задание 8.5
    //Перестройте программный код задания 8.4 из алгоритма линейного пробирования в алгоритм двойного хеширования.
    //Сравните отличительные черты двух алгоритмов.
    // - функция двойного-хеширования вызвает меньше коллизий по сравнения линейным пробированием
    //Решение:

    private static final int SIZE_ARRAY = 400;
    private static final int SIZE_HASH_TABLE = 800;
    private static final int BOUND_RANDOM = 200;

    public static void main(String[] args) {

        int[] intArray = new int[SIZE_ARRAY];

        Random rand = new Random();
        for (int i=0; i<SIZE_ARRAY; i++){
            intArray[i]=rand.nextInt(BOUND_RANDOM);
        }

        Item aDataItem;

        HashTable hTable = new HashTable(SIZE_HASH_TABLE);

        for (int i : intArray) {
            aDataItem = new Item(i);
            hTable.insert(aDataItem);
        }

        hTable.insert(new Item(201));
        hTable.insert(new Item(202));
        hTable.delete(201);

        hTable.display();

        System.out.println(hTable.find(202).getKey());
    }

}