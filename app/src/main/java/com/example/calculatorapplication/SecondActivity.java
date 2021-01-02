package com.example.calculatorapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private HistoryViewModel historyViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        historyViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(HistoryViewModel.class);

        Button button = findViewById(R.id.clear);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyViewModel.delete();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final Historyadapter adapter = new Historyadapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        historyViewModel.getAllWords().observe(this, words -> {
            // Update the cached copy of the words in the adapter.
            adapter.submitList(words);
        });
    }
}
