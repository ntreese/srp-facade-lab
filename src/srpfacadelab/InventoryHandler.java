package srpfacadelab;

public class InventoryHandler {
    public static boolean checkIfItemExistsInInventory(Item item, RpgPlayer player) {
        for (Item i: player.getInventory()) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }

    public static int calculateInventoryWeight(RpgPlayer player) {
        int sum=0;
        for (Item i: player.getInventory()) {
            sum += i.getWeight();
        }
        return sum;
    }

    public static void calculateStats(RpgPlayer player) {
        for (Item i: player.getInventory()) {
            player.setArmour(player.getArmour()+i.getArmour());
        }
    }
}
