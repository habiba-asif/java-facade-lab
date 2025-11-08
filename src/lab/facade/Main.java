package lab.facade;

public class Main {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
        // pretend the computer does some work
        System.out.println("Main: doing user tasks...\n");
        computer.shutdown();
    }
}
