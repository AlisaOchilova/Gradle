package homework6;

import homework6.Program;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;




public class DivisionTest {

    @Tag("Add")
    @ParameterizedTest
    @CsvSource({"1.0, 2.0, 3.0", "2.0, 3.0, 5.0", "1.0, 2.0, 3.0", "1.0, 2.0, 3.0"})
    public void testDoubleSuccessAdd(double a, double b, double c) {
        Assertions.assertEquals(Program.add(a,b), c);
    }



    @Tag("Sub")
    @ParameterizedTest
    @CsvSource({"2.0, 1.0, 1.0", "2.0, 3.0, -1.0", "0.0, 0.0, 0.0", "-1.0, -2.0, 1.0"})
    void testDoubleSuccessSub(double a, double b, double c) {
        Assertions.assertEquals(Program.sub(a, b), c);
    }

    @Tag("Mul")
    @ParameterizedTest
    @CsvSource({"2.0, 1.0, 2.0", "2.0, -3.0, -6.0", "0.0, 0.0, 0.0", "-1.0, -2.0, 2.0"})
    void testDoubleSuccessMul(double a, double b, double c) {
        Assertions.assertEquals(Program.mul(a, b), c);
    }

    @Tag("Div")
    @ParameterizedTest
    @CsvSource({"2.0, 1.0, 2.0", "3.0, -3.0, -1.0", "0.0, 1.0, 0.0", "-2.0, -2.0, 1.0"})
    void testDoubleSuccessDiv(double a, double b, double c) {
        Assertions.assertEquals(Program.div(a, b), c);
    }
}
