import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1+1);
    }
    @Test
    public void testgetLinks() throws IOException {
        String filename = "test-file.md";
        Path path2filename = Paths.get(filename);
        String contents = Files.readString(path2filename);
        ArrayList<String> expected = new ArrayList(List.of("https://something.com", "some-thing.html"));
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
    @Test
    public void testgetLinks2() throws IOException {
        String filename = "test-file1.md";
        Path path2filename = Paths.get(filename);
        String contents = Files.readString(path2filename);
        ArrayList<String> expected = new ArrayList(List.of("https://something.com", "some-thing.html"));
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
    @Test
    public void testgetLinks3() throws IOException {
        String filename = "test-file2.md";
        Path path2filename = Paths.get(filename);
        String contents = Files.readString(path2filename);
        ArrayList<String> expected = new ArrayList(List.of("some-thing.html"));
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
    @Test
    public void testgetLinks4() throws IOException {
        String filename = "test-file3.md";
        Path path2filename = Paths.get(filename);
        String contents = Files.readString(path2filename);
        ArrayList<String> expected = new ArrayList(List.of("https://something.com", "some-thing.html"));
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
    @Test
    public void testgetLinks5() throws IOException {
        String filename = "test-file4.md";
        Path path2filename = Paths.get(filename);
        String contents = Files.readString(path2filename);
        ArrayList<String> expected = new ArrayList(List.of("https://something.com", "some-thing.html"));
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
    @Test
    public void testSnippet1() throws IOException {
        String filename = "snippet1.md";
        Path path2filename = Paths.get(filename);
        String contents = Files.readString(path2filename);
        ArrayList<String> expected = new ArrayList(List.of("`google.com", "google.com","ucsd.edu"));
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
    @Test
    public void testSnippet2() throws IOException {
        String filename = "snippet2.md";
        Path path2filename = Paths.get(filename);
        String contents = Files.readString(path2filename);
        ArrayList<String> expected = new ArrayList(List.of("a.com", "a.com(())","example.com"));
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
    @Test
    public void testSnippet3() throws IOException {
        String filename = "snippet3.md";
        Path path2filename = Paths.get(filename);
        String contents = Files.readString(path2filename);
        ArrayList<String> expected = new ArrayList(List.of("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule"));
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
    @Test
    public void test500() throws IOException {
        String filename = "500.md";
        Path path2filename = Paths.get(filename);
        String contents = Files.readString(path2filename);
        ArrayList<String> expected = new ArrayList(List.of("#fragment", "http://example.com#fragment", "http://example.com?foo=3#frag"));
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }

    @Test
    public void test501() throws IOException {
        String filename = "501.md";
        Path path2filename = Paths.get(filename);
        String contents = Files.readString(path2filename);
        ArrayList<String> expected = new ArrayList(List.of("[foo\bar]"));
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
    @Test
    public void test579() throws IOException {
        String filename = "579.md";
        Path path2filename = Paths.get(filename);
        String contents = Files.readString(path2filename);
        ArrayList<String> expected = new ArrayList(List.of("<url>"));
        assertEquals(expected,MarkdownParse.getLinks(contents));
    }
}

