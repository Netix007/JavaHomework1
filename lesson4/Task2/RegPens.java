public class RegPens extends Task{
    
    @Override
    public long time() {
        return 2000;
    }
    @Override
    public int prioritet() {
        return 2;
    }

    @Override
    public String toString() {
        return String.format("Оформление пенсии: время ожидания - %d, приоритет - %d", time(), prioritet());
    }

}
