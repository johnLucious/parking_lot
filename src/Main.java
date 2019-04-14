import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        boolean exit = false;
        String[] input;
        Command command;
        Scanner scanner;
        Controller controller = new Controller(0);
        if (args.length > 0){
            File file = new File(args[0]);
            try {
                scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    input = scanner.nextLine().split(" ");
                    command = new Command(input, input.length);
                    controller.executeCommand(command);
                }
                scanner.close();
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            scanner = new Scanner(System.in);

            do {
                System.out.print("$ ");
                input = scanner.nextLine().split(" ");

                command = new Command(input, input.length);
                if (command.getCommand().equals("exit")) {
                    exit = true;
                } else {
                    controller.executeCommand(command);
                }
            } while (!exit);
        }
    }
}
