package org.example.demo5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    @Test
    void testCpm() {
        // Przykładowy test dla metody cpm
        Calc calculator = new Calc();
        double result = calculator.cpm("duża (osoba prowadząca aktywny tryb życia, regularnie ćwicząca)",
                "przytyć", 3, "mężczyzna", 180.0, 75.0, 30);
        assertEquals(3410.81, result, 0.01);
    }

    @Test
    void testCalcBmi() {
        // Przykładowy test dla metody calc_bmi
        Calc calculator = new Calc();
        double result = calculator.calc_bmi(70.0, 175.0);
        assertEquals(22.86, result, 0.01);
    }

    @Test
    void testAcceptor() {
        // Przykładowy test dla metody acceptor
        Calc calculator = new Calc();
        String result = calculator.acceptor(26.0, "przytyć");
        assertEquals("WYBRANO CEL ZAGRAŻAJĄCY ZDROWIU", result);
    }

    @Test
    void testDateCheck() {
        // Przykładowy test dla metody Date_check
        Calc calculator = new Calc();
        String result = calculator.Date_check(15, 6, 2023);
        assertEquals("15-06-2023", result);
    }
}