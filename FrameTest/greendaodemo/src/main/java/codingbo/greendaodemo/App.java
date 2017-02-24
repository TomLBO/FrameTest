package codingbo.greendaodemo;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by bob
 * on 16.12.8.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize( Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());
    }
}
