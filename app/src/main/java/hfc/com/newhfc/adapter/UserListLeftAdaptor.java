package hfc.com.newhfc.adapter;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import hfc.com.newhfc.R;
import hfc.com.newhfc.model.left.Datum;
import hfc.com.newhfc.model.left.LeftDownLine;
import hfc.com.newhfc.model.right.RightData;
import hfc.com.newhfc.model.right.RightUser;
import hfc.com.newhfc.views.CircleImageView;

/**
 * Created by rbpatel on 3/16/2017.
 */

public class UserListLeftAdaptor extends RecyclerView.Adapter<UserListLeftAdaptor.ViewHolder> {


    private Context context;


    private LeftDownLine userList;


    OnUserClickCallback onUserClickCallback;

    public UserListLeftAdaptor(Context context) {
        this.context = context;
    }

    public void setDatumList(LeftDownLine datumList) {
        this.userList = datumList;
    }

    public void setOnUserClickCallback(OnUserClickCallback onUserClickCallback) {
        this.onUserClickCallback = onUserClickCallback;
    }

    @Override
    public UserListLeftAdaptor.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = null;
        view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_userlist, viewGroup, false);
        return new UserListLeftAdaptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final UserListLeftAdaptor.ViewHolder holder, int position) {


        final Datum userlist = userList.getData().get(position);
        if (userlist.getFirstName() != null) {
            holder.tvName.setText("" + userlist.getFirstName());
        }
        if (userlist.getAddress() != null) {
            holder.tvAddress.setText("" + userlist.getEmail());
        }
        if (userlist.getStatus().equalsIgnoreCase("1")) {
            holder.activeImage.setImageResource(R.drawable.ic_activated);
        } else {
            holder.activeImage.setImageResource(R.drawable.ic_blocked);
        }

      /*  if(userlist.getImage()!=null) {
            Glide.with(context).load(userlist.getImage()).into(holder.simpleImageView);
        }else {
            holder.simpleImageView.setImageResource(R.drawable.profile_pictures);
        }*/
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        Log.d("Userlist","start");
       if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
           holder.simpleImageView.setVisibility(View.VISIBLE);
           Log.d("Userlist","success");
           // holder.appCompatImageView.setImageResource(R.drawable.profile_pictures);
        } else {
            Picasso.with(context).load(userlist.getImage())
                    .error(R.drawable.profile_pictures)
                    .into(holder.imageView);
           Log.d("Userlist","failed");
            holder.imageView.setVisibility(View.VISIBLE);
        }



        if (userlist.getStatus().equalsIgnoreCase("1")) {
            holder.activeImage.setImageResource(R.drawable.ic_activated);
            holder.cardViewList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    if (onUserClickCallback != null)
//                        onUserClickCallback.onUserClick(userlist.getReferalCode());


                }
            });
        }

       /* if (!TextUtils.isEmpty(userLists.get(holder.getAdapterPosition()).getImage())) {
            Picasso.with(context)
                    .load("" + userLists.get(holder.getAdapterPosition()).getImage())
                    .error(R.drawable.ic_default_image)
                    .into(holder.imageView);

        } else {
            holder.imageView.setImageResource(R.drawable.ic_default_image);
        }

        isUserSelected = userLists.get(holder.getAdapterPosition()).getIsActive();
        if (isUserSelected) {
            holder.activeImage.setImageResource(R.drawable.ic_activated);
        } else {
            holder.activeImage.setImageResource(R.drawable.ic_blocked);
        }
        holder.tvName.setText(userLists.get(holder.getAdapterPosition()).getFirstName());
        holder.tvDesc.setText(userLists.get(holder.getAdapterPosition()).getCreatedOn());
        holder.cardViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onUserClickCallback != null)
                    onUserClickCallback.onUserClick(userLists.get(holder.getAdapterPosition()).getId(), userLists.get(holder.getAdapterPosition()).getReferalCode());


            }
        });*/


    }


    @Override
    public int getItemCount() {
        if (userList != null && userList.getData().size() > 0) {
            return userList.getData().size();
        } else {
            return 0;
        }
    }

    public void setListener(OnUserClickCallback userListActivity) {
        this.onUserClickCallback = userListActivity;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        //private CircleImageView imageView;
        private ImageView simpleImageView;
        private CircleImageView imageView;
        private AppCompatImageView appCompatImageView;
        private TextView tvName;
        private CircleImageView circleImageView;
        private TextView tvAddress;
        private ImageView activeImage;
        private CardView cardViewList;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.image);
            tvName = view.findViewById(R.id.tvName);
            tvAddress = view.findViewById(R.id.tvDesc);
            activeImage = view.findViewById(R.id.tvDelete);
            cardViewList = view.findViewById(R.id.deviceInfoView);


        }
    }

    public interface OnUserClickCallback {
        public void onUserClick(String referalCode);
    }
}
