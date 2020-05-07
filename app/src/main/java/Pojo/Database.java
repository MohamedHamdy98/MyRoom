package Pojo;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
@androidx.room.Database(entities = {Model.class},version = 1 , exportSchema = false)
public abstract class Database extends RoomDatabase {

    public abstract DaoInterface daoInterface();

    public static volatile Database insatnce;

    public static Database getDatabase(Context context) {
        if (insatnce == null) {
            synchronized (Database.class) {
                if (insatnce == null) {
                    insatnce = Room.databaseBuilder(context, Database.class, "database")
                            .build();
                }
            }
        }
        return insatnce;
    }
}
