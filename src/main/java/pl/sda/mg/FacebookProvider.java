package pl.sda.mg;

import java.util.Arrays;
import java.util.List;

public class FacebookProvider {
    public List<Character> GetFriends(String fullName) throws InterruptedException {
        Thread.sleep(5000);
        return Arrays.asList(new Character(null, "znajomy", "znajomy", 10));
    }
}


