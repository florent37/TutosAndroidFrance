package com.tutosandroidfrance.unittest;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by florentchampigny on 03/07/15.
 */
public class Storage {

    SharedPreferences sharedPreferences;
    private static final String PREFS = "PREFS";
    private static final String PREFS_INT_LIST = "PREFS_INT_LIST";

    public Storage(Context context){
        this.sharedPreferences = context.getSharedPreferences(PREFS,Context.MODE_PRIVATE);
    }

    protected String transformToString(List<Integer> list){
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for(int i=0;i<size;++i){
            stringBuilder.append(list.get(i));
            if(i!=size-1)
                stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }

    protected List<Integer> transformFromString(String string){
        List<Integer> list = new ArrayList<>();

        String[] splitted = string.split(",");

        int size = splitted.length;
        for(int i=0;i<size;++i)
            list.add(Integer.valueOf(splitted[i]));

        return list;
    }

    public List<Integer> load(){
        String content = sharedPreferences.getString(PREFS_INT_LIST, null);
        if(content != null)
            return transformFromString(content);
        else
            return new ArrayList<>();

    }

    public void save(List<Integer> list){
        sharedPreferences.edit().putString(PREFS_INT_LIST,transformToString(list)).apply();
    }

}
