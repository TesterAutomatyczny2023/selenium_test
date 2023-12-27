package playground;

import java.util.ArrayList;
import java.util.List;

public class Chain {
    private List<String> words = new ArrayList<>();
    public Chain add(String word) {
        words.add(word);
        return this;
    }
    @Override
    public String toString() {
        return String.join("", words);
    }
}
