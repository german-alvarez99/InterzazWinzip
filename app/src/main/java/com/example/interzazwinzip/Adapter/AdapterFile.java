package com.example.interzazwinzip.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interzazwinzip.Model.File;
import com.example.interzazwinzip.R;

import java.util.ArrayList;
import java.util.List;

import com.example.interzazwinzip.R.drawable;

public class AdapterFile extends RecyclerView.Adapter<AdapterFile.ViewHolderFile> {
    List<File> listaFiles= new ArrayList<File>();

    public AdapterFile(List<File> listaFiles) {
        this.listaFiles = listaFiles;
    }

    @NonNull
    @Override
    public ViewHolderFile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_files, null, false);
        return new ViewHolderFile(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFile holder, int position) {
        holder.nombre.setText(listaFiles.get(position).getNombre());
        holder.descripcion.setText(listaFiles.get(position).getDescripcion());
        holder.fecha.setText(listaFiles.get(position).getDate());
        Boolean directorio=listaFiles.get(position).getDirectorio();
        if(directorio)
            holder.imagen.setImageResource(drawable.carpeta_image);
        else
            holder.imagen.setImageResource(drawable.file_image);
    }

    @Override
    public int getItemCount() {
        return listaFiles.size();
    }

    public class ViewHolderFile extends RecyclerView.ViewHolder {
        TextView nombre, descripcion, fecha;
        ImageView imagen;
        public ViewHolderFile(@NonNull View itemView) {
            super(itemView);
            nombre= (TextView) itemView.findViewById(R.id.txtNombreFile);
            descripcion= (TextView) itemView.findViewById(R.id.txtDescripcionFile);
            fecha= (TextView) itemView.findViewById(R.id.txtFechaFile);
            imagen= (ImageView) itemView.findViewById(R.id.imageFile);
        }
    }
}
