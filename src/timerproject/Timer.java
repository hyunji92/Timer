package timerproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Timer {
	// private long time;
	// private static long num;
	// private static long registerTime;
	private boolean canceled = false;
	private Map<Long, List<TimerCallback>> events = new TreeMap<Long, List<TimerCallback>>();

	// slack공유
	// public boolean isCanceled() {
	// return canceled;
	// }
	// public void setCanceled(boolean canceled) {
	// this.canceled = canceled;
	// }
	public void SetTimer(long duration, TimerCallback callback) {

		// 1. 현재시간
		long currentTime = System.currentTimeMillis();
		long key = currentTime + duration;

		// 2. dataStructure, map에 리스트가 있는지 체크
		List<TimerCallback> list = events.get(key);

		callback.setTime(currentTime);
		callback.setDuration(duration);

		if (list != null) {
			list.add(callback);
		} else {
			list = new ArrayList<TimerCallback>();
			list.add(callback);

			events.put(key, list);
		}

		// time = System.currentTimeMillis();
		// SimpleDateFormat dayTime = new SimpleDateFormat("hh:mm:ss");
		// String str = dayTime.format(new Date(time));
		//
		// //Date d = new Date();
		// String currentTime = "현재시간:" + str;
		// System.out.println( currentTime + "  /  " + time );
		//
		//
		// // 2. Scanner 사용한 Time 입력 받기.
		// System.out.print("숫자를 입력해주세요 :");
		// Scanner sc = new Scanner(System.in);
		// num = sc.nextInt();
		// System.out.println(" 입력 받은 시간은  : " + num);
		//
		// // 3. 입력받은 시간과 현재 시간 더하기
		// registerTime = time + num;
		//
		// String str2 = dayTime.format(new Date(time));
		// System.out.println(" 세팅한 시간은  : " + str2 + "  /  " + registerTime);
		//

	}

	public void run() {
		while (this.canceled == false) {
			// 1. time check
			long current = System.currentTimeMillis();
			// 2. dataStructure 에서 지정한 타이머 이전에 것을 빼온다.
			Iterator<Long> keys = events.keySet().iterator();
			while (keys.hasNext()) {
				Long key = keys.next();
				if (key <= current) {
					List<TimerCallback> temp = events.get(key);
					if (temp != null) {
						for (int i = 0; i < temp.size(); i++) {
							// Object Callback 수 행;
							TimerCallback callback = temp.get(i);
							if (callback != null) {
								callback.call();
							}
						}
					}
					keys.remove();
				} else {
					break;
				}

			}
			// for (Long key : events.keySet()) {
			// if (key <= current) {
			// List<TimerCallback> temp = events.get(key);
			// if (temp != null) {
			// for (int i = 0; i < temp.size(); i++) {
			// // Object Callback 수 행;
			// TimerCallback callback = temp.get(i);
			// if (callback != null) {
			// callback.call();
			// }
			// }
			// }
			// events.remove(key);
			// } else {
			// break;
			// }
			//
			// }
			// 3. callback for 문 다돌고 삭제
		}
	}

	// public void SaveTimer(){
	// // 4. 세팅한 시간 차곡차고 map에 저장하기
	//
	// Map<String, List<String>> m = new HashMap<String, List<String>>();
	// //TreeMap<String, List<String>> tm = new TreeMap<String, List<String>>();
	// }

	public static void main(String[] args) {

		Timer timer = new Timer();
		timer.SetTimer(10000, new CallbackEvent());
		timer.SetTimer(20000, new CallbackEvent());

		timer.run();

	}
}
