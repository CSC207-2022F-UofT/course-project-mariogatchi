package mariogatchi.use_cases.time;

public interface TimeInputBoundary {

    /*
    Interface for the Time use case Input Boundary
     */
    TimeResponseModel checkPassedTime(TimeRequestModel requestModel);
}
