package mariogatchi.use_cases.playdate;


import com.harium.postgrest.Condition;
import com.harium.postgrest.Insert;
import mariogatchi.data_access.DataAccess;
import org.json.JSONArray;
import org.json.JSONObject;


public class PlaydateRunner implements PlaydateInputBoundary {

    private final PlaydatePresenter PRESENTER;

    public PlaydateRunner(PlaydatePresenter presenter) {
        this.PRESENTER = presenter;
    }

    @Override
    /*
      Sends a playdate request to a friend
     */
    public PlaydateResponseModel sendPlaydateReq(PlaydateRequestModel requestModel) {

        DataAccess data = new DataAccess();

        JSONArray users = data.loadDBTable("users");
        boolean codeExists = false;
        for(int i = 0; i < users.length(); i++){
            String code = users.getJSONObject(i).getString("code");
            if(code.equals(requestModel.getFriendCode())) {
                codeExists = true;
            }
        }

        if(!codeExists){
            return this.PRESENTER.prepareFailView("No user exists with that code.");
        }

        boolean success =
                data.insertDBRow("playdates", Insert.row().column("type", "request")
                        .column("to", requestModel.getFriendCode())
                        .column("from", requestModel.getUsername())
                        .column("creature", requestModel.getMariogatchi().toString()));

        if(success){
            return this.PRESENTER.prepareSuccessView(new PlaydateResponseModel(true,"Request sent.", null));
        } else {
            return this.PRESENTER.prepareFailView("Cannot connect to server.");
        }
    }

    @Override
    /*
      Sends a playdate request to a friend
     */
    public PlaydateResponseModel acceptPlaydateReq(PlaydateRequestModel requestModel) {

        DataAccess data = new DataAccess();

        JSONArray entries = data.loadDBTable("playdates");
        String mariogatchi = "";
        boolean requestExists = false;
        for(int i = 0; i < entries.length(); i++){
            String to = entries.getJSONObject(i).getString("to");
            String from = entries.getJSONObject(i).getString("from");
            String type = entries.getJSONObject(i).getString("type");
            mariogatchi = entries.getJSONObject(i).getString("creature");
            if(from.equals(requestModel.getFriendCode()) && to.equals(requestModel.getUsername()) &&
               type.equals("request")) {
                requestExists = true;
            }
        }

        if(!requestExists){
            return this.PRESENTER.prepareFailView("No request exists with that code.");
        }

        boolean success =
                data.insertDBRow("playdates", Insert.row().column("type", "accept")
                        .column("to", requestModel.getFriendCode())
                        .column("from", requestModel.getUsername())
                        .column("creature", requestModel.getMariogatchi().toString()));

        data.deleteDBRow("playdates",  Condition.and(Condition.eq("from", requestModel.getFriendCode()),
                Condition.eq("to", requestModel.getUsername())));

        if(success){
            return this.PRESENTER.prepareSuccessView(new PlaydateResponseModel(true,"Acceptance sent.", mariogatchi));
        } else {
            return this.PRESENTER.prepareFailView("Cannot connect to server.");
        }
    }

    public PlaydateResponseModel checkForMessages(PlaydateRequestModel requestModel) {
        DataAccess data = new DataAccess();

        JSONArray entries = data.loadDBTable("playdates");
        for(int i = 0; i < entries.length(); i++){
            String to = entries.getJSONObject(i).getString("to");
            if(to.equals(requestModel.getUsername())) {
                String type = entries.getJSONObject(i).getString("type");
                String mariogatchi = entries.getJSONObject(i).getString("creature");
                if(type.equals("request")){
                    return this.PRESENTER.prepareSuccessView(new PlaydateResponseModel(true, "Request found", mariogatchi));
                } else {
                    String from = entries.getJSONObject(i).getString("from");
                    data.deleteDBRow("playdates",  Condition.and(Condition.eq("from", from),
                            Condition.eq("to", requestModel.getUsername())));
                    return this.PRESENTER.prepareSuccessView(new PlaydateResponseModel(true, "Acceptance found", mariogatchi));
                }
            }
        }

        return this.PRESENTER.prepareSuccessView(new PlaydateResponseModel(false, "No messages found", null));
    }

}
