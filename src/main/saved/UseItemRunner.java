package mariogatchi;

public class UseItemRunner implements UseItemInputBoundary {

    final UseItemPresenter useItemPresenter;

    public UseItemRunner(UseItemPresenter useItemPresenter) {
        this.useItemPresenter = useItemPresenter;
    }

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

                UseItemResponseModel responseModel = new UseItemResponseModel(1);
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
