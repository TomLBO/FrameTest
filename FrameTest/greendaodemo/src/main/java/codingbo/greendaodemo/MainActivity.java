package codingbo.greendaodemo;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import codingbo.greendaodemo.bean.DaoMaster;
import codingbo.greendaodemo.bean.DaoSession;
import codingbo.greendaodemo.bean.User;
import codingbo.greendaodemo.bean.UserDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "test", null);

        SQLiteDatabase db = helper.getWritableDatabase();

        DaoMaster daoMaster = new DaoMaster(db);

        DaoSession daoSession = daoMaster.newSession();

        UserDao userDao = daoSession.getUserDao();

//        User hermione = new User(1L, "hermione");
//        User harry = new User(2L, "harry");
//        User ron = new User(3L, "ron");
//        userDao.insert(hermione);
//        userDao.insert(harry);
//        userDao.insert(ron);
        User hermione = new User();
        User harry = new User();
        User ron = new User();

        hermione.setName("hermione");
        harry.setName("harry");
        ron.setName("ron");

        userDao.insert(hermione);
        userDao.insert(harry);
        userDao.insert(ron);



//        Long key = userDao.getKey(hermione);
//        Log.d("haha", "onCreate hermione's key: " + key);


    }
}
