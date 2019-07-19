package hfc.com.newhfc.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hfc.com.newhfc.R;
import hfc.com.newhfc.activities.MyDashboardActivity;
import hfc.com.newhfc.adapter.UserListAdaptor;
import hfc.com.newhfc.adapter.UserListLeftAdaptor;
import hfc.com.newhfc.model.left.LeftDownLine;
import hfc.com.newhfc.model.right.RightData;
import hfc.com.newhfc.model.userlist.UserListRequest;
import hfc.com.newhfc.retrofit.RestClient;
import hfc.com.newhfc.utils.Constants;
import hfc.com.newhfc.utils.HFCPrefs;
import hfc.com.newhfc.utils.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.view.View.GONE;


public class LeftFragment extends Fragment {
    RecyclerView leftRecyclerView;
    UserListAdaptor adaptor;
    TextView noData;
    private MyDashboardActivity actvity;

    public LeftFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_left, container, false);
       leftRecyclerView = view.findViewById(R.id.leftRecycler);
        noData = view.findViewById(R.id.noData1);
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        getLeftChilds();

    }

    private void getLeftChilds() {

        if (Utils.isInternetConnected(actvity)) {
            Utils.showProgressDialog(actvity);
            final UserListRequest userListRequest = new UserListRequest();
            userListRequest.setReferalCode(HFCPrefs.getString(actvity, Constants.REFERAL));
            RestClient.userListLeft(userListRequest, new Callback<LeftDownLine>() {
                @Override
                public void onResponse(Call<LeftDownLine> call, Response<LeftDownLine> response) {
                    Utils.dismissProgressDialog();
                    if (response.body() != null) {
                        LeftDownLine rightData = response.body();

                        if (rightData.getStatus() && rightData.getData().size() == 0) {
                            noData.setVisibility(View.VISIBLE);
                            leftRecyclerView.setVisibility(GONE);

                        } else {
                            UserListLeftAdaptor userListAdaptor = new UserListLeftAdaptor(actvity);
                            userListAdaptor.setDatumList(rightData);
                            leftRecyclerView.setHasFixedSize(true);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(actvity);
                            leftRecyclerView.setLayoutManager(layoutManager);
                            //  rightRecyclerView.addItemDecoration(new DividerItemDecoration(actvity, DividerItemDecoration.VERTICAL));
                            leftRecyclerView.setAdapter(userListAdaptor);
                            noData.setVisibility(GONE);
                            leftRecyclerView.setVisibility(View.VISIBLE);
                        }
                    }
                }

                @Override
                public void onFailure (Call < LeftDownLine > call, Throwable t){

                }
            });
        }
    }

    @Override
    public void onAttach (Context context){
        super.onAttach(context);
        actvity= (MyDashboardActivity) getActivity();

    }

    @Override
    public void onDetach () {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
