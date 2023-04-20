package year2016.day3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Triangle {

    private int side1;
    private int side2;
    private int side3;

    public boolean isValid(){
        int x = this.side1;
        int y = this.side2;
        int z = this.side3;

        return (x + y) > z && (x + z) > y && (y + z) > x;
    }
}
