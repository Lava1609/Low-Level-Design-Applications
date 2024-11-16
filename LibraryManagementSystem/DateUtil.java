package LibraryManagement;
public class DateUtil {

    public static String addDaysToDate(String date, int daysToAdd) {
        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        day += daysToAdd;
        while (day > daysInMonth(year, month)) {
            day -= daysInMonth(year, month);
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }

        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public static int daysBetweenDates(String startDate, String endDate) {
        int[] startParts = parseDate(startDate);
        int[] endParts = parseDate(endDate);

        int startYear = startParts[0];
        int startMonth = startParts[1];
        int startDay = startParts[2];

        int endYear = endParts[0];
        int endMonth = endParts[1];
        int endDay = endParts[2];

        return daysBetween(startYear, startMonth, startDay, endYear, endMonth, endDay);
    }

    private static int daysBetween(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) {
        int days = 0;
        while (startYear < endYear || (startYear == endYear && startMonth < endMonth) || (startYear == endYear && startMonth == endMonth && startDay < endDay)) {
            days++;
            startDay++;
            if (startDay > daysInMonth(startYear, startMonth)) {
                startDay = 1;
                startMonth++;
                if (startMonth > 12) {
                    startMonth = 1;
                    startYear++;
                }
            }
        }
        return days;
    }

    private static int[] parseDate(String date) {
        String[] parts = date.split("-");
        return new int[]{ Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]) };
    }

    private static int daysInMonth(int year, int month) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return (isLeapYear(year) ? 29 : 28);
            default:
                return 0;
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
