public class Cars {

    private String colour;
    private String regNumber;

    public Cars() {
        this.colour = null;
        this.regNumber = null;
    }

    public Cars(String colour, String regNumber) {
        this.colour = colour;
        this.regNumber = regNumber;
    }

    public String getColour() {
        return colour;
    }

    public String getRegNumber() {
        return regNumber;
    }
}