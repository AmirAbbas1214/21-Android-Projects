package com.example.quizapp;

public class Questions {
    int AnswarId;
    Boolean AnswarTrue;

    public Questions(int answarId, Boolean answarTrue) {
        AnswarId = answarId;
        AnswarTrue = answarTrue;
    }

    public int getAnswarId() {
        return AnswarId;
    }

    public void setAnswarId(int answarId) {
        AnswarId = answarId;
    }

    public Boolean getAnswarTrue() {
        return AnswarTrue;
    }

    public void setAnswarTrue(Boolean answarTrue) {
        AnswarTrue = answarTrue;
    }
}
