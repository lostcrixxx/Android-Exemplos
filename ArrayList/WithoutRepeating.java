private ArrayList<Object> singleListType(ArrayList<Object> typeAllList) {
	for (int i = 0; i < typeAllList.size(); i++) {
		Object a = typeAllList.get(i);
		for (int j = i + 1; j < typeAllList.size(); j++) {
			Object b = typeAllList.get(j);
			if (((Object) a).getEventTypeId() == (((Object) b).getEventTypeId())) {
				typeAllList.remove(j);
				j--;
			}
		}
	}
	return typeAllList;
}