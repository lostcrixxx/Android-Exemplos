//
Runnable runnable = new Runnable() {
	@Override
	public void run(){
	}
};
new Thread(runnable).start();

//
Runnable runnable = new Runnable() {
	@Override
	public void run(){
	}
};
runnable.start();

Thread thread = new Thread(new Runnable(){
  @Override
  public void run(){
  }
});
thread.start();

Dispatcher.postOnUiThread(new Runnable() {
		@Override
	public void run(){
	}
});

new Handler(Looper.getMainlooper()).post(new Runnable() {
			@Override
	public void run(){
	}
});

getActivity().runOnUiThread(new Runnable) {
				@Override
	public void run(){
	}
};