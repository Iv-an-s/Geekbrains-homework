package lesson6_homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HomeworkTest {

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void shouldReturnModifiedArray(int[] expected, int[] source){
        try{
            int[] result = Homework.returnModifiedArray(source);
            Assertions.assertArrayEquals(expected, result);
        }catch (Exception e){
            Assertions.assertThrows(RuntimeException.class, ()->{
                Homework.returnModifiedArray(source);
            });
            Assertions.assertSame("The array has no the number 4", e.getMessage());
        }
    }
    private static Stream<Arguments> valuesProvider(){
        return Stream.of(
                Arguments.arguments(new int[]{5,6}, new int[]{1, 2, 3, 4, 5, 6}),
                Arguments.arguments(new int[]{1, 7}, new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}),
                Arguments.arguments(null, new int[]{1, 2, 3, 5, 6, 7, 8})
        );
    }

    @Test
    public void shouldCheckArray(){
        Assertions.assertEquals(true, Homework.checkArray(new int[]{1,1,1,4,1,1}));
        Assertions.assertEquals(false, Homework.checkArray(new int[]{1,1,1,1,1,1}));
        Assertions.assertEquals(false, Homework.checkArray(new int[]{4,4,4,4,4,4}));
        Assertions.assertEquals(true, Homework.checkArray(new int[]{1, 4, 1, 4, 1}));
    }
}
