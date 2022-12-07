package mariogatchi.use_cases.info_access;

public interface InfoAccessInputBoundary {

     /*
     Interface for the InfoAccess use case Input Boundary
      */
     InfoAccessResponseModel checkStatistic(InfoAccessRequestModel requestModel);
}
