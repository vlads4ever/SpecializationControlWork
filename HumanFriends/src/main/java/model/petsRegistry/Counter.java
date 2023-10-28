package model.petsRegistry;

public class Counter implements AutoCloseable{
    private static int count;
    public Counter() {
        count = 0;
    }

    public void add() {
        count++;
    }

    public int getNewId() {
        return count;
    }

    @Override
    public void close() {
        System.out.println("Counter closed");
    }

}
