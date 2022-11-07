class Solution
{
    public int solution(int n, int a, int b)
    {
        int count = 0;
        while (a != b) {
            a = (a+1)/2;
            b = (b+1)/2;
            count++;
        }
        return count;
    }
}