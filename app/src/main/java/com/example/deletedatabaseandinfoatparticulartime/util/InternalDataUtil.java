package com.example.deletedatabaseandinfoatparticulartime.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.io.File;

public class InternalDataUtil {

   //dont use this methdd as it will shut the app down
    public static void deleteAppData(Context context) {
        try {
            // clearing app data
            String packageName = context.getApplicationContext().getPackageName();
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("pm clear "+packageName);

        } catch (Exception e) {
            e.printStackTrace();
        } }

    public static void deleteAllInternalData(Context context){

        InternalDataUtil.deleteCache(context);
        InternalDataUtil.deleteDatabaseIfExists(context,context.getFilesDir().getPath()+"/databases/ankit","ankit");
        InternalDataUtil.clearAllSharedPrefrences(context);
    }

    public static void clearAllSharedPrefrences(Context context){

        PreferenceManager.getDefaultSharedPreferences(context).edit().clear().apply();

    }

    public static void deleteDatabaseIfExists(Context context,String dbPath,String dbName){

        File dbFile = context.getDatabasePath(dbPath);
        if (dbFile.exists()){
            context.deleteDatabase(dbName);
            Log.e("Db_delete","Database Deleted Successfully");
        }
        else{
            Log.e("Db_delete","No database has been found");
        }

    }

    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) { e.printStackTrace();}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if(dir!= null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }

}
