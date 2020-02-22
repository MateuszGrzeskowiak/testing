package pl.sda.mg;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class CharacterTests {

    @Test
    public void newCharacterWithMaxHp10_HpIs10AndMaxHpIs10() {
        Character character = new Character(null, "Czesiek", "Kowalski", 10);
        assertThat(character.hp).isEqualTo(10);
        assertThat(character.maxHp).isEqualTo(10);
    }

    @Test
    public void attack_characterWithHp10IsHit9Times_itIsAlive() throws Exception {
        Character first = new Character(null, "Czesiek", "Kowalski", 10);
        Character second = new Character(null, "Franek", "Kimono", 10);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        first.attack(second);
        assertThat(second.isAlive()).isTrue();

    }

//    @Test
//    public void attack_characterWithHp10IsHit9Times_itIsNotAlive() throws Exception {
//        Character first = new Character("Czesiek", "Kowalski", 10);
//        Character second = new Character("Franek", "Kimono", 10);
//        first.attack(second);
//        first.attack(second);
//        first.attack(second);
//        first.attack(second);
//        first.attack(second);
//        first.attack(second);
//        first.attack(second);
//        first.attack(second);
//        first.attack(second);
//        first.attack(second);
//        assertThat(second.isAlive()).isFalse();
//    }

//    @Test
//    public void attack_characterWithHp10IsHit11Times_itIsNotAlive() throws Exception {
//        Character first = new Character("Czesiek", "Kowalski", 10);
//        Character second = new Character("Franek", "Kimono", 10);
//        first.attack(second);
//        first.attack(second);
//        first.attack(second);
//        first.attack(second);
//        first.attack(second);
//        first.attack(second);
//        first.attack(second);
//        first.attack(second);
//        first.attack(second);
//        first.attack(second);
//        first.attack(second);
//        assertThat(second.isAlive()).isFalse();
//    }

    @Test
    public void deadCharacterIsAttacked_ExceptionIsThrown() {
        Character attacker = new Character(null, "attacker", "attacker", 10);
        final Character dead = new Character(null, "asd", "asd", 1);
        dead.hp = 0;
        assertThatThrownBy(() -> {
            attacker.attack(dead);
        }).hasMessageContaining("nieżywa");
    }

//    @Test
//    public void exception() throws Exception {
//        throw new Exception("coś nie tak");
//    }

    static Stream<Arguments> attackParameters() {
        return Stream.of(
                arguments(1, true),
                arguments(2, true),
                arguments(9, true),
                arguments(10, false)
        );
    }
    @ParameterizedTest
    @MethodSource("attackParameters")
    public void assdasd(int hits, boolean expectedIsAlive) throws Exception {
        Character first = new Character(null, "Czesiek", "Kowalski", 10);
        Character second = new Character(null, "Franek", "Kimono", 10);
        for (int i = 0; i < hits; ++i) {
            first.attack(second);
        }
        assertThat(second.isAlive()).isEqualTo(expectedIsAlive);
    }


    @Test
    public void attackFriends() throws Exception {
        Character attacker = new Character(new FakeFacebookProvider(), "Czesiek", "Kowalski",
                10);
        attacker.attackFriends();
    }

    @Test
    public void attackFriendsWithMock() throws Exception {
        FacebookProvider providerMock = mock(FacebookProvider.class);
        when(providerMock.GetFriends(anyString())).thenReturn(Arrays.asList(
                new Character(null, "sztuczny znajomy 1", "sztuczny znajomy 1", 10),
                new Character(null, "sztuczny znajomy 2", "sztuczny znajomy 2", 3)));
        Character attacker = new Character(providerMock, "Czesiek", "Kowalski",
                10);
        attacker.attackFriends();
    }

    @Test
    public void attackFriends_facebookProviderIsCalledForCharactersFullName() throws Exception {
        FacebookProvider providerMock = mock(FacebookProvider.class);
        Character attacker = new Character(providerMock, "Czesiek", "Kowalski",
                10);
        attacker.attackFriends();
        verify(providerMock, times(1)).GetFriends("Czesiek Kowalski");
        verifyNoMoreInteractions(providerMock);
    }


}

