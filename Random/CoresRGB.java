public static int getRandomColor() {
	Random rnd = new Random();
return Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
//        return ((int) (Math.random() * 16777215)) | (0xFF << 24);
}
