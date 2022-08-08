public abstract class Task {
    
    public static int count;
    public int number;

    public Task() {
        count += 1;
        this.number = count;
    }
    
    public abstract long time();

    public abstract int prioritet();

    public int getNumber() {
        return number;
    }

}
