
import java.util.*;

// Adapter class: converts Enumeration to Iterator
class EnumerationIteratorAdapter<E> implements Iterator<E> {

    private Enumeration<E> enumeration;

    public EnumerationIteratorAdapter(Enumeration<E> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public E next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}

// Main class
public class s5 {

    public static void main(String[] args) {
        Vector<String> v = new Vector<>();
        v.add("Apple");
        v.add("Banana");
        v.add("Cherry");

        Enumeration<String> enumeration = v.elements();

        // Use adapter to get an Iterator
        Iterator<String> iterator = new EnumerationIteratorAdapter<>(enumeration);

        System.out.println("Iterating using Adapter:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
