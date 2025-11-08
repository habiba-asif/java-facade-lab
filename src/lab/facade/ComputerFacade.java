package lab.facade;

public class ComputerFacade {
    private final Cpu cpu;
    private final Memory memory;
    private final HardDrive hd;

    private static final long BOOT_ADDRESS = 0x1000;
    private static final long BOOT_SECTOR = 0x2000;
    private static final int SECTOR_SIZE = 64;

    public ComputerFacade() {
        this.cpu = new Cpu();
        this.memory = new Memory();
        this.hd = new HardDrive();
    }

public ComputerFacade(Cpu cpu, Memory memory, HardDrive hd) {
    this.cpu = cpu;
    this.memory = memory;
    this.hd = hd;
}

    public void start() {
        System.out.println("Facade: starting computer");
        cpu.freeze();
        byte[] bootData = hd.read(BOOT_SECTOR, SECTOR_SIZE);
        memory.load(BOOT_ADDRESS, bootData);
        cpu.jump(BOOT_ADDRESS);
        cpu.execute();
        System.out.println("Facade: computer started\n");
    }

    public void shutdown() {
        System.out.println("Facade: shutting down computer");
        System.out.println("Facade: power off\n");
    }
}
