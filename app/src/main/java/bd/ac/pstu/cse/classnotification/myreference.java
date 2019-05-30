package bd.ac.pstu.cse.classnotification;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static android.content.Context.MODE_PRIVATE;

public class myreference {




    public static String getMyReference(Context context){
        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(context);

     return preferences.getString("name","");
    }
    public static String getMyReferencePass(Context context){
        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(context);

        return preferences.getString("pass","");
    }


    public static boolean setMyReference(String setName,String setPass,Context context){
        SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("name",setName);
        editor.putString("pass",setPass);
        editor.commit();
        editor.apply();
        return true;
    }




}
