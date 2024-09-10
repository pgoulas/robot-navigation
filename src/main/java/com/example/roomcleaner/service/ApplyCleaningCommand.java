package com.example.roomcleaner.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ApplyCleaningCommand implements Command {
    private final CleaningInfo cleaningInfo;

    @Override
    public void execute() {
        cleaningInfo.cleanPatch();
    }
}
