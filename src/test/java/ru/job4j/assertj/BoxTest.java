package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(6, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube")
                .isNotEmpty();
    }

    @Test
    void isThisUnknown() {
        Box box = new Box(3, 10);
        String name = box.whatsThis();
        assertThat(name).isNotEmpty()
                .isEqualTo("Unknown object");
    }

    @Test
    void isThisVertex6() {
        Box box = new Box(6, 10);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isPositive()
                .isEqualTo(6);
    }

    @Test
    void isThisVertex0() {
        Box box = new Box(0, 10);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEven()
                .isEqualTo(0);
    }

    @Test
    void isThisAreaCube() {
        Box box = new Box(6, 5);
        double area = box.getArea();
        assertThat(area).isNotZero()
                .isPositive()
                .isEqualTo(150.0d, withPrecision(0.01d));

    }

    @Test
    void isThisAreaSphere() {
        Box box = new Box(0, 3);
        double area = box.getArea();
        assertThat(area).isPositive()
                .isNotZero()
                .isEqualTo(113.097d, withPrecision(0.001d));

    }

    @Test
    void isThisExist() {
        Box box = new Box(4, 3);
        boolean exist = box.isExist();
        assertThat(exist).isTrue();

    }

    @Test
    void isThisNotExist() {
        Box box = new Box(2, 3);
        boolean exist = box.isExist();
        assertThat(exist).isFalse();

    }
}