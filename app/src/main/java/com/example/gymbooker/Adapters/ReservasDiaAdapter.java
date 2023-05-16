package com.example.gymbooker.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gymbooker.Class.Reserva;
import com.example.gymbooker.Class.User;
import com.example.gymbooker.Helpers.HelperPersona;
import com.example.gymbooker.R;

import java.util.ArrayList;

public class ReservasDiaAdapter extends RecyclerView.Adapter<ReservasDiaAdapter.ViewHolder> {

    private ArrayList<Reserva> listReserva;
    private ReservasDiaAdapter.onItemClickListener onItemClickListener;



    public void setDataSet(ArrayList<Reserva> dataSet) {
        listReserva = dataSet;
        notifyDataSetChanged();
    }

    public ReservasDiaAdapter(ArrayList<Reserva> listReserva) {
        this.listReserva = listReserva;
       this.onItemClickListener=null;


    }
    public void setOnItemClickListener(ReservasDiaAdapter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.reserva_item, parent, false);
        return new ViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservasDiaAdapter.ViewHolder viewHolder, int i) {
        Reserva myres= listReserva.get(i);
    }


    @Override
    public int getItemCount() {
        return listReserva.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameUser,hInicio,hFin;
        private Button btnAsiste,btnCancela;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameUser=itemView.findViewById(R.id.txtNameUserReserva);
            hInicio=itemView.findViewById(R.id.txtHoraInicioReserva);
            hFin=itemView.findViewById(R.id.txtHoraFinalReserva);
            btnAsiste=itemView.findViewById(R.id.btnMark);
            btnCancela=itemView.findViewById(R.id.btnMark2);
        }

        public void link(Reserva myres){
            HelperPersona helperPersona=new HelperPersona();
            User u=helperPersona.getUserByCc(myres.getCedula());
            if (u!=null){
                nameUser.setText(myres.getFecha());
            }else{
                nameUser.setText("Nemo Nobody");
            }



            hInicio.setText(myres.getHoraIngreso());



            if(onItemClickListener!=null){

                itemView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        onItemClickListener.onItemClick(myres,getAdapterPosition());
                    }
                });
                btnAsiste.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemBtnAsisteClick(myres,getAdapterPosition());
                    }
                });
                btnCancela.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemBtnCancelaClick(myres,getAdapterPosition());
                    }
                });
            }
        }

    }
    public interface onItemClickListener{
        void onItemClick(Reserva myprod, int posicion);
        void onItemBtnAsisteClick(Reserva myprod, int posicion);
        void onItemBtnCancelaClick(Reserva myprod, int posicion);
    }
}
