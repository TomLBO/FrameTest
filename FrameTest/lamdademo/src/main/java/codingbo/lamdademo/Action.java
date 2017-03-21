package codingbo.lamdademo;

import java.util.ArrayList;
import java.util.function.Supplier;

/**
 * Created by bob
 * on 17.3.14.
 */

public class Action implements Subject {
    private ArrayList<Observer> mObservers;

    public Action() {
        mObservers = new ArrayList<>();
    }

    public Action(Supplier<String> s) {

    }

    @Override
    public void registerObserver(Observer observer) {
        if (mObservers.contains(observer)) {
            return;
        }
        mObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (!mObservers.contains(observer)) {
            return;
        }
        mObservers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        mObservers.forEach(Observer::update);
    }

    public void move() {
        notifyObserver();
    }
}
