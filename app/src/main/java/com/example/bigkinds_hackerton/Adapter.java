package com.example.bigkinds_hackerton;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Model> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model = models.get(position);

        holder.imageView.setImageResource(model.getImage());
        holder.content.setText(model.getContent());
        holder.editor.setText(model.getEditor());

        /**
         * 받아오는 Url을 통해
         * 버튼을 눌렀을때 그 url 로 진입하도록 함
         */
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = model.getUrl();
                try {
                    if (url != null) {
                        // URL이 null이 아닌 경우 처리
                        Log.d("URL", url);
                        // TODO: 여기서 얻은 URL을 사용하여 특정 동작 수행
                    } else {
                        // URL이 null인 경우 처리
                        Log.d("URL이 null입니다.", "dd");
                    }
                } catch (Exception e) {
                    // 예외 처리
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView content, editor;
        Button btn;

        ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            content = itemView.findViewById(R.id.content);
            editor = itemView.findViewById(R.id.editor);
            btn = itemView.findViewById(R.id.button);
        }
    }
}
