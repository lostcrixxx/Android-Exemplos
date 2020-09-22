public static long lastClickTime = 0;
public static final long DOUBLE_CLICK_TIME_DELTA = 500;

public static boolean isDoubleClick(){
    long clickTime = System.currentTimeMillis();
    if(clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA){
        lastClickTime = clickTime;
        return true;
    }
    lastClickTime = clickTime;
    return false;
}

public static boolean oneClick(){
    long clickTime = System.currentTimeMillis();
	if (clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA){
		handler.removeCallbacks(runnable);
		lastClickTime = 0;
		onDoubleClick(view);
	} else {
		...
		lastClickTime = clickTime;
	}
}