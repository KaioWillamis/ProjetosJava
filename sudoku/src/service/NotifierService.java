package service;

public class NotifierService {
    private Map<EventEnum, List<EventListener>> listener = new HashMap<>(){{
        put(CLEAR_SPACE,new ArrayList<>());
    }};

    public void subscribe(final EventEnum eventType, EventListener listener){
        var selectedListeners:List<EventListener> = listeners.get(EventType);
        selectedListeners.add(Listener);
    }

    public void notify(final EventEnum eventType){
        listeners.get(eventType).forEach(l -> l.update(eventType));
    }
}
