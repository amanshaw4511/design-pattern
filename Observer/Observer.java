import java.util.ArrayList;
import java.util.List;
interface Observerable {
    void updateObservers();

}

interface Observer {
    void updateObservers();
}


class ObserverableZ implements Observerable {
    List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    public void removeObserver(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void updateObservers() {
        observers.forEach(Observer::update);
    }
}


class ObserverA implements Observer {
    @Override
    public void update() {
        System.out.println("Observer A update");
    }
}

class ObserverB implements Observer {
    @Override
    public void update() {
        System.out.println("Observer B update");
    }
}

class ObserverC implements Observer {
    @Override
    public void update() {
        System.out.println("Observer C update");
    }
}
