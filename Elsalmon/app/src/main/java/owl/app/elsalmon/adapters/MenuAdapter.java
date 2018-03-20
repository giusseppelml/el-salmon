package owl.app.elsalmon.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import owl.app.elsalmon.R;
import owl.app.elsalmon.models.Menu;

/**
 * Created by Giusseppe on 24/12/2017.
 */

public class MenuAdapter extends BaseAdapter {
private Context context;
private int layout;
private List<Menu> menu;

public MenuAdapter(Context context, int layout, List<Menu> menu)
        {
        this.context = context;
        this.layout = layout;
        this.menu = menu;
        }


@Override
public int getCount() {
        return this.menu.size();
        }

@Override
public Object getItem(int position) {
        return this.menu.get(position);
        }

@Override
public long getItemId(int id) {
        return id;
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null)
        {
        convertView = LayoutInflater.from(context).inflate(layout, null);
        holder = new ViewHolder();
        holder.TextViewTitulo = (TextView)convertView.findViewById(R.id.cardMenuTitulo);
        holder.ImageViewImagen = (ImageView)convertView.findViewById(R.id.cardMenuImagen);
        convertView.setTag(holder);
        }
        else
        {
        holder = (ViewHolder) convertView.getTag();
        }

final Menu currentFruta = (Menu) getItem(position);
        holder.TextViewTitulo.setText(currentFruta.getTitulo());
        holder.ImageViewImagen.setImageResource(currentFruta.getIcono());

        return convertView;
        }
static class ViewHolder
{

    private TextView TextViewTitulo;
    private ImageView ImageViewImagen;
}
}
