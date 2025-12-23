package com.example.textcounterapp;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void ensureCalculationWorks() {
        onView(withId(R.id.etInputText))
                .perform(typeText("Vienas du trys"), closeSoftKeyboard());

        onView(withId(R.id.spnMetricType)).perform(click());
        onView(withText("Žodžiai")).perform(click());

        onView(withId(R.id.btnCalculate)).perform(click());

        onView(withId(R.id.tvResult))
                .check(matches(withText(containsString("3"))));
    }

    @Test
    public void checkEmptyInputError() {
        onView(withId(R.id.btnCalculate)).perform(click());

        onView(withId(R.id.tvResult))
                .check(matches(withText("Rezultatas atsiras čia")));
    }
}