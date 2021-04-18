import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements MyList<E>, Iterable<E> {
    private Object[] array;
    private int size;
    private int cursor;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int capacity) {
        this.size = 0;
        this.cursor = 0;
        this.array = new Object[capacity];
    }

    public MyArrayList(E[] array) {
        this.size = array.length;
        this.array = array;
    }

    @Override
    public void add(E element) {
        if (size == array.length) {
            Object [] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[size++] = element;
    }

    public void add(E[] value){
        for (E element : value){
            add(element);
        }
    }

    @Override
    public void remove(int index) {
        if (index > size || index < 0) {
            throw new RuntimeException("No index!");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array [i+1];
        }
        array = Arrays.copyOf(array, --size);
    }

    @Override
    public void clear() {
        array = new Object[size];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        if (index >= size) {
            throw new RuntimeException("There is no element!");
        }
        return (E) array[index];
    }

    @Override
    public String toString() {
        return "MyArrayList: " + Arrays.toString(array) + ", size = " + size;
    }

    @Override
    public Iterator<E> iterator() {
        cursor = 0;
        return new Iterator<E>(){

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public E next() {
                return (E) array[cursor++];
            }
        };
    }
}

class MyArrayListTest {
    public static void main(String[] args) {
        String [] testArrayOfStrings = {"first", "second", "third", "fourth", "fifth"};
        MyArrayList testArr = new MyArrayList(testArrayOfStrings);

        System.out.println(testArr.toString());
        System.out.println("testArr.size(): " + testArr.size());

        testArr.add("sixth");
        System.out.println(testArr.toString());

        testArr.add("seventh");
        System.out.println(testArr.toString());

        //testArr.get(6);
        System.out.println("testArr.get(6): " + testArr.get(6));

        //testArr.remove(2);
        testArr.remove(2);
        System.out.println(testArr.toString());

        //testArr.remove(8);
        //testArr.remove(8);
        //System.out.println(testArr.toString()); - error

        //testArr.get(7);
        //System.out.println("testArr.get(7): " + testArr.get(7)); - error

        testArr.clear();
        System.out.println(testArr.toString());

        Integer [] testArrayOfStrings1 = {1, 2, 3, 4, 5};
        MyArrayList testArr1 = new MyArrayList();

        testArr1.add(testArrayOfStrings1);
        System.out.println(testArr1.toString());
    }
}
