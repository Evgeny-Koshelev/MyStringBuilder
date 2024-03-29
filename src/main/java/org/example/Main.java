package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        MyStringBuilder stringBuilder = new MyStringBuilder();
        Memory memory = new Memory(stringBuilder);

        stringBuilder.append("12345");
        stringBuilder.append("aqwerty");
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.length());
        System.out.println();
        memory.backup();

        System.out.println(stringBuilder.insert(3,"aaa"));
        System.out.println(stringBuilder.length());
        System.out.println();

        memory.undo();

        System.out.println(stringBuilder);
        System.out.println(stringBuilder.length());


    }
}