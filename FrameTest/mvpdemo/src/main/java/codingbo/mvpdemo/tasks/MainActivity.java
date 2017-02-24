package codingbo.mvpdemo.tasks;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import codingbo.mvpdemo.R;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.fl_contain)
    FrameLayout mFlContain;
    @BindView(R.id.fab_add)
    FloatingActionButton mFabAdd;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.nav_view)
    NavigationView mNavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        ActionBar bar = getSupportActionBar();
        bar.setHomeAsUpIndicator(R.drawable.ic_dehaze);
        bar.setDisplayHomeAsUpEnabled(true);

        setNavMenuListener();

        setFragment();
    }

    private void setFragment() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fl_contain);
        if(fragment == null){
            //TODO
        }

    }

    private void setNavMenuListener() {
        mNavView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.list_nav_menu_item:
                        Toast.makeText(MainActivity.this, "list", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.face_nav_menu_item:
                        Toast.makeText(MainActivity.this, "face", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings_nav_menu_item:
                        Toast.makeText(MainActivity.this, "settings", Toast.LENGTH_SHORT).show();
                        break;

                }
                item.setCheckable(true);
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
    }
}
