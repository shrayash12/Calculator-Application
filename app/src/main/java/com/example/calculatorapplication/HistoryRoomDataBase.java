package com.example.calculatorapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities  = {History.class}, version = 1, exportSchema = false)
public abstract class HistoryRoomDataBase extends RoomDatabase {

    public abstract Historydao historiesdao();

    private static HistoryRoomDataBase historyRoomDataBase;
    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    static HistoryRoomDataBase getDatabase(final Context context) {
            synchronized (HistoryRoomDataBase.class) {
                if (historyRoomDataBase == null) {
                    historyRoomDataBase = Room.databaseBuilder(context.getApplicationContext(),
                            HistoryRoomDataBase.class, "word_database")
                            .build();
                }
            }

        return historyRoomDataBase;
    }
}
