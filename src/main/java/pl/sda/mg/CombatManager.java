package pl.sda.mg;

import java.util.List;

public class CombatManager {

    public void executeCombat(Character first, Character second) throws Exception {


        while (first.isAlive() && second.isAlive()) {
            first.attack(second);
            if (second.isAlive()) {
                second.attack(first);
            }

        }
        if (first.isAlive()) {
            first.maxHp += 2;
            first.heal();
        } else {
            second.maxHp += 2;
            second.heal();
        }
    }
}
