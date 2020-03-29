Intent intent = new Intent(Intent.ACTION_SEND);
intent.setType("text/plain");
String shareBody = "Estou compartilhando o app ?! \n\n" +
		"https://play.google.com/store/apps/details?id=" +
		"\n\nCompartilhe também, é GRÁTIS !!!";
String shareSub = "Título";
intent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
intent.putExtra(Intent.EXTRA_TEXT, shareBody);
startActivity(Intent.createChooser(intent, "Compartilhar usando"));