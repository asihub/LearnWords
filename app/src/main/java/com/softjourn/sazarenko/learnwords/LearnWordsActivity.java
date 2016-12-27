package com.softjourn.sazarenko.learnwords;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class LearnWordsActivity extends AppCompatActivity {

    private static final String TAG = "LearnWordsActivity";
    final private Random random = new Random();

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private Button cardButton;

    private TextView originalTextView;
    private TextView translationTextView;

    private boolean isTranslationCorrect;

    public static Word[] wordsArr = new Word[] {
            new Word(R.string.original_1, R.string.translation_1, R.string.transcription_1),
            new Word(R.string.original_2, R.string.translation_2, R.string.transcription_2),
            new Word(R.string.original_3, R.string.translation_3, R.string.transcription_3)
    };

    private int currentIndex = generateRandomIndex();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate() called");

        setContentView(R.layout.activity_learn_words);

        updateWordTextViews();

        trueButton = (Button) findViewById(R.id.true_button);
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnswerToast(true);
            }
        });

        falseButton = (Button) findViewById(R.id.false_button);
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnswerToast(false);
            }
        });

        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = generateRandomIndex();
                updateWordTextViews();
            }
        });

        cardButton = (Button) findViewById(R.id.answerButton);
        cardButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = WordCardActivity.newIntent(LearnWordsActivity.this, currentIndex);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    private void updateWordTextViews() {

        isTranslationCorrect = generateRandomAnswer();

        originalTextView = (TextView) findViewById(R.id.originalEditText);
        int originalId = wordsArr[currentIndex].getOriginalWordResId();
        originalTextView.setText(originalId);

        translationTextView = (TextView) findViewById(R.id.translationEditText);
        int translationId;
        if (isTranslationCorrect) {
            translationId = wordsArr[currentIndex].getTranslationResId();
        } else {
            int randomAnswerIndex = generateRandomIndex();
            translationId = wordsArr[randomAnswerIndex].getTranslationResId();
            if (randomAnswerIndex == currentIndex) {
                isTranslationCorrect = true;
            }
        }
        translationTextView.setText(translationId);
    }

    private int generateRandomIndex() {
        return random.nextInt(wordsArr.length);
    }

    private boolean generateRandomAnswer() {
        return random.nextBoolean();
    }

    private void showAnswerToast(boolean usersAnswer) {
        String text;

        if (usersAnswer == isTranslationCorrect) {
            text = "Excellent !";
        } else {
            text = "Whoops. Try again !";
        }

        Toast.makeText(LearnWordsActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}
