private void sortArrayType() {
	Collections.sort(mapPointObjects, new Comparator<MapPointObject>() {
		@Override
		public int compare(MapPointObject lhs, MapPointObject rhs) {
			return lhs.getTitle().compareTo(rhs.getTitle());
		}
	});
}