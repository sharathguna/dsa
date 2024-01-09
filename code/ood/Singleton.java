package code.ood;

class PrinterService {

  private static volatile PrinterService uniqueInstance = null;

  private String mode = null;

  private PrinterService() {
    this.mode = "GrayScale";
  }

  public static PrinterService getInstance() {
    if (uniqueInstance == null) {
      synchronized (PrinterService.class) {
        if (uniqueInstance == null) {
          uniqueInstance = new PrinterService();
        }
      }
    }
    return uniqueInstance;
  }

  public String getPrinterStatus() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
    System.out.println("Mode changed to " + mode);
  }
}

class Client {

  public static void main(String[] args) {
    PrinterService worker1 = PrinterService.getInstance();
    PrinterService worker2 = PrinterService.getInstance();

    worker1.setMode("Color");
    worker2.setMode("Grayscale");

    String worker1Mode = worker1.getPrinterStatus();
    String worker2Mode = worker2.getPrinterStatus();

    System.out.println(worker1 + " " + worker1Mode);
    System.out.println(worker2 + " " + worker2Mode);
  }
}
