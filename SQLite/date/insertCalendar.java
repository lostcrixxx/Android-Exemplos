// Classe    
private long id;
private Calendar dt = Calendar.getInstance();

// DATABASE
private static final String DATABASE_CREATE = "create table if not exists "
					+ TABLE_NAME
					+ "("
					+ COLUMN_ID + " integer PRIMARY KEY AUTOINCREMENT, "
					+ COLUMN_DATE + " integer NOT NULL " // long Calendar TimeInMillis
					+ ");";

// CONTENTVALUE
ContentValues cv = new ContentValues();
	cv.put(NameTable.COLUMN_ID, obj.get(i).getId());
	cv.put(NameTable.COLUMN_DATE, obj.get(i).getDt().getTimeInMillis());

// JSONObject
objClasse.setId(object.getLong("id"));

String dataInspection = object.getString("created_at"); // json yyyy-MM-dd HH:mm:ss
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date dateInspection = sdf.parse(dataInspection);
Calendar calInsp = Calendar.getInstance();
	calInsp.setTime(dateInspection);
objClasse.setDt(calInsp);

// GET
convertDate(insp.getDt_inspection().getTimeInMillis());

// CONVERT DATE
public static String convertDate(long time){
	Date date = new Date(time);
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	String dataConvertida = df.format(date);
	return dataConvertida;
}

