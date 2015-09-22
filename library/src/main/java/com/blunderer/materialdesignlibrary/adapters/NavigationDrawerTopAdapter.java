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
import com.blunderer.materialdesignlibrary.models.ListItem;
import com.blunderer.materialdesignlibrary.models.NavigationDrawerListItemDivider;
import com.blunderer.materialdesignlibrary.models.NavigationDrawerListItemHeader;
import com.blunderer.materialdesignlibrary.models.NavigationDrawerListItemTopFragment;
import com.blunderer.materialdesignlibrary.models.NavigationDrawerListItemTopIntent;

import java.util.List;

public class NavigationDrawerTopAdapter extends ArrayAdapter<ListItem> {

    private final int mLayoutResourceId;
    private int mNavigationDrawerSelectedItemPosition;

    public NavigationDrawerTopAdapter(Context context,
                                      int layoutResourceId,
                                      List<ListItem> objects) {
        super(context, layoutResourceId, objects);

        mLayoutResourceId = layoutResourceId;
        mNavigationDrawerSelectedItemPosition = -1;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return getItem(position) instanceof NavigationDrawerListItemTopFragment ||
                getItem(position) instanceof NavigationDrawerListItemTopIntent;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        ListItem item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(mLayoutResourceId, parent, false);

            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.navigation_drawer_row_title);
            holder.titleHeader = (TextView) convertView
                    .findViewById(R.id.navigation_drawer_row_header);
            holder.icon = (ImageView) convertView
                    .findViewById(R.id.navigation_drawer_row_icon);
            holder.headerSeparator = convertView
                    .findViewById(R.id.navigation_drawer_row_header_separator);
            convertView.setTag(holder);
        } else holder = (ViewHolder) convertView.getTag();

        convertView.setBackgroundResource(item.useBackgroundStyle() ?
                item.getBackgroundStyle() : R.drawable.navigation_drawer_selector);

        if (item.useTitle()) {
            try {
                holder.title.setText(item.getTitle());
                holder.titleHeader.setText(item.getTitle());
            } catch (Resources.NotFoundException e) {
                holder.title.setText("");
                holder.titleHeader.setText("");
            }
            holder.title.setTextAppearance(getContext(), item.useTitleStyle() ?
                    item.getTitleStyle() :
                    R.style.MaterialDesignLibraryTheme_NavigationDrawer_ItemsTextStyle);
            holder.titleHeader.setTextAppearance(getContext(), item.useTitleStyle() ?
                    item.getTitleStyle() :
                    R.style.MaterialDesignLibraryTheme_NavigationDrawer_SectionsTextStyle);
        }

        if (item instanceof NavigationDrawerListItemTopFragment) {
            NavigationDrawerListItemTopFragment itemNormal =
                    (NavigationDrawerListItemTopFragment) item;
            holder.title.setVisibility(View.VISIBLE);
            holder.titleHeader.setVisibility(View.GONE);
            holder.headerSeparator.setVisibility(View.GONE);
            if (mNavigationDrawerSelectedItemPosition == position &&
                    (itemNormal.useSelectedIconResource() || itemNormal.useSelectedIconUrl())) {
                try {
                    if (itemNormal.useSelectedIconUrl()) {
                        itemNormal.getSelectedIconUrl().into(holder.icon);
                    } else holder.icon.setImageDrawable(itemNormal.getSelectedIconDrawable());
                    holder.icon.setVisibility(View.VISIBLE);
                } catch (Resources.NotFoundException e) {
                    holder.icon.setVisibility(View.GONE);
                }
            } else if (itemNormal.useIconResource() || itemNormal.useIconUrl()) {
                try {
                    if (itemNormal.useIconUrl()) itemNormal.getIconUrl().into(holder.icon);
                    else holder.icon.setImageDrawable(itemNormal.getIconDrawable());
                    holder.icon.setVisibility(View.VISIBLE);
                } catch (Resources.NotFoundException e) {
                    holder.icon.setVisibility(View.GONE);
                }
            }
        } else if (item instanceof NavigationDrawerListItemTopIntent) {
            NavigationDrawerListItemTopIntent itemNormal =
                    (NavigationDrawerListItemTopIntent) item;
            holder.title.setVisibility(View.VISIBLE);
            holder.titleHeader.setVisibility(View.GONE);
            holder.headerSeparator.setVisibility(View.GONE);
            if (itemNormal.useIconResource() || itemNormal.useIconUrl()) {
                try {
                    if (itemNormal.useIconUrl()) itemNormal.getIconUrl().into(holder.icon);
                    else holder.icon.setImageDrawable(itemNormal.getIconDrawable());
                    holder.icon.setVisibility(View.VISIBLE);
                } catch (Resources.NotFoundException e) {
                    holder.icon.setVisibility(View.GONE);
                }
            }
        } else if (item instanceof NavigationDrawerListItemHeader) {
            holder.title.setVisibility(View.GONE);
            holder.titleHeader.setVisibility(View.VISIBLE);
            holder.icon.setVisibility(View.GONE);
            holder.headerSeparator.setVisibility(position == 0 ? View.GONE : View.VISIBLE);
        } else if (item instanceof NavigationDrawerListItemDivider) {
            holder.title.setVisibility(View.GONE);
            holder.titleHeader.setVisibility(View.GONE);
            holder.icon.setVisibility(View.GONE);
            holder.headerSeparator.setVisibility(View.GONE);
        }

        return convertView;
    }

    public void setNavigationDrawerSelectedItemPosition(int navigationDrawerSelectedItemPosition) {
        mNavigationDrawerSelectedItemPosition = navigationDrawerSelectedItemPosition;
    }

    private class ViewHolder {

        private TextView title;
        private TextView titleHeader;
        private ImageView icon;
        private View headerSeparator;

    }

}
