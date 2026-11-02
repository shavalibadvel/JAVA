package generics;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Mine<T1,T2,T3> {
    public T1 printFirstElementValue(List<T1> t){
        return t.get(0)!=null?t.get(0):null;
    }
    public T1 printFirstElementValue(Set<T1> t){
        return t.stream().findFirst().orElse(null);
    }
    public T1 printFirstElementValue(Map<T1,T2> t){
        return (T1) t.values().stream().findFirst().orElse(null);
    }
    public String convertToString(T1 t){
        return t+"";
    }

}
