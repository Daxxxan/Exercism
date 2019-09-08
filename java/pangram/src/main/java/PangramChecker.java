import java.util.ArrayList;
import java.util.Arrays;

public class PangramChecker {

    public boolean isPangram(String input) {
        ArrayList<String> alphabet = new ArrayList<>(Arrays.asList("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",")));
        input = input.toLowerCase();

        for(int i = 0; i < input.length(); i++) {
            alphabet.remove(String.valueOf(input.charAt(i)));
        }

        return alphabet.isEmpty();
    }

}
