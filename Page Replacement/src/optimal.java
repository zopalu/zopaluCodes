
import java.util.*;
import java.io.*;

public class optimal {
    public static void main(String args[]) throws IOException {
    	
    	Scanner sn=new Scanner(System.in);
    	
        int numberOfFrames, numberOfPages, flag1, flag2, flag3, i, j, k, pos = 0, max,hit=0;
        int faults = 0;
        int temp[] = new int[10];

        System.out.println("Enter number of Frames: ");
        numberOfFrames = sn.nextInt();
        int frame[] = new int[numberOfFrames];

        System.out.println("Enter number of Pages: ");
        numberOfPages = sn.nextInt();

        int pages[] = new int[numberOfPages];
        System.out.println("Enter the pages: ");
        
        for (i = 0; i < numberOfPages; i++)
            pages[i] = sn.nextInt();

        for (i = 0; i < numberOfFrames; i++)
            frame[i] = -1;

        for (i = 0; i < numberOfPages; ++i) {//////
            flag1 = flag2 = 0;

            for (j = 0; j < numberOfFrames; ++j) {
                if (frame[j] == pages[i]) {
                    flag1 = flag2 = 1;
                    hit++;
                    break;
                }
            }

            if (flag1 == 0) {
                for (j = 0; j < numberOfFrames; ++j) {
                    if (frame[j] == -1) {
                        faults++;
                        frame[j] = pages[i];
                        flag2 = 1;
                        break;
                    }
                }
            }

            if (flag2 == 0) {
                flag3 = 0;

                for (j = 0; j < numberOfFrames; ++j) {
                    temp[j] = -1;

                    for (k = i + 1; k < numberOfPages; ++k) {
                        if (frame[j] == pages[k]) {
                            temp[j] = k;
                            break;
                        }
                    }
                }

                for (j = 0; j < numberOfFrames; ++j) {
                    if (temp[j] == -1) {
                        pos = j;
                        flag3 = 1;
                        break;
                    }
                }

                if (flag3 == 0) {
                    max = temp[0];
                    pos = 0;

                    for (j = 1; j < numberOfFrames; ++j) {
                        if (temp[j] > max) {
                            max = temp[j];
                            pos = j;
                        }
                    }
                }

                frame[pos] = pages[i];
                faults++;
            }

            for (j = 0; j < numberOfFrames; ++j) {
                System.out.print("\t" + frame[j]);
            }
            System.out.println("\n");
        }

        System.out.println("\n\nTotal Page Faults: " + faults);
        System.out.println("\n\nTotal Page Hits: " + hit);
    }

}