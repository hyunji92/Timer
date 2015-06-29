package timerproject;

public abstract class TimerCallback {
	// private CallbackEvent callbackEvent;
	//
	// public TimerCallback(CallbackEvent event) {
	// callbackEvent = event;
	// }
	//
	// public void callFunc() {
	// callbackEvent.callbackMethod();
	// }
	abstract public void call();

	private long time;
	private long duration;

	public TimerCallback(long time, long duration) {

		this.time = time;
		this.duration = duration;
	}
	public TimerCallback(){
		this.time = 0;
		this.duration = 0;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public long getTime() {
		return time;
	}

	public long getDuration() {
		return duration;
	}

}