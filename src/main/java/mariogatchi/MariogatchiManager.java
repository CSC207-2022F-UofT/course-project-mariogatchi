package mariogatchi;

import java.util.List;

public class MariogatchiManager {
    public boolean ReleaseMariogatchi(User user, Mariogatchi mariogatchi){
        List<Mariogatchi> lst = user.getMariogatchis();
        if (lst != null){
            for (Mariogatchi mario : lst){
                if (mario.equals(mariogatchi)) {
                    lst.remove(mario);
                    return true;
                }
            }
        }
        return false;
    }


}
