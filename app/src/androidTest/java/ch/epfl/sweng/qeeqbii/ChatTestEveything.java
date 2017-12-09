package ch.epfl.sweng.qeeqbii;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

import ch.epfl.sweng.qeeqbii.activities.BarcodeScannerActivity;
import ch.epfl.sweng.qeeqbii.activities.GraphsActivity;
import ch.epfl.sweng.qeeqbii.activities.MainActivity;
import ch.epfl.sweng.qeeqbii.activities.SavedProductsDatesActivity;
import ch.epfl.sweng.qeeqbii.chat.AgeActivity;
import ch.epfl.sweng.qeeqbii.chat.AllergiesActivity;
import ch.epfl.sweng.qeeqbii.chat.ChatActivity;
import ch.epfl.sweng.qeeqbii.chat.DegoutActivity;
import ch.epfl.sweng.qeeqbii.chat.MainActivityChat;
import ch.epfl.sweng.qeeqbii.chat.ProfileActivity;
import ch.epfl.sweng.qeeqbii.chat.RegisterActivity;
import ch.epfl.sweng.qeeqbii.chat.Request;
import ch.epfl.sweng.qeeqbii.chat.SettingsActivity;
import ch.epfl.sweng.qeeqbii.chat.StartActivity;
import ch.epfl.sweng.qeeqbii.chat.StatusActivity;


import static android.app.PendingIntent.getActivity;
import static android.os.SystemClock.sleep;
import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.DrawerMatchers.isClosed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static ch.epfl.sweng.qeeqbii.R.id.nav_chat;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by nicol on 01.12.2017.
 */

public class ChatTestEveything {

   private FirebaseAuth mAuth;
    @Rule
    public final ActivityTestRule<StartActivity> mActivityRule =
            new ActivityTestRule<>(StartActivity.class);

    @Test
    public void allUsers() {

        // Click sign in
        ViewInteraction appCompatButton = onView(withId(R.id.start_login_btn));
        appCompatButton.perform(click());

        String email = "nicolaslesimple@noos.fr";
        String password = "123456";
        //Enter email
        ViewInteraction emailField = onView(withId(R.id.email_login_chat));
        emailField.perform(replaceText(email));

        // Enter password
        ViewInteraction passwordField = onView((withId(R.id.password_login_chat)));
        passwordField.perform(replaceText(password));

        // Click sign in
        ViewInteraction appCompatButton2 = onView(withId(R.id.login_btn));
        appCompatButton2.perform(click());

        sleep(5000);

        // Click chat on slider
        // register next activity that need to be monitored.
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivityChat.class.getName(), null, false);
        onView(withId(R.id.barcode_scanner))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer
        sleep(500);
        // Start the screen of your activity.
        onView(withId(R.id.nav_view_barcode_scanner)).perform(NavigationViewActions.navigateTo(R.id.nav_chat));
        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        MainActivityChat nextActivity = (MainActivityChat) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        sleep(500);

