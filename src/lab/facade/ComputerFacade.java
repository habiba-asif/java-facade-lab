package lab.facade;

public class ComputerFacade {
    private final Cpu cpu;
    private final Memory memory;
    private final IHardDrive hd;

    private static final long BOOT_ADDRESS = 0x1000;
    private static final long BOOT_SECTOR = 0x2000;
    private static final int SECTOR_SIZE = 64;

    private boolean sleeping = false;

    public ComputerFacade() {
        this.cpu = new Cpu();
        this.memory = new Memory();
        this.hd = new Hdd();
    }

    public ComputerFacade(Cpu cpu, Memory memory, IHardDrive hd) {
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

        // Print metrics
        System.out.println("=== Metrics Report ===");
        System.out.println("CPU execute calls: " + Cpu.getExecuteCount());
        System.out.println("Memory load calls: " + Memory.getLoadCount());
        System.out.println("HardDrive read calls: " + Hdd.getReadCount());
        System.out.println("======================");
    }

    public void sleep() {
        System.out.println("Facade: saving state + lowering power");
        sleeping = true;
    }

    public void wake() {
        if (sleeping) {
            System.out.println("Facade: restoring state + full power");
            sleeping = false;
        }
    }
}
