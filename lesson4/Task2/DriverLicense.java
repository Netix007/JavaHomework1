public class DriverLicense extends Task{
    
    @Override
    public long time() {
        return 5000;
    }
    @Override
    public int prioritet() {
        return 4;
    }

    @Override
    public String toString() {
        return String.format("Получение водительского удостоверения: время ожидания - %d, приоритет - %d", time(), prioritet());
    }

}
