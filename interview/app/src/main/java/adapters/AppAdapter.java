package adapters;

import android.app.Activity;
import android.app.Dialog;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import bluebox.interview.R;
import viewholders.AppViewHolder;


public class AppAdapter  extends BaseAdapter {
    private Activity activity;
    private Integer[] mAppCatalogThumbIds;
    private String[] mAppCatalogImageNames;

    public AppAdapter(Activity activity, Integer[] mAppCatalogThumbIds,
                             String[] mAppCatalogImageNames) {
        this.activity = activity;
        this.mAppCatalogThumbIds = mAppCatalogThumbIds;
        this.mAppCatalogImageNames = mAppCatalogImageNames;

    }

    public int getCount() {
        return mAppCatalogThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        final AppViewHolder view;
        LayoutInflater inflator = activity.getLayoutInflater();
        final int viewPosition = position;


        if (convertView == null) {
            view = new AppViewHolder();
            convertView = inflator.inflate(R.layout.gridview_row, null);

            view.textView = (TextView) convertView.findViewById(R.id.textView1);
            view.imageView = (ImageView) convertView.findViewById(R.id.imageView1);

            view.imageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {

                   showDialog(activity, viewPosition,
                           mAppCatalogThumbIds, mAppCatalogImageNames);
                }});

            convertView.setTag(view);
        } else {
            view = (AppViewHolder) convertView.getTag();
        }

        view.imageView.setImageResource(mAppCatalogThumbIds[position]);
        view.textView.setText(mAppCatalogImageNames[position]);

        return convertView;
    }

    //Refactoring: This functionality can be moved into its own package (dialogs package, for instance)
    public void showDialog(Activity activity, int position,
                           Integer[] mAppCatalogThumbIds, String [] mAppCatalogImageNames){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialog);

        TextView text = (TextView) dialog.findViewById(R.id.text_dialog);
        text.setText(mAppCatalogImageNames[position]);

        ImageView imageView = (ImageView) dialog.findViewById(R.id.imageDialog);
        imageView.setImageResource(mAppCatalogThumbIds[position]);

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();

    }
}