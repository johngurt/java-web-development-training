package facade;

/**
 * @author Hurt Yevhenii
 */
public class FacadeApp {

    public static void main(String[] args) {

//        Power power = new Power();
//        power.on();
//
//        DVDRom dvd = new DVDRom();
//        dvd.load();
//
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvd);

        Computer computer = new Computer();
        computer.copy();
    }
}

class Computer {

    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();

    void copy() {
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

class Power {

    void on() {
        System.out.println("Turn on the power");
    }

    void off() {
        System.out.println("Turn off the power");
    }
}

class DVDRom {

    private boolean data = false;

    public boolean hasData() {
        return data;
    }

    void load() {
        data = true;
    }
    void unload() {
        data = false;
    }
}

class HDD {
    void copyFromDVD (DVDRom dvd) {
        if(dvd.hasData()) {
            System.out.println("Data copying from disc");
        } else {
            System.out.println("Input disc with data");
        }
    }
}