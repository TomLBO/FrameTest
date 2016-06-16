package com.bob.greendaodemo;

import android.app.Application;

public class GreenDaoApplication extends Application {


//    private SQLiteDatabase db;
//    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
//        setDatabase();
    }

    private void setDatabase() {
//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "database.db", null);
//        db = helper.getWritableDatabase();
//        DaoMaster daoMaster = new DaoMaster(db);
//        daoSession = daoMaster.newSession();
//        db.close();
    }

//    public DaoSession getDaoSession(){
//        return daoSession;
//    }
//
//    public SQLiteDatabase getDb(){
//        return db;
//    }
}
