package mariogatchi.use_cases.item_cases.use_item;
import mariogatchi.entities.Statistics;

import java.util.Map;

/*
Interactor for the use item use case.
 */
public class UseItemRunner implements UseItemInputBoundary {

    private final UseItemOutputBoundary USE_ITEM_PRESENTER;

    public UseItemRunner(UseItemOutputBoundary useItemOutputBoundary) {
        this.USE_ITEM_PRESENTER = useItemOutputBoundary;
    }


    /*
    Returns an instance of the response model for the use item use case. "Uses" a specified item.

    @param requestModel an instance of the requestModel for the use item use case.
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
