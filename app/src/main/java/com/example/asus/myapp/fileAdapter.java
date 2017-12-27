package com.example.asus.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by Kojewang on 2017/12/27
 * Adater used to inflate to the file.
 */

public class fileAdapter extends ArrayAdapter {

    private LayoutInflater mInflater; //用来保存上下文菜单

    public fileAdapter(Context context,  List objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
        mInflater = LayoutInflater.from(context);
    }
}
