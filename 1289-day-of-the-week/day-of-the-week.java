class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {

            "Sunday", "Monday", "Tuesday", "Wednesday",

            "Thursday", "Friday", "Saturday"

        };

        int[] daysInMonth = {

            31, 28, 31, 30, 31, 30,

            31, 31, 30, 31, 30, 31

        };

        int totalDays = 0;

        // Count days in previous years

        for (int y = 1971; y < year; y++) {

            totalDays += 365;

            if (isLeapYear(y)) {

                totalDays++;

            }

        }

        // Count days in previous months

        if (isLeapYear(year)) {

            daysInMonth[1] = 29;

        }

        for (int m = 0; m < month - 1; m++) {

            totalDays += daysInMonth[m];

        }

        // Count days before the given date

        totalDays += day - 1;

        // January 1, 1971, was Friday (index 5)

        return week[(totalDays + 5) % 7];
    }
    private boolean isLeapYear(int year) {

        return (year % 400 == 0) ||

               (year % 4 == 0 && year % 100 != 0);

    }
}