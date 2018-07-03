package com.leo.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.leo.utils.AndroidDefaultCacheUtils;
import com.leo.utils.FileUtils;
import com.leo.utils.KeyboardUtils;
import com.leo.utils.ThreadUtils;
import com.leo.utils.ToastUtils;

import java.io.File;
import java.util.concurrent.ExecutorService;

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
        final EditText editText = findViewById(R.id.edit_text);
        TextView tv = findViewById(R.id.sample_text);
        tv.setOnClickListener(v ->
                KeyboardUtils.toggleSoftInput(MainActivity.this)
        );

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
//        Log.i("sdcard", "path:" + SDCardUtils.INNER_EXTERNAL_STORAGE_DIRECTORY);
//        Log.i("sdcard", "path:" + SDCardUtils.getSecondaryStoragePath(this));
//        Log.i("sdcard", "size:" + SDCardUtils.getOuterSDFreeSize(this));


        Log.i("cache", "path:" + AndroidDefaultCacheUtils.getDefaultCachePath(this));

        String aaa = "f65sa4fg684g364d684fg65da4g6ad46da4f6s4f6sa68dfs";
        File file = new File(AndroidDefaultCacheUtils.getDefaultCachePath(this) + File.separator + "text.text");

//        Log.i("cache", "result:" + FileUtils.writeFileFromString(file, aaa, false));
        Log.i("cache", "result:" + FileUtils.readFile2String(file, null));

    }

    private void testThreadPool() {
        for (int i = 0; i < 1000; i++) {
            ExecutorService executor = ThreadUtils.createDefaultThreadPool();
            executor.execute(new InnerRunnable(i));
        }
    }

    static class InnerRunnable implements Runnable {

        int id;

        InnerRunnable(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            Log.i("ExecutorService", "测试线程池" + id);
        }
    }

}
