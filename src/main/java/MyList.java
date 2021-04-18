public interface MyList<E> extends Iterable<E> {

    // добавляет элемент в конец
    void add(E element);

    // удаляет элемент под индексом
    void remove(int index);

    // очищает коллекцию
    void clear();

    // возвращает размер коллекции
    int size();

    // возвращает элемент под индексом
    E get(int index);
}
