package ua.edu.ukma;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CucumberTest {
    int[] arr;

    //"\\[([-0-9, ]*)\\]"
    @ParameterType("\s*\\[(\\s*-?\\d+\\s*(,\\s*-?\\d+\\s*)*)?\\]\s*")
    public int[] listOfIntegers(String integers) {
        String[] strings = integers.split(", ?");
        int[] result = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            result[i] = Integer.parseInt(strings[i]);
        }
        return result;
    }

    @When("I get array {listOfIntegers}")
    public void i_get_array(int[] arg) {
        arr = arg;
    }

    @Then("the mode is {int}")
    public void the_mode_is(int arg) {
        assertEquals(Functions.mode(arr), arg);
    }
}
