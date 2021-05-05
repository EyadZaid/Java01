package training.expires;

import java.util.ArrayList;
import java.util.List;

public class Moderator {
    private final List<String>  badWords;

    public Moderator() {
        this.badWords = new ArrayList<>();
    }

    public void addWord(String word) {
        badWords.add(word);
    }

    public String censor(String msg) {
        StringBuilder newMsg = new StringBuilder();
        String[] arrMsg = msg.split(" ");

        for (var w : arrMsg) {
            if (!stringMatch(w)) {
                newMsg.append(w + " ");
            }
        }

        return newMsg.toString();
    }

    private boolean stringMatch(String word) {
        for (var w : badWords) {
            if (w.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
