/*
读入一个字符串str，输出字符串str中的连续最长的数字串
*/

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int count = 0;
        int max = 0;
        int end = 0;
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                count++;
                if(max < count){
                    max = count;
                    end = i;
                }
            }else{
                count = 0;
            }
        }
        System.out.println(str.substring(end-max+1,end+1));
    }
} 