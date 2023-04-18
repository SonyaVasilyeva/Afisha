public class PosterManager {
    private PosterItem[] films = new PosterItem[0];
    private int limit;


    public PosterManager() {
        this.limit = 5;
    }

    public PosterManager(int limit) {
        this.limit = limit;
    }

    public void addFilm(PosterItem item) { // сохраняет новый фильм

        PosterItem[] bbb = new PosterItem[films.length + 1];  // заводим новый массив с длиной на 1 больше
        for (int i = 0; i < films.length; i++) { // пробегаемся по всем значениям массива films
            bbb[i] = films[i]; // и переносим их в ячейки массива bbb соответственно
        }
        bbb[bbb.length - 1] = item; // присваиваем последней свободной ячейке массива bbb значение перемнной item
        films = bbb; // записываем массив bbb в массив films
    }

    public PosterItem[] findAll() {
        return films;
    }

    public PosterItem[] findLast() { // метод, позволяющий показать все позиции в корзине. (показывать в обратном порядке добавления элементов). Тип возвращаемого значения - PurchaseItem[]
        PosterItem[] all = findAll(); // получим от репозитория массив всех элементов
        int resultLength;
        if (limit >= all.length) {
            resultLength = all.length;
        } else if (limit <= 0) {
            resultLength = 0;
        } else {
            resultLength = limit;
        }

        PosterItem[] reversed = new PosterItem[resultLength]; // создадим еще один массив такой же длины для ответа (обратный порядок)
        for (int i = 0; i < reversed.length; i++) { //пройдемся циклом по индексам реверсированного массива
            reversed[i] = all[all.length - 1 - i]; // положим значения из массива all в массив reversed в нужном порядке
        }
        return reversed; // возвращаем реверсированный массив
    }
}
