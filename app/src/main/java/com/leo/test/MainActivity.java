package com.leo.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.leo.utils.MyPackageUtils;
import com.leo.utils.RegexUtils;
import com.leo.utils.SDCardUtils;
import com.leo.utils.StringUtils;

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

//        Log.i("aaaa", "result:" + StringUtils.isConSpeCharacters("的飞机哦大师傅感觉kuhgidahguid6546581654"));
//        Log.i("aaaa", "result:" + StringUtils.isConSpeCharacters("skufhuishfui"));
//        Log.i("aaaa", "result:" + StringUtils.isConSpeCharacters("165651651651658"));
//        Log.i("aaaa", "result:" + StringUtils.isConSpeCharacters("dgdrag4665846584"));
//        Log.i("aaaa", "result:" + StringUtils.isConSpeCharacters("    " +
//                "" +
//                "" +
//                "+5454"));
//        Log.i("aaaa", "result:" + StringUtils.isConSpeCharacters("^&^&*^&^%&^&*%6546848dfdgdd"));
//        Log.i("aaaa", "result:" + StringUtils.isConSpeCharacters("\\\4364"));


//        Log.i("aaaa","test:"+ RegexUtils.isMatch(".","[`~!@#$%^&*+=|{}':;',-\\[\\].<>/?~！@#￥%……&*——+|{}【】‘；：”“'。，、？]"));
//        Log.i("aaaaa", "666：" + SDCardUtils.getSDCardPath());
//        Log.i("aaaaa", "" + MyPackageUtils.getVersionName(getApplicationContext()));
//        Log.i("aaaaa", "" + MyPackageUtils.getVersionCode(getApplicationContext()));
//        Log.i("aaaaa", "" + MyPackageUtils.getPackageName(getApplicationContext()));
    }
}
