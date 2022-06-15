package roulette;


import java.awt.Color;
import java.util.Objects;

public class RouletteNumber {
    
    //impostare hash e compare
    //even ecc. settarlo nel costruttore o nel metodo? meglio metodo in caso di extends?
    private final int value;
    private final Color color;
    private final Sector sector;
    private final Parity parity;
    private final Included included;
    
    public enum Row{
        FIRST, SECOND, THIRD, NOT
    }
    
    public enum Column{
        FIRST, SECOND, THIRD, NOT
    }
    
    public enum Included{
        _1_18_, _19_36, NOT
    }
    
    public enum Parity{
        EVEN, ODD, NEUTRAL
    }
    
    public enum Sector{
        TIER, ORPHELINS, VOISINS, ZERO
    }
    
    public RouletteNumber(final int value,final Color color, final Sector sector) {
        this.value = value;
        this.color = color;
        this.sector = sector;
        this.parity = value == 0 ? Parity.NEUTRAL : (value % 2 == 0 ? Parity.EVEN : Parity.ODD);
        this.included = value == 0 ? Included.NOT : (value >= 1 && value <= 18 ? Included._1_18_ : Included._19_36);
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }
    
    public Sector getSector() {
        return sector;
    }

    public Parity getParity() {
        return parity;
    }
    
    public Included getIncluded() {
        return included;
    }
    
    public Column getColumn() {
        if (value == 0) {
            return Column.NOT;
        }
        final int nColumn = value / 12;
        return nColumn <= 1 ? Column.FIRST : (nColumn <= 2 ? Column.SECOND : Column.THIRD);
    }
    
    @Override
    public String toString() {
        return "RouletteNumber [value=" + value + ", color=" + color + ", sector=" + sector + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, sector, value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RouletteNumber other = (RouletteNumber) obj;
        return Objects.equals(color, other.color) && sector == other.sector && value == other.value;
    }

    
}