        // Click settings
        // register next activity that need to be monitored.
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("All Users")).perform(click());
        sleep(500);
    }
    @Test
    public void changeImage() {

        // Click sign in
        ViewInteraction appCompatButton = onView(withId(R.id.start_login_btn));
        appCompatButton.perform(click());

        String email = "nicolaslesimple@noos.fr";
        String password = "123456";
        //Enter email
        ViewInteraction emailField = onView(withId(R.id.email_login_chat));
        emailField.perform(replaceText(email));

        // Enter password
        ViewInteraction passwordField = onView((withId(R.id.password_login_chat)));
        passwordField.perform(replaceText(password));

        // Click sign in
        ViewInteraction appCompatButton2 = onView(withId(R.id.login_btn));
        appCompatButton2.perform(click());

        sleep(5000);

        // Click chat on slider
        // register next activity that need to be monitored.
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(MainActivityChat.class.getName(), null, false);
        onView(withId(R.id.barcode_scanner))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer
        sleep(500);
        // Start the screen of your activity.
        onView(withId(R.id.nav_view_barcode_scanner)).perform(NavigationViewActions.navigateTo(R.id.nav_chat));
        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        MainActivityChat nextActivity = (MainActivityChat) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        sleep(500);

        // Click settings
        // register next activity that need to be monitored.
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Account Settings")).perform(click());
        sleep(500);
        //String status = "Take it easy dude !!";
        //String age = "22";
        //String allergie = "Nothing I'm a warrior bro !";
        //String degout = "Fruits berkkkk";

        onView(withId(R.id.settings_status_btn)).perform(click());
        // onView(withId(R.id.status_input)).perform(replaceText(status));
        onView(withId(R.id.status_save_btn)).perform(click());
        pressBack();
        pressBack();
        onView(withId(R.id.settings_age_btn)).perform(click());
        //onView(withId(R.id.age_input)).perform(replaceText(age));
        onView(withId(R.id.age_save_btn)).perform(click());
        pressBack();
        pressBack();
        onView(withId(R.id.settings_allergies_btn)).perform(click());
        //onView(withId(R.id.allergies_input)).perform(replaceText(allergie));
        onView(withId(R.id.allergies_save_btn)).perform(click());
        pressBack();
        pressBack();
        onView(withId(R.id.settings_degout_btn)).perform(click());
        //onView(withId(R.id.degout_input)).perform(replaceText(degout));
        onView(withId(R.id.degout_save_btn)).perform(click());
        pressBack();
        pressBack();
        //onView(withId(R.id.settings_image_btn)).perform(click());
    }












       // Intent intent = new Intent(mActivityRule.getActivity(), MainActivityChat.class);
        /*mActivityRule.launchActivity(intent);
        Intent intent2 = new Intent(mActivityRule.getActivity(), SettingsActivity.class);
        mActivityRule.launchActivity(intent2);
        //onView(withId(R.id.facebook)).perform(click());
        //onView(withId(R.id.settings_age_btn)).perform(click());
        //onView(withId(R.id.age_save_btn)).perform(click());
        //Intent intent3 = new Intent(mActivityRule.getActivity(), SettingsActivity.class);
        //mActivityRule.launchActivity(intent3);
        //onView(withId(R.id.settings_allergies_btn)).perform(click());
        //onView(withId(R.id.allergies_save_btn)).perform(click());
        Intent intent4 = new Intent(mActivityRule.getActivity(), AllergiesActivity.class);
        mActivityRule.launchActivity(intent4);
        Intent intent5 = new Intent(mActivityRule.getActivity(), DegoutActivity.class);
        mActivityRule.launchActivity(intent5);
        Intent intent6 = new Intent(mActivityRule.getActivity(), StatusActivity.class);
        mActivityRule.launchActivity(intent6);
        Intent intent7 = new Intent(mActivityRule.getActivity(), ProfileActivity.class);
        mActivityRule.launchActivity(intent7);
        Intent intent8 = new Intent(mActivityRule.getActivity(), ChatActivity.class);
        mActivityRule.launchActivity(intent8);*/






       // openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        //ViewInteraction appCompatButton3 = onView(withText(R.string.Chat));
        //appCompatButton3.perform(click());




        // Click on the right top button
       // openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        //ViewInteraction appCompatButton4 = onView(withText(R.string.AccountSettings));
        //appCompatButton4.perform(click());



        // Click settings
      //  ViewInteraction appCompatButton5 = onView(withId(R.id.settings_image_btn));
        //appCompatButton5.perform(click());


   /* @Test
    public void changeStatus() {
        // Click sign in
        ViewInteraction appCompatButton = onView(withId(R.id.start_login_btn));
        appCompatButton.perform(click());

        String email = "nicolaslesimple@noos.fr";
        String password = "123456";
        //Enter email
        ViewInteraction emailField = onView(withId(R.id.email_login_chat));
        emailField.perform(replaceText(email));

        // Enter password
        ViewInteraction passwordField = onView((withId(R.id.password_login_chat)));
        passwordField.perform(replaceText(password));

        // Click sign in
        ViewInteraction appCompatButton2 = onView(withId(R.id.login_btn));
        appCompatButton2.perform(click());

        // Click settings
        Context appContext = InstrumentationRegistry.getTargetContext();
        openActionBarOverflowOrOptionsMenu(appContext);
        ViewInteraction appCompatButton3 = onView(withId(R.id.main_settings_btn));
        appCompatButton3.perform(click());

        // Click settings
        ViewInteraction appCompatButton4 = onView(withId(R.id.settings_status_btn));
        appCompatButton4.perform(click());
    }
/*
    @Test
    public void changeAllergie() {
        // Click sign in
        ViewInteraction appCompatButton = onView(withId(R.id.start_login_btn));
        appCompatButton.perform(click());

        String email = "nicolaslesimple@noos.fr";
        String password = "123456";
        //Enter email
        ViewInteraction emailField = onView(withId(R.id.email_login_chat));
        emailField.perform(replaceText(email));

        // Enter password
        ViewInteraction passwordField = onView((withId(R.id.password_login_chat)));
        passwordField.perform(replaceText(password));

        // Click sign in
        ViewInteraction appCompatButton2 = onView(withId(R.id.login_btn));
        appCompatButton2.perform(click());

        // Click settings
        ViewInteraction appCompatButton3 = onView(withId(R.id.main_settings_btn));
        appCompatButton3.perform(click());

        // Click settings
        ViewInteraction appCompatButton4 = onView(withId(R.id.));
        appCompatButton4.perform(click());
    }

    @Test
    public void changeStatus() {
        // Click sign in
        ViewInteraction appCompatButton = onView(withId(R.id.start_login_btn));
        appCompatButton.perform(click());

        String email = "nicolaslesimple@noos.fr";
        String password = "123456";
        //Enter email
        ViewInteraction emailField = onView(withId(R.id.email_login_chat));
        emailField.perform(replaceText(email));

        // Enter password
        ViewInteraction passwordField = onView((withId(R.id.password_login_chat)));
        passwordField.perform(replaceText(password));

        // Click sign in
        ViewInteraction appCompatButton2 = onView(withId(R.id.login_btn));
        appCompatButton2.perform(click());

        // Click settings
        ViewInteraction appCompatButton3 = onView(withId(R.id.main_settings_btn));
        appCompatButton3.perform(click());

        // Click settings
        ViewInteraction appCompatButton4 = onView(withId(R.id.settings_status_btn));
        appCompatButton4.perform(click());
    }

    @Test
    public void changeStatus() {
        // Click sign in
        ViewInteraction appCompatButton = onView(withId(R.id.start_login_btn));
        appCompatButton.perform(click());

        String email = "nicolaslesimple@noos.fr";
        String password = "123456";
        //Enter email
        ViewInteraction emailField = onView(withId(R.id.email_login_chat));
        emailField.perform(replaceText(email));

        // Enter password
        ViewInteraction passwordField = onView((withId(R.id.password_login_chat)));
        passwordField.perform(replaceText(password));

        // Click sign in
        ViewInteraction appCompatButton2 = onView(withId(R.id.login_btn));
        appCompatButton2.perform(click());

        // Click settings
        ViewInteraction appCompatButton3 = onView(withId(R.id.main_settings_btn));
        appCompatButton3.perform(click());

        // Click settings
        ViewInteraction appCompatButton4 = onView(withId(R.id.settings_status_btn));
        appCompatButton4.perform(click());
    }
*/

    @AfterClass
    public static void finish_all_activities() {
        ActivityFinisher.finishOpenActivities();
    }
}




