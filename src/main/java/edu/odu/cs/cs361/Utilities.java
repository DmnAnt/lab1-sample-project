/**
 *  Steven Zeil, Old Dominion University
 *   4/30/2024
 **/

package edu.odu.cs.cs361;

public class Utilities {

    /**
     * Find the shortest string that alphabetically follows a given string.
     * 
     * Ties are broken in favor of the alphabetically smallest such string.
     *
     * @param s a string of upper-case alphabetic characters
     * @return string The shortest string that alphabetically is equal to or follows
     *         this one.
     */
    public static String follower(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == 'Z')
            ++i;
        if (i + 1 < s.length()) {
            String result = s.substring(0, i);
            char c = s.charAt(i);
            c += 1;
            result = result + c;
            return result;
        } else {
            return s;
        }
    }

    /**
     * @brief Find the alphabetically smallest string between name1 and name2
     *
     * @param name1 a string of upper-case alphabetic characters
     * @param name2 another string of upper-case alphabetic characters, such that
     *              name1 < name2
     * @return std::string the alphabetically smallest string dividing name1 and
     *         name2
     */
    public static String findSeparator(String name1, String name2) {
        int match = 0;
        // See how many characters match
        while (match < name1.length() && match < name2.length()
                && name1.charAt(match) == name2.charAt(match)) {
            ++match;
        }
        if (match + 1 >= name1.length())
            // Made it to the end of name1
            return name1;
        else {
            // Stopped inside name1 (and within name2, because name1 < name2)
            char diff1 = name1.charAt(match);
            char diff2 = name2.charAt(match);
            if (diff1 + 1 < diff2) {
                // If the 1st differing characters are more than 1 apart, we
                // can construct a string of length match+1
                // E.g. comparing ABCD to ABFG, the desired answer
                // is AB + ('C'+1) => ABD
                ++diff1; // Note: ++ is safe - diff1 could not be 'Z'
                         // because diff2 > diff1
                return name1.substring(0, match) + diff1;
            } else {
                // This is where it gets messy. The first two differing
                // characters are just one position apart,
                // e.g., AAB... vs AAC... or A... vs B...

                if (match + 1 < name2.length()) {
                    return name2.substring(0, match + 1);
                } else if (match + 2 == name1.length()) {
                    return name1;
                } else {
                    String part1 = name1.substring(0, match + 1);
                    String remainder1 = name1.substring(match + 1); // must be non-empty
                    remainder1 = follower(remainder1);
                    return part1 + remainder1;
                }
            }
        }
    }

}