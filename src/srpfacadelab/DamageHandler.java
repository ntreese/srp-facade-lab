package srpfacadelab;

public class DamageHandler {
    public static void takeDamage(int damage, RpgPlayer player) {
        double damageToDeal;

        if (damage < player.getArmour()) {
            player.getGameEngine().playSpecialEffect("parry");
        }

        if(player.getCarryingCapacity() <= 0.5 * player.MAX_CARRYING_CAPACITY){
            damageToDeal = 0.75 * (damage-player.getArmour());
        }else{
            damageToDeal = damage - player.getArmour();
        }


        player.setHealth(player.getHealth()- (int)damageToDeal);

        player.getGameEngine().playSpecialEffect("lots_of_gore");
    }
}
