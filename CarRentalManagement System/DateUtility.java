package CarRentalManagement;

public class DateUtility {
	
	    public static int[] parseDate(String date) {
	        String[] parts = date.split("-");
	        int year = Integer.parseInt(parts[0]);
	        int month = Integer.parseInt(parts[1]);
	        int day = Integer.parseInt(parts[2]);
	        return new int[]{year, month, day};
	    }

	    public static int calculateDaysBetween(String startDate, String endDate) {
	        int[] start = parseDate(startDate);
	        int[] end = parseDate(endDate);
	        return daysFromEpoch(end) - daysFromEpoch(start);
	    }

	    private static int daysFromEpoch(int[] date) {
	        int year = date[0];
	        int month = date[1];
	        int day = date[2];
	        int days = year * 365 + day;

	        for (int i = 1; i < month; i++) {
	            days += daysInMonth(i, year);
	        }

	        for (int i = 1970; i < year; i++) {
	            if (isLeapYear(i)) {
	                days++;
	            }
	        }

	        return days;
	    }

	    private static int daysInMonth(int month, int year) {
	        switch (month) {
	            case 4: case 6: case 9: case 11: return 30;
	            case 2: return isLeapYear(year) ? 29 : 28;
	            default: return 31;
	        }
	    }

	    private static boolean isLeapYear(int year) {
	        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	    }
	}

   