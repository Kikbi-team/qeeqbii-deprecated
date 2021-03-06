package ch.epfl.sweng.qeeqbii.slider;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.epfl.sweng.qeeqbii.ActivityFinisher;
import ch.epfl.sweng.qeeqbii.R;
import ch.epfl.sweng.qeeqbii.activities.BarcodeToProductActivity;

@RunWith(AndroidJUnit4.class)
public class BarcodeToProductSliderTest {

    @Rule
    public final ActivityTestRule<BarcodeToProductActivity> mActivityRule =
            new ActivityTestRule<>(BarcodeToProductActivity.class);

    // disable product adding for these tests
    @BeforeClass
    public static void run_before() {
        BarcodeToProductActivity.setProductAddingAllowed(false);
    }

    private int layoutId = R.id.barcode_to_product;
    private int navViewId = R.id.nav_view_barcode_to_product;


    @Test
    public void canGoToBarcodeScanner() {
        SliderTest sliderTest = new SliderTest();
        sliderTest.canGoToBarcodeScanner(layoutId, navViewId);
    }


    @Test
    public void canGoToCancerMainActivityChat() {
        SliderTest sliderTest = new SliderTest();
        sliderTest.canGoToCancerMainActivityChat(layoutId, navViewId);
    }


    @Test
    public void canGoToShoppingList() {
        SliderTest sliderTest = new SliderTest();
        sliderTest.canGoToShoppingList(layoutId, navViewId);
    }

    @Test
    public void canGoToStatistics() {
        SliderTest sliderTest = new SliderTest();
        sliderTest.canGoToStatistics(layoutId, navViewId);
    }


    @Test
    public void canGoToSavedProductsDate() {
        SliderTest sliderTest = new SliderTest();
        sliderTest.canGoToSavedProductsDate(layoutId, navViewId);
    }

    @Test
    public void canGoToProductsComparisonActivity() {
        SliderTest sliderTest = new SliderTest();
        sliderTest.canGoToProductsComparisonActivity(layoutId, navViewId);
    }

    @Test
    public void canGoToDidYouKnowActivity() {
        SliderTest sliderTest = new SliderTest();
        sliderTest.canGoToDidYouKnowActivity(layoutId, navViewId);
    }


    @Test
    public void canGoToUsersActivityActivity() {
        SliderTest sliderTest = new SliderTest();
        sliderTest.canGoToUsersActivityActivity(layoutId, navViewId);
    }

    @Test
    public void canGoToOtherActivity() {
        SliderTest sliderTest = new SliderTest();
        sliderTest.canGoToOtherActivity(layoutId, navViewId);
    }

    @AfterClass
    public static void finish_all_activities() {
        ActivityFinisher.finishOpenActivities();
    }
}