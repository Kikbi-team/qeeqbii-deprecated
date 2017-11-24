package ch.epfl.sweng.qeeqbii;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import ch.epfl.sweng.qeeqbii.activities.MainActivity;
import ch.epfl.sweng.qeeqbii.open_food.ClusterType;
import ch.epfl.sweng.qeeqbii.open_food.ClusterTypeFirstLevel;
import ch.epfl.sweng.qeeqbii.open_food.ClusterTypeSecondLevel;

import static junit.framework.Assert.assertEquals;

/**
 * Created by guillaume on 23/11/17.
 */

public class ClusterTypeTest {

    @Rule
    public final ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void getParentAndChildrenTest()
    {
        ClusterType type = ClusterTypeSecondLevel.BISCUITS_GAUFRES;

        ClusterType parent = type.getParent();

        assertEquals(ClusterTypeFirstLevel.CHOCOLAT, parent);

        ClusterType[] children = parent.getChildren();

        assertEquals(10, children.length);

        for (ClusterTypeFirstLevel elem_first : ClusterTypeFirstLevel.values())
        {
            for(ClusterTypeSecondLevel elem_second : elem_first.getChildren())
            {
                assertEquals(elem_first,elem_second.getParent());
            }
        }


        for (ClusterTypeSecondLevel elem_second: ClusterTypeSecondLevel.values())
        {
            ClusterTypeFirstLevel its_parent = elem_second.getParent();
            int found = 0;
            for(ClusterType child: its_parent.getChildren())
            {
                if (child == elem_second)
                {
                    found += 1;
                }
            }
            assertEquals(1,found);
        }

        assertEquals(ClusterTypeFirstLevel.CHOCOLAT.getParent(),null);
        assertEquals(ClusterTypeSecondLevel.CHOCOLAT.getChildren(),null);
    }

    @Test
    public void stringMapTest()
    {
        assertEquals(ClusterTypeFirstLevel.BOISSONS_CHAUDES_FROIDES,
                ClusterTypeFirstLevel.getClusterType("Boissons chaudes ou froides"));

        assertEquals(ClusterTypeSecondLevel.BONBONS_CHEWING_GUM,
                ClusterTypeSecondLevel.getClusterType("Bonbons et Chewing-Gums"));

        assertEquals(ClusterTypeSecondLevel.AGNEAU_CHEVRE, ClusterTypeSecondLevel.getClusterType("AGNEAU_CHEVRE"));
    }



}
