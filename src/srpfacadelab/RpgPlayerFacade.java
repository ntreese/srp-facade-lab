package srpfacadelab;

public class RpgPlayerFacade {

    public void useItem(Item item, RpgPlayer player){
        ItemHandler.useItem(item, player);
    }

    public boolean pickUpItem(Item item, int carryingCapacity, RpgPlayer player){
        return ItemHandler.pickUpItem(item, carryingCapacity, player);
    }

    public void takeDamage(int damage, RpgPlayer player){
        DamageHandler.takeDamage(damage, player);
    }

    public static boolean checkIfItemExistsInInventory(Item item, RpgPlayer player){
        return InventoryHandler.checkIfItemExistsInInventory(item, player);
    }

    public static int calculateInventoryWeight(RpgPlayer player){
        return InventoryHandler.calculateInventoryWeight(player);
    }

    public static void calculateStats(RpgPlayer player){
        InventoryHandler.calculateStats(player);
    }

}
