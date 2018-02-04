class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int n = s.length();
        for(int i = 0; i<n-1;i++){
            switch(s.charAt(i)){
                case 'I': if(s.charAt(i+1)!='I')
                    result -= 1;
                else result++;
                    break;
                case 'X': if(s.charAt(i+1)!='I' && s.charAt(i+1)!='V' && s.charAt(i+1)!='X')
                    result -= 10;
                else result += 10;
                    break;
                case 'C': if(s.charAt(i+1)!='I' && s.charAt(i+1)!='V' && s.charAt(i+1)!='X' && s.charAt(i+1)!='L' && s.charAt(i+1)!='C')
                    result -= 100;
                else result += 100;
                    break;
                case 'M': result += 1000;
                    break;
                case 'V': result += 5;
                    break;
                case 'L': result += 50;
                    break;
                case 'D': result += 500;
                    break;

            }
        }
        switch(s.charAt(n-1)){
            case 'I':result++;
                break;
            case 'X':  result += 10;
                break;
            case 'C': result += 100;
                break;
            case 'M': result += 1000;
                break;
            case 'V': result += 5;
                break;
            case 'L': result += 50;
                break;
            case 'D': result += 500;
                break;

        }
        return result;
    }
}