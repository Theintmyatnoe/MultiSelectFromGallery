package com.example.multiselectfromgallery;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;

import java.io.IOException;
import java.util.ArrayList;

class GalleryAdapter extends BaseAdapter {
    private Context ctx;
    private int pos;
    private LayoutInflater inflater;
    private ImageView ivGallery;
    ArrayList<Uri> mArrayUri=new ArrayList<Uri>();
    public GalleryAdapter(Context ctx, ArrayList<Uri> mArrayUri) {

        this.ctx = ctx;
        this.mArrayUri = mArrayUri;
    }

    @Override
    public int getCount() {
        return mArrayUri.size();
    }

    @Override
    public Object getItem(int position) {
        return mArrayUri.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;
        LayoutInflater inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(ctx);
            grid = inflater.inflate(R.layout.gv_item, null);

            ImageView imageView = (ImageView)grid.findViewById(R.id.ivGallery);
            imageView.setImageURI(mArrayUri.get(position));
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}
