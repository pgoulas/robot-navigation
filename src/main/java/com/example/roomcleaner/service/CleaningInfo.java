package com.example.roomcleaner.service;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class CleaningInfo {
    private Set<Pair<Integer, Integer>> patchesToClean = new HashSet<>();
    private CoordinateSystem coordinateSystem = new CoordinateSystem();
    private int patches = 0;

    public void cleanPatch() {
        // Create the current coordinate as a pair
        Pair<Integer, Integer> currentCoordinates = Pair.of(coordinateSystem.getX(), coordinateSystem.getY());

        // Check if the current coordinates are in patchesToClean
        if (patchesToClean.contains(currentCoordinates)) {
            patches++;  // Increment the patches cleaned counter
            patchesToClean.remove(currentCoordinates);  // Remove the cleaned patch
            System.out.println("Patch cleaned: (" + coordinateSystem.getX() + ", " + coordinateSystem.getY() + ") with patch number: " + patches);
        }
    }
}
