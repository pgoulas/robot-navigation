package com.example.roomcleaner;

import com.example.roomcleaner.service.CleaningInfo;
import com.example.roomcleaner.service.CoordinateSystem;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class CleaningInfoTest {

    private CleaningInfo cleaningInfo;
    private CoordinateSystem coordinateSystem;

    @BeforeEach
    public void setup() {
        // Mocking CoordinateSystem to control its behavior
        coordinateSystem = Mockito.mock(CoordinateSystem.class);

        // Instantiate CleaningInfo with the mocked CoordinateSystem
        cleaningInfo = new CleaningInfo();
        cleaningInfo.setCoordinateSystem(coordinateSystem);
    }

    @Test
    public void testCleanPatch_whenPatchExists_shouldIncrementPatchesAndRemovePatch() {
        // Arrange: Add a patch at coordinates (1, 1)
        cleaningInfo.getPatchesToClean().add(Pair.of(1, 1));

        // Set up coordinate system to return coordinates (1, 1)
        Mockito.when(coordinateSystem.getX()).thenReturn(1);
        Mockito.when(coordinateSystem.getY()).thenReturn(1);

        // Act: Clean the patch
        cleaningInfo.cleanPatch();

        // Assert: The patch count should increase and the patch should be removed
        assertEquals(1, cleaningInfo.getPatches());
        assertFalse(cleaningInfo.getPatchesToClean().contains(Pair.of(1, 1)));
    }

    @Test
    public void testCleanPatch_whenPatchDoesNotExist_shouldNotIncrementPatches() {
        // Arrange: No patches in the set, mock the current coordinates (2, 2)
        Mockito.when(coordinateSystem.getX()).thenReturn(2);
        Mockito.when(coordinateSystem.getY()).thenReturn(2);

        // Act: Attempt to clean a patch that doesn't exist
        cleaningInfo.cleanPatch();

        // Assert: The patch count should not change (remains 0)
        assertEquals(0, cleaningInfo.getPatches());
    }

    @Test
    public void testCleanPatch_whenNoPatchesExist_shouldNotIncrementPatches() {
        // Arrange: patchesToClean is empty, mock the current coordinates (3, 3)
        Mockito.when(coordinateSystem.getX()).thenReturn(3);
        Mockito.when(coordinateSystem.getY()).thenReturn(3);

        // Act: Attempt to clean a patch when none exist
        cleaningInfo.cleanPatch();

        // Assert: The patch count should remain zero
        assertEquals(0, cleaningInfo.getPatches());
    }
}
