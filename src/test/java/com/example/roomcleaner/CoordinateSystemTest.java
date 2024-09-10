package com.example.roomcleaner;

import com.example.roomcleaner.service.CoordinateSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinateSystemTest {

    private CoordinateSystem coordinateSystem;

    @BeforeEach
    public void setup() {
        // Create a CoordinateSystem with room size 5x5
        coordinateSystem = new CoordinateSystem(0, 0, 5, 5);
    }

    @Test
    public void testMoveUp_whenWithinBounds_shouldIncrementY() {
        // Arrange: Set initial position to (0, 0)
        coordinateSystem.setX(0);
        coordinateSystem.setY(0);

        // Act: Move up
        coordinateSystem.moveUp();

        // Assert: Y should have incremented to 1
        assertEquals(1, coordinateSystem.getY());
        assertEquals(0, coordinateSystem.getX());
    }

    @Test
    public void testMoveUp_whenAtTopBoundary_shouldNotMove() {
        // Arrange: Set position to the top boundary (0, 5)
        coordinateSystem.setX(0);
        coordinateSystem.setY(5);

        // Act: Attempt to move up
        coordinateSystem.moveUp();

        // Assert: Y should remain 5 (at the boundary)
        assertEquals(5, coordinateSystem.getY());
    }

    @Test
    public void testMoveDown_whenWithinBounds_shouldDecrementY() {
        // Arrange: Set position to (0, 2)
        coordinateSystem.setX(0);
        coordinateSystem.setY(2);

        // Act: Move down
        coordinateSystem.moveDown();

        // Assert: Y should decrement to 1
        assertEquals(1, coordinateSystem.getY());
        assertEquals(0, coordinateSystem.getX());
    }

    @Test
    public void testMoveDown_whenAtBottomBoundary_shouldNotMove() {
        // Arrange: Set position to the bottom boundary (0, 0)
        coordinateSystem.setX(0);
        coordinateSystem.setY(0);

        // Act: Attempt to move down
        coordinateSystem.moveDown();

        // Assert: Y should remain 0 (at the boundary)
        assertEquals(0, coordinateSystem.getY());
    }

    @Test
    public void testMoveLeft_whenAtLeftBoundary_shouldNotMove() {
        // Arrange: Set position to the left boundary (0, 0)
        coordinateSystem.setX(0);
        coordinateSystem.setY(0);

        // Act: Attempt to move left
        coordinateSystem.moveLeft();

        // Assert: X should remain 0 (at the boundary)
        assertEquals(0, coordinateSystem.getX());
    }

    @Test
    public void testMoveRight_whenWithinBounds_shouldIncrementX() {
        // Arrange: Set position to (0, 0)
        coordinateSystem.setX(0);
        coordinateSystem.setY(0);

        // Act: Move right
        coordinateSystem.moveRight();

        // Assert: X should increment to 1
        assertEquals(1, coordinateSystem.getX());
        assertEquals(0, coordinateSystem.getY());
    }

    @Test
    public void testMoveRight_whenAtRightBoundary_shouldNotMove() {
        // Arrange: Set position to the right boundary (5, 0)
        coordinateSystem.setX(5);
        coordinateSystem.setY(0);

        // Act: Attempt to move right
        coordinateSystem.moveRight();

        // Assert: X should remain 5 (at the boundary)
        assertEquals(5, coordinateSystem.getX());
    }

    @Test
    public void testGetPosition_shouldReturnCorrectPosition() {
        // Arrange: Set position to (3, 4)
        coordinateSystem.setX(3);
        coordinateSystem.setY(4);

        // Act & Assert: GetPosition should return "(3, 4)"
        assertEquals("(3, 4)", coordinateSystem.getPosition());
    }
}

