
import java.io.*;

// Custom decorator to convert input to lowercase
class LowerCaseInputStream extends FilterInputStream {

    protected LowerCaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }
}

public class s1 {

    public static void main(String[] args) {
        try {
            System.out.println("Enter text (uppercase will be converted to lowercase):");

            InputStream in = new LowerCaseInputStream(System.in);
            int ch;
            while ((ch = in.read()) != -1 && ch != '\n') {
                System.out.print((char) ch);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
