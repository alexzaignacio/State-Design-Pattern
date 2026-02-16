public class VendingMachine {
    private int inventory;
    private int balance;
    private VendingMachineState currentState;

    public VendingMachine(int initialInventory) {
        this.inventory = initialInventory;
        this.balance = 0;
        this.currentState = new IdleState();
    }

    public void selectItem() {
        currentState.selectItem(this);
    }

    public void insertCoin(int amount) {
        currentState.insertCoin(this, amount);
    }

    public void dispenseItem() {
        currentState.dispenseItem(this);
    }

    public void setOutOfOrder() {
        currentState.setOutOfOrder(this);
    }

    public int getInventory() {
        return inventory;
    }

    public void reduceInventory() {
        if (inventory > 0) {
            inventory--;
        }
    }

    public int getBalance() {
        return balance;
    }

    public void addToBalance(int amount) {
        balance += amount;
    }

    public void subtractFromBalance(int amount) {
        if (balance >= amount) {
            balance -= amount;
        }
    }

    public void setBalance(int amount) {
        this.balance = amount;
    }

    public void setCurrentState(VendingMachineState state) {
        this.currentState = state;
    }

    public void printStatus() {
        System.out.println("State: " + currentState.getClass().getSimpleName());
        System.out.println("Inventory: " + inventory + " items");
        System.out.println("Balance: ₱" + balance);
        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine(3);

        vm.printStatus();

        vm.insertCoin(10);    
        vm.selectItem();       
        vm.insertCoin(10);     
        vm.dispenseItem();      

        vm.printStatus();

        vm.setOutOfOrder();
        vm.insertCoin(20);      
        vm.selectItem();       
    }
}