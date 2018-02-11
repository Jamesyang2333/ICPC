class Solution {
    public int numRabbits(int[] answers) {
        int[] kinds = new int[1000];
        for(int i = 0; i < 1000;  i++)
            kinds[i] = 0;
        int len = answers.length;
        for(int i = 0;  i < len;  i++){
            kinds[answers[i]]++;
        }
        int result = 0;
        for(int i = 0; i < 1000;  i++){
            int sets = 0;
            if(kinds[i] % (i + 1) == 0)
                sets = kinds[i] / (i + 1);
            else sets = kinds[i] / (i + 1) + 1;
            result += (sets * (i + 1));
        }
        return result;
    }
}