public class RegDisc extends Task{
    
    @Override
    public long time() {
        return 3000;
    }
    @Override
    public int prioritet() {
        return 3;
    }

    @Override
    public String toString() {
        return String.format("Оформление налогового вычета: время ожидания - %d, приоритет - %d", time(), prioritet());
    }

}
