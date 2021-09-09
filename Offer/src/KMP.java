/**
 * @author : 李文龙
 * @createTime : 2021/9/7 20:57
 * @description : 字符串匹配
 */
public class KMP {
    public static void main(String[] args) {

    }

    /**
     * 暴力破解法
     * @param T 主串
     * @param P 子串
     * @return 子串第一次在主串中出现的位置
     */
    private static int bf(String T,String P){
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
        }
        if(j == p.length){
            return i - j;
        }else{
            return -1;
        }
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

        int i = 0;
        int j = 0;

        int[] next = getNext(P);

        while(i < t.length && j < p.length){
            if(j == -1 || t[i] == p[j]){
                i++;
                j++;
            }else{
                //i = i - j + 1;不需要回溯i
                j = next[j];
            }
        }

        if(j == p.length){
            return i - j;
        }else{
            return -1;
        }
    }

    /**
     * 计算每一个位置j对应的k，用一个数组next来保存，next[j] = k，表示当T[i] != P[j]时，j指针的下一个位置。
     * @param str
     * @return next[]
     */
    private static int[] getNext(String str){
        return null;
    }
}
