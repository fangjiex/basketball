package Android20160912;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hxzy.login.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/9/12.
 */
public class TestSharedPreferences extends AppCompatActivity{
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    private TextView spTv;
    protected  void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sp);
        sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        spTv = (TextView) findViewById(R.id.sp_tv);
    }
    public void writeSP(View view){
        editor.putBoolean("isFirstRun",true);
        editor.putFloat("height",1.85f);
        editor.putInt("age",28);
        editor.putLong("birth",System.currentTimeMillis());
        editor.putString("name","安安");
        List<String> tagList = new ArrayList<>(Arrays.asList(new String[]{"王霸之气","龙傲天","叶良辰","赵日天"}));
        Set<String> tag = new HashSet<>();
        tag.addAll(tagList);

        Set<String> tags = new HashSet<>();
        tags.add("高大");
        tags.add("威猛");
        tags.add("英俊");
        tags.add("潇洒");

        editor.putStringSet("des1",tag);
        editor.putStringSet("des2",tags);
        editor.commit();

    }
    public void readSP(View view){
        final boolean isFirstRun = sharedPreferences.getBoolean("isFirstRun",false);
        final float height = sharedPreferences.getFloat("height",0);
        final int age = sharedPreferences.getInt("age",0);
        final long birth = sharedPreferences.getLong("birth",0);
        final String name = sharedPreferences.getString("name","");
        final Set<String> tag = sharedPreferences.getStringSet("des1",null);
        final Set<String> tags = sharedPreferences.getStringSet("des2",null);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        spTv.setText("是否是第一次运行："+(isFirstRun ? "是" : "否")+"\n"
                +"名字："+ name+"\n" + "身高："+height+"米\n"+"出生日期："
                +format.format(new Date(birth))+"\n"+"年龄："+age+"\n"+"标签："+getTags(tag)+"\n标签2："+getTags(tags));
    }
    private String getTags(Set<String> tags){
        if(tags == null || tags.size() == 0) return "";
        Iterator iterator = tags.iterator();
        StringBuffer sb = new StringBuffer();
        while (iterator.hasNext()){
            sb.append(iterator.next()+",");
        }
        return sb.toString();
    }


}
