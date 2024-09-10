package com.example.roomcleaner.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoordinateSystem {
    private int x = 0;
    private int y = 0;
    private int roomSizeX = 0;
    private int roomSizeY = 0;

    public void moveUp() {
        if (y == roomSizeY) {
            System.err.println("Invalid action y must be up to" + roomSizeY);
        } else {
            y++;
            System.out.println("Moved up: (" + x + ", " + y + ")");
        }
    }

    public void moveDown() {
        if (y == 0) {
            System.err.println("Invalid action y mustn't have negative values");
        } else {
            y--;
            System.out.println("Moved down: (" + x + ", " + y + ")");
        }
    }

    public void moveLeft() {
        if (x == 0) {
            System.err.println("Invalid action x mustn't have negative values");
        } else {
            x--;
            System.out.println("Moved left: (" + x + ", " + y + ")");
        }
    }

    public void moveRight() {
        if (x == roomSizeX) {
            System.err.println("Invalid action y must be up to" + roomSizeX);
        } else {
            x++;
            System.out.println("Moved right: (" + x + ", " + y + ")");
        }
    }

    public String getPosition() {
        return "(" + x + ", " + y + ")";
    }
}
