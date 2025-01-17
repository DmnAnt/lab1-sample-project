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
public class TestFollower {

    @Test
    public void testFollower() {
        assertThat(Utilities.follower("ABCD"), is("B"));
        assertThat(Utilities.follower("ZZ"), is("ZZ"));
        assertThat(Utilities.follower("ZZE"), is("ZZE"));
    }

}
