package test;

import com.sherstnyov.PruferCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruferTest {
    private PruferCode pruferCode;

    @BeforeEach
    void setUp() {
        pruferCode = new PruferCode();
    }

    @Test
    public void printAdjacencyListForTwoVerticesTree() {
        assertEquals("1: 2\n2: 1",
                pruferCode.getAdjacencyLists(""));
    }

    @Test
    public void printAdjacencyListForThreeVerticesTree() throws Exception {
        assertEquals("1: 2 3\n2: 1\n3: 1",
                pruferCode.getAdjacencyLists("1"));
    }

    @Test
    public void printAdjacencyListForFourVerticesTree() throws Exception {
        assertEquals("1: 3\n2: 4\n3: 1 4\n4: 2 3",
                pruferCode.getAdjacencyLists("3 4"));
    }

    @Test
    public void printAdjacencyListForFiveVerticesTree() throws Exception {
        assertEquals("1: 2 3\n2: 1\n3: 1 5\n4: 5\n5: 3 4",
                pruferCode.getAdjacencyLists("1 3 5"));
    }
}
