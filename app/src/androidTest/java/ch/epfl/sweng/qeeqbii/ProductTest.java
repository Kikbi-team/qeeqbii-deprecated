package ch.epfl.sweng.qeeqbii;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.epfl.sweng.qeeqbii.activities.MainActivity;
import ch.epfl.sweng.qeeqbii.custom_exceptions.ProductException;
import ch.epfl.sweng.qeeqbii.open_food.Product;

import static junit.framework.Assert.assertEquals;

/**
 * Created by davidcleres on 12.10.17.
 */
@RunWith(AndroidJUnit4.class)
public class ProductTest {

    @Rule
    public final ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void defaultConstructorTest() {
        Product prod = new Product();
        assertEquals(prod.getName(), "");
    }

    @Test
    public void getNameIdTest() {
        Product item = new Product("cheese", "500 mg", "Stuff", "cool Nutrients", "001", R.drawable.cheese);
        assertEquals(item.getImageId(), R.drawable.cheese);
    }

    @Test
    public void getPaserIngredientTest() throws ProductException {
        Product item = new Product("cheese", "500 mg", "Stuff", "cool Nutrients", "001", R.drawable.cheese);
        String[] ingredients = new String[]{"beans", "tomato"};
        item.setParsedIngredients(ingredients);
        assertEquals(ingredients, item.getParsedIngredients());
    }

}

