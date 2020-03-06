import android.graphics.PointF;

public class MapsCalculate {

    public static double haversine(double startLat, double startLong, double endLat, double endLong) {
        final int EARTH_RADIUS = 6371; // Approx Earth radius in KM

        double dLat = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat = Math.toRadians(endLat);

        double a = calc(dLat) + Math.cos(startLat) * Math.cos(endLat) * calc(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c; // <-- d
    }
    private static double calc(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }

    public static PointF calculateDerivedPosition(PointF point,
                                                  double range, double bearing) {
        double EarthRadius = 6371000; // m

        double latA = Math.toRadians(point.x);
        double lonA = Math.toRadians(point.y);
        double angularDistance = range / EarthRadius;
        double trueCourse = Math.toRadians(bearing);

        double lat = Math.asin(
                Math.sin(latA) * Math.cos(angularDistance) +
                        Math.cos(latA) * Math.sin(angularDistance)
                                * Math.cos(trueCourse));

        double dlon = Math.atan2(
                Math.sin(trueCourse) * Math.sin(angularDistance)
                        * Math.cos(latA),
                Math.cos(angularDistance) - Math.sin(latA) * Math.sin(lat));

        double lon = ((lonA + dlon + Math.PI) % (Math.PI * 2)) - Math.PI;

        lat = Math.toDegrees(lat);
        lon = Math.toDegrees(lon);

        PointF newPoint = new PointF((float) lat, (float) lon);

        return newPoint;
    }

    public static boolean pointIsInCircle(PointF pointForCheck, PointF center,
                                          double radius) {
        if (getDistanceBetweenTwoPoints(pointForCheck, center) <= radius)
            return true;
        else
            return false;
    }

    public static double getDistanceBetweenTwoPoints(PointF p1, PointF p2) {
        double R = 6371000; // m
        double dLat = Math.toRadians(p2.x - p1.x);
        double dLon = Math.toRadians(p2.y - p1.y);
        double lat1 = Math.toRadians(p1.x);
        double lat2 = Math.toRadians(p2.x);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2)
                * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c;

        return d;
    }
	
	// search database
	   public List<GeographicMarks_model> getNearLocation(double startLat, double startLng) {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = null;

        GeographicMarks_model marksModel;
        ArrayList<GeographicMarks_model> userFavoriteList = new ArrayList<>();

        try {

            double radius = 1000;
            PointF center = new PointF((float)startLat, (float)startLng); // x, y

            final double mult = 1; // mult = 1.1; is more reliable
            PointF p1 = calculateDerivedPosition(center, mult * radius, 0);
            PointF p2 = calculateDerivedPosition(center, mult * radius, 90);
            PointF p3 = calculateDerivedPosition(center, mult * radius, 180);
            PointF p4 = calculateDerivedPosition(center, mult * radius, 270);

            cursor = db.rawQuery("SELECT * FROM geographic_marks WHERE nu_lat < "
                    + String.valueOf(p3.x) + " AND nu_lat > "
                    + String.valueOf(p1.x) + " AND nu_lon > "
                    + String.valueOf(p2.y) + " AND nu_lon < "
                    + String.valueOf(p4.y) + " ORDER BY km;", null);

            if (cursor != null) {
                while (cursor.moveToNext()) {
                    marksModel = new GeographicMarks_model();
                    marksModel.setId_mark(cursor.getLong(cursor.getColumnIndex(GeographicMarksTable.COLUMN_ID)));
                    marksModel.setNu_lat(cursor.getDouble(cursor.getColumnIndex(GeographicMarksTable.COLUMN_NU_LAT)));
                    marksModel.setNu_lon(cursor.getDouble(cursor.getColumnIndex(GeographicMarksTable.COLUMN_NU_LON)));
                    marksModel.setKm(cursor.getDouble(cursor.getColumnIndex(GeographicMarksTable.COLUMN_KM)));

                    userFavoriteList.add(marksModel);
                }
            }
        } catch (Exception e) {
            Log.e(DBMNG_TAG, e.toString());
        }
        return userFavoriteList;
    }
}
