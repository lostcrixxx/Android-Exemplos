SharedPreferences prefs;


button.setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View view) {
		prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
		SharedPreferences.Editor ed = prefs.edit();

		ed.putString("nome", nome.getText().toString());
		ed.putString("email", email.getText().toString());
		ed.putBoolean("guardar", check.isChecked());

		ed.apply();
		Toast.makeText(getBaseContext(), "gravado com sucesso!", Toast.LENGTH_LONG).show();
	}
});


recuperar.setOnClickListener(new View.OnClickListener() {
	@Override
	public void onClick(View view) {
		prefs = getSharedPreferences("Preferences", Context.MODE_PRIVATE);
		nome.setText(prefs.getString("nome", "Não encontrado"));
		email.setText(prefs.getString("email", "Não encontrado"));
		check.setChecked(prefs.getBoolean("guardar", Boolean.parseBoolean("Não encontrado")));
	}
});
    
// limpar um campo
SharedPreferences preferences = getSharedPreferences("Mypref", 0);
preferences.edit().remove("text").apply();

// limpar todos valores
SharedPreferences settings = context.getSharedPreferences("Preferences", Context.MODE_PRIVATE);
settings.edit().clear().commit();