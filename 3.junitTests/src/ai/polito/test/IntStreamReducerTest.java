package ai.polito.test;

import ai.polito.IntStreamReducer;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class IntStreamReducerTest {

    private IntStreamReducer isr;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        isr = new IntStreamReducer();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        isr=null;
    }

    @org.junit.jupiter.api.Test
    void reduce() {
    }

    @Test
    void testSimpleStream() {
        assertEquals(6, isr.reduce(IntStream.of(1, 2, 3)));
    }

    @Test
    void testEmptyStream() { //RuntimeException
        assertThrows(Exception.class, () -> isr.reduce(IntStream.empty()));
    }
}