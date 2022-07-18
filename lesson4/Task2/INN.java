public class INN extends Task{
    
    @Override
    public long time() {
        return 3000;
    }
    @Override
    public int prioritet() {
        return 1;
    }

    @Override
    public String toString() {
        return String.format("Получение ИНН: время ожидания - %d, приоритет - %d", time(), prioritet());
    }

}
