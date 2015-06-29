package timerproject;

public class CallbackEvent extends TimerCallback {

	public CallbackEvent(long time, long duration) {
		super(time, duration);
		// TODO Auto-generated constructor stub
	}
	public CallbackEvent(){
		
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("시간 : " + getTime() + "Duration : " + getDuration());
		
	}

}
