package util;

public class IDGenerator {

    private static long currentId = 1;

    public static long generateId(){
        return currentId++;
    }
}
