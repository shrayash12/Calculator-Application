package com.example.calculatorapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class HistoryViewModel extends AndroidViewModel {
    private HistoryRepository historyRepository;
    public LiveData<List<History>> allHistories;

    public HistoryViewModel(@NonNull Application application) {
        super(application);
        historyRepository = new HistoryRepository(application);
    }

    LiveData<List<History>> getAllWords() {
        return  historyRepository.getAllHistories() ;
    }

    public void insert(History history) {
        historyRepository.insert(history);
    }

    public void delete() {
        historyRepository.delete();
    }
}

