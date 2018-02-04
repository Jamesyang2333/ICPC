class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(n == 0)
            return 0;
        int[] ways = new int[n];
        if(Integer.parseInt(Character.toString(s.charAt(0))) == 0)
            return 0;
        ways[0] = 1;
        if( n == 1)
            return ways[0];
        int a = Integer.parseInt(Character.toString(s.charAt(0)));
        int b = Integer.parseInt(Character.toString(s.charAt(1)));
        if(a == 0 && b == 0)
            return 0;
        if((a * 10 + b) <= 26){
            if( b == 0)
                ways[1] = 1;
            else ways[1] = 2;
        }
        else {
            if(b == 0)
                return 0;
            else ways[1] = 1;}

        for(int i = 2; i < n; i++){
            a = Integer.parseInt(Character.toString(s.charAt(i-1)));
            b = Integer.parseInt(Character.toString(s.charAt(i)));
            if(a == 0){
                if(b == 0)
                    return 0;
                ways[i] = ways[i-1];
            }
            else if((a*10+b)<=26)
                if(b == 0)
                    ways[i] = ways[i-2];
                else ways[i] = ways[i-1] + ways[i-2];
            else{
                if(b == 0)
                    return 0;
                else ways[i] = ways[i-1];}
        }
        return ways[n-1];

    }
}