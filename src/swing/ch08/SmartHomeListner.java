package swing.ch08;

public interface SmartHomeListner {

    public abstract void onPowerOn();
    public abstract void onPowerOff();
    public abstract void onTemperatureChange(int t);

}
