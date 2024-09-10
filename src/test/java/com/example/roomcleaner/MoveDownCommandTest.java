package com.example.roomcleaner;

import com.example.roomcleaner.service.CoordinateSystem;
import com.example.roomcleaner.service.MoveDownCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class MoveDownCommandTest {

    @Mock
    private CoordinateSystem coordinateSystem;  // Mock the CoordinateSystem dependency

    @InjectMocks
    private MoveDownCommand moveDownCommand;  // Inject the mock into MoveDownCommand

    @BeforeEach
    public void setup() {
        // Initialize the mocks
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExecute_shouldCallMoveDown() {
        // Act: Call the execute method
        moveDownCommand.execute();

        // Assert: Verify that the moveDown() method is called once
        verify(coordinateSystem, times(1)).moveDown();
    }

    @Test
    public void testExecute_shouldNotCallOtherMethods() {
        // Act: Call the execute method
        moveDownCommand.execute();

        // Assert: Ensure no other methods from CoordinateSystem are called
        verify(coordinateSystem, never()).moveUp();
        verify(coordinateSystem, never()).moveLeft();
        verify(coordinateSystem, never()).moveRight();
    }
}
