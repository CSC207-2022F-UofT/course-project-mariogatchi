package mariogatchi.entities.environments;

import mariogatchi.entities.Mariogatchi;

import java.util.List;

/**
 * Interface
 * Environments that inherit this interface are able to create new Mariogatchis.
 */
public interface MariogatchiGeneratable {
    GeneratedMariogatchis createMariogacthis();
}
