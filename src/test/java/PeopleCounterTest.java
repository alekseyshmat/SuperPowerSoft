import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class PeopleCounterTest {
    private PeopleCounter peopleCounter;

    @BeforeClass
    public void before() {
        System.out.println("Checking workers' count test starting.");
    }

    @AfterClass
    public void after() {
        System.out.println("Checking workers' count test ending.");
    }

    @DataProvider
    public Object[] getValidTime() {
        return new List[][]{
                {Arrays.asList(800, 920, 1100, 1000, 1020, 1030), Arrays.asList(907, 1035, 1600, 1030, 1130, 1715)},
        };
    }

    @Test(dataProvider = "getValidTime", groups = "positive")
    public void testMaxCounting(List<Integer> arrivalTime, List<Integer> careTime) {
        peopleCounter = new PeopleCounter();
        Assert.assertEquals(peopleCounter.maxCounting(arrivalTime, careTime), 4);
    }

    @DataProvider
    public Object[] getInvalidTime() {
        return new List[][]{
                {Arrays.<Integer>asList(800, 920, 1100, 1000, 1040, 1030), Arrays.<Integer>asList(907, 1035, 1600, 1030, 1130, 1715)},
        };
    }

    @Test(dataProvider = "getInvalidTime")
    public void areNotValidTestMaxCounting(List<Integer> arrivalTime, List<Integer> careTime) {
        peopleCounter = new PeopleCounter();
        int isValid = peopleCounter.maxCounting(arrivalTime, careTime);
        Assert.assertNotEquals(isValid, 4);
    }
}