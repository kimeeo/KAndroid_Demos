package com.kimeeo.demo.lists;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.kimeeo.demo.R;
import com.kimeeo.demo.model.SampleModel;
import com.kimeeo.demo.projectCore.DefaultHorizontalGridView;
import com.kimeeo.library.listDataView.recyclerView.BaseItemHolder;
import com.kimeeo.library.listDataView.dataManagers.PageData;

import butterknife.Bind;

/**
 * Created by bhavinpadhiyar on 12/26/15.
 */
public class EasyHorizontalGridView extends DefaultHorizontalGridView
{
    public static class ViewTypes {
        public static final int VIEW_ITEM1 = 5;
        public static final int VIEW_ITEM2 = 10;
    }
    //Return View Type here
    @Override
    public int getListItemViewType(int position,Object item)
    {
        if(position<4)
            return ViewTypes.VIEW_ITEM1;
        else
            return ViewTypes.VIEW_ITEM2;
    }
    // get View
    @Override
    public View getItemView(int viewType,LayoutInflater inflater,ViewGroup container)
    {
        return inflater.inflate(R.layout._sample_column_cell,null);
    }
    //END URL
    public String getNextDataURL(PageData pageData)
    {
        return "http://www.googledrive.com/host/0B0GMnwpS0IrNRkI5WFVCZG5EUTQ/data"+pageData.curruntPage+".txt";
    }
    public String getRefreshDataURL(PageData pageData)
    {
        //return "http://www.googledrive.com/host/0B0GMnwpS0IrNRkI5WFVCZG5EUTQ/data1.txt";
        return null;
    }

    //Data Parser
    public Class getLoadedDataParsingAwareClass()
    {
        return SampleDataParser.class;
    }
    //List data object






    // get New BaseItemHolder
    @Override
    public BaseItemHolder getItemHolder(int viewType,View view)
    {
        if(viewType== ViewTypes.VIEW_ITEM1)
            return new VlistItemHolder1(view);
        else
            return new VlistItemHolder2(view);
    }


    // Update View Here
    public class VlistItemHolder1 extends BaseItemHolder {

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
            AQuery aq = new AQuery(view);
            aq.id(R.id.backgroud).image(listObject.image, true, true, 100, 0);

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
            AQuery aq = new AQuery(view);
            aq.id(R.id.backgroud).image(listObject.image, true, true,100,0);

        }
    }

}
