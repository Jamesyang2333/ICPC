import java.util.Arrays;
import java.util.Comparator;

class MyCalendar {
    private int intervals;
    private slot[] bookings;
    private Bystart comp;
    public MyCalendar() {
        bookings = new slot[0];
        intervals = 0;
        comp = new Bystart();
    }
    public boolean book(int start, int end) {
        slot[] next = new slot[intervals + 1];
        for(int i = 0; i < intervals; i++)
            next[i] = bookings[i];
        next[intervals] = new slot(start, end);
        Arrays.sort(next, comp);
        boolean can = true;
        for(int i = 1; i <= intervals; i++){
            if(next[i].start < next[i - 1].end){
                can = false;
                break;
            }
        }
        if(can){
            bookings = next;
            intervals++;
            return true;
        }
        else return false;
    }
    public static void main(String[] args){
        MyCalendar obj = new MyCalendar();
        System.out.println(obj.book(10, 20));
        System.out.println(obj.book(15, 25));
        System.out.println(obj.book(20, 30));

    }
}
class slot{
    int start;
    int end;
    public slot(int start, int end){
        this.start = start;
        this.end = end;
    }
}
class Bystart implements Comparator<slot>{
    public int compare(slot a, slot b){
        return a.start - b.start;
    }
}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */