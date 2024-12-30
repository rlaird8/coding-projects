
// RYAN RUSSELL LAIRD
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Remote r = new Remote();
        TV tv = new TV();

        while (true) {
            r.printOptions(tv);
            String choice = scan.nextLine();

            if (tv.getStatus()) {

                switch (choice) {

                    case "O": {
                        r.actions(Button.POWER, tv);
                        break;
                    }

                    case "+": {
                        r.actions(Button.VOLUMEUP, tv);
                        break;
                    }

                    case "-": {
                        r.actions(Button.VOLUMEDOWN, tv);
                        break;
                    }

                    case "M": {
                        r.actions(Button.MUTE, tv);
                        break;
                    }

                    case "N": {
                        r.actions(Button.NUMERIC_ENTRY, tv);
                        break;
                    }

                    case "U": {
                        r.actions(Button.CHANNELUP, tv);
                        break;
                    }

                    case "D": {
                        r.actions(Button.CHANNELDOWN, tv);
                        break;
                    }

                    case "F": {
                        r.actions(Button.FLASHBACK, tv);
                        break;
                    }

                    case "Q": {
                        r.actions(Button.EXIT, tv);
                        return;
                    }

                    default: {
                        System.out.println("INVALID ENTRY");
                        break;
                    }
                }
            } else {
                switch (choice) {

                    case "O": {
                        r.actions(Button.POWER, tv);
                        break;
                    }

                    case "Q": {
                        r.actions(Button.EXIT, tv);
                        return;
                    }

                    default: {
                        System.out.println("INVALID ENTRY");
                        break;
                    }
                }

            }
        }
    }
}
