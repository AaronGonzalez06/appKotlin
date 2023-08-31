package com.example.aplicacionanimal

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test


@RunWith(AndroidJUnit4::class)
class AnimalTest {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)
    val MenuActivity = ActivityScenarioRule(MenuLogica::class.java)
    val FiltroActivity = ActivityScenarioRule(FiltroMenu::class.java)

    val RecyclerActivity = ActivityScenarioRule(HorizontalFiltro::class.java)
    @Test
    fun click_boton() {
        onView(withId(R.id.boton)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.boton5)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.cb_aves)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.cb_mamiferos)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.cb_1)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.cb_5)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.btn_buscar)).perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.vertical_recycler_view)).perform(swipeLeft())
        Thread.sleep(1000)
    }
}