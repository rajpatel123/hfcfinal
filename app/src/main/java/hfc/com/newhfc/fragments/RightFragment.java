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


public class RightFragment extends Fragment {
    RecyclerView rightRecyclerView;
    UserListAdaptor adaptor;
    TextView noData;
    private MyDashboardActivity actvity;

    public RightFragment() {
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
        View view = inflater.inflate(R.layout.fragment_right, container, false);
        rightRecyclerView = view.findViewById(R.id.rightRecycler);
        noData = view.findViewById(R.id.noData);
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        getRightChilds();

    }

    private void getRightChilds() {

        if (Utils.isInternetConnected(actvity)) {
            Utils.showProgressDialog(actvity);
            final UserListRequest userListRequest = new UserListRequest();
            userListRequest.setReferalCode(HFCPrefs.getString(actvity, Constants.REFERAL));
            RestClient.userListNew(userListRequest, new Callback<RightData>() {
                @Override
                public void onResponse(Call<RightData> call, Response<RightData> response) {
                    Utils.dismissProgressDialog();
                    if (response.body() != null) {
                        RightData rightData = response.body();

                        if (rightData.getStatus()) {
                            if (rightData.getRightUser() != null && rightData.getRightUser().size() == 0) {
                                noData.setVisibility(View.VISIBLE);
                                rightRecyclerView.setVisibility(GONE);

                            } else {
                                UserListAdaptor userListAdaptor = new UserListAdaptor(actvity);
                                userListAdaptor.setDatumList(rightData);
                                rightRecyclerView.setHasFixedSize(true);
                                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(actvity);
                                rightRecyclerView.setLayoutManager(layoutManager);
                                //  rightRecyclerView.addItemDecoration(new DividerItemDecoration(actvity, DividerItemDecoration.VERTICAL));
                                rightRecyclerView.setAdapter(userListAdaptor);
                                noData.setVisibility(GONE);
                                rightRecyclerView.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                }

                    @Override
                    public void onFailure (Call < RightData > call, Throwable t){

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
