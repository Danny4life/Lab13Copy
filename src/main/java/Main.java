import java.io.File;
import java.util.Set;

public class Main {
    private static final String fname = "The-Adventure-of-the-Empty-House.txt";

    public static void main(String[] args) {
        File myfile = new File(fname);
        Set<String> uniques = UniqueWords.processDocument(myfile);
        for (String s : uniques) {
            System.out.println(s);
        }
        System.out.println("Got "+uniques.size()+" words");
    }
}
