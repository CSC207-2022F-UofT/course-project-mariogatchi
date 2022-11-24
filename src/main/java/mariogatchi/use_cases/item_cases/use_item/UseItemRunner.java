package mariogatchi.use_cases.item_cases.use_item;
import mariogatchi.entities.items.Items;
public class UseItemRunner implements UseItemInputBoundary {

    private final UseItemPresenter useItemPresenter;

    /*
    The interactor for the UseItem use case
    @param useItemPresenter - the presenter (output boundary object) for this use case.
     */
    public UseItemRunner(UseItemPresenter useItemPresenter) {
        this.useItemPresenter = useItemPresenter;
    }


    /*
    Uses an Item and returns a UseItemResponseModel.
     */
    @Override
    public UseItemResponseModel useItem(UseItemRequestModel requestModel) {
        try {
            if (requestModel.getItemToUse().itemCanBeUsed(
                    requestModel.getItemToUse(),
                    requestModel.getCurrentEnvironment(),
                    requestModel.getInventory()))
            {
                requestModel.getItemToUse().useThisItem(
                        requestModel.getMariogatchi(),
                        requestModel.getInventory()
                );

                UseItemResponseModel responseModel = new UseItemResponseModel(
                        requestModel.getInventory(),
                        requestModel.getItemToUse().getName());

                return useItemPresenter.prepareSuccessView(responseModel);
            }
            else {
                return useItemPresenter.prepareFailView("mariogatchi.Item cannot be used");
            }
            
        }
        catch (Exception e) {
            return useItemPresenter.prepareFailView(e.getMessage());
        }
    }

}
