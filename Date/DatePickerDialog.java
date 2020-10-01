private DatePickerDialog picker;

	/**
     * Dia menor que 10, adiciona o zero na frente
     * @param num day
     * @return Dia com zero na frente
     */
    public static String verifyDay(int num) {
        String result = "";
        switch (num){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                result = "0" + num;
                break;
            default:
                result = String.valueOf(num);
                break;
        }
        return  result;
    }

txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(parent,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                txtDate.setText(verifyDay(dayOfMonth) + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });