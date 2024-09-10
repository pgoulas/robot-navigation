package com.example.roomcleaner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.roomcleaner.domain.RoomReportInfo;
import com.example.roomcleaner.domain.RoomRequest;
import com.example.roomcleaner.service.ApplyCleaningCommand;
import com.example.roomcleaner.service.CleaningInfo;
import com.example.roomcleaner.service.CoordinateSystem;
import com.example.roomcleaner.service.MoveDownCommand;
import com.example.roomcleaner.service.MoveLeftCommand;
import com.example.roomcleaner.service.MoveRightCommand;
import com.example.roomcleaner.service.MoveUpCommand;
import com.example.roomcleaner.service.NavigationService;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class NavigationServiceTest {

    @Mock
    private MoveUpCommand moveUpCommand;

    @Mock
    private MoveDownCommand moveDownCommand;

    @Mock
    private MoveRightCommand moveRightCommand;

    @Mock
    private MoveLeftCommand moveLeftCommand;

    @Mock
    private CoordinateSystem coordinateSystem;

    @Mock
    private CleaningInfo cleaningInfo;

    @Mock
    private ApplyCleaningCommand applyCleaningCommand;

    @InjectMocks
    private NavigationService navigationService;

    @BeforeEach
    public void setup() {
        // Initialize the mocks and inject them into the navigationService
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testNavigate_withValidInstructions_shouldMoveAndCleanCorrectly() {
        // Arrange: Set up request data
        RoomRequest request = new RoomRequest();
        request.setRoomSize(Arrays.asList(5, 5));
        request.setCoords(Arrays.asList(1, 2));
        request.setPatches(List.of(Arrays.asList(1, 0), Arrays.asList(2, 2), Arrays.asList(2, 3)));
        request.setInstructions("NNESEESWNWW");

        // Mock setting up the coordinate system and cleaning info
        when(coordinateSystem.getX()).thenReturn(1);
        when(coordinateSystem.getY()).thenReturn(2);

        // Act: Call the navigate method
        RoomReportInfo report = navigationService.navigate(request);

        // Assert: Verify correct interactions and behavior
        verify(coordinateSystem).setX(1);
        verify(coordinateSystem).setY(2);
        verify(coordinateSystem).setRoomSizeX(5);
        verify(coordinateSystem).setRoomSizeY(5);

        verify(moveUpCommand, times(3)).execute();
        verify(moveRightCommand, times(3)).execute();
//        verify(moveDownCommand).execute();
        verify(moveLeftCommand, times(3)).execute();

        verify(applyCleaningCommand, times(11)).execute();  // The number of instruction steps

        // Assert the final returned position and patches cleaned
        assertEquals(Arrays.asList(1, 2), report.getCoords());
        assertEquals(0, report.getPatches());  // Assuming no patches were cleaned in this test case
    }
}
