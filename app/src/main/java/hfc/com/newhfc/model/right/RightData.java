package hfc.com.newhfc.model.right;



import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RightData {

@SerializedName("status")
@Expose
private Boolean status;
@SerializedName("message")
@Expose
private String message;
@SerializedName("Right User")
@Expose
private List<RightUser> rightUser = null;

public Boolean getStatus() {
return status;
}

public void setStatus(Boolean status) {
this.status = status;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public List<RightUser> getRightUser() {
return rightUser;
}

public void setRightUser(List<RightUser> rightUser) {
this.rightUser = rightUser;
}

}
