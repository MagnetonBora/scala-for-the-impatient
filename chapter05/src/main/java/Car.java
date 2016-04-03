
public class Car {

    private String manufacturer;
    private String modelName;
    private int modelYear;
    private String licensePlate;

    public Car(String manufacturer, String modelName, int modelYear, String licensePlate) {
        initialize(manufacturer, modelName, modelYear, licensePlate);
    }

    public Car(String manufacturer, String modelName) {
        initialize(manufacturer, modelName, -1, "");
    }

    public Car(String manufacturer, String modelName, int modelYear) {
        initialize(manufacturer, modelName, modelYear, "");
    }

    public Car(String manufacturer, String modelName, String licensePlate) {
        initialize(manufacturer, modelName, -1, licensePlate);
    }

    private void initialize(String manufacturer, String modelName, int modelYear, String licensePlate) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.licensePlate = licensePlate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public int getModelYear() {
        return modelYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
