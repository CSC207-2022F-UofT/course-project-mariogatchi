package Mariogatchi;

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
                    requestModel.getMariogatchi(),
                    requestModel.getInventory()))
            {
                requestModel.getItemToUse().useThisItem(
                        requestModel.getItemToUse(),
                        requestModel.getCurrentEnvironment(),
                        requestModel.getMariogatchi(),
                        requestModel.getInventory()
                );

                UseItemResponseModel responseModel = new UseItemResponseModel(1,
                        requestModel.getInventory());
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
