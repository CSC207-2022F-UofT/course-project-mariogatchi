package mariogatchi.use_cases.change_environment;

import mariogatchi.entities.Mariogatchi;
import java.util.List;

/**
 * Interface
 * Environments that inherit this interface are able to create new Mariogatchis.
 */
public interface MariogatchiGeneratable {
    List<Mariogatchi> createMariogacthis();
}
