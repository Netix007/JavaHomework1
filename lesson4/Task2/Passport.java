public class Passport extends Task{
    
    @Override
    public long time() {
        return 5000;
    }
    @Override
    public int prioritet() {
        return 5;
    }
    
    @Override
    public String toString() {
        return String.format("Получение паспорта: время ожидания - %d, приоритет - %d", time(), prioritet());
    }

}
