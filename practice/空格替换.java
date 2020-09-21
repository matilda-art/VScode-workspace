//空格替换，将空格替换成%20

public String revese(String s){
    StringBuilder sb = new StringBuilder();
    for(int i = 0;i < s.length();i++){
        if(s.charAt(i) == ' '){
            sb.append("%20");
        }else{
            sb.append(s.charAt(i));
        }
    }
    return sb.toString();
}