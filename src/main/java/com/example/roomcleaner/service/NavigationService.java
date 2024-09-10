package com.example.roomcleaner.service;

import com.example.roomcleaner.domain.RoomRequest;
import com.example.roomcleaner.domain.RoomReportInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

/**
 * The navigation service
 */
@Service
@AllArgsConstructor
public class NavigationService {
    private final MoveUpCommand moveUpCommand;
    private final MoveDownCommand moveDownCommand;
    private final MoveRightCommand moveRightCommand;
    private final MoveLeftCommand moveLeftCommand;
    private final CoordinateSystem coordinateSystem;
    private final CleaningInfo cleaningInfo;
    private final ApplyCleaningCommand applyCleaningCommand;

    /**
     * The navigate method that processes the business navigation solution
     * @param request
     * @return
     */
    public RoomReportInfo navigate(RoomRequest request) {
        Pair <Integer, Integer> roomSize = Pair.of(request.getRoomSize().get(0), request.getRoomSize().get(1));
        Pair <Integer, Integer> coords = Pair.of(request.getCoords().get(0), request.getCoords().get(1));
        String instructions = request.getInstructions();
        Set<Pair <Integer, Integer>> patches = request.getPatches().stream().map(patch -> Pair.of(patch.get(0), patch.get(1))).collect(Collectors.toSet());

        coordinateSystem.setX(coords.getLeft());
        coordinateSystem.setY(coords.getRight());
        coordinateSystem.setRoomSizeX(roomSize.getLeft());
        coordinateSystem.setRoomSizeY(roomSize.getRight());
        cleaningInfo.setCoordinateSystem(coordinateSystem);
        cleaningInfo.setPatchesToClean(patches);

        String[] instructionSteps = instructions.split("");
        for (String step : instructionSteps) {
            switch (step) {
                case "N" -> moveUpCommand.execute();
                case "E" -> moveRightCommand.execute();
                case "S" -> moveDownCommand.execute();
                case "W" -> moveLeftCommand.execute();
                default -> throw new IllegalArgumentException("Invalid direction");
            }
            applyCleaningCommand.execute();
        }
        System.out.println("Final position: " + coordinateSystem.getPosition());

        return new RoomReportInfo(Arrays.asList(coordinateSystem.getX(), coordinateSystem.getY()), cleaningInfo.getPatches());
    }
}
