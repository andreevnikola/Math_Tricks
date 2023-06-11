package math.tricks.Board;

public class Field {
    public Sign sign;
    public Integer nmb;
    public IsValidFor isValid;
    public IsValidFor canBeReachedFrom;
    public String stringedSign;

    public Field(Sign sign, Integer nmb, IsValidFor isValid) {
        this.stringedSign = sign == Sign.DIVIDE ? "/" : sign == Sign.SUBTRACT ? "-" : sign == Sign.MULTIPLY ? "*" : "+";
        this.nmb = nmb;
        this.isValid = isValid;
        this.sign = sign;
    }
}
