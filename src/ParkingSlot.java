import java.util.ArrayList;

public class ParkingSlot {

    private int slotSize;
    private Cars[] cars;

    public ParkingSlot(int slotSize){
        this.slotSize = slotSize;
        this.cars = new Cars[slotSize];
        for (int i = 0; i < slotSize; i++){
            cars[i] = null;
        }
    }

    public int getSlotSize() {
        return slotSize;
    }

    public void setSlotSize(int slotSize) {
        this.slotSize = slotSize;
    }

    public void insertCar(Cars car){
        for (int i = 0; i < this.slotSize; i++){
            if (cars[i] == null) {
                cars[i] = car;
                break;
            }
        }
    }

    public void removeCar(int slot){
        this.cars[slot] = null;
    }

    public ArrayList findSlotWithColour(String colour){
        ArrayList carSlot = new ArrayList();
        for (int i = 0; i < this.slotSize; i++){
            if (cars[i].getColour().equals(colour)) {
                carSlot.add(i);
            }
        }
        return carSlot;
    }
}
