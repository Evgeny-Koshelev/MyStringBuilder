package org.example;

import java.util.Stack;

public class Memory {

    private Stack<ISnapshot> history;
    private MyStringBuilder stringBuilder;

    public Memory(MyStringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
        history = new Stack<>();
    }

    public void backup() {
        history.push(stringBuilder.save());

    }

    public void undo(){
        if(history.isEmpty())
            return;;
            stringBuilder.restore(history.pop());
    }
}
