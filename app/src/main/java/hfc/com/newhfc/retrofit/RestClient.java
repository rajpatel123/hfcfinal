package hfc.com.newhfc.retrofit;


import hfc.com.newhfc.model.adduser.AddUserRequest;
import hfc.com.newhfc.model.adduser.AddUserResponse;
import hfc.com.newhfc.model.bankDetail.BankDetailRequest;
import hfc.com.newhfc.model.bankDetail.BankDetailResponse;
import hfc.com.newhfc.model.left.LeftDownLine;
import hfc.com.newhfc.model.login.LoginRequest;
import hfc.com.newhfc.model.login.ResponseLogin;
import hfc.com.newhfc.model.right.RightData;
import hfc.com.newhfc.model.updateUser.UpdateUserDetail;
import hfc.com.newhfc.model.updateUser.UpdateUserResponse;
import hfc.com.newhfc.model.userlist.UserListRequest;
import hfc.com.newhfc.model.userlist.UserListResponse;
import retrofit2.Callback;

public class RestClient {

    public static void loginUser(LoginRequest loginRequest, Callback<ResponseLogin> callback) {
        RetrofitClient.getClient().loginUser(loginRequest).enqueue(callback);
    }


    public static void addUser(AddUserRequest addUserRequest, Callback<AddUserResponse> callback) {
        RetrofitClient.getClient().addUser(addUserRequest).enqueue(callback);
    }


    public static void bankDetailSave(BankDetailRequest bankDetailRequest, Callback<BankDetailResponse> callback) {
        RetrofitClient.getClient().bankDetailSave(bankDetailRequest).enqueue(callback);
    }


    public static void updateUser(UpdateUserDetail updateUserDetail, Callback<UpdateUserResponse> callback) {
        RetrofitClient.getClient().updateUser(updateUserDetail).enqueue(callback);
    }

    public static void userList(UserListRequest userListRequest, Callback<UserListResponse> callback) {
        RetrofitClient.getClient().userList(userListRequest).enqueue(callback);
    }

    public static void userListNew(UserListRequest userListRequest, Callback<RightData> callback) {
        RetrofitClient.getClient().userListRight(userListRequest).enqueue(callback);
    }

    public static void userListLeft(UserListRequest userListRequest, Callback<LeftDownLine> callback) {
        RetrofitClient.getClient().userListLeft(userListRequest).enqueue(callback);
    }




/*

    public static void login(LoginRequestModel loginRequestModel, Callback<LoginResponse> callback) {
        RetrofitClient.getClient().login(loginRequestModel).enqueue(callback);

    }
*/
/*

    public static void getUserList(UserById user, String access_token, Callback<List<UserList>> callback) {
        RetrofitClient.getClient().getUserList(user, access_token).enq
        ueue(callback);
    }

*/


/*

    public static void addUser(String access_token, AddUser addUser, Callback<ResponseBody> callback) {
        RetrofitClient.getClient().addUser(access_token, addUser).enqueue(callback);
    }

*/

}



