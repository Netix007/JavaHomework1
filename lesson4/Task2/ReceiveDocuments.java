public class ReceiveDocuments extends Task{
    
    @Override
    public long time() {
        return 1000;
    }
    @Override
    public int prioritet() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Получение документов: время ожидания - %d, приоритет - %d", time(), prioritet());
    }

}
