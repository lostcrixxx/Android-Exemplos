public static boolean isSpinnerDialogOpen = false;

searchableSpinner.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
	Log.d("spinner", "onTouch");
        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            if (!isSpinnerDialogOpen) {
                isSpinnerDialogOpen = true;
                return searchableSpinner.onTouch(view, motionEvent);
             }
			isSpinnerDialogOpen = false;
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                isSpinnerDialogOpen = false;
            }
        }, 200);
        return true;
    }
});