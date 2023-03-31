public class StringUtil {
    public static String firstChartoUp(String s){
        char ch[]=s.toCharArray();//string变数组
        char tmp=Character.toUpperCase(ch[0]);//character类
        ch[0]=tmp;
        String s2=new String(ch);
        return s2;
    }
}
