    void updateHour(TextView field) {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;
        mTimePicker = new TimePickerDialog(parent, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                field.setText(verifyZero(selectedHour) + ":" + verifyZero(selectedMinute));
            }
        }, hour, minute, true);//Yes 24 hour time
//      mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }