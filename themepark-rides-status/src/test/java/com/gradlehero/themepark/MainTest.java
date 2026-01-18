package com.gradlehero.themepark;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {
    @ParameterizedTest(name = "{index} gets {0} category status")
    @ValueSource(strings = {"odd", "even", "prime"})
    public void getsCaegoryStatus(String ride) {
        String rideStatus = Main.getExample(ride);
        assertNotNull(rideStatus);
    }

    @Test
    public void unknownCategoryCausesFailure() {
        assertThrows(IllegalArgumentException.class, () -> {
            Main.getExample("whole");
        });
    }
}
