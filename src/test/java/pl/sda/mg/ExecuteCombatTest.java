package pl.sda.mg;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ExecuteCombatTest {

    @Test
    public void createCharacters() throws Exception {
        Character character1 = new Character("Czesiek1", "Kowalski", 10, null);
        Character character2 = new Character("Czesiek2", "Kowalski", 10, null);
        assertThat(character1.hp).isEqualTo(character1.maxHp);
        assertThat(character2.hp).isEqualTo(character2.maxHp);

    }

    @Test
    public void combat() throws Exception {
        Character character1 = new Character("Czesiek1", "Kowalski", 10, null);
        Character character2 = new Character("Czesiek2", "Kowalski", 10, null);
        CombatManager cm = new CombatManager();
        cm.executeCombat(character1, character2);
        assertThat(character2.hp).isEqualTo(0);
        assertThat(character1.hp).isEqualTo(12);
    }
}
