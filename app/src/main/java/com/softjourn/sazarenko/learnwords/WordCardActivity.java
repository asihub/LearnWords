package com.softjourn.sazarenko.learnwords;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WordCardActivity extends AppCompatActivity {

    private static final String CURRENT_INDEX = "com.softjourn.sazarenko.learnwords.current_index";
    private int currentIndex;

    private Button okButton;

    private TextView originalTextView;
    private TextView translationTextView;
    private TextView transcriptionTextView;

    public static Intent newIntent(Context packageContext, int currentIndex) {
        Intent i = new Intent(packageContext, WordCardActivity.class);
        i.putExtra(CURRENT_INDEX, currentIndex);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_card);

        currentIndex = getIntent().getIntExtra(CURRENT_INDEX, 0);
        updateWordTextViews();

        okButton = (Button) findViewById(R.id.okButton);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void updateWordTextViews() {

        originalTextView = (TextView) findViewById(R.id.originalEditText);
        int originalId = LearnWordsActivity.wordsArr[currentIndex].getOriginalWordResId();
        originalTextView.setText(originalId);

        translationTextView = (TextView) findViewById(R.id.translationEditText);
        int translationId = LearnWordsActivity.wordsArr[currentIndex].getTranslationResId();
        translationTextView.setText(translationId);

        transcriptionTextView = (TextView) findViewById(R.id.transcriptionEditText);
        int transcriptionId = LearnWordsActivity.wordsArr[currentIndex].getTranscriptionResId();
        transcriptionTextView.setText(transcriptionId);
    }
}
