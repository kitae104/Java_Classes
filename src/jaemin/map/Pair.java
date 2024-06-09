package jaemin.map;

public class Pair<A, B> {
    public A first;
    public  B second;
    public Pair(A a, B b) {
        first = a;
        second = b;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Pair) {
            //@SuppressWarnings("rawtypes")
            // returns true if first and second are the same // your code
            if(first.equals(((Pair) o).first) && second.equals(((Pair) o).second)) {
                return true;
            }
        }
        return false;
    }
}