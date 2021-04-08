Type collectionType = new TypeToken<Collection<Chart>>(){}.getType();

String json = prefs.getString("chart", null);
ArrayList<Chart> addLinesPrefs = new Gson().fromJson(json, collectionType);