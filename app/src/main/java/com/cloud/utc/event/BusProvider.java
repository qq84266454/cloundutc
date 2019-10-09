
package com.cloud.utc.event;


import org.greenrobot.eventbus.EventBus;

/**
 * Maintains a singleton instance for obtaining the bus. Ideally this would be
 * replaced with a more efficient means such as through injection directly into
 * interested classes.
 */
public final class BusProvider {

    //    private static final EventBus BUS = new EventBus();
    private static final EventBus BUS = EventBus.getDefault();

    public static EventBus getInstance() {
        return BUS;
    }

    public static void post(int type){
        getInstance().post(new EventBusInfo<>(type));
    }

    private BusProvider() {
        // No instances.
    }

    public static void unregister(Object object) {
        if (BUS.isRegistered(object)) {
            BUS.unregister(object);
        }
    }

    public static void register(Object object) {
        if (!BUS.isRegistered(object)) {
            BUS.register(object);
        }
    }

}
