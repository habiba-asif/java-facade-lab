package lab.facade;

public class Memory {
    private static int loadCount = 0;

    public void load(long position, byte[] data) {
        loadCount++;
        System.out.println(System.currentTimeMillis() + " | Memory: loading " + data.length + " bytes at " + position);
    }

    public static int getLoadCount() {
        return loadCount;
    }
}
