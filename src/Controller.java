import java.util.ArrayList;

public class Controller {
    ParkingSlot parkingSlot;
    boolean createdParking;

    public Controller(int slot){
        this.parkingSlot = new ParkingSlot(slot);
        this.createdParking = false;
    }

    public void executeCommand(Command command){
        switch(command.getCommand()){
            case "park":
                park(command.getArgs());
                break;
            case "leave":
                leave(command.getArgs());
                break;
            case "status":
                displayStatus();
                break;
            case "create_parking_lot":
                parkingLot(command.getArgs());
                break;
            case "slot_numbers_for_cars_with_colour":
                slotNumbersByColour(command.getArgs());
                break;
            case "slot_number_for_registration_number":
                slotNumbersByRegNumber(command.getArgs());
                break;
            case "registration_numbers_for_cars_with_colour":
                regNumbersByColour(command.getArgs());
                break;
            default:
                System.out.println("Command not found");
        }
    }
    public void park(String[] args){
        String regNumber = args[1];
        String colour = args[2];

        Cars car = new Cars(colour, regNumber);
        this.parkingSlot.insertCar(car);
    }

    public void leave(String[] args){
        int slot = Integer.parseInt(args[1]);

        parkingSlot.removeCar(slot-1);
    }

    public void parkingLot(String[] args){
        int slot = Integer.parseInt(args[1]);
        this.parkingSlot = new ParkingSlot(slot);
        displayMessage("Created a parking lot with " + this.parkingSlot.getSlotSize() + " slots");
    }

    public void slotNumbersByColour(String[] args){
        String colour = args[1];

        ArrayList slots = this.parkingSlot.findSlotWithColour(colour);
        for (int i = 0; i < slots.size()-1; i++){
            System.out.print(slots.get(i) + ", ");
        }
        if (slots.size() > 0) {
            System.out.println(slots.get(slots.size()-1) + "\n");
        }
        else {
            displayMessage("Not found");
        }
    }

    public void slotNumbersByRegNumber(String[] args){
        String regNumber = args[1];

        ArrayList slots = this.parkingSlot.findSlotWithRegNumber(regNumber);
        for (int i = 0; i < slots.size()-1; i++){
            System.out.print(slots.get(i) + ", ");
        }
        if (slots.size() > 0) {
            System.out.println(slots.get(slots.size() - 1) + "\n");
        }
        else {
            displayMessage("Not found");
        }
    }

    public void regNumbersByColour(String[] args){
        String colour = args[1];

        ArrayList slots = this.parkingSlot.findRegNumberWithColour(colour);
        for (int i = 0; i < slots.size()-1; i++){
            System.out.print(slots.get(i) + ", ");
        }
        if (slots.size() > 0) {
            System.out.println(slots.get(slots.size()-1) + "\n");
        }
        else {
            displayMessage("Not found");
        }
    }

    public void displayMessage(String message){
        System.out.println(message + "\n");
    }

    public void displayStatus(){
        parkingSlot.display();
    }
}
