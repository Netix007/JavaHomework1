import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        ArrayList<Task> listTask = new ArrayList<>();
        listTask.add(new Passport());
        listTask.add(new RegPens());
        listTask.add(new RegDisc());
        listTask.add(new INN());
        listTask.add(new DriverLicense());
        listTask.add(new ReceiveDocuments());
        ArrayList<Task> queue = new ArrayList<>();
        Task temp = listTask.get(0);
        for (int i = 1; i < listTask.size(); i++) {
            if (listTask.get(i).prioritet() >  temp.prioritet()) {
                queue.add(listTask.get(i));
            }
            else {
                queue.add(temp);
                temp = listTask.get(i);
            }
        }
        queue.add(temp);
        boolean flag = true;
        for (Task task : queue) {
            if (rnd.nextBoolean()) {
                if (flag) {
                    System.out.println(task);
                    try {    
                        Thread.sleep(task.time());
                    } catch (InterruptedException e) {
                        System.out.println("got interrupted!");
                    }
                } else {
                    System.out.println("Посетитель с таллоном № " + task.number + " ушел");
                }

                flag = rnd.nextBoolean();
            } else {
                System.out.println("Окно закрыто");
                break;
            }
        }
    }
}