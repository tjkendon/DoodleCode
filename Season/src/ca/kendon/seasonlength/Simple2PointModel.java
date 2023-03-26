package ca.kendon.seasonlength;

public class Simple2PointModel implements PointModel{

    @Override
    public double getPoints(Record r) {

        return r.getWins() * 2 + r.getOvertimeWins()+ r.getOvertimeLosses() + r.getTies();
    }
}
