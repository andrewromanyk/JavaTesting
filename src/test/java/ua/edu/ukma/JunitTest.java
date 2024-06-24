package ua.edu.ukma;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class JunitTest {

    @Test
    void concat() {
        Assumptions.assumeTrue(System.getProperty("os.name").toLowerCase().contains("windows"));
        assertEquals("Hello World", Functions.concat("Hello", "World"));
        assertEquals("Hello  World", Functions.concat("Hello ", "World"));
        assertEquals("Hello", Functions.concat("Hell", "lo"));
        assertEquals("Alldead", Functions.concat("All", "ldead"));
    }

    @ParameterizedTest(name = "{1}.concat({2}) == {3}")
    @CsvSource({
            "'Hello ',    World,   Hello  World",
            "Hell,  lo, Hello",
            "All,  ldead, Alldead"
    })
    void concat(String a, String b, String c) {
        assertEquals(Functions.concat(a, b), c);
    }
}