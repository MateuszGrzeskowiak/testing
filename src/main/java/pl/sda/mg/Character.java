package pl.sda.mg;

import java.util.List;

public class Character {
    private FacebookProvider facebookProvider;
    public String firstName;
    public String lastName;
    public int hp;
    public int maxHp;

    public Character(FacebookProvider facebookProvider, String firstName, String lastName, int maxHp) {
        this.facebookProvider = facebookProvider;
        this.firstName = firstName;
        this.lastName = lastName;
        this.maxHp = maxHp;
        this.hp = maxHp;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void attack(Character other) throws Exception {

        if (!other.isAlive()) throw new Exception("nieżywa");
        other.hp--;

    }

    public boolean isAlive() {
        return hp > 0;
    }

    public void attackFriends() throws Exception {
       // facebookProvider.GetFriends(getFullName());
        List<Character> friends = facebookProvider.GetFriends(getFullName());
        for (Character friend:friends){
            attack(friend);
            System.out.println("I attacked " + friend.getFullName());
        }
    }
}
