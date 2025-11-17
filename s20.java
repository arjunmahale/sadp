import java.io.*;

// Decorator class
class LowerCaseReader extends FilterReader {
    protected LowerCaseReader(Reader in) { super(in); }
    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char)c));
    }
}

public class s20 {
    public static void main(String[] args) throws IOException {
        String input = "Hello WORLD! JAVA I/O Decorator.";
        Reader reader = new LowerCaseReader(new StringReader(input));

        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char)c);
        }
        reader.close();
    }
}




/*import java.io.*;

// Decorator class
class LowerCaseInputStream extends FilterReader {

    protected LowerCaseInputStream(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char)c));
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        int result = super.read(cbuf, off, len);
        if (result != -1) {
            for (int i = off; i < off + result; i++) {
                cbuf[i] = Character.toLowerCase(cbuf[i]);
            }
        }
        return result;
    }
}

// Client code
public class s20 {
    public static void main(String[] args) {
        String input = "Hello WORLD! This is JAVA I/O Decorator.";
        try (Reader reader = new LowerCaseInputStream(new StringReader(input))) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/
