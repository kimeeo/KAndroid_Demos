package com.kimeeo.demo.model;

import com.kimeeo.demo.lists.BaseView;
import com.kimeeo.demo.lists.BaseViewListView;
import com.kimeeo.demo.lists.BaseViewPager2;
import com.kimeeo.demo.lists.CardStackViewLikeAirTel;
import com.kimeeo.demo.lists.CarouselView;
import com.kimeeo.demo.lists.EasyCircleListView;
import com.kimeeo.demo.lists.EasyHeaderVerticalGridView;
import com.kimeeo.demo.lists.EasyHorizontalGridView;
import com.kimeeo.demo.lists.EasyHorizontalListView;
import com.kimeeo.demo.lists.EasyVerticalGridView;
import com.kimeeo.demo.lists.EasyVerticalListView;
import com.kimeeo.demo.lists.EasyVerticalListViewFastScroll;
import com.kimeeo.demo.lists.EasyVerticalListViewFastScroll2;
import com.kimeeo.demo.lists.LiteListView;
import com.kimeeo.demo.lists.MapView;
import com.kimeeo.demo.lists.MosaicListWithAdaptor;
import com.kimeeo.demo.lists.RSSListView;
import com.kimeeo.demo.lists.SimpleListView;
import com.kimeeo.demo.lists.StackView;
import com.kimeeo.demo.lists.StickyVerticalListView;
import com.kimeeo.demo.lists.SwipeCards;
import com.kimeeo.demo.lists.SwipeCardsDeck;
import com.kimeeo.demo.lists.VerticalFlipViewWithDefaultAdaptor;
import com.kimeeo.demo.lists.OldVList;
import com.kimeeo.demo.lists.ProfileBasedListView;
import com.kimeeo.demo.lists.RecycleViewBasicHorizontal;
import com.kimeeo.demo.viewPager.HFragmentPager;
import com.kimeeo.demo.viewPager.HorizontalFlipableViewWithDefaltAdaptorView;
import com.kimeeo.demo.viewPager.HorizontalPageViewWithDefaltAdaptorView;
import com.kimeeo.demo.viewPager.VerticalPageViewWithDefaltAdaptorView;
import com.kimeeo.library.model.BaseApplication;
import com.kimeeo.library.model.IFragmentData;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.Iconics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhavinpadhiyar on 1/11/16.
 */
public class Application extends BaseApplication {

    List<IFragmentData> menu;

    public List<IFragmentData> getMainMenu()
    {
        if(menu==null)
            menu = configMainMenu();
        return menu;
    }
    public List<IFragmentData> configMainMenu()
    {
        List<IFragmentData> data = new ArrayList<>();

        FragmentData fragmentData=new FragmentData("02","H Page","","",HorizontalPageViewWithDefaltAdaptorView.class,"");
        data.add(fragmentData);

        fragmentData=new FragmentData("02","V Page","","",VerticalPageViewWithDefaltAdaptorView.class,"");
        data.add(fragmentData);


        fragmentData=new FragmentData("02","H Fragment Page","","",HFragmentPager.class,"");
        data.add(fragmentData);

        fragmentData=new FragmentData("02","RecycleViewBasicHorizontal Pager","","",RecycleViewBasicHorizontal.class,"");
        data.add(fragmentData);



        fragmentData=new FragmentData("01","V List","","",EasyVerticalListView.class,"");
        data.add(fragmentData);
        fragmentData=new FragmentData("02","V Grid","","",EasyVerticalGridView.class,"");
        data.add(fragmentData);


        fragmentData=new FragmentData("02","Old List","","",OldVList.class,"");
        data.add(fragmentData);



        fragmentData=new FragmentData("02","H List","","",EasyHorizontalListView.class,"");
        data.add(fragmentData);

        fragmentData=new FragmentData("02","H Grid","","",EasyHorizontalGridView.class,"");
        data.add(fragmentData);




        fragmentData=new FragmentData("03","Profile Based Grid","","",ProfileBasedListView.class,"");
        data.add(fragmentData);


        fragmentData=new FragmentData("02","V List Fast scroll","","",EasyVerticalListViewFastScroll.class,"");
        data.add(fragmentData);

        fragmentData=new FragmentData("04","V List Fast scroll 2","","",EasyVerticalListViewFastScroll2.class,"");
        data.add(fragmentData);


        fragmentData=new FragmentData("02","London Eye","","",EasyCircleListView.class,"");
        data.add(fragmentData);


        fragmentData=new FragmentData("02","CarouselView","","",CarouselView.class,"");
        data.add(fragmentData);


        fragmentData=new FragmentData("02","Flippable H","","",HorizontalFlipableViewWithDefaltAdaptorView.class,"");
        data.add(fragmentData);

        fragmentData=new FragmentData("02","Page Flip","","",VerticalFlipViewWithDefaultAdaptor.class,"");
        data.add(fragmentData);

        fragmentData=new FragmentData("04","SwipeCards","","",SwipeCards.class,"");
        data.add(fragmentData);


        fragmentData=new FragmentData("04","SwipeCardsDeck","","",SwipeCardsDeck.class,"");
        data.add(fragmentData);




        fragmentData=new FragmentData("04","StackView","","",StackView.class,"");
        data.add(fragmentData);


        fragmentData=new FragmentData("04","Mosaic List","","",MosaicListWithAdaptor.class,"");
        data.add(fragmentData);

        fragmentData=new FragmentData("04","SQL Lite List","","",LiteListView.class,"");
        data.add(fragmentData);

        fragmentData=new FragmentData("04","Simple Statis List","","",SimpleListView.class,"");
        data.add(fragmentData);

        fragmentData=new FragmentData("04","BaseView","","",BaseView.class,"");
        data.add(fragmentData);

        fragmentData=new FragmentData("04","BaseListView","","",BaseViewListView.class,"");
        data.add(fragmentData);


        fragmentData=new FragmentData("04","BaseViewPager","","", com.kimeeo.demo.lists.BaseViewPager.class,"");
        data.add(fragmentData);


        fragmentData=new FragmentData("04","BaseViewPager2","","", BaseViewPager2.class,"");
        data.add(fragmentData);


        fragmentData=new FragmentData("04","StickyVerticalListView","","",StickyVerticalListView.class,"");
        data.add(fragmentData);

        fragmentData=new FragmentData("04","RSS","","",RSSListView.class,"");
        data.add(fragmentData);





        fragmentData=new FragmentData("04","Header View","","",EasyHeaderVerticalGridView.class,"");
        data.add(fragmentData);

        fragmentData=new FragmentData("04","MapView","","",MapView.class,"");
        data.add(fragmentData);

        fragmentData=new FragmentData("04","Airtel View","","",CardStackViewLikeAirTel.class,"");
        data.add(fragmentData);

        return data;
    }
    public void configApplication()
    {
        Iconics.registerFont(new FontAwesome());
        getMainMenu();
    }
}
