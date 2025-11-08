package lab.facade;

public class Cpu {
    private static int executeCount = 0;

    public void freeze() {
        System.out.println(System.currentTimeMillis() + " | CPU: freeze");
    }

    public void jump(long position) {
        System.out.println(System.currentTimeMillis() + " | CPU: jump to " + position);
    }

    public void execute() {
        executeCount++;
        System.out.println(System.currentTimeMillis() + " | CPU: execute");
    }

    public static int getExecuteCount() {
        return executeCount;
    }
}
