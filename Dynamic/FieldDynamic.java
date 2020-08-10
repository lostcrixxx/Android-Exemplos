private TextInputLayout edtNewFieldValue;
private ArrayList<TextInputLayout> customFiedsList = new ArrayList<>();    
	
	public void onAddField(View v) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.activity_maps_new_field, null);
        // Add the new row before the add field button.
        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);

        String title = edtNewFieldTitle.getText().toString();

        edtNewFieldValue = (TextInputLayout) rowView.findViewById(R.id.edt_new_field_value);
        edtNewFieldValue.setHint(title);
        customFiedsList.add(edtNewFieldValue);

        edtNewFieldTitle.setText(""); // limpa o campo depois de criar um novo
    }

	// get method in xml
    public void onDelete(View v) {
        parentLinearLayout.removeView((View) v.getParent());
    }