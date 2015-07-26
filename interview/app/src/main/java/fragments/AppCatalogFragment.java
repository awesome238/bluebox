package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import adapters.AppAdapter;
import bluebox.interview.R;
import resources.AppResources;


public class AppCatalogFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        GridView gv = (GridView) inflater.inflate(
                R.layout.apps_gridview, container, false);


        setupGridView(gv);
        return gv;
    }

    private void setupGridView(GridView gridView) {
        AppResources appResources = new AppResources();
        gridView.setAdapter(new AppAdapter(this.getActivity(), appResources.mAppCatalogThumbIds,
                appResources.mAppCatalogImageNames));
    }


}
