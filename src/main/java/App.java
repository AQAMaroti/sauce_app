public class App {
    static void main() {

       String in = "welcome to java";
       //op: avajote mo clew

        String[] st = in.split("\\s");
        String temp = "";
        for(String s: st){
            temp += s;
        }
        System.out.println(temp);

        char[] ch=temp.toCharArray();
        int len = ch.length;

        for(int i=0; i<len >> 1; i++){
            int j = len - i-1;
            char t = ch[i];
            ch[i] = ch[j];
            ch[j] = t;
        }

        char[] ch1 =in.toCharArray();
        int k=0;
        for(int i=0; i<ch1.length;i++){
            if(ch1[i]==' '){
                System.out.print(" ");
            }else{
                System.out.print(ch[k]);
                k++;
            }
        }
        //System.out.println(new String(ch));
    }
}
