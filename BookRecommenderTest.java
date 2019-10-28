import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookRecommenderTest {
protected BookRecommender br;

@Before
public void setUp() throws Exception {
br = new BookRecommender();
}

@After
public void tearDown() throws Exception {
}

@Test
public void testload() throws Exception {
assertEquals(1, br.load());

//, br.getRecommendedRatings(br.similarityScores, br.ratings));

}

@Test
public void testaskTheUser() throws Exception {
assertEquals(true, br.askTheUser());
}

}


