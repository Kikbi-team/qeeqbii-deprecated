package ch.epfl.sweng.qeeqbii;

/**
 * Created by davidcleres on 14.11.17.
 */

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static junit.framework.Assert.assertNotNull;


@RunWith(AndroidJUnit4.class)
public class ShoppingListTest {
    @Rule
    public final ActivityTestRule<ShoppingListActivity> mActivityRule =
            new ActivityTestRule<>(ShoppingListActivity.class);

    @Test
    public void testCanOpenClickOnImageSaussage() throws InterruptedException {

        // register next activity that need to be monitored.
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ShoppingCartActivity.class.getName(), null, false);

        // open current activity.
        ShoppingListActivity myActivity = mActivityRule.getActivity();
        final View button = (View) myActivity.findViewById(R.id.saussageImageButton);
        myActivity.addSaussage(button);

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        ShoppingCartActivity nextActivity = (ShoppingCartActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    @Test
    public void testCanOpenClickOnImageMeat() throws InterruptedException {
        // register next activity that need to be monitored.
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ShoppingCartActivity.class.getName(), null, false);

        // open current activity.
        ShoppingListActivity myActivity = mActivityRule.getActivity();
        final View button = (View) myActivity.findViewById(R.id.meatImageButton);
        myActivity.addMeat(button);

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        ShoppingCartActivity nextActivity = (ShoppingCartActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    @Test
    public void testCanOpenClickOnImageCarot() throws InterruptedException {
        // register next activity that need to be monitored.
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ShoppingCartActivity.class.getName(), null, false);

        // open current activity.
        ShoppingListActivity myActivity = mActivityRule.getActivity();
        final View button = (View) myActivity.findViewById(R.id.carotImageButton);
        myActivity.addCarrot(button);

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        ShoppingCartActivity nextActivity = (ShoppingCartActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    @Test
    public void testCanOpenClickOnImagePizza() throws InterruptedException {

        // register next activity that need to be monitored.
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ShoppingCartActivity.class.getName(), null, false);

        // open current activity.
        ShoppingListActivity myActivity = mActivityRule.getActivity();
        final View button = (View) myActivity.findViewById(R.id.pizzaImageButton);
        myActivity.addPizza(button);

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        ShoppingCartActivity nextActivity = (ShoppingCartActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    @Test
    public void testCanOpenClickOnImageApple() throws InterruptedException {

        // register next activity that need to be monitored.
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ShoppingCartActivity.class.getName(), null, false);

        // open current activity.
        ShoppingListActivity myActivity = mActivityRule.getActivity();
        final View button = (View) myActivity.findViewById(R.id.appleImageButton);
        myActivity.addApple(button);

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        ShoppingCartActivity nextActivity = (ShoppingCartActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    @Test
    public void testCanOpenClickOnImageChips() throws InterruptedException {
        // register next activity that need to be monitored.
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ShoppingCartActivity.class.getName(), null, false);

        // open current activity.
        ShoppingListActivity myActivity = mActivityRule.getActivity();
        final View button = (View) myActivity.findViewById(R.id.chipsImageButton);
        myActivity.addChip(button);

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        ShoppingCartActivity nextActivity = (ShoppingCartActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    @Test
    public void testCanOpenClickOnImageWine() throws InterruptedException {
        // register next activity that need to be monitored.
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ShoppingCartActivity.class.getName(), null, false);

        // open current activity.
        ShoppingListActivity myActivity = mActivityRule.getActivity();
        final View button = (View) myActivity.findViewById(R.id.wineImageButton);
        myActivity.addWine(button);

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        ShoppingCartActivity nextActivity = (ShoppingCartActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    @Test
    public void testCanOpenClickOnImageGrossery() throws InterruptedException {
        // register next activity that need to be monitored.
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ShoppingCartActivity.class.getName(), null, false);

        // open current activity.
        ShoppingListActivity myActivity = mActivityRule.getActivity();
        final View button = (View) myActivity.findViewById(R.id.grosseryImageButton);
        myActivity.addGrossery(button);

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        ShoppingCartActivity nextActivity = (ShoppingCartActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    @Test
    public void testCanOpenClickOnImageCheese() throws InterruptedException {
        // register next activity that need to be monitored.
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(ShoppingCartActivity.class.getName(), null, false);

        // open current activity.
        ShoppingListActivity myActivity = mActivityRule.getActivity();
        final View button = (View) myActivity.findViewById(R.id.cheeseImageButton);
        myActivity.addCheese(button);

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        ShoppingCartActivity nextActivity = (ShoppingCartActivity) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }
}
