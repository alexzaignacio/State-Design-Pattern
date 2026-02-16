public class ItemSelectedState implements VendingMachineState {
    private static final int ITEM_PRICE = 20;

    @Override
    public void selectItem(VendingMachine machine) {
        System.out.println("Item already selected. Please insert coins or cancel.");
    }

    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        if (amount > 0) {
            machine.addToBalance(amount);
            System.out.println("Inserted ₱" + amount + ". Current balance: ₱" + machine.getBalance());
        } else {
            System.out.println("Please insert a positive amount.");
        }
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        if (machine.getBalance() >= ITEM_PRICE) {
            System.out.println("Dispensing item...");
            machine.reduceInventory();
            machine.subtractFromBalance(ITEM_PRICE);
            System.out.println("Item dispensed! Change: ₱" + machine.getBalance());
            machine.setBalance(0);
            machine.setCurrentState(new DispensingState());
            // Simulate dispensing complete → back to Idle
            machine.setCurrentState(new IdleState());
            System.out.println("Thank you! Machine is now idle.");
        } else {
            System.out.println("Not enough money. Need ₱" + (ITEM_PRICE - machine.getBalance()) + " more.");
        }
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is now out of order.");
        machine.setCurrentState(new OutOfOrderState());
    }
}