package com.example.roomcleaner.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MoveDownCommand implements Command {
    private final CoordinateSystem coord;

    @Override
    public void execute() {
        coord.moveDown();
    }
}
