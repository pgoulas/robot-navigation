package com.example.roomcleaner.domain;

import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Pair;

@Data
@Getter
@Setter
public class RoomReportInfo {
    private List<Integer> coords;
    private Integer patches;

    public RoomReportInfo(List<Integer> coords, Integer patches) {
        this.coords = coords;
        this.patches = patches;
    }

    public RoomReportInfo() {
    }
}
