// keep track of execution time
long lStartTime = System.nanoTime();
// execution finised
long lEndTime = System.nanoTime();
// display execution time
long timeElapsed = lEndTime - lStartTime;


// loop infinity with timer
import android.os.Handler;
// Create the Handler
private Handler handler = new Handler();
// Define the code block to be executed
private Runnable runnable = new Runnable() {
    @Override
    public void run() {
      // Insert custom code here
      // Repeat every 2 seconds
      handler.postDelayed(runnable, 2000);
    }
};
// Start the Runnable immediately
handler.post(runnable);


// after time
Handler handler = new Handler();
handler.postDelayed(new Runnable() {
	@Override
	public void run() {
		// code
	}
}, 30000);
}

