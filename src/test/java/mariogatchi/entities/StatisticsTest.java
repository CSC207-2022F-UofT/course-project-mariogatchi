package mariogatchi.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticsTest {

    @Test
    void changeStat() {
        Statistics stats = new Statistics("common");
        stats.changeStat(Statistics.Stats.CLEANLINESS, 10, Statistics.Operator.ADD);
        assertEquals(60, stats.getCleanliness());
    }

    @Test
    void getStat() {
        Statistics stats = new Statistics("common");
        assertEquals(50, stats.getStat(Statistics.Stats.CLEANLINESS));
    }

    @Test
    void statDecay() {
        Statistics stats = new Statistics("common");
        stats.statDecay(System.currentTimeMillis() + (60000 * 31));
        assertEquals(49, stats.getHunger());
    }
}