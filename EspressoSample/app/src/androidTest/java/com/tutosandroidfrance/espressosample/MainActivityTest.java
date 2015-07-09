package com.tutosandroidfrance.espressosample;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
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
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;
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
        getActivity();
    }

    @Test
    public void testClickLogin_emptyText() {
        onView(withText("LOGIN")).perform(click());

        //if editText empty, LOGIN always displayed
        onView(withText("LOGIN")).check(matches(isDisplayed()));
    }

    @Test
    public void testClickLogin_withText() {
        onView(withId(R.id.editText)).perform(typeText("florent"));

        onView(withText("LOGIN")).perform(click());

        //LOGIN disapear
        onView(withText("LOGIN")).check(matches(not(isDisplayed())));

        onView(withId(R.id.text)).check(matches(allOf(isDisplayed(), withText("Hello florent"))));

        onView(withText("LOGOUT")).check(matches(isDisplayed()));
    }

}