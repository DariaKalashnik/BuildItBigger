package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void AsyncTaskCheck() {
        JokeAsyncTask asyncTask = new JokeAsyncTask(new JokeAsyncTask.OnTaskCompleted() {
            @Override
            public void onTaskCompleted(String joke) {
            }
        });
        try {
            asyncTask.execute();
            String joke = asyncTask.get();
            assertNotNull(joke);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void buttonShouldUpdateText() {
        onView(withId(R.id.btn_tell_joke)).perform(click());
        onView(withId(R.id.joke_text)).check(matches(isDisplayed()));
    }
}