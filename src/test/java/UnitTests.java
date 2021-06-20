import org.testng.annotations.Test;
import org.testng.Assert;

import java.awt.geom.Arc2D;

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

    // a>0, b>0, a>b
    @Test
    public void DivisionOfFractions() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.divFraction(5.5, 3.2), 1.71875);
    }

    // a>0, b>0, a<b
    @Test
    public void DivisionOfFractions1() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.divFraction(3, 5), 0.6);
    }

    // a<0, b>0, a<b
    @Test
    public void DivisionOfFractions2() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.divFraction(-3, 5), -0.6);
    }

    // a>0, b<0, a>b
    @Test
    public void DivisionOfFractions3() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.divFraction(3, -5), -0.6);
    }

    // a=0, b>0, a<b
    @Test
    public void DivisionOfFractions4() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.divFraction(0, 5), 0);
    }

    // a<0, b<0
    @Test
    public void DivisionOfFractions5() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.divFraction(-5.5, -3.2), 1.71875);
    }

    // a>0, b=0
    @Test
    public void DivisionOfFractionsNegative6() {
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.divFraction(5.5, 0), Double.POSITIVE_INFINITY);
    }

    @Test
    public void Root(){
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.root(9), 3);
    }

    @Test
    public void RootNegative(){
        Calculator calc = new Calculator();
        Assert.assertEquals(calc.root(-1), Double.NaN);
    }
}

