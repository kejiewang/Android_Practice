package com.example.asus.myapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dealPathPosition(position);
            }
        });
    }

    private void dealPathPosition(int position) {
        File file = new File(paths.get(position));
        if(file.canRead()){
            if(file.isDirectory()){
                //如果是文件夹
                showFileDir(paths.get(position));
            }else{
                openFile(file);
            }
        }else{
            new AlertDialog.Builder(this).setTitle("警告").setMessage("权限不足").setPositiveButton("OK",null).show();
        }
    }

    private void openFile(File f) {
        Intent intent  = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(android.content.Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(f),"*/*");
        startActivity(intent);
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
            items.add(file.getName());
            paths.add(file.getPath());
        }
       //lv1.setAdapter(new );
    }
}
