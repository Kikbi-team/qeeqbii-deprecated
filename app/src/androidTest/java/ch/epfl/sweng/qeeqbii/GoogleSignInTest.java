package ch.epfl.sweng.qeeqbii;
/*

import android.support.test.espresso.NoMatchingViewException;
import android.test.suitebuilder.annotation.LargeTest;

import android.support.test.runner.AndroidJUnit4;


import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class GoogleSignInTest {

        //@Rule
        //public ActivityTestRule<GoogleSignInActivity> mActivityTestRule =
         //       new ActivityTestRule<>(GoogleSignInActivity.class);

        @Test
        public void GoogleSignInTest_() {
            // Sign out if possible
        //    signOutIfPossible();
            //Disconnect if possible
          //  DisconnectIfPossible();
            //Disconnect if possible
            //SaveIfPossible();

            // Click sign in
            //onView(allOf(withId(R.id.sign_in_button), isDisplayed()))
              //      .perform(click());


        }

        private void signOutIfPossible() {
            try {
                onView(allOf(withId(R.id.sign_out_button), isDisplayed()))
                        .perform(click());
            } catch (NoMatchingViewException e) {
                // Ignore
            }

        }
        private void DisconnectIfPossible() {
            try {
                onView(allOf(withId(R.id.disconnect_button), isDisplayed()))
                        .perform(click());
            } catch (NoMatchingViewException e) {
                // Ignore
            }

        }

    private void SaveIfPossible() {
        try {
            onView(allOf(withId(R.id.buttonSave), isDisplayed()))
                    .perform(click());
        } catch (NoMatchingViewException e) {
            // Ignore
        }

    }


}
*/
import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;



@RunWith(AndroidJUnit4.class)
public class GoogleSignInTest {
    @Rule
    public final IntentsTestRule<GoogleSignInActivity> mActivityRule =
            new IntentsTestRule<>(GoogleSignInActivity.class);

    @Test
    public void useAppContext() throws Exception {
        GoogleSignInActivity activity = mActivityRule.getActivity();
        Thread.sleep(200);
        Espresso.closeSoftKeyboard();
        Thread.sleep(200);
        onView(withId(R.id.sign_in_button)).perform(click());
    }
}

