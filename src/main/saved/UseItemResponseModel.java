package mariogatchi;

public class UseItemResponseModel {

    private int quantityToUpdate;

    public UseItemResponseModel(int quantityToUpdate) {
        this.quantityToUpdate = quantityToUpdate;
    }

    public int getQuantityToUpdate() {
        return quantityToUpdate;
    }
}
