package org.example.shapshot;

import org.example.shapshot.ISnapshot;

public class MyStringBuildSnapshot implements ISnapshot {

    private char [] value;

    public MyStringBuildSnapshot(char[] value) {
        this.value = value;
    }

    @Override
    public char[] getValue() {
        return value;
    }
}
