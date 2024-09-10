package com.example.roomcleaner.controller;

import com.example.roomcleaner.domain.RoomRequest;
import com.example.roomcleaner.domain.RoomReportInfo;
import com.example.roomcleaner.service.NavigationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api")
@AllArgsConstructor
public class ApiController {

private final NavigationService navigationService;

    @PutMapping(path = "/v1/robot/cleanUp")
    public RoomReportInfo cleanUp (@RequestBody final RoomRequest roomRequest) {
        return navigationService.navigate(roomRequest);
    }
}
