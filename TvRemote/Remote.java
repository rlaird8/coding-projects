// RYAN RUSSELL LAIRD
public class Remote {

    public void printOptions(TV tv) {

        if (tv.getStatus()) {

            System.out.println("Enter O to turn the tv off or on: ");
            System.out.println("Enter + to turn the volume up:");
            System.out.println("Enter - to turn the volume down: ");
            System.out.println("Enter M to mute the tv volume: ");
            System.out.println("Enter N to type in a channel: ");
            System.out.println("Enter U to turn the channel up: ");
            System.out.println("Enter D to turn the channel down: ");
            System.out.println("Enter F to go back to the previous channel: ");
            System.out.println("Enter Q to exit: ");
        } else {

            System.out.println("Enter O to turn the tv off or on: ");
            System.out.println("Enter Q to exit: ");
        }
    }

    public void actions(Button b, TV tv) {
        if (b == Button.POWER) {
            System.out.println("Power button pressed.");
            tv.power();
            System.out.println("Power status: " + tv.getStatus());
        } else if (b == Button.VOLUMEUP) {
            System.out.println("Volume up button pressed.");
            tv.volumeUp();
            System.out.println("Volume level: " + tv.getVolume());
        } else if (b == Button.VOLUMEDOWN) {
            System.out.println("Volume down button pressed.");
            tv.volumeDown();
            System.out.println("Volume level: " + tv.getVolume());
        } else if (b == Button.MUTE) {
            System.out.println("Mute button pressed.");
            tv.mute();
            System.out.println("Volume level: " + tv.getVolume());
            System.out.println("Mute status: " + tv.getMute());
        } else if (b == Button.NUMERIC_ENTRY) {
            System.out.println("Enter channel button pressed.");
            tv.enterChannel(0);
            System.out.println("Channel number: " + tv.getChannel());
        } else if (b == Button.CHANNELUP) {
            System.out.println("Channel up button pressed.");
            tv.channelUp();
            System.out.println("Channel number: " + tv.getChannel());
        } else if (b == Button.CHANNELDOWN) {
            System.out.println("Channel down button pressed.");
            tv.channelDown();
            System.out.println("Channel number: " + tv.getChannel());
        } else if (b == Button.FLASHBACK) {
            System.out.println("Previous channel button pressed.");
            tv.previous();
        } else if (b == Button.EXIT) {

        }

        tv.print();
        return;
    }

}
