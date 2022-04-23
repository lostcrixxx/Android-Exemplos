    Uri uri = null;
    Intent intent = null;
                uri = Uri.parse("http://www.google.com.br");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);