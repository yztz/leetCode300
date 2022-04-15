package s80;


import java.util.List;

/**
 * S -> [T] | num
 * T -> S,T | S | ε
 */

public class Solution {
    int i = 0;
    String s;
    public NestedInteger deserialize(String s) {
        this.s = s;
        return S();
    }

    public void T(NestedInteger root) {
        //System.out.println("enter T " + s.substring(i));
        if (s.charAt(i) == ']') return;
        root.add(S());
        if(i < s.length() && s.charAt(i) == ',') {
            i++;
            T(root);
        }
        //System.out.println("leave T");
    }

    public NestedInteger S() {
        //System.out.println("enter S " + s.substring(i));
        NestedInteger integer;
        if (s.charAt(i) == '[') { // [T]
            i++; // [
            integer = new NestedInteger();
            T(integer);
            i++; // ]
        } else { // num
            int start = i;
            while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-')) i++;
            integer = new NestedInteger(Integer.parseInt(s.substring(start, i)));
        }
        //System.out.println("leave S");
        return integer;
    }
}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList();

}
