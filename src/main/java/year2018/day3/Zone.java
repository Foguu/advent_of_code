package year2018.day3;

import lombok.AllArgsConstructor;
import lombok.Data;
import year2015.day3.Position;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Zone {
    int id;
    Position position;
    int length;
    int width;

    List<Position> coveredPositions(){
        List<Position> coveredPos = new ArrayList<>();

        for (int i = position.getX(); i < position.getX()+length; i++) {
            for (int j = position.getY(); j < position.getY()+width; j++) {
                Position newPos = new Position(i,j);
                coveredPos.add(newPos);
            }
        }

        return coveredPos;
    }
}
