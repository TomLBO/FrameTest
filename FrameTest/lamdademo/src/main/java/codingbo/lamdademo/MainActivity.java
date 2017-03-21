package codingbo.lamdademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.function.Supplier;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Action a = new Action(String::new);

        a = new Action(new Supplier<String>() {
            @Override
            public String get() {
                return new String();
            }
        });


        Action action = new Action();

        action.registerObserver(() -> print());



        action.registerObserver(this::print);

        action.registerObserver(new Observer() {
            @Override
            public void update() {
                print();
            }
        });
    }

    public void print() {
        Log.d(TAG, "onCreate: ");
        Log.d(TAG, "onCreate: ");
        Log.d(TAG, "onCreate: ");
    }


}
