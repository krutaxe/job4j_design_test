package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleConvertTest {
    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkArrayString() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("Tom", "Bob", "Raf", "Mike", "Leo");
        assertThat(array)
                .hasSize(5)
                .contains("Bob", "Leo")
                .containsSequence("Mike", "Leo");
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("Tom", "Bob", "Raf", "Mike", "Leo");
        assertThat(list).first().isEqualTo("Tom");
        assertThat(list).element(4).isEqualTo("Leo");
        assertThat(list).hasSize(5)
                .endsWith("Mike", "Leo");
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("Tom", "Bob", "Raf", "Mike", "Leo");
        assertThat(map).containsEntry("Bob", 1)
                .containsKeys("Bob", "Raf", "Mike")
                .containsValues(1, 2, 3, 4)
                .hasSize(5);
    }
}