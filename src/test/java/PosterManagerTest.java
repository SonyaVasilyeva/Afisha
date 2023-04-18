import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {

    PosterManager manager = new PosterManager();
    PosterManager manager1 = new PosterManager(2);

    PosterItem item1 = new PosterItem(1, "Бладшот", "боевик");
    PosterItem item2 = new PosterItem(2, "Вперёд", "мультфильм");
    PosterItem item3 = new PosterItem(3, "Отель Белград", "комедия");
    PosterItem item4 = new PosterItem(4, "Джентльмены", "боевик");
    PosterItem item5 = new PosterItem(5, "Человек-невидимка", "ужасы");
    PosterItem item6 = new PosterItem(6, "Тролли.Мировой тур", "мультфильм");
    PosterItem item7 = new PosterItem(7, "Номер один", "комедия");


/*    @BeforeEach
    public void setUp() {
        manager.addFilm(item1);
        manager.addFilm(item6);
        manager.addFilm(item4);
        manager.addFilm(item2);
        manager.addFilm(item5);
    }*/

    @Test
    public void shouldGetAllFilms() {
        int expected = 0;
        Assertions.assertEquals(expected, manager.findAll().length); // проверка вывода, если в массиве 0 фильмов

/*      PosterItem[] expected = {}; // new PosterItems[0];
        PosterItem[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, manager.findAll());*/


        manager.addFilm(item1);
        manager1.addFilm(item1);

        PosterItem[] added1Film = {item1};
        // PosterItem[] actual1 = manager.findAll();
        Assertions.assertArrayEquals(added1Film, manager.findAll()); // проверка добавления 1 фильма в объекты с разным конструктором, когда изначально 0 фильмов
        Assertions.assertArrayEquals(added1Film, manager1.findAll());


        manager.addFilm(item6);
        manager.addFilm(item4);
        manager.addFilm(item2);
        manager.addFilm(item5);

        PosterItem[] added4Films = {item1, item6, item4, item2, item5}; // проверка добавления нескольких фильмов, когда изначально в афише уже есть 1 фильм
        PosterItem[] actual2 = manager.findAll();
        Assertions.assertArrayEquals(added4Films, actual2);

    }

    @Test
    public void shouldAddNullFilms() {
        manager.addFilm(item1);
        manager.addFilm(null);
        PosterItem[] expected = {item1, null};
        PosterItem[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetReversedFilmsWithParametrizedConstructor() { // Проверка вывода фильмов в обратном порядке
        manager1.addFilm(item1);
        manager1.addFilm(item2);
        PosterItem[] expected = {item2, item1};
        PosterItem[] actual = manager1.findLast();
        Assertions.assertArrayEquals(expected, actual);//Проверка вывода 2 последних фильмов конструктором с параметром, когда на афише только 2 фильма

        manager1.addFilm(item3);
        manager1.addFilm(item4);
        PosterItem[] expected2Films = {item4, item3};
        PosterItem[] actual2 = manager1.findLast();
        Assertions.assertArrayEquals(expected2Films, actual2);//Проверка вывода 2 последних фильмов конструктором с параметром, когда на афише 4 фильма
    }

    @Test
    public void shouldGetReversedFilmsWithConstructor() { // Проверка вывода фильмов в обратном порядке
        manager.addFilm(item1);
        manager.addFilm(item2);
        manager.addFilm(item5);
        manager.addFilm(item4);
        manager.addFilm(item3);
        PosterItem[] expected = {item3, item4, item5, item2, item1};
        PosterItem[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);//Проверка вывода 5 последних фильмов конструктором без параметров, когда на афише 5 фильмов

        manager.addFilm(item6);
        manager.addFilm(item7);

        PosterItem[] expected5Films = {item7, item6, item3, item4, item5};
        PosterItem[] actual2 = manager.findLast();
        Assertions.assertArrayEquals(expected5Films, actual2);//Проверка вывода 5 последних фильмов конструктором без параметров, когда на афише 7 фильмов
    }

    @Test
    public void shouldGetReversedNoneFilms() { // Проверка вывода 0 фильмов, когда на афише есть фильмы
        PosterManager manager2 = new PosterManager(0);

        manager2.addFilm(item1);
        manager2.addFilm(item6);
        manager2.addFilm(item4);
        manager2.addFilm(item2);

        int expected = 0;
        int actual = manager2.findLast().length;
        Assertions.assertEquals(expected, actual);

        // PosterItem[] expected = {}; // new PosterItems[0];
        // Assertions.assertArrayEquals(expected, manager2.findLast());

    }

    @Test
    public void shouldGetReversedNoneFilmsIfRequestedNegativeNumber() { // проверка ввода отрицательного значения
        PosterManager manager2 = new PosterManager(-6);

        manager2.addFilm(item1);
        manager2.addFilm(item6);
        manager2.addFilm(item4);
        manager2.addFilm(item2);

        int expected = 0;
        int actual = manager2.findLast().length;
        Assertions.assertEquals(expected, actual);
        // PosterItem[] expected = {}; // new PosterItems[0];
        // Assertions.assertArrayEquals(expected, manager2.findLast());
    }

    @Test
    public void shouldNotGetReversedFilmsIfRequestedMoreThanPosterLength() { // проверка, когда фильмов а афише меньше, чем лимит
        PosterManager manager3 = new PosterManager(7);

        manager3.addFilm(item1);
        manager3.addFilm(item6);
        manager3.addFilm(item4);
        manager3.addFilm(item2);

        PosterItem[] expected = {item2, item4, item6, item1};
        PosterItem[] actual = manager3.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}
