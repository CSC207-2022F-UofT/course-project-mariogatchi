package mariogatchi.use_cases.item_cases.use_item;
import mariogatchi.entities.Statistics;

import java.util.Map;

public class UseItemRunner implements UseItemInputBoundary {

    private final UseItemOutputBoundary USE_ITEM_PRESENTER;

    /*
    The interactor for the UseItem use case
    @param useItemPresenter - the presenter (output boundary object) for this use case.
     */
    public UseItemRunner(UseItemOutputBoundary useItemOutputBoundary) {
        this.USE_ITEM_PRESENTER = useItemOutputBoundary;
    }


    /*
    Uses an Item and returns a UseItemResponseModel.
     */
    @Override
    public UseItemResponseModel useItem(UseItemRequestModel requestModel) {
        try {
            if (requestModel.getItemToUse().itemCanBeUsed(
                    requestModel.getItemToUse().getName(),
                    requestModel.getCurrentEnvironment(),
                    requestModel.getInventory()))
            {
                Map<Statistics.Stats, Integer> statToValue = requestModel.getItemToUse().useThisItem(
                        requestModel.getMariogatchi(),
                        requestModel.getInventory()
                );

                UseItemResponseModel responseModel = new UseItemResponseModel(
                        requestModel.getInventory(),
                        requestModel.getItemToUse().getName(),
                        requestModel.getMariogatchi(),
                        statToValue
                        );

                return USE_ITEM_PRESENTER.useItemPrepareSuccessView(responseModel);
            }
            else {
                return USE_ITEM_PRESENTER.useItemPrepareFailureView("Item cannot be used");
            }
            
        }
        catch (Exception e) {
            return USE_ITEM_PRESENTER.useItemPrepareFailureView(e.getMessage());
        }
    }

}
