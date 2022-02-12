package ca.kendon.categoryvote;

import org.junit.jupiter.api.Test;

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
}