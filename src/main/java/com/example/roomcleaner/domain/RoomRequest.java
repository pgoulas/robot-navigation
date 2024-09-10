package com.example.roomcleaner.domain;

import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Pair;

@Data
@Getter
@Setter
public class RoomRequest {
    private List<Integer> roomSize;
    private List<Integer> coords;
    private List<List<Integer>> patches;
    private String instructions;


}
