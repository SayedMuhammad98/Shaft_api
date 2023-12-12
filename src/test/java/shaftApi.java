import apis.objects.apis;
import apis.objects.apisBooking;
import com.shaft.driver.SHAFT;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class shaftApi {
    private SHAFT.API api;
   private apisBooking apisBooking;
//    private apis apis;
    //////////// Tests \\\\\\\\\\\\
    @Test
    public void createBookingTest() {
        apisBooking.createBooking("Sayed", "Muhammad", "Metdla3a");
        apisBooking.validateThatTheBookingIsCreated("Sayed", "Muhammad", "Metdla3a");
    }

    @Test()
    public void deleteBookingTest() {
        apisBooking.deleteBooking("Sayed" , "Muhammad");
        apisBooking.validateThatTheBookingDeleted();
    }


    /////////// Configurations \\\\\\\\\\\\\\\
    @BeforeClass
    public void beforeClass() {
        api = new SHAFT.API(apis.baseUrl);
        apis.login(api, "admin", "password123");
        apisBooking =new apisBooking(api);
      //  apis =new apis(api);

    }



}
