package codingbo.webviewdemo;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    WebView webView;
    ProgressBar progressBar;
    String url = "http://swiftlet.net/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        progressBar.setMax(100);

        Button back = (Button) findViewById(R.id.back);
        Button forward = (Button) findViewById(R.id.forward);
        Button load = (Button) findViewById(R.id.load);
        final EditText address = (EditText) findViewById(R.id.address);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoBack()) {
                    webView.goBack();
                }
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (webView.canGoForward()) {
                    webView.goForward();
                }
            }
        });

        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = address.getText().toString().trim();
                if (TextUtils.isEmpty(url)) {
                    Toast.makeText(MainActivity.this, "address can not be empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!url.startsWith("http://")) {
                    url = "http://" + url;
                }
                webView.loadUrl(url);
            }
        });

        iniView();
    }

    private void iniView() {
        initWebView();
        initWebSettings();
        initWebViewClient();
        initWebChromeClient();
    }

    private void initWebView() {
        webView.loadUrl(url);
    }

    private void initWebSettings() {
        WebSettings settings = webView.getSettings();
        //支持获取手势焦点
        webView.requestFocusFromTouch();
//        webView.setInitialScale();
        //支持JS
//        settings.setJavaScriptEnabled(true);

//        settings.setPluginState();


        //设置适应屏幕
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        //支持缩放
        settings.setSupportZoom(true);
        //双指缩放
        settings.setBuiltInZoomControls(true);
        //隐藏原生缩放控件
        settings.setDisplayZoomControls(true);
        //支持文件重新布局
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        settings.supportMultipleWindows();
//        settings.setSupportMultipleWindows(true);

        //设置缓存模式
//        settings.setDomStorageEnabled(true);
//        settings.setDatabaseEnabled(true);
//        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
//        settings.setAppCacheEnabled(true);
//        settings.setAppCachePath(webView.getContext().getCacheDir().getAbsolutePath());

        //设置可访问文件
        settings.setAllowFileAccess(true);
        //当webview调用requestFocus时为webview设置节点
        settings.setNeedInitialFocus(true);
        //支持自动加载图片
        if (Build.VERSION.SDK_INT >= 19) {
            settings.setLoadsImagesAutomatically(true);
        } else {
            settings.setLoadsImagesAutomatically(false);
        }
        //设置编码格式
        settings.setDefaultTextEncodingName("UTF-8");


    }

    private void initWebViewClient() {
        webView.setWebViewClient(new WebViewClient() {
            //页面开始加载时
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }


            //页面完成加载时
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }

            //是否在WebView内加载新页面
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.toString());
                return true;
            }

            //网络错误时回调的方法
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }

            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
            }

        });
    }

    private void initWebChromeClient() {
        webView.setWebChromeClient(new WebChromeClient() {

            private Bitmap mDefaultVideoPoster;//默认的视频展示图

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
//                Log.d(TAG, "onProgressChanged: " + newProgress);
                progressBar.setProgress(newProgress);
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
//                setToolbarTitle(title);
            }

            @Override
            public Bitmap getDefaultVideoPoster() {
//                if (mDefaultVideoPoster == null) {
//                    mDefaultVideoPoster = BitmapFactory.decodeResource(
//                            getResources(), R.drawable.video_default
//                    );
//                    return mDefaultVideoPoster;
//                }
                return super.getDefaultVideoPoster();
            }
        });
    }
}
