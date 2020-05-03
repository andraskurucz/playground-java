public class FraudulentActivity {

    /**
     * HackerLand National Bank has a simple policy for warning clients about possible fraudulent account activity.
     * If the amount spent by a client on a particular day is greater than or equal to 2x the client's median spending
     * for a trailing number of days, they send the client a notification about potential fraud.
     * The bank doesn't send the client any notifications until they have at least that trailing number of prior days'
     * transaction data.
     *
     * @param expenditure array of customer's daily spendings
     * @param d trailing number of days
     * @return number of notifications
     */
    static int activityNotifications(int[] expenditure, int d) {
        int[] freq = new int[201];
        int result = 0;

        for (int i = 0; i < expenditure.length - 1; i++) {

            if (i >= d) {

                double median = median(freq, d);

                if (expenditure[i] >= 2 * median) {
                    result++;
                }

                int prevExpense = expenditure[i - d];
                freq[prevExpense]--;
            }

            freq[expenditure[i]]++;
        }

        return result;
    }

    static double median(int[] frequencies, int size) {
        int count = (size / 2);
        int i = -1;
        int j = 0;

        while (count > 0) {
            i++;

            if (frequencies[i] <= count) {
                count -= frequencies[i];
                j = frequencies[i];
            } else {
                j = count;
                count = 0;
            }
        }

        int k = i;

        if (j == frequencies[i]) {
            do {
                k++;
            } while (frequencies[k] == 0);
        }

        if (size % 2 == 0) {
            return (i + k) / 2.0;
        } else {
            return k;
        }
    }
}
