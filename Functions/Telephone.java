    Uri uri = null;
    Intent intent = null;
                uri = Uri.parse("tel:1100000000");
                intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);