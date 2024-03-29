package org.example;

public class MyStringBuildSnapshot implements ISnapshot{

    private char [] value;

    public MyStringBuildSnapshot(char[] value) {
        this.value = value;
    }

    @Override
    public char[] getValue() {
        return value;
    }
}
