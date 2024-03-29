package org.example;

import java.util.Arrays;

public class MyStringBuilder {

    private char [] value;

    private int count = 0;

    public MyStringBuilder () {
        this.value = new char[8];

    }

    public MyStringBuilder (int number) {
        this.value = new char[number];

    }

    public MyStringBuilder (String str) {
        this.value = new char[str.length()];
        append(str);
    }

    public MyStringBuilder (Object obj) {
        append(obj.toString());
    }


    public MyStringBuilder append (String str) {
//        char [] charArray;
//        if (str == null) {
//            charArray = new char[]{'n', 'u', 'l', 'l'};
//        }
//        else
//            charArray = str.toCharArray();
//
//        int count = this.count;
//        int len = charArray.length;
//        if(value.length < count + len) {
//            grow();
//        }
//        for (int i = 0; i < len;i ++) {
//            value[count + i] = charArray[i];
//
//        }
//        this.count = count + len;
//        return this;
        return insert(count, str);
    }

    public MyStringBuilder append (Object obj) {
        return append(String.valueOf(obj));
    }

    private void grow() {
        value = Arrays.copyOf(value,value.length * 2);

    }

    public int length() {
        return count;
    }

    public int compareTo(MyStringBuilder another) {
        return this.toString().compareTo(another.toString());
    }

    public String toString() {
        return new String(value, 0, count);
    }

    public MyStringBuilder deleteChar (int index) {
        checkedElement(index);
        if (count == 1) {
            value = new char[8];

        }
        else {
            char[] tempArray = value;
            int count = this.count;
            System.arraycopy(value, index + 1, tempArray, index, count - (index + 1));
            this.count--;
        }
        return this;

    }

    public MyStringBuilder delete (int start, int end) throws Exception {
        checkedElement(start);
        checkedOffset(end);
        if (start > end) {
            throw new Exception("start should be less end");
        }
        if (count == 1) {
            value = new char[8];

        }
        else {
            char[] tempArray = value;
            int count = this.count;
            System.arraycopy(value, end, tempArray, start, count - end);
            this.count -= end - start;
        }
        return this;

    }

    private void checkedElement(int index) {
        if (index < 0 || index >= count) {
            throw new StringIndexOutOfBoundsException("index " + index +
                    ", length " + count);
        }
    }

    private void checkedOffset(int index) {
        if (index < 0 || index > count) {
            throw new StringIndexOutOfBoundsException("index " + index +
                    ", length " + count);
        }
    }



    public boolean isEmpty() {
        if(count > 0)
            return false;
        else
            return true;


    }

    public MyStringBuilder insert(int offset, String str) {
        checkedOffset(offset);
        char [] charArray;
        if (str == null) {
            charArray = new char[]{'n', 'u', 'l', 'l'};
        }
        else
            charArray = str.toCharArray();

        int count = this.count;
        int len = charArray.length;
        if(value.length < count + len) {
            grow();
        }
        char [] tempArray = new char[count -offset];
        System.arraycopy(value, offset, tempArray, 0, count - offset);

        for (int i = 0; i < len;i ++) {
            value[offset + i] = charArray[i];

        }
        for (int j =0 ; j < count -offset; j++)
        {
            value[offset+len+j] = tempArray[j];
        }
        this.count = count + len;
        return this;
    }

    public MyStringBuildSnapshot save() {
        char[] tempArray = new char[count];
        for(int i = 0; i < count; i++)
        {
            tempArray[i] = value [i];
        }
        return new MyStringBuildSnapshot(tempArray);
    }

    public void restore(ISnapshot myStringBuildSnapshot) {

        value = myStringBuildSnapshot.getValue();
        count = myStringBuildSnapshot.getValue().length;

    }
}
