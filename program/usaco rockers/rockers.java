/*
ID: jamesya4
LANG: JAVA
TASK: rockers
*/
import java.io.*;
import java.util.*;

class rockers {
    private static int nsongs;
    private static int capacity;
    private static int ndisk;
    private static int[] songs;
    private static int max = 0;
    public static void main (String [] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        BufferedReader f = new BufferedReader(new FileReader("rockers.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rockers.out")));
        // Use StringTokenizer vs. readLine/split -- lots faster
        StringTokenizer st = new StringTokenizer(f.readLine());
        // Get line, break into tokens
        nsongs = Integer.parseInt(st.nextToken());
        capacity = Integer.parseInt(st.nextToken());
        ndisk = Integer.parseInt(st.nextToken());
        songs = new int[nsongs];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < nsongs; i++){
            songs[i] = Integer.parseInt(st.nextToken());
        }
        search(0, 1, 0, 0);
        out.println(max);                           // output result
        out.close();                                  // close the output file
    }
    private static void search(int nthSong, int nthdisk, int used, int recordedSongs){
        if (nthSong == nsongs - 1) {
            if((capacity - used) >= songs[nthSong]){
                if(max < recordedSongs + 1)
                    max = recordedSongs + 1;
            }
            else if(nthdisk < ndisk && capacity >= songs[nthSong]){
                if(max < recordedSongs + 1)
                    max = recordedSongs + 1;
            }
            else {
                if(max < recordedSongs)
                    max = recordedSongs;
            }
        }
        else {
            if((capacity - used) >= songs[nthSong]){
                search(nthSong + 1, nthdisk, used + songs[nthSong], recordedSongs + 1);
            }
            else if(nthdisk < ndisk && capacity >= songs[nthSong]){
                search(nthSong + 1, nthdisk + 1, songs[nthSong], recordedSongs + 1);
            }
            search(nthSong + 1, nthdisk, used, recordedSongs);

        }
    }
}
