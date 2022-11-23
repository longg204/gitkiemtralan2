package com.example.baikiemtralan2;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class mainadapter extends FirebaseRecyclerAdapter<mainmodel, mainadapter.myViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public mainadapter(@NonNull FirebaseRecyclerOptions<mainmodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, final int position, @NonNull mainmodel model) {
        holder.tenkhoahoc.setText(model.getTenkhoahoc());
        holder.tenthuonggoi.setText(model.getTenthuonggoi());
        holder.dactinh.setText(model.getDactinh());
        holder.congdung.setText(model.getCongdung());
        holder.lieudung.setText(model.getLieudung());
        holder.luuydung.setText(model.getLuuydung());

        Glide.with(holder.img.getContext())
                .load(model.getUrl())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);
// detail
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.detail))
                        .setExpanded(true, 2100)
                        .create();
                View viewDialog = dialogPlus.getHolderView();
                EditText tenkhoahoc = (EditText) viewDialog.findViewById(R.id.tenkhoahoc_detail);
                EditText tenthuonggoi = (EditText) viewDialog.findViewById(R.id.tenthuonggoi_detail);
                EditText dactinh = (EditText) viewDialog.findViewById(R.id.dactinh_detail);
                EditText congdung = (EditText) viewDialog.findViewById(R.id.congdung_detail);
                EditText lieudung = (EditText) viewDialog.findViewById(R.id.lieudung_detail);
                EditText luuydung = (EditText) viewDialog.findViewById(R.id.luuydung_detail);

                CircleImageView imgDetail = (CircleImageView) viewDialog.findViewById(R.id.img_detail);

                tenkhoahoc.setText(model.getTenkhoahoc());
                tenthuonggoi.setText(model.getTenthuonggoi());
                dactinh.setText(model.getDactinh());
                congdung.setText(model.getCongdung());
                lieudung.setText(model.getLieudung());
                luuydung.setText(model.getLuuydung());
                Glide.with(holder.img.getContext()).load(model.getUrl()).into(imgDetail);
                dialogPlus.show();


            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.tenkhoahoc.getContext());
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setTitle("Are you sure?");
                builder.setMessage("Delete data can't be Undo!");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("tree")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.tenkhoahoc.getContext(), "Cancelled!!", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView img;
        private TextView tenkhoahoc, tenthuonggoi, dactinh, congdung, lieudung, luuydung;
        private Button btnEdit, btnDelete;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img = (CircleImageView) itemView.findViewById(R.id.img1);
            tenkhoahoc = (TextView) itemView.findViewById(R.id.tenkhoahoc);
            tenthuonggoi = (TextView) itemView.findViewById(R.id.tenthuonggoi);
            dactinh = (TextView) itemView.findViewById(R.id.dactinh);
            congdung = (TextView) itemView.findViewById(R.id.congdung);
            lieudung = (TextView) itemView.findViewById(R.id.lieudung);
            luuydung = (TextView) itemView.findViewById(R.id.luuydung);
            btnEdit = (Button) itemView.findViewById(R.id.btn_edit);
            btnDelete = (Button) itemView.findViewById(R.id.btn_delete);
        }
    }
}

