Runnable runnable = new Runnable() {
	@Override
	public void run(){
	}
};

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