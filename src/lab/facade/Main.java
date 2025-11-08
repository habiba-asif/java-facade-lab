package lab.facade;

public class Main {
    public static void main(String[] args) {
        IHardDrive myHdd = new Hdd(); 
        ComputerFacade computer = new ComputerFacade(new Cpu(), new Memory(), myHdd);

        computer.start();

        computer.start();

        System.out.println("Main: doing user tasks...\n");

        computer.shutdown();
    }
}
