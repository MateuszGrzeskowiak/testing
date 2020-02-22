package pl.sda.mg;

import java.util.Arrays;
import java.util.List;
public class FakeFacebookProvider extends FacebookProvider {
    @Override
    public List<Character> GetFriends(String fullName) throws InterruptedException {
        return Arrays.asList(
                new Character(null, "sztuczny znajomy 1", "sztuczny znajomy 1", 10),
                new Character(null, "sztuczny znajomy 2", "sztuczny znajomy 2", 3)
        );
    }
}






