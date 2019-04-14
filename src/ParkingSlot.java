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
        int slot = -1;
        for (int i = 0; i < this.slotSize; i++){
            if (cars[i] == null) {
                cars[i] = car;
                slot = i+1;
                break;
            }
        }
        if (slot == -1){
            System.out.println("Sorry, parking lot is full\n");
        }
        else {
            System.out.println("Allocated slot number: " + slot + "\n");
        }
    }

    public void removeCar(int slot){
        if (cars[slot] != null) {
            this.cars[slot] = null;
            System.out.println("Slot number " + slot + " is Free\n");
        }
        else {
            System.out.println("No car in slot " + slot + "\n");
        }
    }

    public ArrayList findSlotWithColour(String colour){
        ArrayList carSlot = new ArrayList();
        for (int i = 0; i < this.slotSize; i++){
            if (cars[i] != null && cars[i].getColour().equals(colour)) {
                carSlot.add(i+1);
            }
        }
        return carSlot;
    }

    public ArrayList findSlotWithRegNumber(String regNumber){
        ArrayList carSlot = new ArrayList();
        for (int i = 0; i < this.slotSize; i++){
            if (cars[i] != null && cars[i].getRegNumber().equals(regNumber)) {
                carSlot.add(i+1);
            }
        }
        return carSlot;
    }

    public ArrayList findRegNumberWithColour(String colour){
        ArrayList carSlot = new ArrayList();
        for (int i = 0; i < this.slotSize; i++){
            if (cars[i] != null && cars[i].getColour().equals(colour)) {
                carSlot.add(cars[i].getRegNumber());
            }
        }
        return carSlot;
    }

    public void display(){
        System.out.println("Slot No.\tRegistration No \tColour");
        for (int i = 0; i < slotSize; i++){
            if (this.cars[i] != null){
                System.out.println((i+1) + "\t\t" + cars[i].getRegNumber() + "\t\t" + cars[i].getColour());
            }
        }
        System.out.println();
    }

}
