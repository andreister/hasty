package com.blunderer.materialdesignlibrary.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blunderer.materialdesignlibrary.R;
import com.blunderer.materialdesignlibrary.models.NavigationDrawerListItemBottom;

import java.util.List;

public class NavigationDrawerBottomAdapter extends ArrayAdapter<NavigationDrawerListItemBottom> {

    private int mLayoutResourceId;

    public NavigationDrawerBottomAdapter(Context context,
                                         int layoutResourceId,
                                         List<NavigationDrawerListItemBottom> objects) {
        super(context, layoutResourceId, objects);

        mLayoutResourceId = layoutResourceId;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        NavigationDrawerListItemBottom tool = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(mLayoutResourceId, parent, false);

            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.navigation_drawer_row_title);
            holder.icon = (ImageView) convertView.findViewById(R.id.navigation_drawer_row_icon);
            convertView.setTag(holder);
        } else holder = (ViewHolder) convertView.getTag();

        if (tool.useBackgroundStyle()) convertView.setBackgroundResource(tool.getBackgroundStyle());
        else convertView.setBackgroundResource(android.R.color.transparent);

        if (tool.useTitle()) {
            holder.title.setVisibility(View.VISIBLE);
            try {
                holder.title.setText(tool.getTitle());
            } catch (Resources.NotFoundException e) {
                holder.title.setText("");
            }
            holder.title.setTextAppearance(getContext(), tool.useTitleStyle() ?
                    tool.getTitleStyle() :
                    R.style.MaterialDesignLibraryTheme_NavigationDrawer_ItemsTextStyle);
        }

        if (tool.useIconResource() || tool.useIconUrl()) {
            try {
                if (tool.useIconUrl()) tool.getIconUrl().into(holder.icon);
                else holder.icon.setImageDrawable(tool.getIconDrawable());
                holder.icon.setVisibility(View.VISIBLE);
            } catch (Resources.NotFoundException e) {
                holder.icon.setVisibility(View.GONE);
            }
        }

        return convertView;
    }

    private class ViewHolder {

        private TextView title;
        private ImageView icon;

    }

}
