package com.kimeeo.demo.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kimeeo.demo.R;
import com.kimeeo.demo.model.SampleModel;
import com.kimeeo.library.listDataView.dataManagers.DataManager;
import com.kimeeo.library.listDataView.dataManagers.IListProvider;
import com.kimeeo.library.listDataView.dataManagers.PageData;
import com.kimeeo.library.listDataView.dataManagers.simpleList.ListDataManager;
import com.kimeeo.library.listDataView.viewHelper.ViewPagerHelper;
import com.kimeeo.library.listDataView.viewPager.BaseItemHolder;
import com.kimeeo.library.listDataView.viewPager.viewPager.BaseViewPagerAdapter;
import com.kimeeo.library.listDataView.viewPager.viewPager.DefaultViewPagerAdapter;
import com.kimeeo.library.listDataView.viewPager.viewPager.IViewProvider;
import com.mikepenz.iconics.view.IconicsButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;

/**
 * Created by bhavinpadhiyar on 2/8/16.
 */
public class CoordinatorLayoutExample extends BaseActivity implements IViewProvider {

    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator_layout_example);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        DataManager dataManager= createDataManager();
        View rootView = findViewById(R.id.host);


        ViewPagerHelper viewPagerHelper = new ViewPagerHelper();
        viewPager=(ViewPager) rootView.findViewById(com.kimeeo.library.R.id.viewPager);
        viewPagerHelper.with(viewPager);
        viewPagerHelper.dataManager(dataManager);
        viewPagerHelper.adapter(createViewPagerAdapter(dataManager));

        View indicator = rootView.findViewById(com.kimeeo.library.R.id.indicator);
        if(indicator!=null)
            viewPagerHelper.indicator(indicator);


        try
        {
            viewPagerHelper.create();
        }catch (Exception e){
            System.out.println(e);
        }


    }
    public ViewPager getViewPager()
    {
        return viewPager;
    }
    public void removeView(View view, int position, com.kimeeo.library.listDataView.viewPager.BaseItemHolder itemHolder) {

    }


    protected BaseViewPagerAdapter createViewPagerAdapter(DataManager dataManager)
    {
        return new DefaultViewPagerAdapter(dataManager,this,null);
    }

    // Data Manager
    protected DataManager createDataManager()
    {
        ListDataManager listData1= new ListDataManager(this,listData);
        listData1.setRefreshEnabled(false);
        return listData1;
    }

    IListProvider listData=new IListProvider()
    {
        public List<?> getList(PageData data,Map<String, Object> param)
        {
            if(data.curruntPage==1) {
                List<SampleModel> list = new ArrayList<>();
                list.add(getSample("B1", "534534"));
                list.add(getSample("B2", "534534"));
                list.add(getSample("B3", "534534"));
                list.add(getSample("B4", "534534"));
                list.add(getSample("B5", "534534"));
                list.add(getSample("B6", "534534"));
                list.add(getSample("B7", "534534"));
                list.add(getSample("B8", "534534"));
                list.add(getSample("B9", "534534"));
                list.add(getSample("B10", "534534"));
                return list;
            }
            return null;
        }
    };
    private SampleModel getSample(String name, String phone) {
        SampleModel o = new SampleModel();
        o.name =name;
        o.details = phone;
        return o;
    }


    public String getItemTitle(int position, Object o) {
        return position+"";
    }
    public View getView(int position, Object data) {
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout._sample_column_cell,null);
        return view;
    }

    public BaseItemHolder getItemHolder(View view, int position, Object data) {
        if(position<4)
            return new VlistItemHolder1(view);
        else
            return new VlistItemHolder2(view);
    }


    // Update View Here
    public class VlistItemHolder1 extends BaseItemHolder
    {

        @Bind(R.id.label)TextView label;
        @Bind(R.id.backgroud)ImageView image;

        public VlistItemHolder1(View itemView)
        {
            super(itemView);
        }

        public void updateItemView(Object item,View view,int position)
        {
            SampleModel listObject = (SampleModel)item;
            label.setText(position + " -> " + listObject.name);
        }
        public void cleanView(View itemView,int position)
        {

        }
    }



    // Update View Here
    public class VlistItemHolder2 extends BaseItemHolder {

        @Bind(R.id.label)TextView label;
        @Bind(R.id.backgroud)ImageView image;

        public VlistItemHolder2(View itemView)
        {
            super(itemView);
        }

        public void updateItemView(Object item,View view,int position)
        {
            SampleModel listObject = (SampleModel)item;
            label.setText(position + " -> " + listObject.name);
            label.setTextColor(view.getContext().getResources().getColor(R.color.actionBarBackgroundStart));
        }
        public void cleanView(View itemView,int position)
        {

        }
    }
}
