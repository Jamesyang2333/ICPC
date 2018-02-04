import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class MyCalendarTwo {
    private int intervals;
    private slot[] bookings;
    private Bystart comp;
    public MyCalendarTwo() {
        bookings = new slot[0];
        intervals = -1;
        comp = new Bystart();
    }
    public boolean book(int start, int end) {
        int startcopy = start;
        ArrayList<slot> nextlist = new ArrayList<>();
        boolean can = true;
        boolean continueSearch = true;
        for(int i = 0; i <= intervals; i++){
            if(continueSearch){
                if(startcopy < bookings[i].start){
                    if(end <= bookings[i].start){
                        continueSearch = false;
                        nextlist.add(new slot(startcopy, end ,1));
                    }
                    else{
                        nextlist.add(new slot(startcopy, bookings[i].start,1));
                        startcopy = bookings[i].start;
                    }
                }
            if(bookings[i].start <= startcopy && bookings[i].end > startcopy){
                if(bookings[i].times == 2){
                    can = false;
                    break;
                }
                else{
                    if(bookings[i].start == startcopy){
                        if (bookings[i].end > end){
                            nextlist.add(new slot(startcopy, end, 2));
                            nextlist.add(new slot(end, bookings[i].end, 1));
                            continueSearch = false;
                        }
                        else if(bookings[i].end == end){
                            nextlist.add(new slot(startcopy, end, 2));
                            continueSearch = false;
                        }
                        else{
                            startcopy = bookings[i].end;
                            nextlist.add(new slot(bookings[i].start, bookings[i].end, 2));
                        }
                    }
                    else{
                        nextlist.add(new slot(bookings[i].start, startcopy, 1));
                        if (bookings[i].end > end){
                            nextlist.add(new slot(startcopy, end, 2));
                            nextlist.add(new slot(end, bookings[i].end, 1));
                            continueSearch = false;
                        }
                        else if(bookings[i].end == end){
                            nextlist.add(new slot(startcopy, end, 2));
                            continueSearch = false;
                        }
                        else{
                            nextlist.add(new slot(startcopy, bookings[i].end, 2));
                            startcopy = bookings[i].end;
                        }
                    }
                }
            }
            else{
                nextlist.add(bookings[i]);
            }
        }
        else nextlist.add(bookings[i]);
        }
        if(can){
            if(continueSearch)
                nextlist.add(new slot(startcopy, end, 1));
            int size = nextlist.size();
            slot[] next = new slot[size];
            for(int i = 0; i < size; i++){
                next[i] = nextlist.get(i);
            }
            Arrays.sort(next, comp);
            bookings = next;
            intervals = size - 1;
            return true;
        }
        else return false;
    }
    public static void main(String[] args){
        MyCalendarTwo obj = new MyCalendarTwo();
        System.out.println(obj.book(24, 40));
        System.out.println(obj.book(43, 50));
        System.out.println(obj.book(27, 43));
        System.out.println(obj.book(5, 21));
        System.out.println(obj.book(30, 40));
        System.out.println(obj.book(14, 29));

    }
}
class slot{
    int start;
    int end;
    int times;
    public slot(int start, int end, int times){
        this.start = start;
        this.end = end;
        this.times = times;
    }
}
class Bystart implements Comparator<slot>{
    public int compare(slot a, slot b){
        if(a.start != b.start)
            return a.start - b.start;
        else return b.end - b.end;
    }
}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */