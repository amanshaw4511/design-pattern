package org.example.behavioral.command;

public class Command {
    public static void main(String[] args) {
        Tv tv = new Tv();
        Stereo stereo = new Stereo();

        RemoteCommand turnOnTv = new TurnOnCommand(tv);
        RemoteCommand turnOffTv = new TurnOffCommand(tv);
        RemoteCommand changeChannel = new ChangeChannelCommand(tv);
        RemoteCommand adjustVolume = new AdjustVolumeCommand(stereo);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.pressButton(turnOnTv);
        remoteControl.pressButton(changeChannel);
        remoteControl.pressButton(adjustVolume);
        remoteControl.pressButton(turnOffTv);
    }
}

class RemoteControl {
    void pressButton(RemoteCommand command) {
        command.execute();
    }
}

interface RemoteCommand {
    void execute();
}

class TurnOnCommand implements RemoteCommand {
    private final Device device;

    TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}

class TurnOffCommand implements RemoteCommand {
    private final Device device;

    TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}

class ChangeChannelCommand implements RemoteCommand {
    private final Tv tv;

    ChangeChannelCommand(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.changeChannel();
    }
}

class AdjustVolumeCommand implements RemoteCommand {
    private final Stereo stereo;

    AdjustVolumeCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.adjustVolume();
    }
}

interface Device {
    void turnOn();
    void turnOff();
}

class Tv implements Device {

    public void changeChannel() {
        System.out.println("Tv Channel changed");
    }

    @Override
    public void turnOn() {
        System.out.println("Tv turned On");
    }

    @Override
    public void turnOff() {
        System.out.println("Tv turned Off");
    }
}

class Stereo implements Device {

    public void adjustVolume() {
        System.out.println("Stereo Volume Changed");
    }

    @Override
    public void turnOn() {
        System.out.println("Stereo turned On");
    }

    @Override
    public void turnOff() {
        System.out.println("Stereo turned Off");
    }
}