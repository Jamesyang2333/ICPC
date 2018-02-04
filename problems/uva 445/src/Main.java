import  java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            char[] line = sc.nextLine().toCharArray();
            boolean whiteline = true;
            for (int i = 0; i < line.length; i++) {
                if (!Character.isWhitespace(line[i])) {
                    whiteline = false;
                    break;
                }
            }
            if (whiteline){
                System.out.println("");
                continue;
            }
            for (int i = 0; i < line.length; i++){
                if ((Character.isAlphabetic(line[i]) || line[i] == '*') && line[i] != 'b'){
                    int sum = 0;
                    int j = i - 1;
                    while (j >= 0 && Character.isDigit(line[j])){
                        sum += (line[j] - '0');
                        j--;
                    }
                    for(int k = 0; k < sum; k++)
                        System.out.print(line[i]);
                }
                else if (line[i] == 'b'){
                    int sum = 0;
                    int j = i - 1;
                    while (j >= 0 && Character.isDigit(line[j])){
                        sum += (line[j] - '0');
                        j--;
                    }
                    for(int k = 0; k < sum; k++)
                        System.out.print(" ");
                }
                else if (line[i] == '!')
                    System.out.println();
                if(i == line.length - 1 && line[i] != '!')
                    System.out.println();
            }
        }
    }
}
