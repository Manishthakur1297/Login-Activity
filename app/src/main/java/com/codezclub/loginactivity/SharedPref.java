package com.codezclub.loginactivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Mj 2 on 15-Jun-17.
 */

public class SharedPref {

    SharedPreferences sp ;
    SharedPreferences.Editor ed;
    String Filename = "myfile";
    String isLogin;
    int mode = 0;
    Context context;


    public SharedPref(Context context)
    {
        //super();
        this.context = context;  //--------Declare Area
        sp = context.getSharedPreferences(Filename,mode);  //-------------Add SharePreferences to Area Context
        ed = sp.edit();
    }

    public void checkLogin()
    {
        if(!this.isLogin())
        {
            Intent i = new Intent(context, LoginActivity.class);

            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //-------Removes Intent history-------------
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }

    }

    //------------Create Login

    public void createLogin()
    {
        ed.putBoolean(isLogin,true);
        ed.commit();

    }

    public void Logout()
    {
        ed.clear();
        ed.commit();
        Intent i = new Intent(context,LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(i);
    }

    private boolean isLogin() {
        return sp.getBoolean(isLogin,false);
    }
}
