public class IdleState implements VendingMachineState {
    @Override
    public void selectItem(VendingMachine machine) {
        if (machine.getInventory() > 0) {
            System.out.println("Item selected.");
            machine.setCurrentState(new ItemSelectedState());
        } else {
            System.out.println("Sorry, item is out of stock.");
            machine.setCurrentState(new OutOfOrderState());
        }
    }

    @Override
    public void insertCoin(VendingMachine machine, int amount) {
        System.out.println("Please select an item first.");
    }

    @Override
    public void dispenseItem(VendingMachine machine) {
        System.out.println("No item selected yet.");
    }

    @Override
    public void setOutOfOrder(VendingMachine machine) {
        System.out.println("Machine is now out of order.");
        machine.setCurrentState(new OutOfOrderState());
    }
}