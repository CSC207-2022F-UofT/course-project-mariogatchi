package mariogatchi.use_cases.playdate;

public interface PlaydateInputBoundary {

     /*
     Interface for the Playdate use case Input Boundary
      */
     PlaydateResponseModel sendPlaydateReq(PlaydateRequestModel requestModel);

     PlaydateResponseModel acceptPlaydateReq(PlaydateRequestModel requestModel);

     PlaydateResponseModel checkForMessages(PlaydateRequestModel requestModel);

}
