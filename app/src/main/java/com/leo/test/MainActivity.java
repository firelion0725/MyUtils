package com.leo.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.leo.utils.MyPackageUtils;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        test();
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    private void test() {
        Log.i("aaaaa", "" + MyPackageUtils.getSdkVersion());
        Log.i("aaaaa", "" + MyPackageUtils.getVersionName(getApplicationContext()));
        Log.i("aaaaa", "" + MyPackageUtils.getVersionCode(getApplicationContext()));
        Log.i("aaaaa", "" + MyPackageUtils.getPackageName(getApplicationContext()));
    }
}
