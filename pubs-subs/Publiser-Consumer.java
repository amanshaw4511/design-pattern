import java.util.*;

interface Subscriber {
    // void subscribe(Subscriber subs, String topic);
    void update(String topic, String message);
}

class Broker {
    Map<String,List<Subscriber<T>>> data = new HashMap<>();
    private static Broker instance;

    private Broker() {}

    static Broker getInstance() {
        if (instance == null) {
            instance = new Broker();
        }
        return instance;
    }

    void publish(String topic, String message) {
        List<Subscriber> subsList = data.get(topic);
        if (subsList == null) return;
        subsList.forEach(subs -> subs.update(topic, message));
    }

    void subscribe(Subscriber subs, String topic) {
        List<Subccriber> subsList = data.get(event);
        if (subsList == null) {
            data.put(topic, new ArrayList<Subscriber>(List.of(subs)));
        } else {
            subsList.add(subs);
        }
    }
}

class NewsPublisher {
    private String news;

    public void setNews(String news) {
        this.news = news;
        Broker.GetInstance().publish("news", news);
    }
}


class NewsSubscriberA implements Subscriber {

    NewsSubscriberA() {
        Broker.getInstance().subscribe(this, "news");
    }

    @Override
    public void update(String topic, String message) {
        System.out.println("NewsSubscriberA -> " + topic + " : " + message);
    }
}

class NewsSubscriberB implements Subscriber {

    NewsSubscriberB() {
        Broker.getInstance().subscribe(this, "news");
    }

    @Override
    public void update(String topic, String message) {
        System.out.println("NewsSubscriberB -> " + topic + " : " + message);
    }
}
