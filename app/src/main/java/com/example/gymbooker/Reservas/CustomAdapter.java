package com.example.gymbooker.Reservas;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.gymbooker.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<Reserva> DataSet;
    private onItemClickListener onItemClickListener;

    public void setDataSet(ArrayList<Reserva> dataSet) {
        DataSet = dataSet;
        notifyDataSetChanged();
    }

    public CustomAdapter(ArrayList<Reserva> dataSet) {
        DataSet = dataSet;
        this.onItemClickListener = null;
    }

    public void setOnItemClickListener(CustomAdapter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_reserva, parent, false);
        return new ViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        Reserva myres = DataSet.get(position);
        holder.link(myres);
    }

    public int getItemCount() {
        return DataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_fecha,tv_hora,tv_duracion,tv_rutina;
        private Button btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_fecha = itemView.findViewById(R.id.tv_fecha_info);
            tv_hora = itemView.findViewById(R.id.tv_hora_info);
            tv_duracion = itemView.findViewById(R.id.tv_duracion_info);
            tv_rutina = itemView.findViewById(R.id.tv_rutina_info);
            btn = itemView.findViewById(R.id.btn_cancel);
        }

        public void link(Reserva myres){
            tv_fecha.setText(myres.getFecha());
            tv_hora.setText(myres.getHoraIngreso() + "/" + myres.getHoraSalida());
            tv_duracion.setText(myres.getDuracion());
            tv_rutina.setText(myres.getRutina());


            if(onItemClickListener!=null){

                itemView.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        onItemClickListener.onItemClick(myres,getAdapterPosition());
                    }
                });
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemBtnClick(myres,getAdapterPosition());
                    }
                });
            }
        }
    }
    public interface onItemClickListener{
        void onItemClick(Reserva myprod, int posicion);
        void onItemBtnClick(Reserva myprod, int posicion);
    }
}
