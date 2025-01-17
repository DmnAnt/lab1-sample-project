/**
 * 
 */
package edu.odu.cs.cs361;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author zeil
 *
 */
public class TestSeparator {

    @Test
    public void testSeparatorDistinct() {
        assertThat(Utilities.findSeparator("ABCD", "EFGH"), is("B"));
    }

    @Test
    public void testSeparatorSharedPrefixes() {
        assertThat(Utilities.findSeparator("ABCD", "ABXY"), is("ABD"));
    }

    @Test
    public void testSeparatorZs() {
        assertThat(Utilities.findSeparator("ABZ", "ABZA"), is("ABZ"));
    }

}
