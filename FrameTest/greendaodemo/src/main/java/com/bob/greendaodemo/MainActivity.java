package com.bob.greendaodemo;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import test.greenDAO.bean.Note;
import test.greenDAO.dao.DaoMaster;
import test.greenDAO.dao.DaoSession;
import test.greenDAO.dao.NoteDao;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input)
    EditText input;
    @BindView(R.id.add)
    Button add;
    @BindView(R.id.query)
    Button query;
    private DaoSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "DemoDB.db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster master = new DaoMaster(db);
        session = master.newSession();


    }

    @OnClick({R.id.add, R.id.query})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                addData();

                break;
            case R.id.query:
                queryData();

                break;
        }
    }

    private void queryData() {
        String data = input.getText().toString();
        input.setText("");
//        DateFormat date = DateFormat.getDateTimeInstance();
        Note note = new Note(null, data, 11 + "",  new Date());
        getNoteDao().insert(note);

    }

    private void addData() {
        String data = input.getText().toString();
        input.setText("");

    }

    private NoteDao getNoteDao(){
//        return ((GreenDaoApplication)this.getApplication()).getDaoSession().getNoteDao();
        return session.getNoteDao();
    }

}
