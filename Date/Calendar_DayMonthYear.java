int day, month, year;

Calendar cal = Calendar.getInstance();
day = cal.get(Calendar.DAY_OF_MONTH)
month = cal.get(Calendar.MONTH)
year = cal.get(Calendar.YEAR)

// convert timestamp to calendar
Date d = new Date(dateLong);
Calendar c = Calendar.getInstance();
c.setTime(d);
int year = c.get(Calendar.YEAR);
int monthOfYear = c.get(Calendar.MONTH); // TODO add +1
int dayOfMonth = c.get(Calendar.DATE);
