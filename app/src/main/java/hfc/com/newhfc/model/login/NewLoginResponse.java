package hfc.com.newhfc.model.login;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewLoginResponse {

@SerializedName("Status")
@Expose
private Boolean status;
@SerializedName("Message")
@Expose
private String message;
@SerializedName("Id")
@Expose
private String id;
@SerializedName("First_Name")
@Expose
private String firstName;
@SerializedName("Last_Name")
@Expose
private String lastName;
@SerializedName("User_Name")
@Expose
private String userName;
@SerializedName("Image")
@Expose
private String image;
@SerializedName("Phone_Number")
@Expose
private String phoneNumber;
@SerializedName("Email")
@Expose
private String email;
@SerializedName("Date-of-Birth")
@Expose
private String dateOfBirth;
@SerializedName("Address")
@Expose
private String address;
@SerializedName("Pincode")
@Expose
private String pincode;
@SerializedName("Active_Status")
@Expose
private String activeStatus;
@SerializedName("Referal ")
@Expose
private String referal;
@SerializedName("Adhar_Number")
@Expose
private String adharNumber;
@SerializedName("Pan_Number")
@Expose
private String panNumber;
@SerializedName("Account_Number")
@Expose
private String accountNumber;
@SerializedName("IFSC_Code")
@Expose
private String iFSCCode;
@SerializedName("Account_Holder_Name")
@Expose
private String accountHolderName;
@SerializedName("Branch_Name")
@Expose
private String branchName;
@SerializedName("Nominee_Name")
@Expose
private String nomineeName;
@SerializedName("Relation")
@Expose
private String relation;
@SerializedName("Commision")
@Expose
private String commision;






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

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getFirstName() {
return firstName;
}

public void setFirstName(String firstName) {
this.firstName = firstName;
}

public String getLastName() {
return lastName;
}

public void setLastName(String lastName) {
this.lastName = lastName;
}

public String getUserName() {
return userName;
}

public void setUserName(String userName) {
this.userName = userName;
}

public String getImage() {
return image;
}

public void setImage(String image) {
this.image = image;
}

public String getPhoneNumber() {
return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
this.phoneNumber = phoneNumber;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getDateOfBirth() {
return dateOfBirth;
}

public void setDateOfBirth(String dateOfBirth) {
this.dateOfBirth = dateOfBirth;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getPincode() {
return pincode;
}

public void setPincode(String pincode) {
this.pincode = pincode;
}

public String getActiveStatus() {
return activeStatus;
}

public void setActiveStatus(String activeStatus) {
this.activeStatus = activeStatus;
}

public String getReferal() {
return referal;
}

public void setReferal(String referal) {
this.referal = referal;
}

public String getAdharNumber() {
return adharNumber;
}

public void setAdharNumber(String adharNumber) {
this.adharNumber = adharNumber;
}

public String getPanNumber() {
return panNumber;
}

public void setPanNumber(String panNumber) {
this.panNumber = panNumber;
}

public String getAccountNumber() {
return accountNumber;
}

public void setAccountNumber(String accountNumber) {
this.accountNumber = accountNumber;
}

public String getIFSCCode() {
return iFSCCode;
}

public void setIFSCCode(String iFSCCode) {
this.iFSCCode = iFSCCode;
}

public String getAccountHolderName() {
return accountHolderName;
}

public void setAccountHolderName(String accountHolderName) {
this.accountHolderName = accountHolderName;
}

public String getBranchName() {
return branchName;
}

public void setBranchName(String branchName) {
this.branchName = branchName;
}

public String getNomineeName() { return nomineeName; }

public void setNomineeName(String nomineeName) {
this.nomineeName = nomineeName;
}

public String getRelation() {
return relation;
}

public void setRelation(String relation) {
this.relation = relation;
}

public String getCommision() { return commision; }

public void setCommision(String commision) { this.commision = commision; }

}