package mariogatchi.use_cases.item_cases.use_item;
import mariogatchi.entities.Statistics;

import java.util.Map;

public class UseItemRunner implements UseItemInputBoundary {

    private final UseItemOutputBoundary USEITEMPRESENTER;

    /*
    The interactor for the UseItem use case
    @param useItemPresenter - the presenter (output boundary object) for this use case.
     */
    public UseItemRunner(UseItemOutputBoundary useItemOutputBoundary) {
        this.USEITEMPRESENTER = useItemOutputBoundary;
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

                return USEITEMPRESENTER.useItemPrepareSuccessView(responseModel);
            }
            else {
                return USEITEMPRESENTER.useItemPrepareFailureView("Item cannot be used");
            }
            
        }
        catch (Exception e) {
            return USEITEMPRESENTER.useItemPrepareFailureView(e.getMessage());
        }
    }

}
