package com.travel.dulichviet;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Database {
    public static SQLiteDatabase initDatabase(Activity activity, String databaseName){
        try {
            String outFileName = activity.getApplicationInfo().dataDir + "/databases/" + databaseName;
            File f = new File(outFileName);
            if(!f.exists()) {
                InputStream e = activity.getAssets().open(databaseName);
<<<<<<< HEAD
//                File folder = new File(activity.getApplicationInfo().dataDir + "/databases/");
//                if (!folder.exists()) {
//                    folder.mkdir();
//                }
=======
                File folder = new File(activity.getApplicationInfo().dataDir + "/databases/");
                if (!folder.exists()) {
                    folder.mkdir();
                }
>>>>>>> 2d5c1ad41669ed9f69b4fa0627614d9ff93d626c
                FileOutputStream myOutput = new FileOutputStream(outFileName);
                byte[] buffer = new byte[1024];

                int length;
                while ((length = e.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }
<<<<<<< HEAD
=======

>>>>>>> 2d5c1ad41669ed9f69b4fa0627614d9ff93d626c
                myOutput.flush();
                myOutput.close();
                e.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return activity.openOrCreateDatabase(databaseName, Context.MODE_PRIVATE, null);
    }
<<<<<<< HEAD

=======
>>>>>>> 2d5c1ad41669ed9f69b4fa0627614d9ff93d626c
}
