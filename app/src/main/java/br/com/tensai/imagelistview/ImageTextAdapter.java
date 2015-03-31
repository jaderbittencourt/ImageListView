package br.com.tensai.imagelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jader Bittencourt on 31/03/15.
 */
public class ImageTextAdapter extends ArrayAdapter<ImageTextItem> {

    Context context;
    List<ImageTextItem> list;
    LayoutInflater inflater;
    int layoutId = 0;

    public ImageTextAdapter(Context context, int resource, List<ImageTextItem> items) {
        super(context, resource, items);
        this.context = context;
        this.list = items;
        this.inflater = LayoutInflater.from(getContext());
    }

    public ImageTextAdapter(Context context, int resource, int layoutId, List<ImageTextItem> items) {
        super(context, resource, items);
        this.context = context;
        this.layoutId = layoutId;
        this.list = items;
        this.inflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null) {
            if (layoutId != 0)
                convertView = inflater.inflate(layoutId, null);
            else
                convertView = inflater.inflate(R.layout.image_text_item, null);
            holder = new ViewHolder();
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ImageTextItem item = getItem(position);

        if (item != null) {
            holder.context = getContext();
            holder.title = (TextView) convertView.findViewById(R.id.listTitle);
            holder.detail= (TextView) convertView.findViewById(R.id.listDetail);
            holder.image = (ImageView) convertView.findViewById(R.id.listImage);

            holder.title.setText(item.getTitle());
            holder.detail.setText(item.getDetail());
            holder.image.setImageDrawable(item.getImage());
        }
        return convertView;
    }

    static class ViewHolder {
        Context context;
        TextView title;
        TextView detail;
        ImageView image;
    }
}

