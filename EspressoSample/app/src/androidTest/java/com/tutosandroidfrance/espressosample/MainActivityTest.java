package com.tutosandroidfrance.espressosample;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by florentchampigny on 06/07/15.
 */
@LargeTest
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();

        //doit être appelé dans le setup
        getActivity();
    }

    @Test
    public void testContainsIntialViews() {
        //je vais tester ici que l'EditText et le bouton LOGIN sont bien affichés
        //mais que le TextView "Hello XXXX" n'est pas présent
        
        onView(withId(R.id.editText)).check(matches(isDisplayed()));
        onView(withText("LOGIN")).check(matches(isDisplayed()));
        onView(withId(R.id.text)).check(matches(not(isDisplayed())));
    }

    @Test
    public void testClickLogin_emptyText() {
        //je vais cliquer sur LOGIN, mais sans avoir écrit de texte dans l'EditText
        onView(withText("LOGIN")).perform(click());

        //Ce qui ne devrait pas cacher le bouton LOGIN, ni afficher le "Hello XXXX"
        onView(withText("LOGIN")).check(matches(isDisplayed()));
        onView(withId(R.id.text)).check(matches(not(isDisplayed())));
    }

    @Test
    public void testClickLogin_withText() {
        //je vais écrire "florent" dans l'EditText
        onView(withId(R.id.editText)).perform(typeText("florent"));

        //puis clicker sur le bouton LOGIN
        onView(withText("LOGIN")).perform(click());

        //ce qui devrait faire disparaitre LOGIN et l'EditText
        onView(withText("LOGIN")).check(matches(not(isDisplayed())));
        onView(withId(R.id.editText)).check(matches(not(isDisplayed())));

        //puis afficher "Hello florent"
        onView(withId(R.id.text)).check(matches(allOf(isDisplayed(), withText("Hello florent"))));
    }

}