package lt.povilas.pupkys.utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @author Povilas Pupkys
 * @project SEB-GSV-Test-Automation
 */
public class RandomStringGenerator {
    private static SecureRandom random = new SecureRandom();
    private static final String SOURCES =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";

    /**
     * Generates random string
     *
     * @param random
     * @param characters sources of the characters to be used
     * @param length     of the generated string
     * @return random generated string
     */
    private static String generateString(Random random, String characters, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }

    /**
     * Returns random generated String
     *
     * @return random generated String
     */
    public static String getRandomString() {
        return generateString(random, SOURCES, 10);
    }
}
