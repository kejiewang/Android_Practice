package com.example.asus.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lv1;
    private List<String> items = null;
    private List<String> paths = null;
    private String rootPath = "/";
    private TextView mPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lv1 = (ListView) findViewById(R.id.ListView1);
        mPath = (TextView) findViewById(R.id.textView);
        showFileDir(rootPath);
    }

    private void showFileDir(String filePath) {
        //设定当前路径
        mPath.setText(filePath);
        items = new ArrayList<String>();
        paths = new ArrayList<String>();
        File f = new File(filePath);
        File[] files = f.listFiles(); //通过listFiles获取当前File(目录)的所有文件及子目录

        if (!filePath.equals(rootPath)) { //如果不是根目录
           //b1设定为根目录
            items.add("b1");
            paths.add(rootPath);
            //b2设定为返回上一层
            items.add("b2");
            paths.add(f.getParent());
        }
        for(int i = 0; i < files.length; i++){
            File file = files[i];
            //items.add();
        }
    }
}
