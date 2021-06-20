import org.testng.annotations.Test;
import org.testng.Assert;

public class UnitTests {
Calculator calc = new Calculator();

// a>0, b>0
    @Test
    public void positiveSumTest1() {
        Calculator calc = new Calculator();

        Assert.assertEquals(calc.sum(2, 3), 5, "Тестовый комментарий...");
    }

// a=0, b=0
    @Test
    public void positiveSumTest2() {
        Calculator calc = new Calculator();

        Assert.assertEquals(calc.sum(0, 0), 0);
    }

// a<0, b>0
    @Test
    public void positiveSumTest3() {
        Calculator calc = new Calculator();

        Assert.assertEquals(calc.sum(-2, 3), 1);
    }

// a<0, b<0
    @Test
    public void positiveSumTest4() {
        Calculator calc = new Calculator();

        Assert.assertEquals(calc.sum(-2, -3), -5);
    }

}

