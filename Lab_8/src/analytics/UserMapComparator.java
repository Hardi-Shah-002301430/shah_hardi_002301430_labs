package analytics;
import java.util.Comparator;
import java.util.HashMap;
import model. User;

public class UserMapComparator implements Comparator<User>{
HashMap<Integer, Integer> userPostMap;
public UserMapComparator(HashMap<Integer, Integer> userPostMap) {
this.userPostMap = userPostMap;
}
@Override
public int compare (User o1, User o2) {
    return Integer.compare (
        ( (userPostMap. get (o1. getId()) == null) ? 0 : userPostMap. get (o1 .getId())) ,
        ( (userPostMap. get (o2.getId()) == null) ? 0 : userPostMap. get (o2. getId ()))
        ) ;
}
}
//To change body of generated methods, choose Tools | Templates.