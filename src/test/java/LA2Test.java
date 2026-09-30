import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LA2Test {

    @Test
    void cleansWords() {
        assertEquals("java", LA2.cleanWord("Java!"));
        assertEquals("coop", LA2.cleanWord("co-op"));
        assertEquals("", LA2.cleanWord("123?!"));
    }

    @Test
    void findsWords() {
        ArrayList<String> words = new ArrayList<>();
        words.add("java");
        words.add("files");
        assertEquals(1, LA2.findWord("files", words));
        assertEquals(-1, LA2.findWord("missing", words));
    }

    @Test
    void buildsReportInFirstAppearanceOrder(@TempDir Path directory) throws IOException {
        Path input = directory.resolve("input.txt");
        Files.writeString(input, "Java is fun. Java is powerful!\nAnagrams are fun, too.");

        String expected = """
                Word Frequency Report
                ----------------------
                java: 2
                is: 2
                fun: 2
                powerful: 1
                anagrams: 1
                are: 1
                too: 1""";

        assertEquals(expected, LA2.buildReport(input.toString()));
    }
}
