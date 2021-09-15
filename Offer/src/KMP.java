/**
 * @author : 李文龙
 * @createTime : 2021/9/7 20:57
 * @description : 字符串匹配
 */
public class KMP {
    public static void main(String[] args) {
        String P = "ABACABAD";
        String T = "BBC ABACABACABAD ABCDABDE";
        int result = BF(T, P);
        System.out.println("BF=" + result);
        int result2 = KMP(T,P);
        System.out.println("KMP=" + result2);

    }

    /**
     * 暴力破解法
     * @param T 主串
     * @param P 子串
     * @return 子串第一次在主串中出现的位置
     */
    private static int BF(String T,String P){
        char[] t = T.toCharArray();
        char[] p = P.toCharArray();

        int i = 0;//主串指针
        int j = 0;//子串指针

        while(i < t.length && j < p.length){
            if(t[i] == p[j]){
                i++;
                j++;
            }else{
                i = i - j + 1;
                j = 0;
            }

        }if(j == p.length){
            return i - j;
        }
        return -1;
    }

    /**
     * KMP算法
     * @param T 主串
     * @param P 子串
     * @return 子串第一次在主串中出现的位置
     */
    private static int KMP(String T,String P){
        char[] t = T.toCharArray();
        char[] p = P.toCharArray();

        int[] next = getNext(P);

        int i ,j;

        for(i=j=0;i < t.length && j < p.length;i++){
            while(j > 0 && t[i] != p[j]){
                j = next[j-1];
            }
            if(t[i] == p[j]){
                j++;
            }
            /*if(j == p.length){
                return i - j + 1;
            }*/
        }
        if(j == p.length){
            return i - j ;
        }
        return -1;
    }

    /**
     * 计算每一个位置i对应的j，用一个数组next来保存，next[i] = j，表示模式串的0~i位置的前后缀最长相同子串。
     * @param str
     * @return next[]
     */
    private static int[] getNext(String str){
        int[] next = new int[str.length()];
        next[0] = 0;
        for (int i = 1,j = 0; i < str.length(); i++) {
            while(j > 0 && str.charAt(i) != str.charAt(j)){
                j = next[j - 1];
            }
            if(str.charAt(i) == str.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
