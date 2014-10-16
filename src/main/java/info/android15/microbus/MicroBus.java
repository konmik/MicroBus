package info.android15.microbus;

import java.util.ArrayList;
import java.util.HashMap;

public class MicroBus {
	public interface BusEventReceiver {
		void onBusEvent(Object event);
	}

	private HashMap<Class<?>, ArrayList<BusEventReceiver>> receivers = new HashMap<Class<?>, ArrayList<BusEventReceiver>>();

	public void register(BusEventReceiver receiver, Class<?> cls) {
		ArrayList<BusEventReceiver> list = receivers.get(cls);
		if (list == null)
			receivers.put(cls, list = new ArrayList<BusEventReceiver>());

		list.add(receiver);
	}

	public void unregister(BusEventReceiver receiver, Class<?> cls) {
		ArrayList<BusEventReceiver> list = receivers.get(cls);
		if (list != null)
			list.remove(receiver);
	}

	public void post(Object event) {
		ArrayList<BusEventReceiver> list = receivers.get(event.getClass());
		if (list != null) {
			for (BusEventReceiver receiver : (ArrayList<BusEventReceiver>)list.clone())
				receiver.onBusEvent(event);
		}
	}
}
