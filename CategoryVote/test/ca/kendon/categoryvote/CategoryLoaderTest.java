package ca.kendon.categoryvote;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryLoaderTest {

    @Test
    void load() {

        String categoryString = "Category 1, 10, 1_1, 1_2, 1_3, 1_4, 1_5";
        Category generated = CategoryLoader.load(categoryString);

        List<String> contents = new ArrayList<>();
        contents.add("1_1");
        contents.add("1_2");
        contents.add("1_3");
        contents.add("1_4");
        contents.add("1_5");
        Category expected = new Category("Category 1", 10, contents);

        assertEquals(expected, generated);

    }

    @Test
    void readFile() {

        List<String> cat1Stuff = new ArrayList<>();
        cat1Stuff.add("1_1");
        cat1Stuff.add("1_2");
        cat1Stuff.add("1_3");
        cat1Stuff.add("1_4");
        cat1Stuff.add("1_5");
        Category cat1 = new Category("Category 1", 10, cat1Stuff);

        List<String> cat2Stuff = new ArrayList<>();
        cat2Stuff.add("2_1");
        cat2Stuff.add("2_2");
        cat2Stuff.add("2_3");
        Category cat2 = new Category("Category 2", 8, cat2Stuff);

        ArrayList<Category> expected = new ArrayList<>();
        expected.add(cat1);
        expected.add(cat2);

        try {
            List<Category> actual = CategoryLoader.readFile(new File("data/categories.data"));
            assertEquals(expected, actual);

        } catch (FileNotFoundException e) {
            System.out.println("no file");
        }

    }
}