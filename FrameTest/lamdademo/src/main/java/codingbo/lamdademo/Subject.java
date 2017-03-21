package codingbo.lamdademo;

/**
 * Created by bob
 * on 17.3.14.
 */

public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();

}
