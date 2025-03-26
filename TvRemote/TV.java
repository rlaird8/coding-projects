
// RYAN RUSSELL LAIRD
import java.util.Scanner;

public class TV {
    private boolean status;
    private int channel;
    private int prev;
    private int volume;
    private int prevVolume;
    private boolean mute;

    Scanner scan = new Scanner(System.in);
    // constructor

    public TV() {
        status = false;
        channel = 1;
        prev = 1;
        volume = 0;
        prevVolume = 0;
        mute = false;
    }

    // I originally had setters too, but they were not used so I took them out.

    public int getVolume() {
        return volume;
    }

    public int getChannel() {
        return channel;
    }

    public int getPrev() {
        return prev;
    }

    public boolean getStatus() {
        return status;
    }

    public int getPrevVolume() {
        return prevVolume;
    }

    public boolean getMute() {
        return mute;
    }

    public int volumeUp() {
        if (mute) {
            mute();
        }
        if (volume < 40) {

            volume++;
        }
        return volume;
    }

    public int volumeDown() {
        if (volume > 0) {
            volume--;
        }
        return volume;
    }

    public int enterChannel(int cNumber) {
        System.out.println("Enter a channel number: ");
        cNumber = scan.nextInt();
        if (cNumber <= 9999 && cNumber >= 1) {
            prev = channel;
            channel = cNumber;
        } else {
            System.out.println("Invalid entry, enter a channel between 1-9999");
        }
        return channel;
    }

    public int channelUp() {
        prev = channel;
        if (channel < 9999) {
            channel++;
        } else {
            channel = 1;
        }
        return channel;
    }

    public int channelDown() {
        prev = channel;
        if (channel > 1) {
            channel--;

        } else {
            channel = 9999;
        }
        return channel;
    }

    public void previous() {
        int holder = channel;
        channel = prev;
        prev = holder;

        System.out.println("New channel number is: " + channel);
    }

    public void power() {
        status = !status;

    }

    public void print() {
        System.out.println("TV");
    }

    public void mute() {
        mute = !mute;
        if (mute == true) {
            prevVolume = volume;
            volume = 0;
        } else if (mute == false) {
            volume = prevVolume;
        }

    }

}
