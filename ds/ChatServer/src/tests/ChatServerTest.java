package tests;

import org.junit.jupiter.api.Test;
import training.expires.moderators.Moderator;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ChatServerTest {

    @org.junit.jupiter.api.BeforeAll
    static void setUp() {

    }

    @Test
    void testModeratorWithBadWords() {
        Moderator moderator = new Moderator();
        var list = Arrays.asList("fuck","piss","damn","shit","asshole");
        moderator.addListWords(list);

        String actual = moderator.censor("Hellofuck world");
        String expected = "Hello**** world";
        assertEquals(expected, actual);


        actual = moderator.censor("fuckHellofuck world");
        expected = "****Hello**** world";
        assertEquals(expected, actual);

        actual = moderator.censor("shitFFF shit world");
        expected = "****FFF **** world";
        assertEquals(expected, actual);
    }


    @Test
    void testModeratorWithoutBadWords() {
        Moderator moderator = new Moderator();
        var list = Arrays.asList("fuck","piss","damn","shit","asshole");
        moderator.addListWords(list);

        String actual = moderator.censor("Hello world");
        String expected = "Hello world";
        assertEquals(expected, actual);


        actual = moderator.censor("");
        expected = "";
        assertEquals(expected, actual);


        actual = moderator.censor("asshole");
        expected = "*******";
        assertEquals(expected, actual);
    }


}