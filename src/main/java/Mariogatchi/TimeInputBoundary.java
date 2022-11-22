package Mariogatchi;

public interface TimeInputBoundary {

    /*
    Interface for the Time use case Input Boundary
     */
    TimeResponseModel checkPassedTime(TimeRequestModel requestModel);
}
