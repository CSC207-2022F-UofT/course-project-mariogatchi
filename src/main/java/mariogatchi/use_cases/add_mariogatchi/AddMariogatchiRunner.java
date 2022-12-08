package mariogatchi.use_cases.add_mariogatchi;

import mariogatchi.entities.Mariogatchi;
import mariogatchi.entities.User;

public class AddMariogatchiRunner implements AddMariogatchiInputBoundary{

    private final AddMariogatchiPresenter PRESENTER;


    public AddMariogatchiRunner(AddMariogatchiPresenter presenter) {
        this.PRESENTER = presenter;
    }


    @Override
    public AddMariogatchiResponseModel addMariogatchiToList(AddMariogatchiRequestModel requestModel){
        if (MariogatchiInList(requestModel.getMariogatchi(), requestModel.getUser())){
            return PRESENTER.prepareFailView("You already own an identical Mariogatchi");
        }
        else if (!(MariogatchiInList(requestModel.getMariogatchi(), requestModel.getUser())) && requestModel.getUser().getMariogatchis().size() < 10){
            AddMariogatchiResponseModel responseModel = new AddMariogatchiResponseModel(requestModel.getMariogatchi(), requestModel.getUser());
            return PRESENTER.prepareSuccessView(responseModel);

        }
        else{
            return PRESENTER.prepareFailView("Mariogatchi can not be caught: You have to many Mariogatchis");
        }
    }

    public boolean MariogatchiInList(Mariogatchi mariogatchi, User user){ return user.getMariogatchis().contains(mariogatchi);};




}
