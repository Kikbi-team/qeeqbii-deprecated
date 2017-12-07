package ch.epfl.sweng.qeeqbii.open_food;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.ArrayAdapter;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import ch.epfl.sweng.qeeqbii.R;
import ch.epfl.sweng.qeeqbii.activities.RecentlyScannedProductsActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
public class RecentlyScannedProductsActivityTest {

    @Rule
    public final ActivityTestRule<RecentlyScannedProductsActivity> mActivityRule =
            new ActivityTestRule<>(RecentlyScannedProductsActivity.class);

    @Test
    public void canUseDeleteButton() {
        ArrayAdapter adapter = mActivityRule.getActivity().getmAdapter();

        onView(withId(R.id.delete_recently_scanned_product_button)).perform(click());

        assertEquals(adapter.getCount(), 0);
    }






}