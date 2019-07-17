package hfc.com.newhfc.retrofit;


import hfc.com.newhfc.model.adduser.AddUserRequest;
import hfc.com.newhfc.model.adduser.AddUserResponse;
import hfc.com.newhfc.model.bankDetail.BankDetailRequest;
import hfc.com.newhfc.model.bankDetail.BankDetailResponse;
import hfc.com.newhfc.model.left.LeftDownLine;
import hfc.com.newhfc.model.login.LoginRequest;
import hfc.com.newhfc.model.login.LoginResponse;
import hfc.com.newhfc.model.login.NewLoginResponse;
import hfc.com.newhfc.model.right.RightData;
import hfc.com.newhfc.model.updateUser.UpdateUserDetail;
import hfc.com.newhfc.model.updateUser.UpdateUserResponse;
import hfc.com.newhfc.model.userlist.UserListRequest;
import hfc.com.newhfc.model.userlist.UserListResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers({
            "Accept: application/vnd.yourapi.v1.full+json",
            "User-Agent: Your-App-Name"
    })

    @POST("login")
    Call<NewLoginResponse> loginUser(@Body LoginRequest loginRequest);
/*

    @POST("api/account/Authenticate")
    Call<LoginResponse> login(@Body LoginRequestModel requestModel);*/


    @POST("add_user")
    Call<AddUserResponse> addUser(@Body AddUserRequest addUserRequest);


    @POST("add_bank")
    Call<BankDetailResponse> bankDetailSave(@Body BankDetailRequest bankDetailRequest);


    @POST("update")
    Call<UpdateUserResponse> updateUser(@Body UpdateUserDetail updateUserDetail);



    /*@POST("api/account/register")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    Call<ResponseBody> addUser(@Header("Authorization") String access_token, @Body AddUser addUser);

*/


    @POST("list")
    Call<UserListResponse> userList(@Body UserListRequest userListRequest);

//    @POST("referleft")
//    Call<RightData> userListNew(@Body UserListRequest userListRequest);

    @POST("referright")
    Call<RightData> userListRight(@Body UserListRequest userListRequest);


    @POST("referleft")
    Call<LeftDownLine> userListLeft(@Body UserListRequest userListRequest);




}