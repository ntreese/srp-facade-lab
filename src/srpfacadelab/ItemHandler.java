package srpfacadelab;

import java.util.List;

public class ItemHandler {

    public static void useItem(Item item, RpgPlayer player) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = player.getGameEngine().getEnemiesNear(player);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }

    public static boolean pickUpItem(Item item, int carryingCapacity, RpgPlayer player) {
        int weight = InventoryHandler.calculateInventoryWeight(player);
        if (weight + item.getWeight() > carryingCapacity)
            return false;

        if (item.isUnique() && InventoryHandler.checkIfItemExistsInInventory(item, player))
            return false;

        // Don't pick up items that give health, just consume them.
        if (item.getHeal() > 0) {
            player.setHealth(player.getMaxHealth() + item.getHeal());

            if (player.getHealth() > player.getMaxHealth())
                player.setHealth(player.getMaxHealth()) ;

            if (item.getHeal() > 500) {
                player.getGameEngine().playSpecialEffect("green_swirly");
            }

            return true;
        }

        if (item.isRare())
            player.getGameEngine().playSpecialEffect("cool_swirly_particles");

        if(item.isRare() && item.isUnique()){
            player.getGameEngine().playSpecialEffect("blue_swirly");
        }

        player.getInventory().add(item);

        InventoryHandler.calculateStats(player);

        return true;
    }
}
