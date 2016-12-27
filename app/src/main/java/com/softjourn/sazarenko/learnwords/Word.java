package com.softjourn.sazarenko.learnwords;

public class Word {

    private int originalWordResId;
    private int translationResId;
    private int transcriptionResId;

    public Word(int originalWordResId, int translationResId, int transcriptionResId) {
        this.originalWordResId = originalWordResId;
        this.translationResId = translationResId;
        this.transcriptionResId = transcriptionResId;
    }

    public int getOriginalWordResId() {
        return originalWordResId;
    }

    public void setOriginalWordResId(int originalWordResId) {
        this.originalWordResId = originalWordResId;
    }

    public int getTranslationResId() {
        return translationResId;
    }

    public void setTranslationResId(int translationResId) {
        this.translationResId = translationResId;
    }

    public int getTranscriptionResId() {
        return transcriptionResId;
    }

    public void setTranscriptionResId(int transcriptionResId) {
        this.transcriptionResId = transcriptionResId;
    }
}
