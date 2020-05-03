import org.junit.Test;

import static org.junit.Assert.*;

public class FraudulentActivityTest {

    @Test
    public void test00() {
        int[] expenditures = new int[]{1, 2, 3, 4, 4};

        int notifications = FraudulentActivity.activityNotifications(expenditures, 4);

        assertEquals(0, notifications);
    }

    @Test
    public void test01() {
        int[] expenditures = new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5};

        int notifications = FraudulentActivity.activityNotifications(expenditures, 5);

        assertEquals(2, notifications);
    }

    @Test
    public void test02() {
        int[] expenditures = new int[]{10, 20, 30, 40, 50};

        int notifications = FraudulentActivity.activityNotifications(expenditures, 3);

        assertEquals(1, notifications);
    }

    @Test
    public void medianTest00() {
        int[] frequencies = new int[10];
        frequencies[1] = 1;
        frequencies[2] = 1;
        frequencies[3] = 1;
        frequencies[4] = 1;
        frequencies[5] = 1;


        double median = FraudulentActivity.median(frequencies, 5);

        assertEquals(3, median, 0.1);
    }

    @Test
    public void medianTest01() {
        int[] frequencies = new int[10];
        frequencies[1] = 1;
        frequencies[2] = 1;
        frequencies[3] = 1;
        frequencies[4] = 3;
        frequencies[5] = 1;

        double median = FraudulentActivity.median(frequencies, 7);

        assertEquals(4, median, 0.1);
    }

    @Test
    public void medianTest02() {
        int[] frequencies = new int[10];
        frequencies[2] = 1;
        frequencies[4] = 1;

        double median = FraudulentActivity.median(frequencies, 2);

        assertEquals(3, median, 0.1);
    }

    @Test
    public void medianTest03() {
        int[] frequencies = new int[10];
        frequencies[1] = 1;
        frequencies[2] = 2;
        frequencies[4] = 1;
        frequencies[5] = 1;
        frequencies[6] = 1;

        double median = FraudulentActivity.median(frequencies, 6);

        assertEquals(3, median, 0.1);
    }

    @Test
    public void medianTest04() {
        int[] frequencies = new int[10];
        frequencies[1] = 1;
        frequencies[2] = 1;
        frequencies[3] = 2;
        frequencies[4] = 1;
        frequencies[5] = 1;

        double median = FraudulentActivity.median(frequencies, 6);

        assertEquals(3, median, 0.1);
    }
}